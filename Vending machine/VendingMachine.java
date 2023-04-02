
//////////////// FILE HEADER  //////////////////////////
//
// Title:    VendingMachine  class
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:    psingh76@wisc.edu
// Lecturer:  Hobbes LeGault

// Below is a javadoc class header to complete
/**
 * this class contains methods to insert,find,remove items from a vending
 * machine.
 * 
 * @author pushpit singh
 *
 */
public class VendingMachine {

  /**
   * Adds/appends an item defined by its description and expirationDate to a vending machine
   * represented by an oversize array of strings defined by the two-dimensional array items and its
   * size itemsCount. The item will be added to the end of the array. If the vending machine is
   * full, the new item won't be added and the method returns the items count passed as input
   * without making any changes to the contents of the array items.
   * 
   * @param description    description of the item to be added to the vending machine
   * @param expirationDate a string parsable to a positive integer which represents the expiration
   *                       date of the item. The date "0" represents January 1st 2023.
   * @param items          a two-dimensional of strings storing items. items[i][0] and items[i][1]
   *                       respectively represent the description and the expiration date of the
   *                       item stored at index i
   * @param itemsCount     number of items in the vending machine
   * @return the size of the vending machine after trying to add the new item
   */
  public static int addItem(String description, String expirationDate, String[][] items,
      int itemsCount) {
    
    // Note that we suppose that the expirationDate is valid, meaning it is correctly
    // parsable to a positive integer
       if(itemsCount==0){ //checks if its the first time the item is added
          items[0] = new String[2];         //creates an array in the 2d array
          items[0][0] = description; //assigns description
          items[0][1] = expirationDate; //assigns expirationDate
          itemsCount++;
        }
     else if (itemsCount < items.length) {
      items[itemsCount] = new String[2];
      items[itemsCount][0] = description;
      items[itemsCount][1] = expirationDate;
      itemsCount++;
      if(itemsCount == items.length){
        return itemsCount;
      }
    }
    return itemsCount; // default return statement added to avoid compiler errors. Feel free to
                       // change it.
  }

  /**
   * Returns without removing a string representation of the item at the given index within the
   * vending machine defined by the array items and its size itemsCount. This method does not make
   * any changes to the contents of the vending machine.
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @param index      index of an item within the provided vending machine
   * @return a string representation of the item stored at the given index within the vending
   *         machine defined by items and itemsCount. The returned string must have the following
   *         format: "description (expiration date)". If the provided index is out of the range of
   *         indexes 0..itemsCount-1, the method returns "ERROR INVALID INDEX"
   */
  public static String getItemAtIndex(int index, String[][] items, int itemsCount) {
    
   
    return (items[index][0]+ " " + "(" + items[index][1] + ")"); //returns the item at a given index
     // default return statement added to avoid compiler errors. Feel free to change
                   // it.
  }

  /**
   * Returns without removing the index of the item having the provided description and the smallest
   * expiration date within the vending machine defined by the array items and its size itemsCount.
   * 
   * @param description description of the item to get its index
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the index of the next item, meaning the item with the given description and the
   *         smallest expiration date. If no match found, return -1.
   */
  public static int getIndexNextItem(String description, String[][] items, int itemsCount) {
    
    // If the vending machine contains more than one item with the given description,
    // return the index o the one with the smallest expiration date.
    int index = -1;
    int x = 0;
    while (x < itemsCount) {
      if (description.equals(items[x][0])) {
        if(index == -1){ 
          index = x;
        }

        else if(Integer.parseInt(items[x][1]) < Integer.parseInt(items[index][1])) {
          index = x;
        }

      }
      
      x++;

    }
    return index; // default return statement added to avoid compiler errors. Feel free to change
                  // it.

  }

  /**
   * Removes the item having the provided description with the smallest expiration date within the
   * vending machine defined by the array items and its size itemsCount. This method should maintain
   * the order of precedence of items in the vending machine. This means that the remove operation
   * involves a shift operation.
   * 
   * @param description description of the item to remove or dispense
   * @param items       array storing items within a vending machine
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return size of the vending machine after removing the item with the given description and the
   *         smallest expiration date. If no match found, this method must return the provided
   *         itemsCount without making any change to the contents of the vending machine.
   */
  public static int removeNextItem(String description, String[][] items, int itemsCount) {
    
    
    int temp = getIndexNextItem(description, items, itemsCount);
    if(temp!=-1){

    

      String[][] arr = new String[items.length][2];
      for(int i = 0; i < temp; i++) {
        arr[i][0] = items[i][0];
        arr[i][1] = items[i][1];
      }
      
      
      for (int j = temp+1; j < itemsCount; j++) {


        arr[j-1][0] = items[j][0];
        arr[j-1][1] = items[j][1];

      }
      
      for(int i =0;i < itemsCount-1; i++){
        items[i][0] = arr[i][0];
        items[i][1] = arr[i][1];
      }
      items[itemsCount-1] = null;
      

      itemsCount--;}
  
    return itemsCount; // default return statement added to avoid compiler errors. Feel free to
                       // change it.
  }

