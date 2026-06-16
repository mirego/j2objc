// swift-tools-version:5.9
import PackageDescription

// J2ObjCRuntime — the Mirego J2ObjC 3.1 runtime, distributed for Swift Package
// Manager directly from this (public) repo. Mirrors the `J2ObjC@mirego` CocoaPod
// (jre_emul + jsr305 subspecs):
//   - JRE     -> JRE.xcframework     (libjre_emul.a, flat headers under Headers/)
//   - JSR305  -> JSR305.xcframework  (libjsr305.a)
//
// The xcframeworks carry flat headers and NO module map; consumers use bare
// imports (e.g. `#import <IOSClass.h>`). The binaries are published as assets on
// this repo's GitHub Release (tag 3.1.0). A single regular wrapper target depends
// on both binaries and carries the runtime's link settings — all "safe" settings,
// so the package stays SemVer-versionable.
let package = Package(
    name: "J2ObjCRuntime",
    platforms: [
        .iOS(.v12)
    ],
    products: [
        .library(name: "J2ObjCRuntime", targets: ["J2ObjCRuntime"])
    ],
    targets: [
        .binaryTarget(
            name: "JRE",
            url: "https://github.com/mirego/j2objc/releases/download/3.1.0/JRE.xcframework.zip",
            checksum: "57ccdb38e1eed2b81dd35821920c7cd155252de8382ee159804c6cdd11300bb3"
        ),
        .binaryTarget(
            name: "JSR305",
            url: "https://github.com/mirego/j2objc/releases/download/3.1.0/JSR305.xcframework.zip",
            checksum: "7e71d45b21344d3a43e7adc402709e5af161fe01741487cee9477c516136bbc7"
        ),
        .target(
            name: "J2ObjCRuntime",
            dependencies: ["JRE", "JSR305"],
            path: "Sources/J2ObjCRuntime",
            linkerSettings: [
                .linkedLibrary("iconv"),
                .linkedLibrary("z"),
                .linkedFramework("Foundation"),
                .linkedFramework("Security"),
                .linkedFramework("UIKit", .when(platforms: [.iOS]))
            ]
        )
    ]
)
