// --== CS400 Spring 2023 File Header Information ==--
// Name: Aahaan Ruchir Sheth
// Email: arsheth@wisc.edu
// Team: DS
// TA: Daniel Finer
// Lecturer: Florian Hermiel
// Notes to Grader: <optional extra notes>
import java.util.LinkedList;
import java.util.Stack;

import org.junit.jupiter.api.BeforeEach;
/*** JUnit imports ***/
// We will use the BeforeEach and Test annotation types to mark methods in
// our test class.
import org.junit.jupiter.api.Test;
// The Assertions class that we import from here includes assertion methods like assertEquals()
// which we will used in test1000Inserts().
import static org.junit.jupiter.api.Assertions.assertEquals;
// More details on each of the imported elements can be found here:
// https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/package-summary.html
/*** JUnit imports end  ***/


/**
 * Red-Black Tree implementation with a Node inner class for representing
 * the nodes of the tree. Currently, this implements a Binary Search Tree that
 * we will turn into a red black tree by modifying the insert functionality.
 * In this activity, we will start with implementing rotations for the binary
 * search tree insert algorithm.
 */
public class RedBlackTree<T extends Comparable<T>> implements SortedCollectionInterface<T> {

    /**
     * This class represents a node holding a single value within a binary tree.
     */
    protected static class Node<T> {
        public T data;
        //0 = red, 1 = black, and 2 = double-black
        public int blackHeight;
        // The context array stores the context of the node in the tree:
        // - context[0] is the parent reference of the node,
        // - context[1] is the left child reference of the node,
        // - context[2] is the right child reference of the node.
        // The @SupressWarning("unchecked") annotation is used to supress an unchecked
        // cast warning. Java only allows us to instantiate arrays without generic
        // type parameters, so we use this cast here to avoid future casts of the
        // node type's data field.
        @SuppressWarnings("unchecked")
        public Node<T>[] context = (Node<T>[])new Node[3];
        public Node(T data) {
             this.data = data; 
             this.blackHeight = 0;
            }
        
        /**
         * @return true when this node has a parent and is the right child of
         * that parent, otherwise return false
         */
        public boolean isRightChild() {
            return context[0] != null && context[0].context[2] == this;
        }

    }

    protected Node<T> root; // reference to root node of tree, null when empty
    protected int size = 0; // the number of values in the tree

