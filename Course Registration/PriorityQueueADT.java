//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Course Registration
// Course: CS 300 Fall 2022
//
// Author: Pushpit Singh
// Email: psingh76@wisc.edu
// Lecturer: Hobbes Legault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: NONE
// Partner Email: NONE
// Partner Lecturer's Name: NONE
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
////////////////////////////////////////////////////////////////////////////////


import java.util.NoSuchElementException;

/**
 * This interface models the priority queue abstract data type
 *
 * @param <T> type parameter bounded by the Comparable interface. Represents the type of elements
 *            stored in this priority queue.
 */
public interface PriorityQueueADT<T extends Comparable<T>> {
  /**
   * Checks if this priority queue is empty.
   *
   * @return true if this priority queue is empty and false otherwise.
   */
  public boolean isEmpty();

  /**
   * Returns the current size of this priority queue.
   *
   * @return the size of this priority queue
   */
  public int size();

  /**
   * Adds the given element to the priority queue
   *
   * @param element to be added to this queue
   * @throws NullPointerException  if element is null
   * @throws IllegalStateException with a descriptive error message if this priority queue is full
   */
  public void enqueue(T element) throws NullPointerException, IllegalStateException;

  /**
   * Returns and removes the element at the front (aka root position) of this queue (the element
   * having the highest priority).
   *
   * @return the removed element
   * @throws NoSuchElementException with a descriptive error message if this queue is empty
   */
  public T dequeue() throws NoSuchElementException;

  /**
   * Returns without removing the element at the front (aka root position) of this queue (the
   * element having the highest priority).
   *
   * @return the element with the highest priority in this queue
   * @throws NoSuchElementException with a descriptive error message if this queue is empty
   */
  public T peek() throws NoSuchElementException;
}
