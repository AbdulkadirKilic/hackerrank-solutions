// HackerRank Question: https://www.hackerrank.com/challenges/java-factory/problem

package solutions.java.Java_Factory_Pattern;

import java.security.*;
import java.util.*;

interface Food {
  public String getType();
}

class Pizza implements Food {
  public String getType() {
    return "Someone ordered a Fast Food!";
  }
}

class Cake implements Food {

  public String getType() {
    return "Someone ordered a Dessert!";
  }
}

class FoodFactory {
  public Food getFood(String order) {

    if (order.equalsIgnoreCase("pizza")) {
      return new Pizza();
    } else if (order.equalsIgnoreCase("cake")) {
      return new Cake();
    } else {
      return null;
    }
  }
}

public class Solution {

  public static void main(String args[]) {
    Do_Not_Terminate.forbidExit();

    try {

      Scanner sc = new Scanner(System.in);

      FoodFactory foodFactory = new FoodFactory();

      Food food = foodFactory.getFood(sc.nextLine());

      System.out.println("The factory returned " + food.getClass());
      System.out.println(food.getType());
    } catch (Do_Not_Terminate.ExitTrappedException e) {
      System.out.println("Unsuccessful Termination!!");
    }
  }
}

class Do_Not_Terminate {

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
