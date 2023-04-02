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

// TODO Add file header
import java.util.NoSuchElementException;

/**
 * This class implements a ChugidexStorage as a Binary Search Tree.
 * 
 * Notes: 1) You may NOT use any arrays or Collections objects (ArrayLists, etc)
 * in this class. 2)
 * You may NOT use any loops (for, while, etc) in this class. Recursive
 * strategies only.
 *
 */
public class ChugiTree implements ChugidexStorage {
  private static BSTNode<Chugimon> prev = null;
  /**
   * The root of this ChugiTree. Set to null when tree is empty.
   */
  private BSTNode<Chugimon> root;

  /**
   * The size of this ChugiTree (total number of Chugimon stored in this BST)
   */
  private int size;

  /**
   * Constructor for Chugitree. Should set size to 0 and root to null.
   */
  public ChugiTree() {
    // TODO implement the constructor
    root = null;
    size = 0;
  }

  /**
   * Getter method for the Chugimon at the root of this BST.
   * 
   * @return the root of the BST.
   */
  public Chugimon getRoot() {
    // TODO implement this method


    return root.getData(); //return statement
  }

  /**
   * A method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   * 
   * @return true if this ChugiTree is a valid BST, false otherwise
   */
  public boolean isValidBST() {
    return isValidBSTHelper(root);
  }

  /**
   * A helper method for determining whether this ChugiTree is a valid BST. In
   * order to be a valid BST, the following must be true: For every internal
   * (non-leaf) node X of a binary tree, all the values in the node's left subtree
   * are less than the value in X, and all the values in the node's right subtree
   * are greater than the value in X.
   * 
   * @param node The root of the BST.
   * @return true if the binary tree rooted at node is a BST, false otherwise
   */
  public static boolean isValidBSTHelper(BSTNode<Chugimon> node) {
    

    if(node == null){
      return true;
    }
    if(isValidBSTHelper(node.getLeft()) == false) return false;
    if(prev!=null && prev.getData().compareTo(node.getData())>=0){
      return false;
    }
    prev = node;
    return isValidBSTHelper(node.getRight());
    
  }

  /**
   * Checks whether this ChugiTree is empty or not
   * 
   * @return true if this tree is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    // TODO implement this method
    if(size == 0 && root == null){
      return true; //check if the tree is empty
    }
    return false; // default return statement
  }

  /**
   * Gets the size of this ChugiTree
   * 
   * @return the total number of Chugimons stored in this tree
   */
  @Override
  public int size() {
    // TODO implement this method


    return size; // default return statement
  }

  /**
   * Returns a String representation of all the Chugimons stored within this
   * ChugiTree in the
   * increasing order with respect to the result of Chugimon.compareTo() method.
   * The string should
   * be a comma-separated list of all the Chugimon toString() values. No spaces
   * are expected to be
   * in the resulting string. No comma should be at the end of the resulting
   * string. For instance,
   * 
   * "nameOne#12.25,nameTwo#12.56,nameTwo#89.27"
   * 
   * @return a string containing all of the Chugimon, in the increasing order.
   *         Returns an empty
   *         string "" if this BST is empty.
   * 
   */
  @Override
  public String toString() {
    return toStringHelper(root);
  }

  /**
   * Recursive helper method which returns a String representation of the
   * ChugiTree rooted at node. An example of the String representation of the
   * contents of a ChugiTree storing three Chugimons is provided in the
   * description of the above toString() method.
   * 
   * @param node references the root of a subtree
   * @return a String representation of all the Chugimons stored in the sub-tree
   *         rooted at node in
   *         increasing order. Returns an empty String "" if current is null.
   */
  protected static String toStringHelper(BSTNode<Chugimon> node) {
    // TODO Implement this method
    String result = "";
    if (node == null)
        return "";
    result += toStringHelper(node.getLeft());
    result += toStringHelper(node.getRight());
    result += node.getData().toString();
    return result; // Default return statement added to resolve compiler errors
  }

  /**
   * Adds a new Chugimon to this ChugiTree. Duplicate Chugimons are NOT allowed.
   * 
   * @param newChugimon Chugimon to add to this ChugiTree
   * @return true if if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with newChugimon is already present in the tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  newChugimon is null.
   */
  @Override
  public boolean add(Chugimon newChugimon) {
    // TODO implement this method
    	    // if root is null:
          if(newChugimon == null){
            throw new IllegalArgumentException("Null chugi input");
          }
          if (isEmpty()) {
            root = new BSTNode<Chugimon>(newChugimon);
            size++;
            return true;
          }
          
          // otherwise:
          else {
            boolean x = addHelper(newChugimon, root);
            if(x){
              size++;
              
            }
           return x;
          }
   
  }

