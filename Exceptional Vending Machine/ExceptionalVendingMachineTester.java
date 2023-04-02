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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.zip.DataFormatException;



/**
 * This class implements testers to check the correctness of the methods implemented in p04
 * Exceptional Vending Machine
 *
 */
public class ExceptionalVendingMachineTester {
  // TODO complete the implementation of all the public static tester methods defined below

  // It is recommended but NOT required to add additional tester methods to check the correctness
  // of loadItems and saveVendingMachineSumary defined in the ExceptionalVendingMachine class.

  /**
   * Checks the correctness of the constructor of the class Item when passed invalid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorNotValidInput() {
    boolean flag = false;
    boolean flag2 = false;
    boolean flag3 = false;
    try {
      Item tester = new Item(null, 1);


    } catch (Exception IllegalArgumentException) {
      flag = true;
    }
    if (flag == false) {
      System.out.println(
          "the constructor did not give an error when null description was passed in Item");
    }
    try {
      Item tester2 = new Item("", 2);


    } catch (Exception IllegalArgumentException) {
      flag2 = true;
    }
    if (flag2 == false) {
      System.out.println(
          "the constructor did not give an error when blank description was passes in Item");
    }
    try {
      Item tester3 = new Item("kl", -1);


    } catch (Exception IllegalArgumentException) {
      flag3 = true;
    }
    if (flag3 == false) {
      System.out.println(
          "the constructor did not give an error when negative expiration date was passes in Item");
    }
    return (flag && flag2 && flag3);
  }

  /**
   * Checks the correctness of the constructor of the class Item, Item.getDescription(),
   * Item.getExpirationDate(), Item.setDescription(), and Item.toString() when passed valid inputs
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemConstructorGettersSetters() {
    Item tester = new Item("chips", 2);
    boolean flag1 = true;
    boolean flag2 = true;
    boolean flag3 = true;
    boolean flag4 = true;
    if (!tester.getDescription().equals("chips")) {
      System.out
          .println("the Item constructor did not work properly the description is different ");
      flag1 = false;
    }
    if (tester.getExpirationDate() != 2) {
      System.out
          .println("the Item constructor did not work properly the expiration date is different ");
      flag2 = false;
    }

    Item tester2 = new Item("s", 3);
    tester2.setDescription("fish");

    if (!tester2.getDescription().equals("fish")) {
      System.out.println(
          "the Item description setter did not work properly the description is different ");
      flag3 = false;
    }

    if (!tester.toString().equals("chips: 2")) {
      System.out.println("the to string overriden method toString doesnt work properly");
      flag4 = false;
    }


    return (flag1 && flag2 && flag3 && flag4); // default return statement added to resolve compiler
                                               // errors
  }

  /**
   * Checks the correctness of the Item.equals() method. You should consider at least the following
   * four scenarios. (1) Create an item with valid description and expiration date, comparing it to
   * itself should return true. (2) Two items having the same description but different expiration
   * dates should be equal. (3) Passing a null reference to the Item.equals() method should return
   * false. (4) An item MUST NOT be equal to an object NOT instance of the class Item, for instance
   * a string object.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testItemEquals() {
    Item tester1 = new Item("jelly", 7);
    Item tester2 = new Item("jelly", 8);
    boolean flag1 = true;
    boolean flag2 = true;
    boolean flag3 = true;
    boolean flag4 = true;
    if (!tester1.equals(tester1)) {
      System.out.println(
          "the equals() method did not work as expected when an object was compared to itself");
      flag1 = false;
    }
    if (!tester1.equals(tester2)) {
      System.out.println(
          "the equals method did not work as expected items with same description but with different expiration date were not equals");
      flag2 = false;
    }
    if (tester1.equals(null) != false) {
      System.out.println(
          "the equals method did not work as expected when item was compared with null it didnot return false");
      flag3 = false;
    }
    String blue = "jelly";
    if (tester1.equals(blue)) {
      System.out.println(
          " An item MUST NOT be equal to an object NOT instance of the class Item, for instance a string object while the equals() method returns true");
      flag4 = false;
    }
    return (flag1 && flag2 && flag3 && flag4); // default return statement added to resolve compiler
                                               // errors
  }


  /**
   * Checks the correctness of the constructor of the ExceptionalVendingMachine when passed invalid
   * input
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineConstructor() {
    try {
      ExceptionalVendingMachine tester = new ExceptionalVendingMachine(-2);
    } catch (Exception IllegalArgumentException) {
      return true;

    }
    System.out.println(
        "the constructor ExceptionalVendingMachine() did not return error when illegal argument was passed");
    return false; // default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the following methods defined in the ExceptionalVendingMachine class
   * when an exception is expected to be thrown:
   * 
   * addItem(), containsItem(), getIndexNextItem(), getItemAtIndex(), getItemOccurrences(),
   * getItemOccurrencesByExpirationDate(), removeNextItem().
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testExceptionalVendingMachineAddContainsRemoveGetters() {

    ExceptionalVendingMachine tester = new ExceptionalVendingMachine(2);
    tester.addItem("chilli", 1);
    tester.addItem("bones", 2);
    boolean flag = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    boolean flag6 = false;
    boolean flag7 = false;
    boolean flag8 = false;
    boolean flag9 = false;
    boolean flag10 = false;
    boolean flag11 = false;
    boolean flag12 = false;
    boolean flag13 = false;
    boolean flag14 = false;
    boolean flag15 = false;
    // add items test

    try {
      tester.addItem("hands", 2);
    } catch (Exception IllegalArgumentException) {
      flag = true;
    }
    if (flag == false) {
      System.out.println("The add method did not return exception when the array was full");
    }
    // contains item test

    try {
      tester.containsItem("");
    } catch (Exception IllegalArgumentException) {
      flag2 = true;
    }
    if (flag2 == false) {
      System.out.println(
          "the contains item method did not identify the illegal Argument error when string is blank");
    }

    // getIndexNextItem test

    // check for IllegalArgument exception
    try {

      tester.getIndexNextItem("");
      tester.getIndexNextItem(null);
    } catch (Exception IllegalArgumentException) {
      flag3 = true;
    }
    if (flag3 != true) {
      System.out.print(
          "the getIndexNextItem did not report an error when the string passed was blank or null ");
    }

    try {

      tester.getIndexNextItem("mona");

    } catch (Exception NoSuchElementException) {
      flag4 = true;
    }
    if (flag4 != true) {
      System.out.print(
          "the getIndexNextItem did not report an error when the string passed had no match ");
    }


    // test for get item at index

    try {
      tester.getItemAtIndex(-1);

    } catch (Exception IndexOutOfBoundException) {
      flag5 = true;
    }
    if (flag5 != true) {
      System.out.println(
          "the getItemStIndex did not give index out of bound exceptuon when the index passed was negative");
    }
    try {

      tester.getItemAtIndex(20);

    } catch (Exception IndexOutOfBoundException) {
      flag6 = true;
    }
    if (flag6 != true) {
      System.out.println(
          "the getItemStIndex did not give index out of bound exception when the index passed was greater than size of array");
    }
    try {

      tester.getItemAtIndex(tester.size());
    } catch (Exception IndexOutOfBoundException) {
      flag7 = true;
    }
    if (flag7 != true) {
      System.out.println(
          "the getItemStIndex did not give index out of bound exception when the index passed was equal to size of array");
    }

    // tester for getItemOccurences

    try {
      tester.getItemOccurrences(null);


    } catch (Exception IllegalArgumentException) {
      flag8 = true;
    }
    if (flag8 == false) {
      System.out.println(
          "the getItemOccurrences() did not give an error when null description was passed in Item");
    }
    try {
      tester.getItemOccurrences("");


    } catch (Exception IllegalArgumentException) {
      flag9 = true;
    }
    if (flag9 == false) {
      System.out.println(
          "the getItemOccurrences() did not give an error when blank description was passes in Item");
    }

    // getItemOccurrencesByExpirationDate() tester

    try {
      tester.getItemOccurrencesByExpirationDate(null, 2);


    } catch (Exception IllegalArgumentException) {
      flag10 = true;
    }
    if (flag10 == false) {
      System.out.println(
          "the getITEMOccurencesByExpirationDate did not give an error when null description was passed");
    }
    try {
      tester.getItemOccurrencesByExpirationDate("", 2);


    } catch (Exception IllegalArgumentException) {
      flag11 = true;
    }
    if (flag11 == false) {
      System.out.println(
          "the getITEMOccurencesByExpirationDate() method did not give an error when blank description was passed");
    }
    try {
      tester.getItemOccurrencesByExpirationDate("chilli", -22);


    } catch (Exception IllegalArgumentException) {
      flag12 = true;
    }
    if (flag12 == false) {
      System.out.println(
          "the getITEMOccurencesByExpirationDate method did not give an error when negative expiration date was passed");
    }
    // test removeNextItem

    try {
      tester.removeNextItem(null);


    } catch (Exception IllegalArgumentException) {
      flag13 = true;
    }
    if (flag13 == false) {
      System.out
          .println("the removeNextItem() did not give an error when null description was passed");
    }
    try {
      tester.removeNextItem("");


    } catch (Exception IllegalArgumentException) {
      flag14 = true;
    }
    if (flag14 == false) {
      System.out.println(
          "the removeNextItem() method did not give an error when blank description was passed");
    }

    try {
      tester.removeNextItem("mona");
    } catch (Exception NoSuchElementException) {
      flag15 = true;
    }
    if (flag15 != true) {
      System.out.println("remove next item did not give an error when no match was found");
    }

    return (flag && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10
        && flag11 && flag12 && flag13 && flag14 && flag15); // default return statement added to
                                                            // resolve
    // compiler
    // errors
  }

  /**
   * Checks the correctness of isEmpty(), size(), and isFull() methods defined in the
   * ExceptionalVendingMachine class
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testEmptySizeFullExceptionalVendingMachine() {
    ExceptionalVendingMachine item = new ExceptionalVendingMachine(3);
    ExceptionalVendingMachine item2 = new ExceptionalVendingMachine(3);
    item2.addItem("bill", 4);
    item2.addItem("neaon", 10);
    item2.addItem("billy", 1);


    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    boolean flag6 = false;
    boolean flag7 = false;
    boolean flag8 = false;
    boolean flag9 = false;
    // isEmpty tests
    if (item.isEmpty()) {
      flag1 = true;
    }
    if (!flag1) {
      System.out
          .println("the is empty method did not work properly empty machine was not reported");
    }
    if (!item2.isEmpty()) {
      flag2 = true;
    }
    if (!flag2) {
      System.out.println(
          "the is empty method did not work properly not empty machine was reported empty");
    }
    // size() tests
    if (item2.size() == 3) {
      flag3 = true;

    }
    if (!flag3) {
      System.out.println("the size() method does not return the correct size");
    }

    // is full tests///
    if (item2.isFull()) {
      flag4 = true;
    }
    if (!flag4) {
      System.out.println("the isFull method returned false for a full vending machine");
    }


    return (flag1 && flag2 && flag3 && flag4); // default return statement added to resolve compiler
                                               // errors

  }

  /**
   * Checks the correctness of loadOneItem method with respect to its specification. Consider at
   * least the four following scenarios. (1) Successful scenario for loading one item with a valid
   * string representation to a non-full vending machine. (2) Unsuccessful scenario for passing null
   * or a blank string (for instance one space or empty string) to the loadOneItem() method call, an
   * IllegalArgumentEXception is expected to be thrown. (3) Unsuccessful scenario for passing a
   * badly formatted string to the loadOneItem method. A DataFormatException is expected to be
   * thrown. (4) Unsuccessful scenario for trying to load an item with a valid representation to a
   * full vending machine. An IllegalStateException is expected to be thrown.
   * 
   * @return true if the test verifies a correct functionality and false if any bug is detected
   */
  public static boolean testLoadOneItem() {
    boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
    ExceptionalVendingMachine test = new ExceptionalVendingMachine(25);
    test.addItem("bones", 42);
    try {
      test.loadOneItem("hello:5");
      if(!test.getItemAtIndex(1).equals("hello: 5")) {
        System.out.println("the method is not working correctly line 462 tester");
      }
    } catch (IllegalArgumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IllegalStateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (DataFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    // (1) Successful scenario for loading one item with a valid
    // * string representation to a non-full vending machine.

    try {
      test.loadOneItem("first: 23");
      flag1 = test.getItemAtIndex(2).equals("first: 23");
      if (!flag1) {
        System.out.println(
            "the load one item method did not add the string to the vending machine properly"
                + test.getItemAtIndex(1));
      }



    } catch (DataFormatException e) {
      // TOdO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      test.loadOneItem(null);
      test.loadOneItem(" ");
    } catch (Exception IllegalArgumentException) {
      flag2 = true;
    }
    if (!flag2) {
      System.out.println("the loadOneItem() did not give an error when string was null or blank ");

    }

    try {
      test.loadOneItem("first :   23");
      test.loadOneItem("first 23");
      test.loadOneItem("first :23");
      test.loadOneItem("first   : 23");
    } catch (DataFormatException e) {
      // TOdO Auto-generated catch block
      flag3 = true;
    }
    if (!flag3) {
      System.out.println("the loadOneItem did not identify when string was badly formatted");
    }
    try {

      test.loadOneItem("first 23");
      test.loadOneItem("St :: 12");

    } catch (DataFormatException e) {
      // TOdO Auto-generated catch block
      flag4 = true;
    }
    if (!flag4) {
      System.out.println("the loadOneItem did not identify when string was badly formatted");
    }
    try {
      test.loadOneItem("first: true");
    } catch (DataFormatException e) {
      // TOdO Auto-generated catch block
      flag5 = true;
    }
    if (!flag5) {
      System.out.println("the loadOneItem did not identify when string was badly formatted");
    }
    
    
    return flag1 && flag2 && flag3 && flag4 && flag5; // default return statement added to resolve
                                                      // compiler errors
  }


  /**
   * Invokes all the public tester methods implemented in this class
   * 
   * @return true if all testers pass with no errors, and false if any of the tester fails.
   */
  public static boolean runAllTests() {
    boolean flag = testItemConstructorNotValidInput() && testItemConstructorGettersSetters()
        && testItemEquals() && testExceptionalVendingMachineConstructor()
        && testExceptionalVendingMachineAddContainsRemoveGetters()
        && testEmptySizeFullExceptionalVendingMachine() && testLoadOneItem();
    return flag; // default return statement added to resolve compiler errors
  }
  public static void tester() {
    File file = new File("/Users/pushpitsingh/eclipse-workspace/P04 Exceptional Vending Machine/src/itemstester.txt");
    ExceptionalVendingMachine x = new ExceptionalVendingMachine(15);
    int y =0;
    try {
      y = x.loadItems(file);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println(x.getItemsSummary() + "           " + y);
    
  }

  /**
   * Main method for the tester class
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    System.out.println(
        "testItemConstructorNotValidInput() returns " + testItemConstructorNotValidInput());
    System.out.println(
        "testItemConstructorGettersSetters() returns " + testItemConstructorGettersSetters());
    System.out.println("testItemEquals() returns " + testItemEquals());
    System.out.println("testExceptionalVendingMachineConstructor() returns "
        + testExceptionalVendingMachineConstructor());
    System.out.println(testExceptionalVendingMachineAddContainsRemoveGetters());
    System.out.println("testEmptySizeFullExceptionalVendingMachine()"
        + testEmptySizeFullExceptionalVendingMachine());
    System.out.println(testLoadOneItem() + " testLoadOneItem()");
    tester();
  }

}
