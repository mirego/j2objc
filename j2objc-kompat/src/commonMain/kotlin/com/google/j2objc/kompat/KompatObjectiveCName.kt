package com.google.j2objc.kompat

/**
 * Annotation that specifies what the Objective-C class, protocol, method,
 * constructor should be when translated. Usable in kotlin files
 *
 * <p>For classes specify the desired Objective-C class name for the translated type.
 *
 * <p>For methods specify the desired Objective-C selector for the translated method:
 * <pre>
 * &#64;KompatObjectiveCName("setDateWithYear:month:day:")
 * fun setDate(int year, int month, int day)</pre>
 *
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
)
@Retention(AnnotationRetention.BINARY)
annotation class KompatObjectiveCName(val name: String = "")