  /**
   * Recursive helper method to insert a new Chugimon to a Pokedex rooted at node.
   * 
   * @param node        The "root" of the subtree we are inserting the new
   *                    Chugimon into.
   * @param newChugimon The Chugimon to be added to a BST rooted at node. We
   *                    assume that newChugimon is NOT null.
   * @return true if the newChugimon was successfully added to the ChugiTree,
   *         false if a match with
   *         newChugimon is already present in the subtree rooted at node.
   */
  protected static boolean addHelper(Chugimon newChugimon, BSTNode<Chugimon> node) {
    // TODO implement this method

   
	  int r = newChugimon.compareTo(node.getData());
	    //CHECK THE RESULTS
	    if (r == 0) {
	      // they are the same!!
	      return false;
	    }
	    else if (r < 0) {
	      // toAdd goes in left subtree
	      if (node.getLeft() == null) {
	        // base case
	        node.setLeft(new BSTNode<Chugimon>(newChugimon));
          
	        return true;
	      }
	      else {
	        // recursive case
	        addHelper(newChugimon, node.getLeft());
	      }
	    }
	    else {
	      // toAdd goes in right subtree
	      if (node.getRight() == null) {
	        // base case
	        node.setRight(new BSTNode<Chugimon>(newChugimon));
	        return true;
	      }
	      else {
	    	  // recursive case
		        addHelper(newChugimon, node.getRight());
	      }
	    }
	        // default return statement, definitely wrong
	    return true;   // default return statement
  }

  /**
   * Searches a Chugimon given its first and second identifiers.
   * 
   * @param firstId  First identifier of the Chugimon to find
   * @param secondId Second identifier of the Chugimon to find
   * @return the matching Chugimon if match found, null otherwise.
   */
  @Override
  public Chugimon lookup(int firstId, int secondId) {
    if(isEmpty()){
      return null;
    }
    return lookupHelper(new Chugimon(firstId, secondId), root);
    
  }

  /**
   * Recursive helper method to search and return a match with a given Chugimon in
   * the subtree rooted at node, if present.
   * 
   * @param toFind a Chugimon to be searched in the BST rooted at node. We assume
   *               that toFind is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match to target.
   * @return a reference to the matching Chugimon if found, null otherwise.
   */
  protected static Chugimon lookupHelper(Chugimon toFind, BSTNode<Chugimon> node) {
    // TODO Implement this method.
    if (node.getData().equals(toFind)) {
      return node.getData(); 
    }
    if (node.getData().compareTo(toFind) > 0&&node.getLeft() != null) {
      return lookupHelper(toFind, node.getLeft()); 
    } else{
      return lookupHelper(toFind, node.getRight());
    }
  }

  

  /**
   * Computes and returns the height of this BST, counting the number of NODES
   * from root to the deepest leaf.
   * 
   * @return the height of this Binary Search Tree
   */
  public int height() {
    // TODO Implement this method.
    return heightHelper(root); // Default return statement
  }

  /**
   * Recursive helper method that computes the height of the subtree rooted at
   * node counting the number of nodes and NOT the number of edges from node to
   * the deepest leaf
   * 
   * @param node root of a subtree
   * @return height of the subtree rooted at node
   */
  protected static int heightHelper(BSTNode<Chugimon> node) {
    // TODO Implement this method.
    if (node == null) {
      return 0;
    } else {
      int left = heightHelper(node.getLeft()); 
      int right = heightHelper(node.getRight()); 

      if (left > right) {
        return (left + 1); 
      } else {
        return (right + 1); 
      }
    }
  }

  /**
   * Recursive method to find and return the first Chugimon, in the increasing
   * order, within this ChugiTree (meaning the smallest element stored in the
   * tree).
   * 
   * @return the first element in the increasing order of this BST, and null if
   *         the tree is empty.
   */
  @Override
  public Chugimon getFirst() {
    // TODO Implement this method.
    return getFirstHelper(root);
    // HINT: The smallest element in a non-empty BST is the left most element

  // default return statement
  }

