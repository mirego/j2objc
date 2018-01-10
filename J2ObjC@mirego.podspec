Pod::Spec.new do |s|
  s.name         = 'J2ObjC@mirego'
  s.version      = '1.0.0.2' # Don't forget to change it in 's.prepare_command' too
  s.summary      = 'Java to iOS Objective-C translation tool and runtime.'
  s.description  = "J2ObjC is an open-source command-line tool from Google that translates Java source code to Objective-C for the iOS (iPhone/iPad) platform. This tool enables Java source to be part of an iOS application's build, as no editing of the generated files is necessary. The goal is to write an app's non-UI code (such as application logic and data models) in Java, which is then shared by web apps (using GWT), Android apps, and iOS apps."
  s.homepage     = 'http://j2objc.org/'
  s.author       = 'Google Inc.'
  s.license      = { :type => 'Apache License, Version 2.0', :file => 'LICENSE' }
  s.source       = { :git => 'https://github.com/mirego/j2objc.git', :tag => s.version.to_s + '-mirego' }

  s.prepare_command = <<-CMD
J2OBJC_VERSION="1.0.0.2-mirego"
J2OBJC_VERSION_SOURCE="mirego"
J2OBJC_BASE_DIR="${HOME}/.j2objc"
J2OBJC_DIR="${J2OBJC_BASE_DIR}/j2objc-${J2OBJC_VERSION}"
J2OBJC_ZIP="${J2OBJC_DIR}.zip"
J2OBJC_URL="https://github.com/${J2OBJC_VERSION_SOURCE}/j2objc/releases/download/${J2OBJC_VERSION}/j2objc-${J2OBJC_VERSION}.zip"

if [ ! -d "${J2OBJC_DIR}" ]; then
  echo "Downloading J2ObjC ${J2OBJC_VERSION} to ${J2OBJC_ZIP}"
  mkdir -p ${J2OBJC_BASE_DIR}
  curl -o ${J2OBJC_ZIP} -L ${J2OBJC_URL} --progress-bar

  echo "Unpacking J2ObjC ${J2OBJC_VERSION}"
  unzip -q -o ${J2OBJC_ZIP} -d ${J2OBJC_BASE_DIR}
  rm -f ${J2OBJC_ZIP}
fi

echo "Preparing J2ObjC ${J2OBJC_VERSION}"

LIBRARIES=( "JRE:libjre_emul"
            "Guava:libguava"
            "JavaxInject:libjavax_inject"
            "JSR305:libjsr305"
            "JUnit:libjunit"
            "Mockito:libmockito"
            "ProtobufRuntime:libprotobuf_runtime"
            "Xalan:libxalan"
            )

RESOURCES=( "Xalan"
            )

PLATFORMS=( "ios:."
            "watchos:watchos"
            "tvos:appletvos"
            "osx:macosx"
            )

