//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    The programm models an item to be dispensed by an vending machine
// Course:   CS 300 Fall 2022
//
// Author:   Arnesh Tarachandani    
// Email:    tarachandani@wisc.edu
// Lecturer: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Pushpit Singh
// Partner Email:   psingh76@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   _x_ Write-up states that pair programming is allowed for this assignment.
//   _x_ We have both read and understand the course Pair Programming Policy.
//   _x_ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         NONE
// Online Sources:  NONE
//
///////////////////////////////////////////////////////////////////////////////
/**
 * This class models an item defined by its description and expiration date.
 */
public class Item {
  private String description; // human readable description of the item.
  private int expirationDate; // the expiration,
                              // date of the item, starting at day 0, which represents Jan 1, 2023.

  /**
   * 
   * 
   * constructor for class Item
   * 
   * @param description,    - a human readable description of this item
   * @param expirationDate, a positive integer starting at day 0, which represents Jan 1, 2023
   * @throws IllegalArgumentException, with a descriptive error message if expirationDate is
   *                                   negative (less than zero) or description is null or blank
   */
  public Item(String description, int expirationDate) throws IllegalArgumentException { // CONSTRUCTOR
    if (expirationDate < 0) {
      throw new IllegalArgumentException("expiration date cannot be negative"); // check and throws
                                                                                // exception if date
                                                                                // is negative
    }
    if (description == null) {
      throw new IllegalArgumentException("description cannot be null"); // throws exception if
                                                                        // description is null
    }
    if (description!=null && description.isBlank() ) {
      throw new IllegalArgumentException("description cannot be blank"); // throws exception if
                                                                         // description is blank
    }
    
    this.description = description; // initializing the objects
    this.expirationDate = expirationDate;

  }

  /**
   * Gets the description of this item
   * 
   * @return the description of this item
   */
  public String getDescription() {
    return description;
  }

  /**
   * Changes the description of this item
   * 
   * @param description,new description of the item
   * 
   * @throws IllegalArgumentException, a descriptive error message if description is null or blank
   */
  public void setDescription(String description) throws IllegalArgumentException {
    if (description.isBlank()) {
      throw new IllegalArgumentException("description cannot be blank"); // throws exception if
                                                                         // description is blank
    }
    if (description.equals(null)) {
      throw new IllegalArgumentException("description cannot be null"); // throws exception if
                                                                        // description is null
    }
    this.description = description; // sets the description

  }

  /**
   * Gets the expiration date of this item
   * 
   * @return the expiration date of this item
   */
  public int getExpirationDate() {
    return expirationDate; // getter for expiration date
  }

  /**
   * Returns a String representation of this item formatted as "description: expirationDate"
   * 
   * @Overrides toString in class Object
   * @return a String representation of this item
   */
  @Override
  public String toString() {
    return description + ": " + expirationDate; // Returns a String representation of this item
                                               // formatted as "description: expirationDate"
  }

  /**
   * Checks whether this item equals another object passed as input.
   * 
   * @Overrides equals in class Object
   * 
   * @return true if other is instance of Item and has the same description as this item, false
   *         otherwise.
   * 
   */
  @Override
  public boolean equals(Object other) {
   try {
    if (other instanceof Item && ((Item) other).getDescription().equals(description)) {
      return true;


    }}
   catch(Exception NullpointerException) {
     return false;
   }
    return false;
  }



}
