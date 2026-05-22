package com.mirego.interop.java.test.interfaces;

// javax.annotations doesn't work with command line tests
import org.jetbrains.annotations.NotNull;

public class ImplementsComparable implements Comparable<Integer> {

  @SuppressWarnings("unchecked")
  public static String main(String[] args) {
    ImplementsComparable implementsComparable = new ImplementsComparable();

    Object obj = implementsComparable;

    boolean isInstanceOfComparable = obj instanceof Comparable;
    Comparable<Integer> castedComparable = (Comparable<Integer>) obj;

    Comparable[] comparableArray = new Comparable[2];

    return String.format(
        "compare() is greater than 0? --> %s\n" +
        "isInstanceOfComparable? --> %s\n" +
        "castedComparable.compare() is greater than 0?  --> %s" +
        "comparableArray.size() --> %s",
        implementsComparable.compareTo(1),
        isInstanceOfComparable,
        castedComparable.compareTo(1),
        comparableArray.length);
  }

  @Override
  public int compareTo(@NotNull Integer o) {
    return o;
  }
}
