
#kotlin subsection

include make/translate_macros.mk

KOTLIN_INTEROP_DIR = $(J2OBJC_ROOT)/kotlin-interop-test-cases
KOTLIN_INTEROP_JVM_JAR = $(KOTLIN_INTEROP_DIR)/build/libs/kotlin-interop-test-cases-jvm.jar
KOTLIN_NATIVE_FRAMEWORK = $(KOTLIN_INTEROP_DIR)/build/bin/native/Common.framework
KOTLIN_INTEROP_BUILD_OUTPUT_DIR = $(KOTLIN_INTEROP_DIR)/build
KOTLIN_NATIVE_DIR = $(J2OBJC_ROOT)/kotlin-native-tests/
KOTLIN_NATIVE_BUILD_OUTPUT_DIR = $(KOTLIN_NATIVE_DIR)/build_result
KOTLIN_NATIVE_SOURCE_DIR = $(KOTLIN_NATIVE_DIR)/src/test/java

KOTLIN_INTEROP_KOTLIN_SOURCES_DIR = $(KOTLIN_INTEROP_DIR)/src/commonMain/kotlin/com/mirego/interop/kotlin/test
KOTLIN_INTEROP_KOTLIN_SOURCES = $(shell find $(KOTLIN_INTEROP_JAVA_SOURCES_DIR) -name '*.kt')
KOTLIN_INTEROP_JAVA_SOURCES_DIR = $(KOTLIN_INTEROP_DIR)/src/commonMain/kotlin/com/mirego/interop/java/test
KOTLIN_INTEROP_JAVA_SOURCES = $(shell find $(KOTLIN_INTEROP_JAVA_SOURCES_DIR) -name '*.java')
KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR = $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)/generated_objc/test_cases

KOTLIN_NATIVE_JAVA_SOURCES = $(shell find $(KOTLIN_NATIVE_SOURCE_DIR) -name '*.java')
KOTLIN_NATIVE_J2OBJC_OUTPUT_DIR = $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)/generated_objc/tests

J2OBJCC_EXE = $(DIST_DIR)/j2objcc
GW = ./gradlew

kotlin_debug:
	@echo $(KOTLIN_NATIVE_JAVA_SOURCES)

kotlin_clean: kotlin_clean_interop kotlin_clean_native

kotlin_clean_interop:
	@rm -rf $(KOTLIN_INTEROP_BUILD_OUTPUT_DIR)

kotlin: kotlin_interop kotlin_native_test

kotlin_interop:
	@cd $(KOTLIN_INTEROP_DIR) && $(GW) jvmJar
	@cd $(KOTLIN_INTEROP_DIR) && $(GW) copyFrameworkNative
	@cp $(KOTLIN_NATIVE_FRAMEWORK)/Headers/Common.h $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR)

kotlin_clean_native:
	@rm -rf $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)

kotlin_native_test: kotlin_translate_test kotlin_compile_test kotlin_run_test

kotlin_translate_test: kotlin_translate_test_cases kotlin_translate_unit_tests

kotlin_translate_test_cases:
	$(TRANSLATE_EXE) \
	-classpath $(DIST_LIB_DIR)/j2objc_junit.jar:$(KOTLIN_INTEROP_JVM_JAR) \
	-encoding UTF-8 \
	-Werror \
	--build-closure \
	--doc-comments \
	--generate-deprecated \
	--no-package-directories \
	--nullability \
	--swift-friendly \
	-J-Xmx2G \
	--header-mapping $(KOTLIN_NATIVE_DIR)header-mapping.j2objc \
	--prefixes $(KOTLIN_NATIVE_DIR)prefixes.properties \
	-d $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR) \
	$(KOTLIN_INTEROP_JAVA_SOURCES) \
	$(KOTLIN_NATIVE_JAVA_SOURCES)


# kotlin_translate_unit_tests:
# 	$(TRANSLATE_EXE) \
# 	-sourcepath $(KOTLIN_INTEROP_JAVA_SOURCES_DIR) \
# 	-classpath $(DIST_LIB_DIR)/j2objc_junit.jar:$(KOTLIN_INTEROP_JVM_JAR) \
# 	--build-closure \
# 	--doc-comments \
# 	--generate-deprecated \
# 	--no-package-directories \
# 	--nullability \
# 	--swift-friendly \
# 	--header-mapping $(KOTLIN_NATIVE_DIR)header-mapping.j2objc \
# 	--prefixes $(KOTLIN_NATIVE_DIR)prefixes.properties \
# 	-d $(KOTLIN_NATIVE_J2OBJC_OUTPUT_DIR) \
# 	$(KOTLIN_NATIVE_JAVA_SOURCES)

KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES = $(shell find $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR) -name '*.m')

kotlin_compile_tests:
	$(J2OBJCC_EXE) \
	-ObjC \
	-ljunit $(KOTLIN_NATIVE_FRAMEWORK) \
	-o nativeTests \
	$(KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES)

kotlin_run_test:
	./nativeTests org.junit.runner.JUnitCore



# kotlin-tests: $(TRANSLATOR_INTEROP_TEST_DIR)/*.java
# 	$(TRANSLATE_EXE) \
# 	-classpath $(DIST_LIB_DIR)/j2objc_junit.jar:$(KOTLIN_JVM_JAR) \
# 	--build-closure \
# 	--doc-comments \
# 	--generate-deprecated \
# 	--no-package-directories \
# 	--nullability \
# 	--swift-friendly \
# 	$^
