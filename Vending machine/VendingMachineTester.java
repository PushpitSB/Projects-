//////////////// FILE HEADER  //////////////////////////
//
// Title:    VendingMachineTester class
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:    psingh76@wisc.edu
// Lecturer:  Hobbes LeGault

import java.util.Arrays;


/*
VendingMachineTester has methods to test the class Vending machine with various tests `
*/  

// Javadoc style class header comes here
public class VendingMachineTester {
/**
 * 
 * @return boolean check if the tester method getIndexNextItem passes edge case scenarios 
 * returns true if all cases pass
 */

  // Checks the correctness of getIndexNextItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetIndexNextItem() {
    // Test scenarios normal and edge cases
    // Recall that the VendingMachine.getNextItem method gets the next item to be dispensed given
    // its description without removing it.

    // 1. Next item to be dispensed is NOT found: the expected output is -1
    {
      // define the vending machine
      String[][] items =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      int itemsCount = 3;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("candy", items, itemsCount) != -1) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did not return "
                + "-1 when no match found.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, null, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 1. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 2. Next item to be dispensed is at index 0
    {
      String[][] items = new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 0) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at index 0.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "1"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 2. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 3. Next item to be dispensed is at the end of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Chocolate", items, itemsCount) != 6) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains multiple matches with the "
                + "provided item description and the matching item with the soonest expiration date "
                + "is at the end of the array");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "20"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 3. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    // 4. Next item to be dispensed is at the middle of the array
    {
      String[][] items = new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"},
          {"Water", "5"}, {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      int itemsCount = 7;

      // check the correctness of the output
      if (VendingMachine.getIndexNextItem("Water", items, itemsCount) != 3) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did not return "
                + "the expected output when the vending machines contains matches with the provided "
                + "item description with different expiration dates.");
        return false;
      }
      // Check that the method did not make change to the contents of the array items passed as
      // input
      String[][] originalItems =
          new String[][] {{"Water", "15"}, {"Chocolate", "10"}, {"Juice", "20"}, {"Water", "5"},
              {"Candy", "30"}, {"Water", "15"}, {"Chocolate", "10"}, null, null};
      if (!Arrays.deepEquals(items, originalItems)) {
        System.out.println(
            "testGetIndexNextItem-scenario 4. Problem detected: Your getIndexNextItem did make "
                + "changes to the content of the array passed as input.");
        return false;
      }
    }

    return true; // No bug detected
  }

  // Checks the correctness of containsItem defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testContainsItem() {
    // Define at least two test scenarios: (1) successful search returning true and (2) unsuccessful
    // search returning false.
    
    // 1. succesful search returning true 
    String[][] items =  {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
      {"Soda", "100"}, null};
    int itemsCount = 5;
    String[][] orignalItem = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
    {"Soda", "100"}, null};

    if(VendingMachine.containsItem("Soda", items, itemsCount)){
        if(!Arrays.deepEquals(items,orignalItem)){
          System.out.println("testContainsItem-scenario 1. Problem detected: Your getIndexNextItem did make "
          + "changes to the content of the array passed as input.");
          return false;
        }
        System.out.println("1) the method found the object");
        return true;} 
  
    //2 unsucceful search
    if(VendingMachine.containsItem("Juice", items, itemsCount)){
      System.out.println("containsitemstest2: problem detected: containsItem didnt have element still it returned true");
      return false;
    }
    



    return false; // default return statement to let this incomplete code compiles with no errors.
                  // Feel free to change it.
  }
  /**
   * @return boolean returns false if any of the tests fail of getItemAtIndex
   */


  // Checks the correctness of getItemAtIndex defined in the VendingMachine class. This method
  // returns true if the test verifies a correct functionality and false if any bug is detected
  public static boolean testGetItemAtIndex() {
    String[][] items = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
    {"Soda", "100"}, {"Water", "30"}, null, null, null};
    String[][] orignal = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
    {"Soda", "100"}, {"Water", "30"}, null, null, null};
    int itemsCount = 6;

    //(1) the provided index is in bounds [0..itemsCount-1].
    if(VendingMachine.getItemAtIndex(0, items, itemsCount).equals("Water (50)")){
      System.out.println("getItemAtIndex: the method did  return right element");
      return true;

    }
    //(2) if any changes [0..itemsCount-1].
    if(!Arrays.deepEquals(items, orignal)){
      System.out.println("testGetItemAtIndex-scenario 2. Problem detected: Your getIndexNextItem did make "
          + "changes to the content of the array passed as input.");
          return false;
    }
    return true;

    // Define at least two test scenarios: (1) the provided index is out of the range
    // 0..itemsCount-1, (2) the provided index is in bounds [0..itemsCount-1].
    // For each test scenario, ensure that the method returned the exact expected string output
    // without making any changes to the contents of the array.

    // default return statement to let this incomplete code compiles with no errors.
  }
   /**
   * @return boolean returns false if any of the tests fail of getItemOccurences()
   */


  // Checks the correctness of getItemOccurrences defined in the VendingMachine class.
  public static boolean testGetItemsOccurrences() {
    // Define at least two test scenarios: (1) no match found so that the method returns zero,
    //(2) the items array contains multiple occurrences of the provided item description. 
    //(1) no match found so that the method returns zero,
   String[][] items = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
      {"Soda", "100"}, {"Water", "30"}, {"Soda", "20"}, null, null, null};
    int itemsCount = 7;
    if(VendingMachine.getItemOccurrences("tequila", items, itemsCount) != 0 ){
      System.out.println("the method didnt work it didnt return zero when object didnt exsist");
      return false;

    }
        //(2) the items array contains multiple occurrences of the provided item description.
        if(VendingMachine.getItemsOccurrencesByExpirationDate("Soda", "50", items, itemsCount)!= 3){
            System.out.println("the method failed when there were more than one item");
            return false;

        }
     // For each test scenario, ensure that the method returned the expected output without making
    // any changes to the contents of the array.
    return true; // default return statement to let this incomplete code compiles with no errors.
  }
   /**
   * @return boolean returns false if any of the tests fail of addItem
   */


  // Checks the correctness of addItem defined in the VendingMachine class.
  public static boolean testAddItem() {
    // Define at least three test scenarios: (1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0), and (3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.
    
    //(1) adding a new item to an empty vending machine whose
    // size is zero (provided itemsCount == 0)
    String[][] empt = new String[7][2]; //empty array test

    
    if(1 != VendingMachine.addItem("water", "10", empt, 0)){
      System.out.println("the method fails when the array is empty");
      return false;
    }

    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.
    //(2) adding a new item to a non-empty non-full
    // vending machine, 
    String[][] items = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
    null, null};
    int itemsCount = 4;
    if(5 != VendingMachine.addItem("Soda", "100", items, itemsCount)){
      System.out.println("the test didnt work the number didnt get added correctly");
      return false;
    }
    //(3) adding a new item to a full vending machine where the provided
    // itemsCount equals the length of the provided items array.
    String[][] fullArr =  {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
    {"Soda", "100"}, {"Water", "30"}};
    int itemsCount1 = 6; //the size of the full array
    if(VendingMachine.addItem("water", "2", fullArr, itemsCount1) != itemsCount1){
      System.out.println("the method changed the item size test failed");
      return false;
    }

    


    return true;
     // default return statement to let this incomplete code compiles with no errors.
  }

  // Checks the correctness of removeNextItem defined in the VendingMachine class.
   /**
   * @return boolean returns false if any of the tests fail of removeNextItem()
   */

  public static boolean testRemoveNextItem() {

    // Define at least four test scenarios: (1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), (2) the next item to be removed matching
    // the provided description is at index 0 of the array, (3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array), and (4) the next item to be removed
    // is at a middle index of the provided items array.
    
    //(1) trying to remove a non-existing item from a vending
    // machine (the vending machine can be empty or not), 
    String[][] items = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, {"Water", "20"},
    {"Soda", "100"}, {"Water", "30"}, null, null, null};
    int itemsCount = 6;
    if(VendingMachine.removeNextItem("shit", items, itemsCount)!= itemsCount){
      System.out.println("the method made changes to the array when the item didnt exsist test failed");
      return false;
    }
    //(2) the next item to be removed matching
    // the provided description is at index 0 of the array,
    String[][] item = {{"water","10"},{"soda","50"},{"water","50"}};
    String[][] item1 = {{"soda","50"},{"water","50"}};
    
    if(VendingMachine.removeNextItem("water", item, 3) != 2){
      System.out.println("(2)the method failed couldnt remove the required object");
      return false;
    }
    
    //(3) the next item to be removed is at
    // index itemsCount of the array (at the end of the array)
    String[][] item3 = {{"water","50"},{"soda","50"},{"water","10"}};
    String[][] item4 = {{"water","50"},{"soda","50"}};
    if(VendingMachine.removeNextItem("water", item3, 3) != 2){
      System.out.println("(3)the method failed couldnt remove the required object");
      return false;
    }

   // (4) the next item to be removed
    // is at a middle index of the provided items array.
    String[][] item5 = {{"piano","20"},{"water","50"},{"soda","50"},{"water","10"},{"soda","70"}};
    String[][] item6 = {{"piano","20"},{"water","50"},{"water","10"},{"soda","70"}};
    if(VendingMachine.removeNextItem("water", item5, 5) != 4){
      System.out.println("(4)the method failed couldnt remove the required object");
      return false;
    }
  
    // For each tester scenario, check for the expected returned size of the vending machine and
    // the expected content of the items array after the method call returns.


    return true; // default return statement to let this incomplete code compiles with no errors.
  }
