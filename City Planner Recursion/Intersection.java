
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


/**
 * This class represents a single intersection point where two streets laid out on a grid plan cross
 * at specified x and y coordinate positions.
 * 
 * @author pushpitsingh
 *
 */
public class Intersection {
  private final int x; // X- axis coordinate of this intersection
  private final int y;// Y-axis coordinate of this intersection

  /**
   * Initializes this intersection with the given coordinates
   * 
   * @param x-Horizontal position of this Intersection
   * @param y            - Vertical position of this Intersection
   */
  public Intersection(int x, int y) {
    this.x = x; // constructor used to initialize the
    this.y = y; // coordinate fields
  }

  /**
   * Returns the horizontal position of this Intersection
   * 
   * @return x - the horizontal position of this intersection
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the vertical position of this Intersection
   * 
   * @return y - the vertical position of this intersection
   */
  public int getY() {
    return y;
  }

  /**
   * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
   * 
   * @Overrides:toString in class Object
   * @return a coordinate-pair representation of this Intersection
   */
  @Override
  public String toString() {
    String f = "(" + x + "," + y + ")";
    return f;
  }

  /**
   * Returns true if the given Object is identical to this Intersection
   * 
   * @Overrides equals in class Object
   * @param -o - object to compare for equality
   * @return true if the given Object is an Intersection object which has the same x and y
   *         coordinates as this Intersection
   */
  @Override
  public boolean equals(Object o) {
    if (o instanceof Intersection) { // checks if the object is the instance of the Intersection
                                     // class
      if (((Intersection) o).getX() == this.getX()) { // checks if the x coordinate is equal
        if (((Intersection) o).getY() == this.getY()) { // checks if the y coordinate is equal
          return true;// returns true if all the conditions are met
        }
      }
    }
    return false; // otherwise returns false
  }

  /**
   * Creates a new Intersection instance which is one step directly above this Intersection.
   * 
   * 
   * 
   * @return a new Intersection instance which is one step directly above this Intersection
   */
  public Intersection goNorth() {
    int yN = this.getY(); // gets the y coordinate of the current position
    yN++;// moves it one step directly above
    Intersection go = new Intersection(this.getX(), yN); // creates a new instance with new
                                                         // intersection coordinates
    return go;
  }

  /**
   * Creates a new Intersection instance which is one step directly below this Intersection.
   * 
   * 
   * 
   * @return a new Intersection instance which is one step directly below this Intersection
   */
  public Intersection goSouth() {
    int yN = this.getY(); // gets the y coordinate of the current position
    yN--;// moves it one step directly below
    Intersection go = new Intersection(this.getX(), yN); // creates a new instance with new
                                                         // intersection coordinates
    return go;
  }


  /**
   * Creates a new Intersection instance which is one step directly to the right of this
   * Intersection object
   * 
   * 
   * 
   * @return a new Intersection instance which is one step directly to the right of this
   *         Intersection
   */
  public Intersection goEast() {
    int xN = this.getX(); // gets the x coordinate of the current position
    xN++;// moves it one step directly right
    Intersection go = new Intersection(xN, this.getY()); // creates a new instance with new
                                                         // intersection coordinates
    return go;
  }

  /**
   * Creates a new Intersection instance which is one step directly to the left of this
   * Intersection.
   * 
   * 
   * 
   * @return a new Intersection instance which is one step directly to the left of this Intersection
   */
  public Intersection goWest() {
    int xN = this.getX(); // gets the x coordinate of the current position
    xN--;// moves it one step directly left
    Intersection go = new Intersection(xN, this.getY()); // creates a new instance with new
                                                         // intersection coordinates
    return go;
  }



}