for library in "${LIBRARIES[@]}" ; do
  LIB_NAME="${library%%:*}"
  LIB_FILE="${library##*:}"

  echo "Preparing ${LIB_NAME}"

  for platform in "${PLATFORMS[@]}" ; do
    PLAT_DST="${platform%%:*}"
    PLAT_SRC="${platform##*:}"

    mkdir -p ${LIB_NAME}/lib/${PLAT_DST}
    cp ${J2OBJC_DIR}/lib/${PLAT_SRC}/${LIB_FILE}.a ${LIB_NAME}/lib/${PLAT_DST}/${LIB_FILE}.a
  done

  mkdir -p ${LIB_NAME}/src
  cp -R ${J2OBJC_DIR}/frameworks/${LIB_NAME}.framework/Versions/A/Headers/* ${LIB_NAME}/src
done

for RESOURCE in "${RESOURCES[@]}" ; do
  mkdir -p ${RESOURCE}/resources
  cp -R ${J2OBJC_DIR}/frameworks/${RESOURCE}.framework/Versions/A/Resources/* ${LIB_NAME}/resources
done
CMD

  s.ios.deployment_target = '7.0'
  s.osx.deployment_target = '10.11'
  s.watchos.deployment_target = '2.0'
  s.tvos.deployment_target = '9.0'

  s.requires_arc = false
  s.compiler_flags = '-Wno-strict-prototypes', '-Wno-documentation'

  s.default_subspec = 'jre_emul'

  s.frameworks = 'Foundation', 'Security'
  s.ios.frameworks = 'UIKit'
  s.osx.frameworks = 'ExceptionHandling'

  # All in one JRE Library

  s.subspec 'jre_emul' do |sp|
    sp.source_files = 'JRE/src/**/*.h'
    sp.header_mappings_dir = 'JRE/src'
    sp.ios.vendored_libraries = 'JRE/lib/ios/libjre_emul.a'
    sp.watchos.vendored_libraries = 'JRE/lib/watchos/libjre_emul.a'
    sp.tvos.vendored_libraries = 'JRE/lib/tvos/libjre_emul.a'
    sp.osx.vendored_libraries = 'JRE/lib/osx/libjre_emul.a'
    sp.libraries = 'z'
  end

  # Other J2ObjC Libraries

  s.subspec 'guava' do |sp|
    sp.source_files = 'Guava/src/**/*.h'
    sp.header_mappings_dir = 'Guava/src'
    sp.ios.vendored_libraries = 'Guava/lib/ios/libguava.a'
    sp.watchos.vendored_libraries = 'Guava/lib/watchos/libguava.a'
    sp.tvos.vendored_libraries = 'Guava/lib/tvos/libguava.a'
    sp.osx.vendored_libraries = 'Guava/lib/osx/libguava.a'
    sp.dependency 'J2ObjC@mirego/jre_emul'
    sp.dependency 'J2ObjC@mirego/jsr305'
  end

  s.subspec 'javax_inject' do |sp|
    sp.source_files = 'JavaxInject/src/**/*.h'
    sp.header_mappings_dir = 'JavaxInject/src'
    sp.ios.vendored_libraries = 'JavaxInject/lib/ios/libjavax_inject.a'
    sp.watchos.vendored_libraries = 'JavaxInject/lib/watchos/libjavax_inject.a'
    sp.tvos.vendored_libraries = 'JavaxInject/lib/tvos/libjavax_inject.a'
    sp.osx.vendored_libraries = 'JavaxInject/lib/osx/libjavax_inject.a'
    sp.dependency 'J2ObjC@mirego/jre_emul'
  end

  s.subspec 'jsr305' do |sp|
    sp.source_files = 'JSR305/src/**/*.h'
    sp.header_mappings_dir = 'JSR305/src'
    sp.ios.vendored_libraries = 'JSR305/lib/ios/libjsr305.a'
    sp.watchos.vendored_libraries = 'JSR305/lib/watchos/libjsr305.a'
    sp.tvos.vendored_libraries = 'JSR305/lib/tvos/libjsr305.a'
    sp.osx.vendored_libraries = 'JSR305/lib/osx/libjsr305.a'
    sp.dependency 'J2ObjC@mirego/jre_emul'
  end

  s.subspec 'junit' do |sp|
    sp.source_files = 'JUnit/src/**/*.h'
    sp.header_mappings_dir = 'JUnit/src'
    sp.ios.vendored_libraries = 'JUnit/lib/ios/libjunit.a'
    sp.watchos.vendored_libraries = 'JUnit/lib/watchos/libjunit.a'
    sp.tvos.vendored_libraries = 'JUnit/lib/tvos/libjunit.a'
    sp.osx.vendored_libraries = 'JUnit/lib/osx/libjunit.a'
    sp.xcconfig = { 'OTHER_LDFLAGS' => '-ObjC' }
    sp.dependency 'J2ObjC@mirego/jre_emul'
  end

  s.subspec 'mockito' do |sp|
    sp.source_files = 'Mockito/src/**/*.h'
    sp.header_mappings_dir = 'Mockito/src'
    sp.ios.vendored_libraries = 'Mockito/lib/ios/libmockito.a'
    sp.watchos.vendored_libraries = 'Mockito/lib/watchos/libmockito.a'
    sp.tvos.vendored_libraries = 'Mockito/lib/tvos/libmockito.a'
    sp.osx.vendored_libraries = 'Mockito/lib/osx/libmockito.a'
    sp.xcconfig = { 'OTHER_LDFLAGS' => '-ObjC' }
    sp.dependency 'J2ObjC@mirego/jre_emul'
    sp.dependency 'J2ObjC@mirego/junit'
  end

  s.subspec 'protobuf_runtime' do |sp|
    sp.source_files = 'ProtobufRuntime/src/**/*.h'
    sp.header_mappings_dir = 'ProtobufRuntime/src'
    sp.ios.vendored_libraries = 'ProtobufRuntime/lib/ios/libprotobuf_runtime.a'
    sp.watchos.vendored_libraries = 'ProtobufRuntime/lib/watchos/libprotobuf_runtime.a'
    sp.tvos.vendored_libraries = 'ProtobufRuntime/lib/tvos/libprotobuf_runtime.a'
    sp.osx.vendored_libraries = 'ProtobufRuntime/lib/osx/libprotobuf_runtime.a'
    sp.libraries = 'c++'
    sp.dependency 'J2ObjC@mirego/jre_emul'
  end

  s.subspec 'xalan' do |sp|
    sp.source_files = 'Xalan/src/**/*.h'
    sp.header_mappings_dir = 'Xalan/src'
    sp.resources = 'Xalan/resources'
    sp.ios.vendored_libraries = 'Xalan/lib/ios/libxalan.a'
    sp.watchos.vendored_libraries = 'Xalan/lib/watchos/libxalan.a'
    sp.tvos.vendored_libraries = 'Xalan/lib/tvos/libxalan.a'
    sp.osx.vendored_libraries = 'Xalan/lib/osx/libxalan.a'
    sp.dependency 'J2ObjC@mirego/jre_emul'
  end
end
