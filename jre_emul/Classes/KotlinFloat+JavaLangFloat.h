// kotlin interop >>

#import <Foundation/Foundation.h>
#include "J2ObjC_header.h"
#import "J2ObjC_kotlinTypes.h"

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#ifndef _KotlinFloat_JavaLangFloat_h_
#define _KotlinFloat_JavaLangFloat_h_

#include "java/lang/Comparable.h"

@class IOSClass;
@class CommonBoolean;
@class CommonByte;
@class CommonDouble;
@class CommonInt;
@class CommonLong;
@class CommonShort;
@class NSString;

/*!
 @brief The <code>Float</code> class wraps a value of primitive type 
 <code>float</code> in an object.An object of type 
 <code>Float</code> contains a single field whose type is 
 <code>float</code>.
 <p>In addition, this class provides several methods for converting a 
 <code>float</code> to a <code>String</code> and a 
 <code>String</code> to a <code>float</code>, as well as other
  constants and methods useful when dealing with a 
 <code>float</code>.
  
 <!-- Android-removed: paragraph on ValueBased
 <p>This is a <a href="{@@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>
 class; programmers should treat instances that are
 {@@linkplain #equals(Object) equal} as interchangeable and should not
 use instances for synchronization, or unpredictable behavior may
 occur. For example, in a future release, synchronization may fail.
 -->
  
 <h2><a id=equivalenceRelation>Floating-point Equality, Equivalence,
  and Comparison</a></h2>
  The class <code>java.lang.Double</code> has a <a href="Double.html#equivalenceRelation">
 discussion of equality,
  equivalence, and comparison of floating-point values</a> that is
  equality applicable to <code>float</code> values.
 @author Lee Boynton
 @author Arthur van Hoff
 @author Joseph D. Darcy
 @since 1.0
 */
@interface CommonFloat (JavaLangFloat) < JavaIoSerializable, CommonKotlinComparable >

#pragma mark Public

/*!
 @brief Constructs a newly allocated <code>Float</code> object that
  represents the argument converted to type <code>float</code>.
 @param value the value to be represented by the <code>Float</code> .
 */
- (instancetype __nonnull)initWithDouble:(double)value;

/*!
 @brief Constructs a newly allocated <code>Float</code> object that
  represents the primitive <code>float</code> argument.
 @param value the value to be represented by the <code>Float</code> .
 */
- (instancetype __nonnull)initWithFloat:(float)value;

/*!
 @brief Constructs a newly allocated <code>Float</code> object that
  represents the floating-point value of type <code>float</code>
  represented by the string.The string is converted to a 
 <code>float</code> value as if by the <code>valueOf</code> method.
 @param s a string to be converted to a <code>Float</code> .
 @throw NumberFormatExceptionif the string does not contain a
               parsable number.
 */
- (instancetype __nonnull)initWithNSString:(NSString *)s;

/*!
 @brief Returns the value of this <code>Float</code> as a <code>byte</code> after
  a narrowing primitive conversion.
 @return the <code>float</code> value represented by this object
           converted to type <code>byte</code>
 */
- (jbyte)charValue;

/*!
 @brief Compares the two specified <code>float</code> values.The sign
  of the integer value returned is the same as that of the
  integer that would be returned by the call: 
 @code

     new Float(f1).compareTo(new Float(f2)) 
  
@endcode
 @param f1 the first <code>float</code>  to compare.
 @param f2 the second <code>float</code>  to compare.
 @return the value <code>0</code> if <code>f1</code> is
           numerically equal to <code>f2</code>; a value less than
           <code>0</code> if <code>f1</code> is numerically less than
           <code>f2</code>; and a value greater than <code>0</code>
           if <code>f1</code> is numerically greater than
           <code>f2</code>.
 @since 1.4
 */
+ (jint)compareWithFloat:(float)f1
                  withFloat:(float)f2;