/**
 * 
 * @return true if getItemsSummary passes all the tests 
 */
  // Checks the correctness of getItemsSummary defined in the VendingMachine class.
  public static boolean testGetItemsSummary() {
    // Define at least three scenarios: 
    //(1) the vending machine is empty
    String[][] empty = new String[7][2]; //creates an empty array
    if(VendingMachine.getItemsSummary(empty, 0)!= null){
      System.out.println("testGetItemsSummary - test1 failed, does not return false when the array is empty"); //error message
      return false;
    }
     //(2) the vending machine
         // contains non duplicate items (no multiple items with the same description),
    String[][] items = {{"Water", "50"}, {"Soda", "60"}, {"Cookies", "10"}, null, null, null};
    int itemsCount = 3;
    int x = 0;
    String sum = "\n";
    for (int i = 0; i < itemsCount; i++) {

      x = VendingMachine.getItemOccurrences(items[i][0], items, itemsCount);

        
      
      
      sum = sum + items[i][0] + " " + "(" + x + ")" + "\n";
    }

    if(!sum.equals(VendingMachine.getItemsSummary(items, itemsCount))){
      System.out.println("test failed contains non duplicate items");
      System.out.println(sum);
      System.out.println(VendingMachine.getItemsSummary(items, itemsCount));
     

      return false;
    }
    

      

    // (3) the vending
    // machine contains multiple items with the same description at various index locations.

    /*String[][] multi = {{"blue","20"},{"nylon","60"},{"thrift","70"},{"blue","50"},null,null}; // repeated occurence
    String su = "\n";
    int itemsCount2 = 4; //item count for above array
    String[][] now = new String[15][2]; // new array for storing the non repeatative items
    
    int c =0;
    for (int i = 0; i < itemsCount2; i++) {
      if(VendingMachine.getItemOccurrences(now[i][0], now, itemsCount2) == 0){
        now[i] = new String[2];
        now[i][0] = multi[i][0];
        now[i][1] = multi[i][1];
      }
      c = VendingMachine.getItemOccurrences(multi[i][0], multi, itemsCount2);

        
      

      su = su + multi[i][0] + " " + "(" + c + ")" + "\n";

    }
    if(!su.equals(VendingMachine.getItemsSummary(now, itemsCount2))){
      System.out.println("method getItemsummary failed when tested with repeated objects");
    }*/


    return true;

     // default return statement to let this incomplete code compiles with no errors.
  }
  /**
   * // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
   * @return false if any of the above method fails
   */
  // This method returns false if any of the tester methods defined in this class fails, and true
  // if no bug detected.
  public static boolean runAllTests() {
    if(!testGetItemsSummary()){
      System.out.println("testGetItemsSummary() failed");
      return false;
    }
    if(!testRemoveNextItem()){
      System.out.println("testRemoveNextItem() failed");
      return false;
    }
    if(!testAddItem()){
      System.out.println("test testAddItem() failed");
      return false;
    }
    if(!testGetItemsOccurrences()){
      System.out.println("test testGetItemsOccurrences() failed");
      return false;
    }
    if(!testGetItemAtIndex()){
      System.out.println("test get item at index failed");
      return false;
    }
    
    
    return true; // default return statement to let this incomplete code compiles with no errors.
  }

  // main method to call the tester methods defined in this class
  public static void main(String[] args) {
   
    System.out.println(" testRemoveNextItem()" + runAllTests());


  }

}

