package com.google.devtools.j2objc.util;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import kotlin.Metadata;
import kotlinx.metadata.KmClass;
import kotlinx.metadata.KmFunction;
import kotlinx.metadata.KmValueParameter;
import kotlinx.metadata.jvm.KotlinClassHeader;
import kotlinx.metadata.jvm.KotlinClassMetadata;

public class KotlinMetadataUtil {

  public static List<String> getFunctionParameterNames(Element enclosingElement, String functionName) {
    KmClass kmClass = getClass(enclosingElement);

    List<String> functionParameters = new ArrayList<>();
    for (KmValueParameter parameter : findMatchingFunction(kmClass, functionName)) {
      functionParameters.add(parameter.getName());
    }
    return functionParameters;
  }

  private static KmClass getClass(Element enclosingElement) {
    Metadata meta = enclosingElement.getAnnotation(Metadata.class);
    KotlinClassHeader header = new KotlinClassHeader(meta.k(), meta.mv(), meta.bv(), meta.d1(), meta.d2(), meta.xs(), meta.pn(), meta.xi());
    KotlinClassMetadata metadata = KotlinClassMetadata.read(header);
    KmClass kmClass = ((KotlinClassMetadata.Class) metadata).toKmClass();

    return kmClass;
  }

  private static List<KmValueParameter> findMatchingFunction(KmClass kotlinClass, String functionName) {
    List<KmValueParameter> parameters = new ArrayList<>();

    for (KmFunction function : kotlinClass.getFunctions()) {
      if (function.getName().equals(functionName)) {
        parameters = function.getValueParameters();
        break;
      }
    }
    return parameters;
  }
}
