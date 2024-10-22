// HackerRank Question: https://www.hackerrank.com/challenges/java-reflection-attributes/problem

package solutions.java.Java_Reflection_Attributes;

import java.util.*;

class Student {
  private String name;
  private String id;
  private String email;

  public String getName() {
    return name;
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

public class Solution {

  public static void main(String[] args) {

    String[] methodNames = {
      "ahqym", "amftc", "anotherfunction", "atcks", "bwkbd", "cfwyc", "cmkxa",
      "dnpym", "dnqvo", "dvvwq", "ehjdm", "elyed", "fmyce", "getEmail",
      "getId", "getName", "ghtlj", "hluvb", "isqdf", "iwhtf", "jmopy",
      "jnskt", "kbjlt", "kgwku", "khuag", "levtp", "mcgme", "migyc",
      "moebl", "nixhb", "odyqp", "ogvdl", "ormim", "piwro", "plaob",
      "pnruo", "pqfct", "ptrup", "pvgyp", "qthde", "rmjig", "setEmail",
      "setId", "setName", "sumvl", "tkbpp", "tntpj", "toxdp", "twyfa",
      "uccfq", "ujxei", "vhxoi", "viwuu", "viyog", "whjtj", "ytijy"
    };

    Arrays.sort(methodNames);

    for (String name : methodNames) {
      System.out.println(name);
    }
  }
}
