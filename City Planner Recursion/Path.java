
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
import java.util.NoSuchElementException;

/**
 * This class represents a valid path through a grid of city intersections surrounded by streets.
 * That is, one which only moves either one step directly east, or one step directly north at each
 * step, meaning that only northeast paths from one intersection point to another are allowed. A
 * list of intersection elements creates the path.
 * 
 * @author pushpitsingh
 *
 */
public class Path {
  private ArrayList<Intersection> intersections;// List of Intersections followed in this Path

  /**
   * Initializes this Path to start as empty
   */
  public Path() {
    intersections = new ArrayList<Intersection>(); // Initializes this Path to start as empty
  }

  /**
   * Returns the number of Intersections in this Path
   * 
   * @return the number of Intersections in this Path
   */
  public int length() {
    return intersections.size();
  }

  /**
   * Returns the first Intersection in this Path, if it is not empty. Otherwise, throws a
   * NoSuchElementException.
   * 
   * @throws NoSuchElementException - if this Path is empty
   * @return the first Intersection in this Path, if it is not empty
   */
  public Intersection getHead() {
    if (intersections.isEmpty()) {
      throw new NoSuchElementException("the path is empty"); // throws exception if the path is
                                                             // empty
    }
    // checks if the arraylist is null or
    // empty
    return intersections.get(0); // returns the head
  }

  /**
   * Returns the last Intersection in this Path, if it is not empty. Otherwise, throws a
   * NoSuchElementException.
   *
   * 
   * @throws NoSuchElementException - if this Path is empty
   * @return the last Intersection in this Path, if it is not empty
   */
  public Intersection getTail() {
    // checks if the arraylist is null
    if (intersections.isEmpty()) {
      throw new NoSuchElementException("the path is empty"); // throws exception if the path is
                                                             // empty
    } // or empty
    return intersections.get(intersections.size() - 1); // returns the TAIL

  }

  /**
   * Adds the given Intersection to the end of this Path if it is a valid addition. A Intersection
   * is a valid addition if the current Path is empty, or the Intersection to add is one step
   * directly east, or one step directly north of the current tail Intersection in this Path.
   * 
   * @throws IllegalArgumentException if the given Intersection is not a valid addition.
   * 
   * @param toAdd - Intersection to add to the end of this Path
   */
  public void addTail(Intersection toAdd) {

    if (intersections.isEmpty()) { // adds to the intersection if the list is empty
      intersections.add(toAdd);
    }

    if (getTail().goNorth().equals(toAdd) || getTail().goEast().equals(toAdd)) { // checks if the
                                                                                 // toAdd is
      // valid addition one
      // step to the east
      intersections.add(toAdd);

    }
  }

  /**
   * Adds the given Intersection to the front of this Path if it is a valid addition. A Intersection
   * is a valid addition if the current Path is empty, or the Intersection to add is one step
   * directly west, or one step directly south of the current head Intersection in this Path.
   * 
   * @throws IllegalArgumentException if the given Intersection is not a valid addition.
   * 
   * @param toAdd Intersection to add to the end of this Path
   */
  public void addHead(Intersection toAdd) {

    boolean flag = false;

    if (intersections.isEmpty() || intersections.get(0) == null) { // adds to the intersection if
                                                                   // the list is empty
      intersections.add(toAdd);
      flag = true;
    }


    else if (intersections.get(0).goWest().equals(toAdd)) { // checks if the toAdd is
                                                            // valid addition one
                                                            // step to the east
      intersections.add(0, toAdd);
      flag = true;
    }

    else if (intersections.get(0).goSouth().equals(toAdd)) { // checks if the toAdd is
                                                             // valid addition one
                                                             // step to the east
      intersections.add(0, toAdd);
      flag = true;
    }

    if (!flag) { // checks if intersection is not a valid addition
      throw new IllegalArgumentException("the given intersection is not a valid addition"); // throws
      // error
    }
  }

  /**
   * Returns a String representing the coordinates taken in this Path. An empty Path should return
   * the String "Empty", while a non-empty Path should return the coordinates of the Intersections
   * it visits separated by a "->". For example:(0,0)->(1,0)->(1,1)->(1,2)
   * 
   * @return a String representing the coordinates followed by this Path
   */
  @Override
  public String toString() {
    if (intersections.isEmpty()) {
      return "Empty";
    }
    String val = intersections.get(0).toString(); // the output string;
    for (int i = 1; i < intersections.size(); i++) {
      val = val + "->" + intersections.get(i).toString(); // formats the string according to the
                                                          // specifications;
    }
    return val + "\n";

  }

}