  /**
   * Recursive helper method for getFirst().
   * 
   * @param root the node from which to find the the minimum node
   * @return the minimum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getFirstHelper(BSTNode<Chugimon> root) {
    // TODO Implement this method.
    if (root == null) {
      return null; 
    }
    if (root.getLeft() == null) {
      return root.getData(); 
    }
    return getFirstHelper(root.getLeft()); 

    // HINT: The smallest element in a non-empty BST is the left most element

    
  }

  /**
   * Recursive method to find and return the last Chugimon, in the increasing
   * order, within this ChugiTree (meaning the greatest element stored in the
   * tree).
   * 
   * @return the last element in the increasing order of this BST, and null if the
   *         tree is empty.
   */
  @Override
  public Chugimon getLast() {
    // TODO Implement this method.

    // HINT: The greatest element in a non-empty BST is the right most element
    return getLastHelper(root); // default return statement
  }

  /**
   * Recursive helper method for getLast().
   * 
   * @param root the node from which to find the the maximum node
   * @return the maximum element in the increasing order from the node <b>root</b>
   */
  protected static Chugimon getLastHelper(BSTNode<Chugimon> root) {
    // TODO Implement this method.
    if (root == null) {
      return null; // 
    }
    if (root.getRight() == null) {
      return root.getData(); // 
    }
    return getFirstHelper(root.getRight()); 
    // HINT: The smallest element in a non-empty BST is the right most element
  }

  /**
   * Recursive method to get the number of Chugimon with a primary or secondary
   * type of the specified type, stored in this ChugiTree.
   * 
   * @param chugiType the type of Chugimons to count. We assume that chugiType is
   *                  NOT null.
   * @return the number of all the Chugimon objects with a primary or secondary
   *         type of the
   *         specified type stored in this ChugiTree.
   */
  public int countType(ChugiType chugiType) {
    // TODO(student): Implement method.
    return countTypeHelper(chugiType,root);
  }
  private static int countTypeHelper(ChugiType chugiType, BSTNode<Chugimon> node) {
    if(node==null) {
      return 0;
    }
    int count=0;
    if(node.getData().getPrimaryType()==chugiType||node.getData().getSecondaryType()==chugiType) {
      count++;
    }
    return count+countTypeHelper(chugiType,node.getLeft())+countTypeHelper(chugiType,node.getRight());
  }

  /**
   * Finds and returns the in-order successor of a specified Chugimon in this
   * ChugiTree
   * 
   * @param chugi the Chugimon to find its successor
   * @return the in-order successor of a specified Chugimon in this ChugiTree
   * 
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   with a descriptsve error message if the
   *                                  Chugimon provided as input has no in-order
   *                                  successor in this ChugiTree.
   */
  @Override
  public Chugimon next(Chugimon chugi) {
    // TODO: Implement this method.
    if(chugi == null)
    throw new IllegalArgumentException("Chugimon cannot be null");

  Chugimon chugimon = nextHelper(chugi,root,null);

  if (chugimon == null)
    throw new NoSuchElementException("Chugimon not found");

  return nextHelper(chugi,root,null);
  
  }

  /**
   * Recursive helper method to find and return the next Chugimon in the tree
   * rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order successor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param next  a BSTNode which stores a potentional candidate for next node
   * @return the next Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                successor in the subtree
   *                                rooted at node.
   */
  protected static Chugimon nextHelper(Chugimon chugi, BSTNode<Chugimon> node, BSTNode next) {
    if(node == null){
      return null;
    }

    // recursive cases:
    // (1) if chugi is found and if the right child is not null, use getFirstHelper
    // to find and
    // return the next chugimon. It should be the left most child of the right
    // subtree

    if(node.getData().compareTo(chugi) == 0 && node.getRight() != null){
      return getFirstHelper(node.getRight());
    }

    // (2) if chugi is less than the Chugimon at node, set next as the root node and
    // search
    // recursively into the left subtree

    if (node.getData().compareTo(chugi) > 0){
      next = node;

      return nextHelper(chugi,node.getLeft(),next);
    }

    return null;
  }

  /**
   * Finds and returns the in-order predecessor of a specified Chugimon in this
   * ChugiTree
   * 
   * @param chugi the Chugimon to find its predecessor
   * @return the in-order predecessor of a specified Chugimon in this ChugiTree.
   * 
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   * @throws NoSuchElementException   if there is no Chugimon directly before the
   *                                  provided Chugimon
   */
  @Override
  public Chugimon previous(Chugimon chugi) {
        // TODO: Implement this method.
        if(chugi == null)
        throw new IllegalArgumentException("Chugimon cannot be null");
    
      Chugimon chugimon = previousHelper(chugi,root,null);
    
      if (chugimon == null)
        throw new NoSuchElementException("Chugimon not found");
    
      return previousHelper(chugi,root,null);
  }