/*!
 @brief Compares two <code>Float</code> objects numerically.
 This method imposes a total order on <code>Float</code> objects
  with two differences compared to the incomplete order defined by
  the Java language numerical comparison operators (<code><, <=,
  ==, >=, ></code>
 ) on <code>float</code> values. 
 <ul><li> A NaN is <em>unordered</em> with respect to other
           values and unequal to itself under the comparison
           operators.  This method chooses to define <code>Float.NaN</code>
  to be equal to itself and greater than all
           other <code>double</code> values (including <code>Float.POSITIVE_INFINITY</code>
 ).
       <li> Positive zero and negative zero compare equal
       numerically, but are distinct and distinguishable values.
       This method chooses to define positive zero (<code>+0.0f</code>),
       to be greater than negative zero (<code>-0.0f</code>).
  </ul>
  This ensures that the <i>natural ordering</i> of <code>Float</code>
  objects imposed by this method is <i>consistent with
  equals</i>; see <a href="Double.html#equivalenceRelation">this
  discussion</a> for details of floating-point comparison and
  ordering.
 @param anotherFloat the <code>Float</code>  to be compared.
 @return the value <code>0</code> if <code>anotherFloat</code> is
           numerically equal to this <code>Float</code>; a value
           less than <code>0</code> if this <code>Float</code>
           is numerically less than <code>anotherFloat</code>;
           and a value greater than <code>0</code> if this
           <code>Float</code> is numerically greater than
           <code>anotherFloat</code>.
 @since 1.2
 */
- (jint)compareToWithId:(CommonFloat *)anotherFloat;

/*!
 @brief Returns the value of this <code>Float</code> as a <code>double</code>
  after a widening primitive conversion.
 @return the <code>float</code> value represented by this
          object converted to type <code>double</code>
 */
- (double)doubleValue;

/*!
 @brief Compares this object against the specified object.The result
  is <code>true</code> if and only if the argument is not 
 <code>null</code> and is a <code>Float</code> object that
  represents a <code>float</code> with the same value as the 
 <code>float</code> represented by this object.
 For this
  purpose, two <code>float</code> values are considered to be the
  same if and only if the method <code>floatToIntBits(float)</code>
  returns the identical <code>int</code> value when applied to
  each.
 @param obj the object to be compared
 @return <code>true</code> if the objects are the same;
           <code>false</code> otherwise.
 - seealso: java.lang.Float#floatToIntBits(float)
 */
- (jboolean)isEqual:(id)obj;

/*!
 @brief Returns a representation of the specified floating-point value
  according to the IEEE 754 floating-point "single format" bit
  layout.
 <p>Bit 31 (the bit that is selected by the mask 
 <code>0x80000000</code>) represents the sign of the floating-point
  number.
  Bits 30-23 (the bits that are selected by the mask 
 <code>0x7f800000</code>) represent the exponent.
  Bits 22-0 (the bits that are selected by the mask 
 <code>0x007fffff</code>) represent the significand (sometimes called
  the mantissa) of the floating-point number. 
 <p>If the argument is positive infinity, the result is 
 <code>0x7f800000</code>.
  
 <p>If the argument is negative infinity, the result is 
 <code>0xff800000</code>.
  
 <p>If the argument is NaN, the result is <code>0x7fc00000</code>.
  
 <p>In all cases, the result is an integer that, when given to the 
 <code>intBitsToFloat(int)</code> method, will produce a floating-point
  value the same as the argument to <code>floatToIntBits</code>
  (except all NaN values are collapsed to a single
  "canonical" NaN value).
 @param value a floating-point number.
 @return the bits that represent the floating-point number.
 */
+ (jint)floatToIntBitsWithFloat:(float)value;

/*!
 @brief Returns a representation of the specified floating-point value
  according to the IEEE 754 floating-point "single format" bit
  layout, preserving Not-a-Number (NaN) values.
 <p>Bit 31 (the bit that is selected by the mask 
 <code>0x80000000</code>) represents the sign of the floating-point
  number.
  Bits 30-23 (the bits that are selected by the mask 
 <code>0x7f800000</code>) represent the exponent.
  Bits 22-0 (the bits that are selected by the mask 
 <code>0x007fffff</code>) represent the significand (sometimes called
  the mantissa) of the floating-point number. 
 <p>If the argument is positive infinity, the result is 
 <code>0x7f800000</code>.
  
 <p>If the argument is negative infinity, the result is 
 <code>0xff800000</code>.
  
 <p>If the argument is NaN, the result is the integer representing
  the actual NaN value.  Unlike the <code>floatToIntBits</code>
  method, <code>floatToRawIntBits</code> does not collapse all the
  bit patterns encoding a NaN to a single "canonical"
  NaN value. 
 <p>In all cases, the result is an integer that, when given to the 
 <code>intBitsToFloat(int)</code> method, will produce a
  floating-point value the same as the argument to 
 <code>floatToRawIntBits</code>.
 @param value a floating-point number.
 @return the bits that represent the floating-point number.
 @since 1.3
 */
+ (jint)floatToRawIntBitsWithFloat:(float)value;

/*!
 @brief Returns the <code>float</code> value of this <code>Float</code> object.
 @return the <code>float</code> value represented by this object
 */
- (float)floatValue;

