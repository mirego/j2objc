
#kotlin subsection
KOTLIN_INTEROP_DIR = $(J2OBJC_ROOT)/kotlin-interop-test-cases
KOTLIN_INTEROP_JVM_JAR = $(KOTLIN_INTEROP_DIR)/build/libs/kotlin-interop-test-cases-jvm.jar
KOTLIN_NATIVE_FRAMEWORK = $(KOTLIN_INTEROP_DIR)/build/bin/native/Common.framework
KOTLIN_NATIVE_FRAMEWORK_LIB = $(KOTLIN_NATIVE_FRAMEWORK)/Common
KOTLIN_INTEROP_BUILD_OUTPUT_DIR = $(KOTLIN_INTEROP_DIR)/build
KOTLIN_NATIVE_DIR = $(J2OBJC_ROOT)/kotlin-native-tests/
KOTLIN_NATIVE_BUILD_OUTPUT_DIR = $(KOTLIN_NATIVE_DIR)/build_result
KOTLIN_NATIVE_SOURCE_DIR = $(KOTLIN_NATIVE_DIR)/src/test/java

# files here are disabled for j2objc jira to fix is noted after
KOTLIN_NATIVE_J2OBJC_DISABLED_TESTS = \
	DefaultConstructorWithDefaultValue.h \
	DefaultConstructorWithDefaultValue.m \
	DefaultConstructorWithNullableIntParameter.h \
	DefaultConstructorWithNullableIntParameter.m \
	DefaultConstructorWithListParameter.h \
	DefaultConstructorWithListParameter.m \
	DefaultConstructorWithMutableListParameter.h \
	DefaultConstructorWithMutableListParameter.m \
	WithInt.h \
	WithInt.m \
	WithList.h \
	WithList.m \
	WithNullableInt.h \
	WithNullableInt.m

KOTLIN_INTEROP_JAVA_SOURCES_DIR = $(KOTLIN_INTEROP_DIR)/src/commonMain/kotlin/com/mirego/interop/java/test
KOTLIN_INTEROP_JAVA_SOURCES = $(shell find $(KOTLIN_INTEROP_JAVA_SOURCES_DIR) -name '*.java')
KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR = $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)/generated_objc/test_cases

KOTLIN_NATIVE_JAVA_SOURCES = $(shell find $(KOTLIN_NATIVE_SOURCE_DIR) -name '*.java')
KOTLIN_NATIVE_J2OBJC_OUTPUT_DIR = $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)/generated_objc/tests

J2OBJC_EXE = $(DIST_DIR)/j2objc
J2OBJCC_EXE = $(DIST_DIR)/j2objcc
GW = ./gradlew

kotlin_clean: kotlin_clean_interop kotlin_clean_native

kotlin_clean_interop:
	@rm -rf $(KOTLIN_INTEROP_BUILD_OUTPUT_DIR)

kotlin: kotlin_interop kotlin_native_tests

kotlin_interop:
	@cd $(KOTLIN_INTEROP_DIR) && $(GW) jvmJar
	@cd $(KOTLIN_INTEROP_DIR) && $(GW) copyFrameworkNative
	@mkdir -p $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR)
	@cp $(KOTLIN_NATIVE_FRAMEWORK)/Headers/Common.h $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR)

kotlin_clean_native:
	@rm -rf $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)

kotlin_native_tests: kotlin_translate_tests kotlin_compile_tests kotlin_run_tests

kotlin_translate_tests:
	$(J2OBJC_EXE) \
	-classpath $(TEST_CLASSPATH)  \
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

KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES = $(shell find $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR) -name '*.m')

kotlin_remove_disabled_tests:
	@cd $(KOTLIN_INTEROP_J2OBJC_OUTPUT_DIR) && rm -r $(KOTLIN_NATIVE_J2OBJC_DISABLED_TESTS)

kotlin_compile_tests: kotlin_remove_disabled_tests
	$(J2OBJCC_EXE) \
	-ObjC \
	-Wno-objc-property-no-attribute \
	-ljunit $(KOTLIN_NATIVE_FRAMEWORK_LIB) \
	-o $(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)/nativeTests \
	$(KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES)

kotlin_run_tests:
	$(KOTLIN_NATIVE_BUILD_OUTPUT_DIR)/nativeTests org.junit.runner.JUnitCore NativeTestSuite
