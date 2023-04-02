// TODO Complete file header must be added here
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    PO9 chugimon
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:  psingh76@wisc.edu
// Lecturer:  Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////


/**
 * This class checks the correctness of the implementation of the methods defined in the Chugimon
 * and ChugiTree classes.
 * 
 * @author TODO add your name(s)
 *
 */

public class ChugidexTester {


  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Chugimon class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonCompareToEquals() {
    //creating tester chugimons 
    Chugimon Bulbbell = new Chugimon(1, 70);
    Chugimon Bulbbell2 = new Chugimon(1, 71);
    Chugimon unEqName1 = new Chugimon(37, 1); //the smaller one 
    Chugimon unEqName2 = new Chugimon(37, 82); //the biger one 
    Chugimon test1 = new Chugimon(4, 25); //the smaller one 
    Chugimon test2 = new Chugimon(6, 25); //the biger one 
    Chugimon test3 = new Chugimon(4, 25); //the smaller one 
    //testing if the elements are accesed correctly 
    if(!Bulbbell.getName().equals(Bulbbell2.getName())){
      System.out.println("the accesor of class chugimon is not working properly ");
      return false;
    }


    //testing compare to 
    
    //(1) testing with unequal names  
    if(unEqName2.compareTo(unEqName1)<0){
      System.out.println("the method .compareto() did not work properly when the elements had different names" );
      return false;
    }
    //(2) equal names but different primary id 
    if(test1.compareTo(test2)>=0){
      System.out.println("the .compare to method did not work properly when names were equal but different primary id");
      return false;
    }
    //(3) equal name and primary id but different secondary id 
    if(Bulbbell.compareTo(Bulbbell2)>=0){
      System.out.println("the compare to method does not work propperly when used with chugimon with same name but different swcondary id");
      return false;
    }    
    
    //(4) all three fields are equal
    //testing equals()
    if(!test1.equals(test3) || test2.equals(test3)){
      System.out.println("the .equals()_ method does not work properly");
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of Chugimon.toString() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testChugimonToString() {
    // TODO complete the implementation of this method
    Chugimon Bulbbell = new Chugimon(1, 70);
    Chugimon Bulbbell2 = new Chugimon(1, 71);
    

    return Bulbbell.toString().equals("Bulbbell#1.70"); // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of ChugiTree.isValidBSTHelper() method. This
   * tester should consider at least three scenarios. (1) An empty tree whose root is null should be
   * a valid BST. (2) Consider a valid BST whose height is at least 3. Create the tree using the
   * constructors of the BSTNode and its setters methods, (3) Consider a NON-valid BST where the
   * search order property is violated at at least one internal node.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testIsValidBSTHelper() {
    // TODO complete the implementation of this method

    //check if throws false if the field is null
    if (ChugiTree.isValidBSTHelper(null) == false){
        System.out.println("problem when root is null");
     return false;}
  Chugimon first = new Chugimon(10, 25); //creating chugimon
  BSTNode<Chugimon> aNode = new BSTNode<Chugimon>(first);
      //creating a test binary tree and seeing if it is a valid binary tree
  Chugimon second = new Chugimon(8, 27);
  BSTNode<Chugimon> bNode = new BSTNode<Chugimon>(second);
  Chugimon third = new Chugimon(9, 2);
  BSTNode<Chugimon> cNode = new BSTNode<Chugimon>(third);
  aNode.setLeft(bNode);
  bNode.setRight(cNode);
  if (ChugiTree.isValidBSTHelper(aNode) != false){
  
    return false;}
  BSTNode<Chugimon> NodeD = new BSTNode<Chugimon>(first);
  cNode.setRight(NodeD);
  if (ChugiTree.isValidBSTHelper(aNode) == true)
    return false;
  return true; // Default return statement added to resolve compiler errors
}

  /**
   * Checks the correctness of the implementation of both add() and toString() methods implemented
   * in the ChugiTree class. This unit test considers at least the following scenarios. (1) Create a
   * new empty ChugiTree, and check that its size is 0, it is empty, and that its string
   * representation is an empty string "". (2) try adding one Chugimon and then check that the add()
   * method call returns true, the tree is not empty, its size is 1, and the toString() called on
   * the tree returns the expected output. (3) Try adding another Chugimon which is less than the
   * Chugimon at the root, (4) Try adding a third Chugimon which is greater than the one at the
   * root, (5) Try adding at least two further Chugimons such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, that the ChugiTree is a valid BST, and that the toString() method returns the expected
   * string representation of the contents of the binary search tree in an increasing order from the
   * smallest to the greatest Chugimon. (6) Try adding a Chugimon already stored in the tree. Make
   * sure that the add() method call returned false, and that the size of the tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddToStringSize() {
    ChugiTree nwT = new ChugiTree();
	  //scenario 1
	  if (nwT.isEmpty() == false || nwT.size() != 0 || nwT.toString() != ""){
		  System.out.println("error scenario 1");
      return false;}
	  
	  //scenario 2
	  Chugimon first = new Chugimon(10, 25);	  
	  if (nwT.add(first) != true || nwT.isEmpty() == true || 
		  nwT.size() != 1 || nwT.toString() == first.toString()){
        System.out.println("error in scenario 2" + " " + nwT.toString() + " " + first.toString()+ nwT.size());
        return false;}
	  
	  //scenario 3
	  Chugimon second = new Chugimon(8, 27);
	  if (nwT.add(second) != true  || nwT.size() != 2 ){
		  System.out.println("error in scenario 2");
    return false;
    }
	  //scenario 4
	  Chugimon c = new Chugimon(11, 27);
	  if (nwT.add(c) != true  || nwT.size() != 3 
		  ){
      System.out.println("error in scenario 2");
		 return false;}
	  
	  //scenario 5
	  Chugimon d = new Chugimon(7, 22);
	  Chugimon e = new Chugimon(10, 27);
	  if (nwT.add(d) != true  || nwT.add(e) != true || nwT.size() != 5)
			 return false;
	  
	  //scenario 6
	  Chugimon f = new Chugimon(10, 25);
	  if (nwT.add(f) == true  || nwT.size() != 5)
		  return false;
			  
    // TODO complete the implementation of this method
    return true; // Default return statement added to resolve compiler errors
  
    
  }

  /**
   * This method checks mainly for the correctness of the ChugiTree.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ChugiTree. Then, check that
   * calling the lookup() method on an empty ChugiTree returns fbalse. (2) Consider a ChugiTree of
   * height 3 which contains at least 5 Chugimons. Then, try to call lookup() method to search for a
   * Chugimon having a match at the root of the tree. (3) Then, search for a Chugimon at the right
   * and left subtrees at different levels considering successful and unsuccessful search
   * operations. Make sure that the lookup() method returns the expected output for every method
   * call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    if(nwT.lookup(0, 0) != null){
      return false;
    }
    Chugimon first = new Chugimon(10, 25);
    Chugimon second = new Chugimon(9, 5);
    Chugimon third = new Chugimon(5, 25);
    Chugimon fourth = new Chugimon(4, 25);
    Chugimon fifth = new Chugimon(8, 25);
    nwT.add(first);
    nwT.add(second);
    nwT.add(third);
    nwT.add(fourth);
    nwT.add(fifth);
    if(!nwT.lookup(10, 25).equals(first)){
      return false;
    }
    if(nwT.lookup(9, 5).equals(first)){
      return false;
    }
    if(nwT.lookup(4, 25).equals(first)){
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.countType() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testCountType() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    Chugimon first = new Chugimon(10, 25);
    Chugimon second = new Chugimon(9, 5);
    Chugimon third = new Chugimon(5, 25);
    Chugimon fourth = new Chugimon(4, 25);
    Chugimon fifth = new Chugimon(8, 25);
    nwT.add(first);
    nwT.add(second);
    nwT.add(third);
    nwT.add(fourth);
    nwT.add(fifth);
    if(nwT.countType(first.getPrimaryType()) !=0) return false;
    return true; // Default return statement added to resolve compiler errors
  }
  
  /**
   * Checks for the correctness of ChugiTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty Chugimon tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ChugiTree with four levels for instance, is 4.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    if(nwT.height() != 0) return false;
  
    Chugimon first = new Chugimon(10, 25);
    Chugimon second = new Chugimon(9, 5);
    Chugimon third = new Chugimon(5, 25);
    Chugimon fourth = new Chugimon(4, 25);
    Chugimon fifth = new Chugimon(8, 25);
    nwT.add(first);
    if(nwT.height()!=1) return false;
    nwT.add(first);
    nwT.add(second);
    nwT.add(third);
    nwT.add(fourth);
    nwT.add(fourth);
    nwT.add(fourth);
    if(nwT.height()!=3)return false;

    
    

    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getFirst() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetFirst() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    if(nwT.getFirst()!= null) return false;
    Chugimon first = new Chugimon(10, 25);
    nwT.add(first);
    if(nwT.getFirst()!=first) return false;
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.getLast() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetLast() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    if(nwT.getLast()!= null) return false;
    Chugimon first = new Chugimon(10, 25);
    nwT.add(first);
    if(nwT.getLast()!=first) return false;
    return true;
 // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.delete() method. This test must consider at least 3
   * test scenarios. (1) Remove a Chugimon that is at leaf node (2) Remove a Chugimon at non-leaf
   * node. For each of these scenarios, check that the size of the tree was decremented by one and
   * that the resulting ChugiTree is a valid BST, (3) ensures that the ChugiTree.delete() method
   * returns false when called on an Chugimon that is not present in the BST.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testDelete() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    Chugimon first = new Chugimon(10, 25);
    Chugimon second = new Chugimon(9, 5);
    Chugimon third = new Chugimon(5, 25);
    Chugimon fourth = new Chugimon(4, 25);
    Chugimon fifth = new Chugimon(8, 25);
    nwT.add(first);
    nwT.add(second);
    nwT.add(third);
    nwT.add(fourth);
    nwT.add(fifth);
    nwT.delete(fifth);
    if(nwT.size()!=4 || !nwT.isValidBST()) return false;
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.next() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testNext() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    Chugimon first = new Chugimon(10, 25);
    Chugimon second = new Chugimon(9, 5);
    Chugimon third = new Chugimon(5, 25);
    Chugimon fourth = new Chugimon(4, 25);
    Chugimon fifth = new Chugimon(8, 25);
    nwT.add(first);
    nwT.add(second);
    nwT.add(third);
    nwT.add(fourth);
    nwT.add(fifth);

    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ChugiTree.previous() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testPrevious() {
    // TODO complete the implementation of this method
    ChugiTree nwT = new ChugiTree();
    Chugimon first = new Chugimon(10, 25);
    Chugimon second = new Chugimon(9, 5);
    Chugimon third = new Chugimon(5, 25);
    Chugimon fourth = new Chugimon(4, 25);
    Chugimon fifth = new Chugimon(8, 25);
    nwT.add(first);
    nwT.add(second);
    nwT.add(third);
    nwT.add(fourth);
    nwT.add(fifth);
  
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testChugimonCompareToEquals: " + testChugimonCompareToEquals());
    System.out.println("testChugimonToString(): " + testChugimonToString());
    System.out.println("testIsValidBSTHelper(): " + testIsValidBSTHelper());
    System.out.println("testAddToStringSize(): " + testAddToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testCountType(): " + testCountType());
    System.out.println("testGetFirst(): " + testGetFirst());
    System.out.println("testGetLast(): " + testGetLast());
    System.out.println("testDelete(): " + testDelete());
    System.out.println("testNext(): " + testNext());
    System.out.println("testPrevious(): " + testPrevious());
  }

}