/*!
 @brief Returns a hash code for this <code>Float</code> object.The
  result is the integer bit representation, exactly as produced
  by the method <code>floatToIntBits(float)</code>, of the primitive 
 <code>float</code> value represented by this <code>Float</code>
  object.
 @return a hash code value for this object.
 */
- (NSUInteger)hash;

/*!
 @brief Returns a hash code for a <code>float</code> value; compatible with 
 <code>Float.hashCode()</code>.
 @param value the value to hash
 @return a hash code value for a <code>float</code> value.
 @since 1.8
 */
+ (jint)hashCodeWithFloat:(float)value;

/*!
 @brief Returns the <code>float</code> value corresponding to a given
  bit representation.
 The argument is considered to be a representation of a
  floating-point value according to the IEEE 754 floating-point
  "single format" bit layout. 
 <p>If the argument is <code>0x7f800000</code>, the result is positive
  infinity. 
 <p>If the argument is <code>0xff800000</code>, the result is negative
  infinity. 
 <p>If the argument is any value in the range 
 <code>0x7f800001</code> through <code>0x7fffffff</code> or in
  the range <code>0xff800001</code> through 
 <code>0xffffffff</code>, the result is a NaN.  No IEEE 754
  floating-point operation provided by Java can distinguish
  between two NaN values of the same type with different bit
  patterns.  Distinct values of NaN are only distinguishable by
  use of the <code>Float.floatToRawIntBits</code> method. 
 <p>In all other cases, let <i>s</i>, <i>e</i>, and <i>m</i> be three
  values that can be computed from the argument: 
 <blockquote>@code
 int s = ((bits >> 31) == 0) ? 1 : -1;
  int e = ((bits >> 23) & 0xff);
  int m = (e == 0) ?
                  (bits & 0x7fffff) << 1 :
                  (bits & 0x7fffff) | 0x800000; 
 
@endcode</blockquote>
  Then the floating-point result equals the value of the mathematical
  expression <i>s</i>&middot;<i>m</i>&middot;2<sup><i>e</i>-150</sup>.
  
 <p>Note that this method may not be able to return a 
 <code>float</code> NaN with exactly same bit pattern as the 
 <code>int</code> argument.  IEEE 754 distinguishes between two
  kinds of NaNs, quiet NaNs and <i>signaling NaNs</i>.  The
  differences between the two kinds of NaN are generally not
  visible in Java.  Arithmetic operations on signaling NaNs turn
  them into quiet NaNs with a different, but often similar, bit
  pattern.  However, on some processors merely copying a
  signaling NaN also performs that conversion.  In particular,
  copying a signaling NaN to return it to the calling method may
  perform this conversion.  So <code>intBitsToFloat</code> may
  not be able to return a <code>float</code> with a signaling NaN
  bit pattern.  Consequently, for some <code>int</code> values, 
 <code>floatToRawIntBits(intBitsToFloat(start))</code> may 
 <i>not</i> equal <code>start</code>.  Moreover, which
  particular bit patterns represent signaling NaNs is platform
  dependent; although all NaN bit patterns, quiet or signaling,
  must be in the NaN range identified above.
 @param bits an integer.
 @return the <code>float</code> floating-point value with the same bit
           pattern.
 */
+ (float)intBitsToFloatWithInt:(jint)bits;

/*!
 @brief Returns the value of this <code>Float</code> as an <code>int</code> after
  a narrowing primitive conversion.
 @return the <code>float</code> value represented by this object
           converted to type <code>int</code>
 */
- (jint)intValue;

/*!
 @brief Returns <code>true</code> if the argument is a finite floating-point
  value; returns <code>false</code> otherwise (for NaN and infinity
  arguments).
 @param f the <code>float</code>  value to be tested
 @return <code>true</code> if the argument is a finite
  floating-point value, <code>false</code> otherwise.
 @since 1.8
 */
+ (jboolean)isFiniteWithFloat:(float)f;

/*!
 @brief Returns <code>true</code> if this <code>Float</code> value is
  infinitely large in magnitude, <code>false</code> otherwise.
 @return <code>true</code> if the value represented by this object is
           positive infinity or negative infinity;          
 <code>false</code> otherwise.
 */
- (jboolean)isInfinite;

/*!
 @brief Returns <code>true</code> if the specified number is infinitely
  large in magnitude, <code>false</code> otherwise.
 @param v the value to be tested.
 @return <code>true</code> if the argument is positive infinity or
           negative infinity; <code>false</code> otherwise.
 */
+ (jboolean)isInfiniteWithFloat:(float)v;

