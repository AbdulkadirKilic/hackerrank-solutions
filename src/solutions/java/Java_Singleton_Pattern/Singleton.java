// HackerRank Question: https://www.hackerrank.com/challenges/java-singleton/problem

package solutions.java.Java_Singleton_Pattern;

import java.lang.reflect.*;
import java.util.*;

class Singleton {
  public String str;

  private static Singleton singleInstance = null;

  private Singleton() {}

  public static Singleton getSingleInstance() {
    if (singleInstance == null) {
      singleInstance = new Singleton();
    }
    return singleInstance;
  }
}
