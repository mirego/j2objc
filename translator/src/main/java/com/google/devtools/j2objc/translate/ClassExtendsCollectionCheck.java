// kotlin interop >>

package com.google.devtools.j2objc.translate;

import com.google.devtools.j2objc.ast.ClassInstanceCreation;
import com.google.devtools.j2objc.ast.CompilationUnit;
import com.google.devtools.j2objc.ast.UnitTreeVisitor;
import com.google.devtools.j2objc.gen.GeneratedType;
import com.google.devtools.j2objc.util.TypeUtil;
import com.sun.source.tree.IdentifierTree;
import com.sun.source.tree.MemberSelectTree;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;

public class ClassExtendsCollectionCheck extends UnitTreeVisitor {

  public ClassExtendsCollectionCheck(CompilationUnit unit) {
    super(unit);
  }

  @Override
  public boolean visit(ClassInstanceCreation node) {
    TypeElement typeElement = TypeUtil.asTypeElement(node.getTypeMirror());

    String simpleName = "";
    if (typeElement != null) {
      if (isExcludedFromJ2Objc(typeElement.getAnnotationMirrors())) {
        return super.visit(node);
      }

      simpleName = typeElement.getSimpleName().toString();
      if (simpleName != null) {
        if (simpleName.equals("ArrayList")
          || simpleName.equals("LinkedList")
          || simpleName.equals("HashMap")
          || simpleName.equals("LinkedHashMap")
          || simpleName.equals("ConcurrentHashMap")
          || simpleName.equals("WeakHashMap")
          || simpleName.equals("TreeSet")
          || simpleName.equals("HashSet")
          || simpleName.equals("LinkedHashSet")) {
          return super.visit(node);
        }
      }
    }

    String sourceFilePath = unit.getSourceFilePath();
    if (sourceFilePath.contains("java/util/stream/Collectors")
      || sourceFilePath.contains("java/util/Hashtable")
      || sourceFilePath.contains("java/util/AbstractMap")
      || sourceFilePath.contains("java/util/LinkedHashMap")
      || sourceFilePath.contains("java/util/AbstractSet")
      || sourceFilePath.contains("java/util/zip")
      || sourceFilePath.contains("java/util/PriorityQueue")
      || sourceFilePath.contains("java/util/PropertyResourceBundle")
      || sourceFilePath.contains("java/util/concurrent/DelayQueue")
      || sourceFilePath.contains("java/util/concurrent/Executor")
      || sourceFilePath.contains("java/util/concurrent/PriorityBlockingQueue")
      || sourceFilePath.contains("java/util/concurrent/ScheduledThreadPoolExecutor")
      || sourceFilePath.contains("java/util/stream/Nodes")
      || sourceFilePath.contains("java/nio/file")
      || sourceFilePath.contains("java/security")
      || sourceFilePath.contains("java/sql")
      || sourceFilePath.contains("javax/xml")
      || sourceFilePath.contains("android/icu/impl")
      || sourceFilePath.contains("libcore/net")
      || sourceFilePath.contains("net/DataEnqueuedInputStream")
      || sourceFilePath.contains("net/DataEnqueuedOutputStream")
      || sourceFilePath.contains("sun/nio")
      || sourceFilePath.contains("sun/security")) {
      return super.visit(node);
    }

    // Get all super classes
    ArrayList<TypeMirror> superClasses = new ArrayList<>();
    GeneratedType.getAllSuperClasses(typeElement, superClasses);

    // Get all interfaces from current class and super classes
    ArrayList<TypeMirror> interfaces = new ArrayList<>();
    for (TypeMirror superClass : superClasses) {
      TypeElement superClassTypeElement = TypeUtil.asTypeElement(superClass);
      if (superClassTypeElement != null) {
        interfaces.addAll(GeneratedType.getAllInterfaces(superClassTypeElement));
      }
    }

    for (TypeMirror interfaceType : interfaces) {
      if (interfaceType.toString().equals("java.util.Collection<E>") || interfaceType.toString().equals("java.util.Map<K,V>")) {
        // ErrorUtil.error(String.format("%s : FORBIDDEN COLLECTION [%s]", unit.getSourceFilePath(), simpleName));
        return super.visit(node);
      }
    }

    return super.visit(node);
  }

  private boolean isExcludedFromJ2Objc(List<? extends AnnotationMirror> annotations) {
    for (AnnotationMirror annotation : annotations) {
      if (isJ2ObjCIncompatible(annotation)) {
        return true;
      }
    }
    return false;
  }

  private boolean isJ2ObjCIncompatible(AnnotationMirror annotation) {
    String name = annotation.getAnnotationType().toString();
    return name.contains("J2ObjCIncompatible");
  }

  private String getLastComponent(Tree name) {
    switch (name.getKind()) {
      case IDENTIFIER:
        return ((IdentifierTree) name).getName().toString();
      case MEMBER_SELECT:
        return ((MemberSelectTree) name).getIdentifier().toString();
      default:
        return "";
    }
  }
}

// kotlin interop <<
