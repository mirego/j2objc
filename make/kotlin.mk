# kotlin interop >>

KOTLIN_KOMPAT_DIR = $(J2OBJC_ROOT)/j2objc-kompat
KOTLIN_KOMPAT_BUILD_OUTPUT_DIR = $(KOTLIN_KOMPAT_DIR)/build
KOTLIN_KOMPAT_FRAMEWORK = $(KOTLIN_KOMPAT_BUILD_OUTPUT_DIR)/bin/macosArm64/debugFramework/common.framework
KOTLIN_KOMPAT_FRAMEWORK_LIB = $(KOTLIN_KOMPAT_FRAMEWORK)/common
KOTLIN_KOMPAT_JVM_JAR = $(KOTLIN_KOMPAT_BUILD_OUTPUT_DIR)/libs/j2objc-kompat-jvm-3.0.jar

KOTLIN_INTEROP_TEST_CASES_DIR = $(J2OBJC_ROOT)/kotlin-interop-test-cases
KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR = $(KOTLIN_INTEROP_TEST_CASES_DIR)/build
KOTLIN_INTEROP_TEST_CASES_FRAMEWORK = $(KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR)/bin/macosArm64/debugFramework/common.framework
KOTLIN_INTEROP_TEST_CASES_FRAMEWORK_LIB = $(KOTLIN_INTEROP_TEST_CASES_FRAMEWORK)/common
KOTLIN_INTEROP_TEST_CASES_JVM_JAR = $(KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR)/libs/kotlin-test-cases-jvm-3.0.jar

KOTLIN_NATIVE_TESTS_DIR = $(J2OBJC_ROOT)/kotlin-native-tests
KOTLIN_NATIVE_TESTS_BUILD_OUTPUT_DIR = $(KOTLIN_NATIVE_TESTS_DIR)/build_result
KOTLIN_NATIVE_TESTS_SOURCES_DIR = $(KOTLIN_NATIVE_TESTS_DIR)/src/test/java
KOTLIN_NATIVE_TESTS_SOURCES = $(shell find $(KOTLIN_NATIVE_TESTS_SOURCES_DIR) -name '*.java')
KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES_DIR = $(KOTLIN_NATIVE_TESTS_BUILD_OUTPUT_DIR)/test_cases
KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES = $(shell find $(KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES_DIR) -name '*.m')

TRANSLATOR_DIR = $(J2OBJC_ROOT)/translator
TRANSLATOR_TEST_SOURCES_DIR = $(TRANSLATOR_DIR)/src/test/java/com/mirego/interop/java/test
TRANSLATOR_TEST_SOURCES = $(shell find $(TRANSLATOR_TEST_SOURCES_DIR) -name '*.java')

J2OBJC_EXE = $(DIST_DIR)/j2objc
J2OBJCC_EXE = $(DIST_DIR)/j2objcc
GW = ./gradlew

kotlin_clean: kotlin_clean_interop_test_cases kotlin_clean_native_tests

kotlin_clean_kompat:
	@rm -rf $(KOTLIN_KOMPAT_BUILD_OUTPUT_DIR)

kotlin_clean_interop_test_cases:
	@rm -rf $(KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR)

kotlin_clean_native_tests:
	@rm -rf $(KOTLIN_NATIVE_TESTS_BUILD_OUTPUT_DIR)

kotlin_kompat:
	@cd $(KOTLIN_KOMPAT_DIR) && $(GW) jvmJar j2objcKotlinTypes
	@cp $(KOTLIN_KOMPAT_JVM_JAR) $(DIST_DIR)/lib

kotlin_interop_test_cases: kotlin_kompat
	@cd $(KOTLIN_INTEROP_TEST_CASES_DIR) && $(GW) jvmJar linkDebugFrameworkMacosArm64
	@mkdir -p $(KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR)/Headers/common
	@cp -fp $(KOTLIN_INTEROP_TEST_CASES_FRAMEWORK)/Headers/common.h $(KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR)/Headers/common

kotlin_native_tests_deps:
	@cd $(J2OBJC_ROOT) && $(MAKE) junit_dist

kotlin_translator:
	@cd $(TRANSLATOR_DIR) && $(MAKE) translator

kotlin_translate_tests: kotlin_interop_test_cases kotlin_native_tests_deps kotlin_translator
	@$(J2OBJC_EXE) \
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
	-use-arc \
	--header-mapping $(KOTLIN_NATIVE_TESTS_DIR)/header-mapping.j2objc \
	--prefixes $(KOTLIN_NATIVE_TESTS_DIR)/prefixes.properties \
	-d $(KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES_DIR) \
	$(TRANSLATOR_TEST_SOURCES) \
	$(KOTLIN_NATIVE_TESTS_SOURCES)

kotlin_compile_tests: kotlin_translate_tests
	@$(J2OBJCC_EXE) \
	-ObjC \
	-Wno-objc-property-no-attribute \
	-Wno-pointer-sign \
	-Wno-unused-value \
	-Wno-incomplete-implementation \
	-Wno-deprecated-declarations \
	-fobjc-arc -fobjc-arc-exceptions \
	-I$(KOTLIN_INTEROP_TEST_CASES_BUILD_OUTPUT_DIR)/Headers \
	-ljre_emul -ljunit $(KOTLIN_INTEROP_TEST_CASES_FRAMEWORK_LIB) \
	-o $(KOTLIN_NATIVE_TESTS_BUILD_OUTPUT_DIR)/nativeTests \
	$(KOTLIN_NATIVE_TESTS_J2OBJC_OUTPUT_SOURCES)

kotlin_run_tests: kotlin_compile_tests
	$(KOTLIN_NATIVE_TESTS_BUILD_OUTPUT_DIR)/nativeTests org.junit.runner.JUnitCore com.google.devtools.j2objc.runtime.NativeTests

# kotlin interop <<