/*!
 @brief Returns <code>true</code> if this <code>Float</code> value is a
  Not-a-Number (NaN), <code>false</code> otherwise.
 @return <code>true</code> if the value represented by this object is
           NaN; <code>false</code> otherwise.
 */
- (jboolean)isNaN;

/*!
 @brief Returns <code>true</code> if the specified number is a
  Not-a-Number (NaN) value, <code>false</code> otherwise.
 @param v the value to be tested.
 @return <code>true</code> if the argument is NaN;
           <code>false</code> otherwise.
 */
+ (jboolean)isNaNWithFloat:(float)v;

/*!
 @brief Returns value of this <code>Float</code> as a <code>long</code> after a
  narrowing primitive conversion.
 @return the <code>float</code> value represented by this object
           converted to type <code>long</code>
 */
- (jlong)longLongValue;

/*!
 @brief Returns the greater of two <code>float</code> values
  as if by calling <code>Math.max</code>.
 @param a the first operand
 @param b the second operand
 @return the greater of <code>a</code> and <code>b</code>
 - seealso: java.util.function.BinaryOperator
 @since 1.8
 */
+ (float)maxWithFloat:(float)a
            withFloat:(float)b;

/*!
 @brief Returns the smaller of two <code>float</code> values
  as if by calling <code>Math.min</code>.
 @param a the first operand
 @param b the second operand
 @return the smaller of <code>a</code> and <code>b</code>
 - seealso: java.util.function.BinaryOperator
 @since 1.8
 */
+ (float)minWithFloat:(float)a
            withFloat:(float)b;

/*!
 @brief Returns a new <code>float</code> initialized to the value
  represented by the specified <code>String</code>, as performed
  by the <code>valueOf</code> method of class <code>Float</code>.
 @param s the string to be parsed.
 @return the <code>float</code> value represented by the string
          argument.
 @throw NullPointerExceptionif the string is null
 @throw NumberFormatExceptionif the string does not contain a
                parsable <code>float</code>.
 - seealso: java.lang.Float#valueOf(String)
 @since 1.2
 */
+ (float)parseFloatWithNSString:(NSString *)s;

/*!
 @brief Returns the value of this <code>Float</code> as a <code>short</code>
  after a narrowing primitive conversion.
 @return the <code>float</code> value represented by this object
           converted to type <code>short</code>
 @since 1.1
 */
- (jshort)shortValue;

/*!
 @brief Adds two <code>float</code> values together as per the + operator.
 @param a the first operand
 @param b the second operand
 @return the sum of <code>a</code> and <code>b</code>
 - seealso: java.util.function.BinaryOperator
 @since 1.8
 */
+ (float)sumWithFloat:(float)a
            withFloat:(float)b;

/*!
 @brief Returns a hexadecimal string representation of the 
 <code>float</code> argument.All characters mentioned below are
  ASCII characters.
 <ul>
  <li>If the argument is NaN, the result is the string
      "<code>NaN</code>".
  <li>Otherwise, the result is a string that represents the sign and
  magnitude (absolute value) of the argument. If the sign is negative,
  the first character of the result is '<code>-</code>'
  (<code>'\u002D'</code>); if the sign is positive, no sign character
  appears in the result. As for the magnitude <i>m</i>:
  
 <ul>
  <li>If <i>m</i> is infinity, it is represented by the string 
 <code>"Infinity"</code>; thus, positive infinity produces the
  result <code>"Infinity"</code> and negative infinity produces
  the result <code>"-Infinity"</code>.
  
 <li>If <i>m</i> is zero, it is represented by the string 
 <code>"0x0.0p0"</code>; thus, negative zero produces the result 
 <code>"-0x0.0p0"</code> and positive zero produces the result 
 <code>"0x0.0p0"</code>.
  
 <li>If <i>m</i> is a <code>float</code> value with a
  normalized representation, substrings are used to represent the
  significand and exponent fields.  The significand is
  represented by the characters <code>"0x1."</code>
  followed by a lowercase hexadecimal representation of the rest
  of the significand as a fraction.  Trailing zeros in the
  hexadecimal representation are removed unless all the digits
  are zero, in which case a single zero is used. Next, the
  exponent is represented by <code>"p"</code> followed
  by a decimal string of the unbiased exponent as if produced by
  a call to <code>Integer.toString</code> on the
  exponent value. 
 <li>If <i>m</i> is a <code>float</code> value with a subnormal
  representation, the significand is represented by the
  characters <code>"0x0."</code> followed by a
  hexadecimal representation of the rest of the significand as a
  fraction.  Trailing zeros in the hexadecimal representation are
  removed. Next, the exponent is represented by 
 <code>"p-126"</code>.  Note that there must be at
  least one nonzero digit in a subnormal significand. 
 </ul>
  
 </ul>
  
 <table class="striped">
  <caption>Examples</caption>
  <thead>
  <tr><th scope="col">Floating-point Value</th><th scope="col">Hexadecimal String</th>
  </thead>
  <tbody>
  <tr><th scope="row"><code>1.0</code></th> <td><code>0x1.0p0</code></td>
  <tr><th scope="row"><code>-1.0</code></th>        <td><code>-0x1.0p0</code></td>
  <tr><th scope="row"><code>2.0</code></th> <td><code>0x1.0p1</code></td>
  <tr><th scope="row"><code>3.0</code></th> <td><code>0x1.8p1</code></td>
  <tr><th scope="row"><code>0.5</code></th> <td><code>0x1.0p-1</code></td>
  <tr><th scope="row"><code>0.25</code></th>        <td><code>0x1.0p-2</code></td>
  <tr><th scope="row"><code>Float.MAX_VALUE</code></th>
      <td><code>0x1.fffffep127</code></td>
  <tr><th scope="row"><code>Minimum Normal Value</code></th>
      <td><code>0x1.0p-126</code></td>
  <tr><th scope="row"><code>Maximum Subnormal Value</code></th>
      <td><code>0x0.fffffep-126</code></td>
  <tr><th scope="row"><code>Float.MIN_VALUE</code></th>
      <td><code>0x0.000002p-126</code></td>
  </tbody>
  </table>
 @param f the <code>float</code>  to be converted.
 @return a hex string representation of the argument.
 @since 1.5
 @author Joseph D. Darcy
 */