  /**
   * Recursive helper method to find and return the previous Chugimon in the tree
   * rooted at node.
   * 
   * @param chugi a Chugimon to search its in-order predecessor. We assume that
   *              <b>chugi</b> is NOT
   *              null.
   * @param node  "root" of a subtree storing Chugimon objects
   * @param prev  a BSTNode which stores a potentional candidate for previous node
   * @return the previous Chugimon in the tree rooted at node.
   * @throws NoSuchElementException with a descriptive error message if the
   *                                Chugimon provided as input has no in-order
   *                                predecessor in the subtree rooted at node.
   */
  protected static Chugimon previousHelper(Chugimon chugi, BSTNode<Chugimon> node,
      BSTNode<Chugimon> prev) {
    // TODO Implement this method.
    // Hint: you will need to use getLastHelper in this method. Below are more
    // hints.

    // base case: node is null
    if(node == null){
      return null;
    }

    // recursive cases:
    // (1) if chugi is found and if the left child is not null, use getLastHelper to
    // find and return
    // the previous chugimon. It should be the right most child of the left subtree
    if(node.getData().compareTo(chugi) == 0 && node.getLeft() != null){
      return getLastHelper(node.getLeft());
    }
    // (2) if chugi is greater than the Chugimon at node, set prev as the root node
    // and search
    // recursively into the right subtree
    if (node.getData().compareTo(chugi) < 0){
      prev = node;

      return nextHelper(chugi,node.getLeft(),prev);
    }
    return null;
  }

  /**
   * Deletes a specific Chugimon from this ChugiTree.
   * 
   * @param chugi the Chugimon to delete
   * @return true if the specific Chugimon is successfully deleted, false if no
   *         match found with any
   *         Chugimon in this tree.
   * @throws IllegalArgumentException with a descriptive error message if
   *                                  <b>chugi</b> is null
   */
  @Override
  public boolean delete(Chugimon chugi) {
    // TODO Implement this method.

    if(chugi==null) {
      throw new IllegalArgumentException("Chugimon is null");
    }
    if(lookup(chugi.getFirstID(),chugi.getSecondID())==null) {
      return false;
    }
    root=deleteChugimonHelper(chugi,root);
    return true; // default return statement
  }

  /**
   * Recursive helper method to search and delete a specific Chugimon from the BST
   * rooted at node
   * 
   * @param target a reference to a Chugimon to delete from the BST rooted at
   *               node. We assume that target is NOT null.
   * @param node   "root" of the subtree we are checking whether it contains a
   *               match with the target Chugimon.
   * 
   * 
   * @return the new "root" of the subtree we are checking after trying to remove
   *         target
   * @throws NoSuchElementException with a descriptive error message if there is
   *                                no Chugimon matching target in the BST rooted
   *                                at <b>node</b>
   */
  protected static BSTNode<Chugimon> deleteChugimonHelper(Chugimon target, BSTNode<Chugimon> node) {
     // TODO complete the implementation of this method. Problem decomposition and
    // hints are provided in the comments below

    // if node == null (empty subtree rooted at node), no match found, throw an
    // exception
    if (node == null) {
      throw new NoSuchElementException("Empty subtree ");
    }
    // Compare the target to the data at node and proceed accordingly
    // Recurse on the left or right subtree with respect to the comparison result
    // Make sure to use the output of the recursive call to appropriately set the
    // left or the right child of node accordingly
    if (target.compareTo(node.getData()) < 0) {
      deleteChugimonHelper(target, node.getLeft());
    } 
    else if (target.compareTo(node.getData()) > 0) {
      deleteChugimonHelper(target, node.getRight());
    }
    // if match with target found, three cases should be considered. Feel free to
    // organize the order of these cases at your choice.
    else {
      // Case 1: node may be a leaf (has no children), set node to null.
      if (node.getLeft() == null && node.getRight() == null) {
        node = null;
      }
      // Case 2: node may have only one child, set node to that child (whether left or
      // right child)
      if (node.getLeft() == null && node.getRight() != null) {
        node = node.getRight();
      }
      if (node.getLeft() != null && node.getRight() == null) {
        node = node.getLeft();
      }
      // Case 3: node may have two children,
      // Replace node with a new BSTNode whose data field value is the successor of
      // target in the tree, and having the same left and right children as node.
      // Notice carefully that you cannot set the data of a BSTNode. Hint: The
      // successor is the smallest element at the right subtree of node
      //
      // Then, remove the successor from the right subtree. The successor must have up
      // to one child.

      // Make sure to return node (the new root to this subtree) at the end of each
      // case or at the end of the method.
    }
    return null;

     // Default return statement added to resolve compiler errors

  }

}

