// HackerRank Question: https://www.hackerrank.com/challenges/can-you-access/problem

package solutions.java.Can_You_Access;

import java.io.*;
import java.security.*;

public class Solution {

  public static void main(String[] args) throws Exception {
    DoNotTerminate.forbidExit();

    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int num = Integer.parseInt(br.readLine().trim());
      Object o;

      Inner inner = new Inner();
      Inner.Private innerPrivate = inner.new Private();
      System.out.println(num + " is " + innerPrivate.powerof2(num));
      o = innerPrivate;

      System.out.println(
          "An instance of class: " + o.getClass().getCanonicalName() + " has been created");

    } catch (DoNotTerminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  }

  static class Inner {
    private class Private {
      private String powerof2(int num) {
        return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
      }
    }
  }
}

class DoNotTerminate {

  public static class ExitTrappedException extends SecurityException {

    private static final long serialVersionUID = 1L;
  }

  public static void forbidExit() {
    final SecurityManager securityManager =
        new SecurityManager() {
          @Override
          public void checkPermission(Permission permission) {
            if (permission.getName().contains("exitVM")) {
              throw new ExitTrappedException();
            }
          }
        };
    System.setSecurityManager(securityManager);
  }
}