+ (NSString * __nonnull)toHexStringWithFloat:(float)f;

/*!
 @brief Returns a string representation of this <code>Float</code> object.
 The primitive <code>float</code> value represented by this object
  is converted to a <code>String</code> exactly as if by the method 
 <code>toString</code> of one argument.
 @return a <code>String</code> representation of this object.
 - seealso: java.lang.Float#toString(float)
 */
- (NSString * __nonnull)description;

/*!
 @brief Returns a string representation of the <code>float</code>
  argument.All characters mentioned below are ASCII characters.
 <ul>
  <li>If the argument is NaN, the result is the string
  "<code>NaN</code>".
  <li>Otherwise, the result is a string that represents the sign and
      magnitude (absolute value) of the argument. If the sign is
      negative, the first character of the result is
      '<code>-</code>' (<code>'\u002D'</code>); if the sign is
      positive, no sign character appears in the result. As for
      the magnitude <i>m</i>:
  <ul>
  <li>If <i>m</i> is infinity, it is represented by the characters
      <code>"Infinity"</code>; thus, positive infinity produces
      the result <code>"Infinity"</code> and negative infinity
      produces the result <code>"-Infinity"</code>.
  <li>If <i>m</i> is zero, it is represented by the characters
      <code>"0.0"</code>; thus, negative zero produces the result
      <code>"-0.0"</code> and positive zero produces the result
      <code>"0.0"</code>.
  <li> If <i>m</i> is greater than or equal to 10<sup>-3</sup> but
       less than 10<sup>7</sup>, then it is represented as the
       integer part of <i>m</i>, in decimal form with no leading
       zeroes, followed by '<code>.</code>'
       (<code>'\u002E'</code>), followed by one or more
       decimal digits representing the fractional part of      
 <i>m</i>.
  <li> If <i>m</i> is less than 10<sup>-3</sup> or greater than or
       equal to 10<sup>7</sup>, then it is represented in
       so-called "computerized scientific notation." Let <i>n</i>
       be the unique integer such that 10<sup><i>n</i> </sup>&le;
       <i>m</i> &lt; 10<sup><i>n</i>+1</sup>; then let <i>a</i>
       be the mathematically exact quotient of <i>m</i> and
       10<sup><i>n</i></sup> so that 1 &le; <i>a</i> &lt; 10.
       The magnitude is then represented as the integer part of      
 <i>a</i>, as a single decimal digit, followed by
       '<code>.</code>' (<code>'\u002E'</code>), followed by
       decimal digits representing the fractional part of      
 <i>a</i>, followed by the letter '<code>E</code>'
       (<code>'\u0045'</code>), followed by a representation
       of <i>n</i> as a decimal integer, as produced by the
       method <code>java.lang.Integer.toString(int)</code>.
  
 </ul>
  </ul>
  How many digits must be printed for the fractional part of 
 <i>m</i> or <i>a</i>? There must be at least one digit
  to represent the fractional part, and beyond that as many, but
  only as many, more digits as are needed to uniquely distinguish
  the argument value from adjacent values of type 
 <code>float</code>. That is, suppose that <i>x</i> is the
  exact mathematical value represented by the decimal
  representation produced by this method for a finite nonzero
  argument <i>f</i>. Then <i>f</i> must be the <code>float</code>
  value nearest to <i>x</i>; or, if two <code>float</code> values are
  equally close to <i>x</i>, then <i>f</i> must be one of
  them and the least significant bit of the significand of 
 <i>f</i> must be <code>0</code>.
  
 <p>To create localized string representations of a floating-point
  value, use subclasses of <code>java.text.NumberFormat</code>.
 @param f the float to be converted.
 @return a string representation of the argument.
 */
