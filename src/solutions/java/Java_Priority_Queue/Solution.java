// HackerRank Question: https://www.hackerrank.com/challenges/java-priority-queue/problem

package solutions.java.Java_Priority_Queue;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCgpa() {
    return cgpa;
  }
}

class Priorities {
  public List<Student> getStudents(List<String> events) {
    PriorityQueue<Student> queue =
        new PriorityQueue<>(
            (s1, s2) -> {
              if (Double.compare(s2.getCgpa(), s1.getCgpa()) != 0) {
                return Double.compare(s2.getCgpa(), s1.getCgpa());
              } else if (!s1.getName().equals(s2.getName())) {
                return s1.getName().compareTo(s2.getName());
              } else {
                return s1.getId() - s2.getId();
              }
            });

    for (String event : events) {
      String[] parts = event.split(" ");
      if (parts[0].equals("ENTER")) {
        String name = parts[1];
        double cgpa = Double.parseDouble(parts[2]);
        int id = Integer.parseInt(parts[3]);
        queue.add(new Student(id, name, cgpa));
      } else if (parts[0].equals("SERVED")) {
        queue.poll();
      }
    }

    List<Student> students = new ArrayList<>();
    while (!queue.isEmpty()) {
      students.add(queue.poll());
    }
    return students;
  }
}

public class Solution {
  private static final Scanner scan = new Scanner(System.in);
  private static final Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