    /**
     * Performs a naive insertion into a binary search tree: adding the input
     * data value to a new node in a leaf position within the tree. After  
     * this insertion, no attempt is made to restructure or balance the tree.
     * This tree will not hold null references, nor duplicate data values.
     * @param data to be added into this binary search tree
     * @return true if the value was inserted, false if not
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when data is already contained in the tree
     */
    public boolean insert(T data) throws NullPointerException, IllegalArgumentException {
        // null references cannot be stored within this tree
        if(data == null) throw new NullPointerException(
                "This RedBlackTree cannot store null references.");

        Node<T> newNode = new Node<>(data);
        if (this.root == null) {
            // add first node to an empty tree
            root = newNode; size++;
            //adding the new method
            enforceRBTreePropertiesAfterInsert(newNode);
            return true;
        } else {
            // insert into subtree
            Node<T> current = this.root;
            while (true) {
                int compare = newNode.data.compareTo(current.data);
                if (compare == 0) {
                    throw new IllegalArgumentException("This RedBlackTree already contains value " + data.toString());
                } else if (compare < 0) {
                    // insert in left subtree
                    if (current.context[1] == null) {
                        // empty space to insert into
                        current.context[1] = newNode;
                        newNode.context[0] = current;
                        this.size++;
                        //adding the new method
                        enforceRBTreePropertiesAfterInsert(newNode);
                        return true;
                    } else {
                        // no empty space, keep moving down the tree
                        current = current.context[1];
                    }
                } else {
                    // insert in right subtree
                    if (current.context[2] == null) {
                        // empty space to insert into
                        current.context[2] = newNode;
                        newNode.context[0] = current;
                        this.size++;
                        //adding the new method
                        enforceRBTreePropertiesAfterInsert(newNode);
                        return true;
                    } else {
                        // no empty space, keep moving down the tree
                        current = current.context[2]; 
                    }
                }
            }
        }
    }
    /*
    /**
     * Performs the rotation operation on the provided nodes within this tree.
     * When the provided child is a left child of the provided parent, this
     * method will perform a right rotation. When the provided child is a
     * right child of the provided parent, this method will perform a left rotation.
     * When the provided nodes are not related in one of these ways, this method
     * will throw an IllegalArgumentException.
     * @param child is the node being rotated from child to parent position
     *      (between these two node arguments)
     * @param parent is the node being rotated from parent to child position
     *      (between these two node arguments)
     * @throws IllegalArgumentException when the provided child and parent
     *      node references are not initially (pre-rotation) related that way
     */
    private void rotate(Node<T> child, Node<T> parent) throws IllegalArgumentException {
        // TODO: Implement this method.
        
        if(parent==null || child == null || (parent.context[2] == null && parent.context[1] == null)) throw new IllegalArgumentException("Parent or child cannont be null");
      
       
        //(1) when parent is the node
        if(parent.context[0]==null){
            //if its the right child 
            if(child.isRightChild()){
                if(!parent.context[2].data.equals(child.data))throw new IllegalArgumentException("wrong relation");
                Node<T> temp = child.context[1]; //caturing left child  

                this.root = child;
                child.context[0] = null;
                child.context[1] = parent;
                parent.context[0] = child;
                parent.context[2] = temp;
                //making grandchild parent
                if(temp!=null) temp.context[0] = parent; 

            }
            else{
                if(!parent.context[1].data.equals(child.data))throw new IllegalArgumentException("wrong relation");
                //if left child
                Node<T> temp = child.context[2];
                this.root = child;
                child.context[0] = null;
                child.context[2] = parent;
                parent.context[0] = child;
                parent.context[1] = temp;
                if(temp!=null)temp.context[0] = parent;
            }
        }
        else{        
            boolean parentR = parent.isRightChild();   
        
        //if he child is right
        if(child.isRightChild()){
            //then left roate
            if(!parent.context[2].data.equals(child.data))throw new IllegalArgumentException("the child is not of the parent");
            Node<T> temp = child.context[2];
            
            Node<T> tempP = parent.context[0];
            child.context[0] = parent.context[0];
            if(parentR){
                parent.context[0].context[2] = child;
            }
            else{
                parent.context[0].context[1] = child;
            }
            parent.context[2] = child.context[1];
            parent.context[0] = child;
            child.context[1] = parent;
            
           
            if(temp!=null) temp.context[0] = parent;
            
            
            
            
        }
            //else left child 
        else{
            if(!parent.context[1].data.equals(child.data))throw new IllegalArgumentException("the child is not of the parent");
                Node<T> tempC = child.context[2];
                Node<T> tempP = parent.context[0];
                child.context[2] = parent;
                parent.context[0] = child;
                child.context[0] = tempP;
                parent.context[1] = tempC;
                if(parentR){
                    tempP.context[2] = child;
                }
                else{
                    tempP.context[1] = child;
                }
                if(tempC!=null) tempC.context[0] = parent;

                
                
                
            

        }
    }


    } 

    protected void enforceRBTreePropertiesAfterInsert(Node<T> newRed){
        this.root.blackHeight = 1;

        Node<T> parent = newRed.context[0];
        Node<T> grandParent = (parent == null) ? null : parent.context[0];
        // no element 
        if (parent == null) {
            newRed.blackHeight = 1; // root colout
            return;
        }
        if(grandParent == null){
            return;
        }
        
        Node<T> aunty = (parent.isRightChild()) ? grandParent.context[1] : grandParent.context[2];
        //no aunty found
        if(aunty == null){
            rotate(parent,grandParent);
            grandParent.blackHeight = 0;
            parent.blackHeight = 1;
        }
        // no properties violated
        if (parent.blackHeight == 1) {
            return;
        }
    
        // aunty and parent are red
        if (aunty != null && aunty.blackHeight == 0) {
            parent.blackHeight = 1;
            aunty.blackHeight = 1;
            if(grandParent != this.root){
                if(grandParent.context[0].blackHeight == 1) {
                    grandParent.blackHeight = 0;
                } else{
                    grandParent.blackHeight = 1;
                }
            }
            return;
        }
        // parent is red but aunty is black 
        if (aunty != null && aunty.blackHeight == 1) {
            //right and right scene
            if(parent.isRightChild() && parent.context[2] == newRed){
                rotate(parent,grandParent);
                changeColour(parent,grandParent);
              
            }
            //right and left 
            if(parent.isRightChild() && parent.context[1] == newRed){
                rotate(newRed,parent);
                rotate(newRed,grandParent);
                changeColour(newRed,grandParent);
                
            }
            //left and left 
            if(!parent.isRightChild() && parent.context[1] == newRed){
                rotate(parent,grandParent);
                changeColour(parent,grandParent);
                
            }
            //left and right 
            if(!parent.isRightChild() && parent.context[2] == newRed){
                rotate(newRed,parent);
                rotate(newRed,grandParent);
                changeColour(newRed,grandParent);
               
            }
        }
    }

    
    /**
     * exchanges colour
     * @param xterm - first node
     * @param yterm - second node
     */
    public void changeColour(Node<T> xterm, Node<T> yterm){
        int xCol = xterm.blackHeight;
        int yCol = yterm.blackHeight;
        xterm.blackHeight = yCol;
        yterm.blackHeight = xCol;
    }
    
        

    

