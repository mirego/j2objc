includeBuild("annotations")
includeBuild("cycle_finder")
includeBuild("jre_emul")
includeBuild("translator")

// Not using Protobuf feature, not doing this for now
// includeBuild("protobuf/tests")
// includeBuild("tree_shaker")

// kotlin interop >>
includeBuild("kompat")
includeBuild("kotlin-interop-test-cases")
// kotlin interop <<
