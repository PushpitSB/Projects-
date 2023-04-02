//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: (descriptive title of the program making use of this file)
// Course: CS 300 Fall 2022
//
// Author: Pushpit Singh
// Email: psingh76@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Soumya Kataria
// Partner Email: skataria2@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: None
// Online Sources: None
//
///////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

/**
 * PathUtilsTester is a tester class that has 6 tester methods.
 * 
 * @author - soumyakataria
 */

public class PathUtilsTester {
  PathUtils x = new PathUtils();

  /**
   * The testCountPathsNoPath() method tests the case of countPaths() when there are no valid Paths.
   * For example, when the start position is Intersection(1, 1) and the ending position is
   * Intersection(0, 1), there should be no valid Paths, so countPaths() should return 0.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsNoPath() {
    Intersection a = new Intersection(1, 2);
    Intersection b = new Intersection(0, 1);

    if (PathUtils.countPaths(a, b) == 0) {
      return true;
    }
    return false;
  }

  /**
   * The testCountPathsOnePath() method tests the case of countPaths() when there is a single valid
   * Path. For example, when the start position is Intersection(1, 1) and the ending position is
   * Intersection(1, 2), there should be a single Path, so countPaths() should return 1.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsOnePath() {
    Intersection a = new Intersection(1, 2);
    Intersection b = new Intersection(1, 3);

    if (PathUtils.countPaths(a, b) == 1) {
      return true;
    }
    return false;
  }

  /**
   * The testCountPathsRecursive() method tests the case of countPaths() when there are multiple
   * possible paths. For example, when the start position is Intersection(0, 0) and the ending
   * position is Intersection(1, 2), there should be three possible Paths, so countPaths() should
   * return 3.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testCountPathsRecursive() {
    Intersection a = new Intersection(0, 1);
    Intersection b = new Intersection(1, 2);

    if (PathUtils.countPaths(a, b) == 2) {
      return true;
    }
    return false;
  }

  /**
   * The testFindAllPathsNoPath() method tests the case of findAllPaths() when there are no valid
   * Paths. For example, when the start position is Intersection(1, 1) and the ending position is
   * Intersection(0, 1), there should be no valid Paths, so findAllPaths() should return an empty
   * ArrayList.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsNoPath() {
    Intersection a = new Intersection(1, 2);
    Intersection b = new Intersection(0, 1);

    ArrayList<Path> c = new ArrayList<Path>();
    c = PathUtils.findAllPaths(a, b);

    if (c.size() == 0) {
      return true;
    }
    return false;
  }

  /**
   * The method testFindAllPathsOnePath() tests the case of findAllPaths() when there is a single
   * valid Path. For example, when the start position is Intersection(1, 1) and the ending position
   * is Intersection(1, 2), there should be a single Path. For each of your cases, ensure that there
   * is only a single path, and that the Path exactly matches what you expect to see.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsOnePath() {
    Intersection a = new Intersection(1, 2);
    Intersection b = new Intersection(1, 3);

    // creates path x and adds intersections
    Path x = new Path();
    x.addHead(a);
    x.addTail(b);

    // adds paths to the arraylist answer
    ArrayList<Path> answer = new ArrayList<Path>();
    answer.add(x);

    // sets arraylist c to what the findAllPaths output
    ArrayList<Path> c = new ArrayList<Path>();
    c = PathUtils.findAllPaths(a, b);

    int num = 0;

    if (c.size() == answer.size()) {
      for (int i = 0; i < answer.size(); i++) {
        for (int j = 0; j < c.size(); j++) {
          if (c.get(i).toString().equals(answer.get(j).toString())) {
            num++;
          }
        }
      }
    }

    if (num == PathUtils.countPaths(a, b)) {
      return true;
    }

    return false;
  }

  /**
   * The method testFindAllPathsRecursive() tests the case of findAllPaths() when there are multiple
   * possible paths. For example, when the start position is Intersection(0, 0) and the ending
   * position is Intersection(1, 2), there should be three possible Paths. For each of your cases,
   * ensure that there is both the correct number of Paths, and that the returned Paths exactly
   * match what you expect to see.
   * 
   * @return true if all test cases are passed
   */
  public static boolean testFindAllPathsRecursive() {
    Intersection a = new Intersection(0, 1);
    Intersection b = new Intersection(1, 2);

    Intersection c1 = new Intersection(1, 1);
    Intersection c2 = new Intersection(0, 2);

    // creates path x and adds intersections
    Path x = new Path();
    x.addHead(a);
    x.addTail(c1);
    x.addTail(b);

    // creates path y and adds intersections
    Path y = new Path();
    y.addHead(a);
    y.addTail(c2);
    y.addTail(b);

    // adds paths to the arraylist answer
    ArrayList<Path> answer = new ArrayList<Path>();
    answer.add(x);
    answer.add(y);

    // sets arraylist c to what the findAllPaths output
    ArrayList<Path> c = new ArrayList<Path>();
    c = PathUtils.findAllPaths(a, b);

    int num = 0;


    if (c.size() == answer.size()) {
      for (int i = 0; i < answer.size(); i++) {
        for (int j = 0; j < c.size(); j++) {
          if (c.get(i).toString().equals(answer.get(j).toString())) {
            num++;
          }
        }
      }
    }

    if (num == PathUtils.countPaths(a, b)) {
      return true;
    }
    return false;

  }

  /**
   * The main method takes inputs for the coordinates and outputs the number of paths and the path
   * themselves. The input offers to repeat with different coordinates.
   */
  public static void main(String[] args) {
    try (Scanner keyboard = new Scanner(System.in)) {
      int startX, startY, endX, endY;
      String input = "Y";

      while (input.equalsIgnoreCase("Y")) {
        System.out.print("Enter starting X coordinate: ");
        startX = keyboard.nextInt();
        System.out.print("Enter starting Y coordinate: ");
        startY = keyboard.nextInt();
        System.out.print("Enter ending X coordinate: ");
        endX = keyboard.nextInt();
        System.out.print("Enter ending Y coordinate: ");
        endY = keyboard.nextInt();
        Intersection start = new Intersection(startX, startY);
        Intersection end = new Intersection(endX, endY);
        System.out
            .println("Number of paths from start to end: " + PathUtils.countPaths(start, end));
        System.out.println("List of possible paths:");

        for (Path p : PathUtils.findAllPaths(start, end)) {
          System.out.println(p);
        }

        do {
          System.out.print("Try another route? (Y/N): ");
          input = keyboard.next();
        }

        while (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N"));
      }
    }

    System.out.println("testCountPathsNoPath(): " + testCountPathsNoPath());
    System.out.println("testCountPathsOnePath(): " + testCountPathsOnePath());
    System.out.println("testCountPathsRecursive(): " + testCountPathsRecursive());
    System.out.println("testFindAllPathsNoPath(): " + testFindAllPathsNoPath());
    System.out.println("testFindAllPathsOnePath(): " + testFindAllPathsOnePath());
    System.out.println("testFindAllPathsRecursive(): " + testFindAllPathsRecursive());

  }
}