    /**
     * Get the size of the tree (its number of nodes).
     * @return the number of nodes in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Method to check if the tree is empty (does not contain any node).
     * @return true of this.size() return 0, false if this.size() > 0
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Removes the value data from the tree if the tree contains the value.
     * This method will not attempt to rebalance the tree after the removal and
     * should be updated once the tree uses Red-Black Tree insertion.
     * @return true if the value was remove, false if it didn't exist
     * @throws NullPointerException when the provided data argument is null
     * @throws IllegalArgumentException when data is not stored in the tree
     */
    public boolean remove(T data) throws NullPointerException, IllegalArgumentException {
        // null references will not be stored within this tree
        if (data == null) {
            throw new NullPointerException("This RedBlackTree cannot store null references.");
        } else {
            Node<T> nodeWithData = this.findNodeWithData(data);
            // throw exception if node with data does not exist
            if (nodeWithData == null) {
                throw new IllegalArgumentException("The following value is not in the tree and cannot be deleted: " + data.toString());
            }  
            boolean hasRightChild = (nodeWithData.context[2] != null);
            boolean hasLeftChild = (nodeWithData.context[1] != null);
            if (hasRightChild && hasLeftChild) {
                // has 2 children
                Node<T> successorNode = this.findMinOfRightSubtree(nodeWithData);
                // replace value of node with value of successor node
                nodeWithData.data = successorNode.data;
                // remove successor node
                if (successorNode.context[2] == null) {
                    // successor has no children, replace with null
                    this.replaceNode(successorNode, null);
                } else {
                    // successor has a right child, replace successor with its child
                    this.replaceNode(successorNode, successorNode.context[2]);
                }
            } else if (hasRightChild) {
                // only right child, replace with right child
                this.replaceNode(nodeWithData, nodeWithData.context[2]);
            } else if (hasLeftChild) {
                // only left child, replace with left child
                this.replaceNode(nodeWithData, nodeWithData.context[1]);
            } else {
                // no children, replace node with a null node
                this.replaceNode(nodeWithData, null);
            }
            this.size--;
            return true;
        } 
    }

    /**
     * Checks whether the tree contains the value *data*.
     * @param data the data value to test for
     * @return true if *data* is in the tree, false if it is not in the tree
     */
    public boolean contains(T data) {
        // null references will not be stored within this tree
        if (data == null) {
            throw new NullPointerException("This RedBlackTree cannot store null references.");
        } else {
            Node<T> nodeWithData = this.findNodeWithData(data);
            // return false if the node is null, true otherwise
            return (nodeWithData != null);
        }
    }

    /**
     * Helper method that will replace a node with a replacement node. The replacement
     * node may be null to remove the node from the tree.
     * @param nodeToReplace the node to replace
     * @param replacementNode the replacement for the node (may be null)
     */
    protected void replaceNode(Node<T> nodeToReplace, Node<T> replacementNode) {
        if (nodeToReplace == null) {
            throw new NullPointerException("Cannot replace null node.");
        }
        if (nodeToReplace.context[0] == null) {
            // we are replacing the root
            if (replacementNode != null)
                replacementNode.context[0] = null;
            this.root = replacementNode;
        } else {
            // set the parent of the replacement node
            if (replacementNode != null)
                replacementNode.context[0] = nodeToReplace.context[0];
            // do we have to attach a new left or right child to our parent?
            if (nodeToReplace.isRightChild()) {
                nodeToReplace.context[0].context[2] = replacementNode;
            } else {
                nodeToReplace.context[0].context[1] = replacementNode;
            }
        }
    }

    /**
     * Helper method that will return the inorder successor of a node with two children.
     * @param node the node to find the successor for
     * @return the node that is the inorder successor of node
     */
    protected Node<T> findMinOfRightSubtree(Node<T> node) {
        if (node.context[1] == null && node.context[2] == null) {
            throw new IllegalArgumentException("Node must have two children");
        }
        // take a steop to the right
        Node<T> current = node.context[2];
        while (true) {
            // then go left as often as possible to find the successor
            if (current.context[1] == null) {
                // we found the successor
                return current;
            } else {
                current = current.context[1];
            }
        }
    }

    /**
     * Helper method that will return the node in the tree that contains a specific
     * value. Returns null if there is no node that contains the value.
     * @return the node that contains the data, or null of no such node exists
     */
    protected Node<T> findNodeWithData(T data) {
        Node<T> current = this.root;
        while (current != null) {
            int compare = data.compareTo(current.data);
            if (compare == 0) {
                // we found our value
                return current;
            } else if (compare < 0) {
                // keep looking in the left subtree
                current = current.context[1];
            } else {
                // keep looking in the right subtree
                current = current.context[2];
            }
        }
        // we're at a null node and did not find data, so it's not in the tree
        return null; 
    }

