Pod::Spec.new do |s|
  s.name                = "J2ObjC@mirego"
  s.version             = '2.0.5'
  s.license             = { :type => 'Apache 2.0', :file => 'LICENSE' }
  s.homepage            = "https://developers.google.com/j2objc/"
  s.author              = { "Tom Ball" => "tball@google.com" }
  s.summary             = "J2ObjC is an open-source command-line tool from Google that translates Java source code to Objective-C for the iOS platform."

  s.source              = { :http => 'https://github.com/mirego/j2objc/releases/download/2.0.5-mirego-frameworks/j2objc-2.0.5-mirego-frameworks.zip' }
  s.platform            = :ios, "8.0"
  s.requires_arc        = true

  #s.source_files        = 'JRE.framework/Headers/*.h', 'JSR305.framework/Headers/*.h'
  #s.public_header_files = 'JRE.framework/Headers/*.h', 'JSR305.framework/Headers/*.h'
  s.vendored_frameworks = ['JRE.framework', 'JSR305.framework']
  s.preserve_paths      = ['j2objc', 'JRE.framework/*', 'JSR305.framework/*']
  s.frameworks          = 'Security'
  s.libraries           = 'iconv', 'icucore', 'z' # icucore might be useless
end