  /**
   * Returns the number of occurrences of an item with a given description within the vending
   * machine defined by items and itemsCount
   * 
   * @param description description (name) of an item
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return the number of occurrences of an item with a given description within the vending
   *         machine
   */
  public static int getItemOccurrences(String description, String[][] items, int itemsCount) {
    
    int count = 0;
    for (int i = 0; i < itemsCount; i++) {
      if (items[i][0].equals(description)) {
        count++;

      }

    }
    return count; // default return statement added to avoid compiler errors. Feel free to change
                  // it.
  }

  /**
   * Checks whether a vending machine defined by the array items and its size itemsCount contains at
   * least an item with the provided description
   * 
   * @param description description (name) of an item to search
   * @param items       two dimensional array storing items within a vending machine where
   *                    items[i][0] represents the description of the item at index i and
   *                    items[i][1] stores its expiration date.
   * @param itemsCount  (size) number of items stored in the vending machine
   * @return true if there is a match with description in the vending machine, false otherwise
   */
  public static boolean containsItem(String description, String[][] items, int itemsCount) {
   
    for (int i = 0; i < items.length; i++) {
      if (items[i][0].equals(description)) {
        return true;
      }
    }
    return false; // default return statement added to avoid compiler errors. Feel free to change
                  // it.
  }

  /**
   * Returns the number of items in the vending machine with a specific description and whose
   * expiration dates are greater or equal to a specific expiration date
   * 
   * @param description    description of the item to find its number of occurrences
   * @param expirationDate specific (earliest) expiration date
   * @param items          two dimensional array storing items within a vending machine where
   *                       items[i][0] represents the description of the item at index i and
   *                       items[i][1] stores its expiration date.
   * @param itemsCount     (size) number of items stored in the vending machine
   * @return the number of items with a specific description and whose expiration date is greater or
   *         equal to the given one
   */
  public static int getItemsOccurrencesByExpirationDate(String description, String expirationDate,
      String[][] items, int itemsCount) {
    int count = 0;
    for (int i = 0; i < itemsCount; i++) {
      if (items[i][0] == description) {
        if (Integer.parseInt(items[0][1]) >= Integer.parseInt(expirationDate)) {
          count++;
        }
      }
    }
  

    return count; // default return statement added to avoid compiler errors. Feel free to change
                  // it.
  }

  /**
   * Returns a summary of the contents of a vending machine in the following format: Each line
   * contains the description or item name followed by one the number of occurrences of the item
   * name in the vending machine between parentheses. For instance, if the vending machine contains
   * five bottles of water, ten chocolates, and seven snacks, the summary description will be as
   * follows. "water (5)\nchocolate (10)\nsnack (7)" If the vending machine is empty, this method
   * returns an empty string ""
   * 
   * @param items      two dimensional array storing items within a vending machine where
   *                   items[i][0] represents the description of the item at index i and items[i][1]
   *                   stores its expiration date.
   * @param itemsCount (size) number of items stored in the vending machine
   * @return a descriptive summary of the contents of a vending machine
   */
  public static String getItemsSummary(String[][] items, int itemsCount) {
  
    String sum = "\n";
    String[][] now = new String[15][2]; // new array for storing the non repeatative items
    int x = 0;
    int c =0;
    for (int i = 0; i < itemsCount; i++) {
      if(getItemOccurrences(items[i][0], now, x) == 0){
        now[i] = new String[2];
        now[i][0] = items[i][0];
        now[i][1] = items[i][1];
      }
      c = getItemOccurrences(items[i][0], items, itemsCount);

        
      

      sum = sum + items[i][0] + " " + "(" + c + ")" + "\n";
    }
    if(items[0][0] ==null){
      return null;
    }
    
    return sum; // default return statement added to avoid compiler errors.
                // Feel free to change it.
  }

}
