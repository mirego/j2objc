
#import "Common_wrapper.h"
#import "J2ObjC_common.h"
#import "IOSObjectArray.h"

id toKotlinArray(IOSObjectArray *sourceArray) {
   int arraySize = sourceArray.length;
   id (^initCall)(CommonInt *) = ^ (CommonInt *index) {
    return IOSObjectArray_Get(sourceArray, [index intValue]);
   };

   return [CommonKotlinArray arrayWithSize:arraySize init:initCall];
}
