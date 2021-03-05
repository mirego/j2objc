
import com.mirego.interop.java.test.function.*;
import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class FunctionTests extends TestCase {

  private static final String[] args = {""};

  @Test
  public void testPublicExtensionFunction() {
    PublicExtensionFunction publicExtensionFunction = new PublicExtensionFunction();
    assert(publicExtensionFunction.main(args) == "extension");
  }

  @Test
  public void testPublicFunctionReturningBoolean() {
    PublicFunctionReturningBoolean publicFunctionReturningBoolean = new PublicFunctionReturningBoolean();
    assert(!publicFunctionReturningBoolean.main(args));
  }

 @Test
 public void testPublicFunctionReturningCharacter() {
   PublicFunctionReturningCharacter publicFunctionReturningCharacter = new PublicFunctionReturningCharacter();
   assert(publicFunctionReturningCharacter.main(args) == 'a');
 }

 @Test
 public void testPublicFunctionReturningDouble() {
   PublicFunctionReturningDouble publicFunctionReturningDouble = new PublicFunctionReturningDouble();
   assert(publicFunctionReturningDouble.main(args) == 1.0D);
 }

 @Test
 public void testPublicFunctionReturningFloat() {
   PublicFunctionReturningFloat publicFunctionReturningFloat = new PublicFunctionReturningFloat();
   assert(publicFunctionReturningFloat.main(args) == 1.0f);
 }

 @Test
 public void testPublicFunctionReturningInteger() {
   PublicFunctionReturningInteger publicFunctionReturningInteger = new PublicFunctionReturningInteger();
   assert(publicFunctionReturningInteger.main(args) == 1);
 }

 @Test
 public void testPublicFunctionReturningLong() {
   PublicFunctionReturningLong publicFunctionReturningLong = new PublicFunctionReturningLong();
   assert(publicFunctionReturningLong.main(args) == 1L);
 }

   @Test
  public void testPublicFunctionReturningPrimitive() {
    PublicFunctionReturningPrimitive publicFunctionReturningPrimitive = new PublicFunctionReturningPrimitive();
    assert(publicFunctionReturningPrimitive.main(args) == 1L);
  }

 @Test
 public void testPublicFunctionReturningShort() {
   PublicFunctionReturningShort publicFunctionReturningShort = new PublicFunctionReturningShort();
   short returnValue = publicFunctionReturningShort.main(args);
   assert(returnValue == 1);
 }

 @Test
 public void testPublicFunctionReturningString() {
   PublicFunctionReturningString publicFunctionReturningString = new PublicFunctionReturningString();
   assert(publicFunctionReturningString.main(args) == "testString");
 }

 @Test
 public void testPublicFunctionReturningUnit() {
   PublicFunctionReturningUnit publicFunctionReturningUnit = new PublicFunctionReturningUnit();
   publicFunctionReturningUnit.main(args);
   assert(true);
 }

  // todo default not working try @JvmOverload
//  @Test
//  public void testPublicFunctionWithDefaultArguments() {
//    PublicFunctionWithDefaultArguments publicFunctionWithDefaultArguments = new PublicFunctionWithDefaultArguments();
//    assert(publicFunctionWithDefaultArguments.main(args) == "string1 string2");
//  }

 @Test
 public void testPublicInnerClassFunction() {
   PublicInnerClassFunction publicInnerClassFunction = new PublicInnerClassFunction();
   assert(publicInnerClassFunction.main(args) == 3);
 }

// todo lambda is a property getter not working properly
//  @Test
//  public void testPublicLambdaFunction() {
//    PublicLambdaFunction publicLambdaFunction = new PublicLambdaFunction();
//    Function1<Integer, Integer> test = publicLambdaFunction.main(args);
//    assert (test(1, 1) == 2);
//  }

 @Test
 public void testPublicLocalFunction() {
   PublicLocalFunction publicLocalFunction = new PublicLocalFunction();
   assert(publicLocalFunction.main(args) == "local function");
 }

 @Test
 public void testPublicOverloadedFunction() {
   PublicOverloadedFunction publicOverloadedFunction = new PublicOverloadedFunction();
   assert(publicOverloadedFunction.main(args) == "1");
 }

 @Test
 public void testPublicRecursiveFunction() {
   PublicRecursiveFunction publicRecursiveFunction = new PublicRecursiveFunction();
   assert(publicRecursiveFunction.main(args) == 24);
 }

 @Test
 public void testPublicSingleExpressionFunction() {
   PublicSingleExpressionFunction publicSingleExpressionFunction = new PublicSingleExpressionFunction();
   assert(publicSingleExpressionFunction.main(args) == "single expression");
 }

// todo using static issues
//  @Test
//  public void testPublicStaticFunction() {
//    PublicStaticFunction publicStaticFunction = new PublicStaticFunction();
//    assert(publicStaticFunction.main(args) == "staticString");
//  }

 @Test
 public void testPublicTailRecursiveFunction() {
   PublicTailRecursiveFunction publicTailRecursiveFunction = new PublicTailRecursiveFunction();
   assert(publicTailRecursiveFunction.main(args) == 24);
 }

// todo incompatible types
//  @Test
//  public void testPublicVariableArgumentsFunction() {
//    PublicVariableArgumentsFunction publicVariableArgumentsFunction = new PublicVariableArgumentsFunction();
//    assert(publicVariableArgumentsFunction.main(args) == 10);
//  }
  
}