+ (NSString * __nonnull)toStringWithFloat:(float)f;

/*!
 @brief Returns a <code>Float</code> instance representing the specified 
 <code>float</code> value.
 If a new <code>Float</code> instance is not required, this method
  should generally be used in preference to the constructor 
 <code>Float(float)</code>, as this method is likely to yield
  significantly better space and time performance by caching
  frequently requested values.
 @param f a float value.
 @return a <code>Float</code> instance representing <code>f</code>.
 @since 1.5
 */
+ (CommonFloat * __nonnull)valueOfWithFloat:(float)f;

/*!
 @brief Returns a <code>Float</code> object holding the 
 <code>float</code> value represented by the argument string 
 <code>s</code>.
 <p>If <code>s</code> is <code>null</code>, then a 
 <code>NullPointerException</code> is thrown. 
 <p>Leading and trailing whitespace characters in <code>s</code>
  are ignored.  Whitespace is removed as if by the <code>String.trim</code>
  method; that is, both ASCII space and control
  characters are removed. The rest of <code>s</code> should
  constitute a <i>FloatValue</i> as described by the lexical
  syntax rules: 
 <blockquote>
  <dl>
  <dt><i>FloatValue:</i>
  <dd><i>Sign<sub>opt</sub></i> <code>NaN</code>
  <dd><i>Sign<sub>opt</sub></i> <code>Infinity</code>
  <dd><i>Sign<sub>opt</sub> FloatingPointLiteral</i>
  <dd><i>Sign<sub>opt</sub> HexFloatingPointLiteral</i>
  <dd><i>SignedInteger</i>
  </dl>
  
 <dl>
  <dt><i>HexFloatingPointLiteral</i>:
  <dd> <i>HexSignificand BinaryExponent FloatTypeSuffix<sub>opt</sub></i>
  </dl>
  
 <dl>
  <dt><i>HexSignificand:</i>
  <dd><i>HexNumeral</i>
  <dd><i>HexNumeral</i> <code>.</code>
  <dd><code>0x</code> <i>HexDigits<sub>opt</sub>
      </i><code>.</code><i> HexDigits</i>
  <dd><code>0X</code><i> HexDigits<sub>opt</sub>
      </i><code>.</code> <i>HexDigits</i>
  </dl>
  
 <dl>
  <dt><i>BinaryExponent:</i>
  <dd><i>BinaryExponentIndicator SignedInteger</i>
  </dl>
  
 <dl>
  <dt><i>BinaryExponentIndicator:</i>
  <dd><code>p</code>
  <dd><code>P</code>
  </dl>
  
 </blockquote>
  where <i>Sign</i>, <i>FloatingPointLiteral</i>,
  <i>HexNumeral</i>, <i>HexDigits</i>, <i>SignedInteger</i> and 
 <i>FloatTypeSuffix</i> are as defined in the lexical structure
  sections of 
 <cite>The Java Language Specification</cite>,
  except that underscores are not accepted between digits.
  If <code>s</code> does not have the form of
  a <i>FloatValue</i>, then a <code>NumberFormatException</code>
  is thrown. Otherwise, <code>s</code> is regarded as
  representing an exact decimal value in the usual
  "computerized scientific notation" or as an exact
  hexadecimal value; this exact numerical value is then
  conceptually converted to an "infinitely precise"
  binary value that is then rounded to type <code>float</code>
  by the usual round-to-nearest rule of IEEE 754 floating-point
  arithmetic, which includes preserving the sign of a zero
  value.
  Note that the round-to-nearest rule also implies overflow and
  underflow behaviour; if the exact value of <code>s</code> is large
  enough in magnitude (greater than or equal to (<code>MAX_VALUE</code>
  + <code>ulp(MAX_VALUE)</code>/2),
  rounding to <code>float</code> will result in an infinity and if the
  exact value of <code>s</code> is small enough in magnitude (less
  than or equal to <code>MIN_VALUE</code>/2), rounding to float will
  result in a zero.
  Finally, after rounding a <code>Float</code> object representing
  this <code>float</code> value is returned. 
 <p>To interpret localized string representations of a
  floating-point value, use subclasses of <code>java.text.NumberFormat</code>
 .
  
 <p>Note that trailing format specifiers, specifiers that
  determine the type of a floating-point literal
  (<code>1.0f</code> is a <code>float</code> value; 
 <code>1.0d</code> is a <code>double</code> value), do 
 <em>not</em> influence the results of this method.  In other
  words, the numerical value of the input string is converted
  directly to the target floating-point type.  In general, the
  two-step sequence of conversions, string to <code>double</code>
  followed by <code>double</code> to <code>float</code>, is 
 <em>not</em> equivalent to converting a string directly to 
 <code>float</code>.  For example, if first converted to an
  intermediate <code>double</code> and then to 
 <code>float</code>, the string<br>
  <code>"1.00000017881393421514957253748434595763683319091796875001d"</code><br>
  results in the <code>float</code> value 
 <code>1.0000002f</code>; if the string is converted directly to 
 <code>float</code>, <code>1.000000<b>1</b>f</code> results. 
 <p>To avoid calling this method on an invalid string and having
  a <code>NumberFormatException</code> be thrown, the documentation
  for <code>Double.valueOf</code> lists a regular
  expression which can be used to screen the input.
 @param s the string to be parsed.
 @return a <code>Float</code> object holding the value
           represented by the <code>String</code> argument.
 @throw NumberFormatExceptionif the string does not contain a
           parsable number.
 */
