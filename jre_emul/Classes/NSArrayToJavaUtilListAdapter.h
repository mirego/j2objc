
//MIREGO kotlin interop >>

#ifndef _NSArrayToJavaUtilListAdapter_h_
#define _NSArrayToJavaUtilListAdapter_h_

#import "J2ObjC_common.h"

#if __has_feature(nullability)
#pragma clang diagnostic push
#pragma GCC diagnostic ignored "-Wnullability"
#pragma GCC diagnostic ignored "-Wnullability-completeness"
#endif

#define RESTRICT_JavaUtilList 1
#define INCLUDE_JavaUtilList 1
#include "java/util/List.h"

@class IOSObjectArray;
@protocol JavaUtilCollection;
@protocol JavaUtilComparator;
@protocol JavaUtilFunctionConsumer;
@protocol JavaUtilFunctionPredicate;
@protocol JavaUtilFunctionUnaryOperator;
@protocol JavaUtilIterator;
@protocol JavaUtilListIterator;
@protocol JavaUtilSpliterator;
@protocol JavaUtilStreamStream;

@interface NSArrayToJavaUtilsListAdapter : NSObject < JavaUtilList >

@property (strong, nonatomic) NSArray *sourceArray;

- (instancetype)initWithSourceArray:(NSArray *)sourceArray;

#pragma mark Public

- (void)addWithInt:(jint)i
            withId:(id)o;

- (jboolean)addWithId:(id)o;

- (jboolean)addAllWithJavaUtilCollection:(id<JavaUtilCollection> __nonnull)collection;

- (jboolean)addAllWithInt:(jint)i
   withJavaUtilCollection:(id<JavaUtilCollection> __nonnull)collection;

- (void)clear;

- (jboolean)containsWithId:(id)o;

- (jboolean)containsAllWithJavaUtilCollection:(id<JavaUtilCollection> __nonnull)collection;

- (id)getWithInt:(jint)i;

- (jint)indexOfWithId:(id)o;

- (jboolean)isEmpty;

- (id<JavaUtilIterator> __nonnull)iterator;

- (jint)lastIndexOfWithId:(id)o;

- (id<JavaUtilListIterator> __nonnull)listIterator;

- (id<JavaUtilListIterator> __nonnull)listIteratorWithInt:(jint)i;

- (id)removeWithInt:(jint)i;

- (jboolean)removeWithId:(id)o;

- (jboolean)removeAllWithJavaUtilCollection:(id<JavaUtilCollection> __nonnull)collection;

- (jboolean)retainAllWithJavaUtilCollection:(id<JavaUtilCollection> __nonnull)collection;

- (id)setWithInt:(jint)i
          withId:(id)o;

- (jint)size;

- (id<JavaUtilList> __nonnull)subListWithInt:(jint)i
                                     withInt:(jint)i1;

- (IOSObjectArray * __nonnull)toArray;

- (IOSObjectArray * __nonnull)toArrayWithNSObjectArray:(IOSObjectArray * __nonnull)objects;

@end


#endif /* _NSArrayToJavaUtilListAdapter_h_ */

//MIREGO <<