    /**
     * This method performs an inorder traversal of the tree. The string 
     * representations of each data value within this tree are assembled into a
     * comma separated string within brackets (similar to many implementations 
     * of java.util.Collection, like java.util.ArrayList, LinkedList, etc).
     * @return string containing the ordered values of this tree (in-order traversal)
     */
    public String toInOrderString() {
        // generate a string of all values of the tree in (ordered) in-order
        // traversal sequence
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        if (this.root != null) {
            Stack<Node<T>> nodeStack = new Stack<>();
            Node<T> current = this.root;
            while (!nodeStack.isEmpty() || current != null) {
                if (current == null) {
                    Node<T> popped = nodeStack.pop();
                    sb.append(popped.data.toString());
                    if(!nodeStack.isEmpty() || popped.context[2] != null) sb.append(", ");
                    current = popped.context[2];
                } else {
                    nodeStack.add(current);
                    current = current.context[1];
                }
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    /**
     * This method performs a level order traversal of the tree. The string
     * representations of each data value
     * within this tree are assembled into a comma separated string within
     * brackets (similar to many implementations of java.util.Collection).
     * This method will be helpful as a helper for the debugging and testing
     * of your rotation implementation.
     * @return string containing the values of this tree in level order
     */
    public String toLevelOrderString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[ ");
        if (this.root != null) {
            LinkedList<Node<T>> q = new LinkedList<>();
            q.add(this.root);
            while(!q.isEmpty()) {
                Node<T> next = q.removeFirst();
                if(next.context[1] != null) {
                    q.add(next.context[1]);
                    //System.out.println(next.context[1].blackHeight);
                }
                if(next.context[2] != null){
                    //System.out.println(next.context[2].blackHeight);
                     q.add(next.context[2]);
                    }
                sb.append(next.data.toString());
                if(!q.isEmpty()) sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public String toString() {
        return "level order: " + this.toLevelOrderString() +
                "\nin order: " + this.toInOrderString();
    }

    
    
    /**
     * Main method to run tests. Comment out the lines for each test
     * to run them.
     * @param args
     */
    public static void main(String[] args) {
      
    }

    
    
        /* 
    @BeforeEach
    public void createInstane() {
        
    }
    */
    
    /**
     * adding only one element and checking element
     * @return true if tests pasta
     */
    @Test
    public void testOneElement(){
        RedBlackTree<Integer> tester1 = new RedBlackTree<>();
        tester1.insert(19);
        //colour of the root should be black
        assertEquals(1, tester1.root.blackHeight);
        //inserting one more element and checking the colour of the root and the newly added element
        tester1.insert(11);
        assertEquals(0,tester1.findNodeWithData(11).blackHeight);
        assertEquals(1, tester1.root.blackHeight);


    }
    /**
     * parent and the aunty is red 
     * @return true if colour change right
     */
    @Test
    public void test2(){
        RedBlackTree<Integer> testing = new RedBlackTree<>();
        testing.insert(24);
        testing.insert(8);
        testing.insert(42);
        testing.insert(20);
        ///new node should be red
        assertEquals(testing.findNodeWithData(20).blackHeight,0);
        //3 of em should be black
        assertEquals(testing.findNodeWithData(8).blackHeight,1);
        assertEquals(testing.findNodeWithData(42).blackHeight,1);
        assertEquals(testing.findNodeWithData(24).blackHeight,1);
    }

    /**
     * checking colour change
     * @return true if order is corred
     */
    @Test
    public void test3(){
        RedBlackTree<Integer> testing = new RedBlackTree<>();
        testing.insert(22);
        testing.insert(6);
        testing.insert(39);
        testing.insert(36);

        String toLevString = testing.toLevelOrderString();
        //  23
        //7     41
        //     37
        //
        assertEquals(testing.toLevelOrderString(), toLevString);
        
    }
    
    /**
     *  
     * @return true if the tree is correct
     */
    @Test
    public void test4(){
        RedBlackTree<Integer> testing = new RedBlackTree<>();
        testing.insert(46);
        testing.insert(25);
        testing.insert(71);
        //forcing the tree to change colours and then testing 
        testing.findNodeWithData(71).blackHeight = 1;
        System.out.println(testing.toLevelOrderString());
        System.out.println(testing.findNodeWithData(46).blackHeight);
        System.out.println(testing.findNodeWithData(25).blackHeight);
        System.out.println(testing.findNodeWithData(71).blackHeight);
        //insertion
        testing.insert(17);
        String expecString = "[ 25, 17, 46, 71 ]";

        assertEquals(testing.toLevelOrderString(), expecString); //checking if the tree rotated properly 

    }
 


}