+ (CommonFloat * __nonnull)valueOfWithNSString:(NSString *)s;

#pragma mark Package-Private

// Disallowed inherited constructors, do not use.

- (instancetype __nonnull)init NS_UNAVAILABLE;

@end

J2OBJC_STATIC_INIT(CommonFloat)

/*!
 @brief A constant holding the positive infinity of type 
 <code>float</code>.It is equal to the value returned by 
 <code>Float.intBitsToFloat(0x7f800000)</code>.
 */
inline float CommonFloat_get_POSITIVE_INFINITY(void);
#define CommonFloat_POSITIVE_INFINITY INFINITY
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, POSITIVE_INFINITY, float)

/*!
 @brief A constant holding the negative infinity of type 
 <code>float</code>.It is equal to the value returned by 
 <code>Float.intBitsToFloat(0xff800000)</code>.
 */
inline float CommonFloat_get_NEGATIVE_INFINITY(void);
#define CommonFloat_NEGATIVE_INFINITY -INFINITY
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, NEGATIVE_INFINITY, float)

/*!
 @brief A constant holding a Not-a-Number (NaN) value of type 
 <code>float</code>.It is equivalent to the value returned by 
 <code>Float.intBitsToFloat(0x7fc00000)</code>.
 */
inline float CommonFloat_get_NaN(void);
#define CommonFloat_NaN NAN
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, NaN, float)

/*!
 @brief A constant holding the largest positive finite value of type 
 <code>float</code>, (2-2<sup>-23</sup>)&middot;2<sup>127</sup>.
 It is equal to the hexadecimal floating-point literal 
 <code>0x1.fffffeP+127f</code> and also equal to 
 <code>Float.intBitsToFloat(0x7f7fffff)</code>.
 */
inline float CommonFloat_get_MAX_VALUE(void);
#define CommonFloat_MAX_VALUE __FLT_MAX__
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, MAX_VALUE, float)

/*!
 @brief A constant holding the smallest positive normal value of type 
 <code>float</code>, 2<sup>-126</sup>.It is equal to the
  hexadecimal floating-point literal <code>0x1.0p-126f</code> and also
  equal to <code>Float.intBitsToFloat(0x00800000)</code>.
 @since 1.6
 */
inline float CommonFloat_get_MIN_NORMAL(void);
#define CommonFloat_MIN_NORMAL __FLT_MIN__
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, MIN_NORMAL, float)

/*!
 @brief A constant holding the smallest positive nonzero value of type 
 <code>float</code>, 2<sup>-149</sup>.It is equal to the
  hexadecimal floating-point literal <code>0x0.000002P-126f</code>
  and also equal to <code>Float.intBitsToFloat(0x1)</code>.
 */
inline float CommonFloat_get_MIN_VALUE(void);
#define CommonFloat_MIN_VALUE 1.4E-45f
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, MIN_VALUE, float)

/*!
 @brief Maximum exponent a finite <code>float</code> variable may have.It
  is equal to the value returned by <code>Math.getExponent(Float.MAX_VALUE)</code>
 .
 @since 1.6
 */
inline jint CommonFloat_get_MAX_EXPONENT(void);
#define CommonFloat_MAX_EXPONENT 127
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, MAX_EXPONENT, jint)

/*!
 @brief Minimum exponent a normalized <code>float</code> variable may have.
 It is equal to the value returned by <code>Math.getExponent(Float.MIN_NORMAL)</code>
 .
 @since 1.6
 */
inline jint CommonFloat_get_MIN_EXPONENT(void);
#define CommonFloat_MIN_EXPONENT -126
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, MIN_EXPONENT, jint)

/*!
 @brief The number of bits used to represent a <code>float</code> value.
 @since 1.5
 */
inline jint CommonFloat_get_SIZE(void);
#define CommonFloat_SIZE 32
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, SIZE, jint)

/*!
 @brief The number of bytes used to represent a <code>float</code> value.
 @since 1.8
 */
inline jint CommonFloat_get_BYTES(void);
#define CommonFloat_BYTES 4
J2OBJC_STATIC_FIELD_CONSTANT(CommonFloat, BYTES, jint)

/*!
 @brief The <code>Class</code> instance representing the primitive type 
 <code>float</code>.
 @since 1.1
 */
inline IOSClass *CommonFloat_get_TYPE(void);
/*! INTERNAL ONLY - Use accessor function from above. */
FOUNDATION_EXPORT IOSClass *CommonFloat_TYPE;
J2OBJC_STATIC_FIELD_OBJ_FINAL(CommonFloat, TYPE, IOSClass *)

FOUNDATION_EXPORT NSString *CommonFloat_toStringWithFloat_(float f);

FOUNDATION_EXPORT NSString *CommonFloat_toHexStringWithFloat_(float f);

FOUNDATION_EXPORT CommonFloat *CommonFloat_valueOfWithNSString_(NSString *s);

FOUNDATION_EXPORT CommonFloat *CommonFloat_valueOfWithFloat_(float f);

FOUNDATION_EXPORT float CommonFloat_parseFloatWithNSString_(NSString *s);

FOUNDATION_EXPORT jboolean CommonFloat_isNaNWithFloat_(float v);

FOUNDATION_EXPORT jboolean CommonFloat_isInfiniteWithFloat_(float v);

FOUNDATION_EXPORT jboolean CommonFloat_isFiniteWithFloat_(float f);


FOUNDATION_EXPORT CommonFloat *new_CommonFloat_initWithFloat_(float value) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT CommonFloat *create_CommonFloat_initWithFloat_(float value);


FOUNDATION_EXPORT CommonFloat *new_CommonFloat_initWithDouble_(double value) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT CommonFloat *create_CommonFloat_initWithDouble_(double value);


FOUNDATION_EXPORT CommonFloat *new_CommonFloat_initWithNSString_(NSString *s) NS_RETURNS_RETAINED;

FOUNDATION_EXPORT CommonFloat *create_CommonFloat_initWithNSString_(NSString *s);

FOUNDATION_EXPORT jint CommonFloat_hashCodeWithFloat_(float value);

FOUNDATION_EXPORT jint CommonFloat_floatToIntBitsWithFloat_(float value);

FOUNDATION_EXPORT jint CommonFloat_floatToRawIntBitsWithFloat_(float value);

FOUNDATION_EXPORT float CommonFloat_intBitsToFloatWithInt_(jint bits);

FOUNDATION_EXPORT jint CommonFloat_compareWithFloat_withFloat_(float f1, float f2);

FOUNDATION_EXPORT float CommonFloat_sumWithFloat_withFloat_(float a, float b);

FOUNDATION_EXPORT float CommonFloat_maxWithFloat_withFloat_(float a, float b);

FOUNDATION_EXPORT float CommonFloat_minWithFloat_withFloat_(float a, float b);

J2OBJC_TYPE_LITERAL_HEADER(CommonFloat)

BOXED_INC_AND_DEC(Float, floatValue, CommonFloat)
BOXED_COMPOUND_ASSIGN_ARITHMETIC(Float, floatValue, float, CommonFloat)
BOXED_COMPOUND_ASSIGN_FPMOD(Float, floatValue, float, CommonFloat)


#endif


#if __has_feature(nullability)
#pragma clang diagnostic pop
#endif

// kotlin interop <<
