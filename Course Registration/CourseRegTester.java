import java.util.NoSuchElementException;

//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P10 Course Registration
// Course: CS 300 Fall 2022
//
// Author: Pushpit Singh 
// Email: psingh76@wisc.edu
// Lecturer: Hobbs legault
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

/**
 * This class implements unit test methods to check the correctness of Course, CourseIterator,
 * CourseQueue and CourseReg classes in P10.
 * 
 * Be aware that all methods in this class will be run against not only your code, but also our own
 * working and broken implementations to verify that your tests are working appropriately!
 */
public class CourseRegTester {

  /**
   * START HERE, and continue with testCompareTo() after this.
   * 
   * This method must test the Course constructor, accessor, and mutator methods, as well as its
   * toString() implementation. The compareTo() method will get its own test.
   * 
   * @see Course
   * @return true if the Course implementation is correct; false otherwise
   */
  public static boolean testCourse() {
    try {

      try {
        Course first = new Course("", 100, 3, 100);
        System.out.println(
            "did not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course second = new Course(null, 10, 3, 100);
        System.out.println(
            "did not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course math = new Course("EH", 0, 4, 4);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course MATH = new Course("EH", -1, 3, 100);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course MATH = new Course("MH", 300, 0, 5);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course MATh = new Course("MTH", 100, -1, 100);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course MATH = new Course("MAH", 130, 6, 400);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        Course math = new Course("TH", 100, 3, -100);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      // valid constructors
      Course hoos = new Course("CS", 300, 1, 100);
      // test set professor
      hoos.setProfessor(null, -990);
      try {
        hoos.setProfessor("s", -10);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        hoos.setProfessor("s", 60);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      hoos.setProfessor("s", 2.59);
      try {
        hoos.setSeatsAvailable(-10);
        System.out.println(
            "id not throw IllegalArgumentException");
        return false;
      } catch (IllegalArgumentException e) {

      }
      hoos.setSeatsAvailable(0);

      Course y = new Course("ECON", 50, 4, 99);
      Course y0 = new Course("ECON", 50, 4, 99);
      Course y1 = new Course("ECO", 50, 4, 99);
      Course y2 = new Course("ECON", 100, 4, 99);
      Course y3 = new Course("ECON", 50, 5, 99);
      Course y4 = new Course("ECON", 50, 4, 102);

      // test accessors
      if (y.getNumCredits() != 4) {
        System.out.println("testCourse - accessor problem");
        return false;
      }
      if (y.equals(y1)) {
        System.out.println(
            "problem in equal method");
        return false;
      }
      if (y.equals(y2)) {
        System.out.println(
            "problem in equal (courseNumber)");
        return false;
      }
      if (y.equals(y3)) {
        System.out.println("different credits equals probelm");
        return false;
      }
      if (!y.equals(y0)) {
        System.out.println(
            "same course equals problem");
        return false;
      }
      y.setProfessor("s", 2.8);
      y.setSeatsAvailable(5678);
      y0.setProfessor("s", 2.8);
      y0.setSeatsAvailable(5678);
      Course y6 = new Course("ECON", 100, 3, 99);
      y6.setProfessor("a", 2.8);
      y6.setSeatsAvailable(5678);
      if (!y.equals(y0)) {
        System.out.println(
            "testCourse - equals false");
        return false;
      }
      if (y.equals(y6)) {
        System.out.println(
            "testCourse - equals error");
        return false;
      }
      // to string
      if (!hoos.toString().equals("CS 300 (closed) with s (2.59)")) {
        System.out
            .println("wrong tostring for class");
        return false;
      }
      if (!y.toString().equals("ECON 50 (5678 seats) with s (2.8)")) {
        System.out
            .println("toString error");
        return false;
      }
    } catch (Exception e) {
      System.out.println("unknown exception");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This method must test the Course compareTo() implementation. Be sure to test ALL FOUR levels of
   * the comparison here!
   * 
   * Once you complete this test, finish the Course implementation if you have not done so already,
   * then move to testCourseQueue() and testEnqueueDequeue().
   * 
   * @see Course#compareTo(Course)
   * @return true if the compareTo() implementation is correct; false otherwise
   */
  public static boolean testCompareTo() {
    try {
      Course alpine = new Course("CS", 234, 4, 1);
      alpine.setProfessor("Mouna", 4);
      alpine.setSeatsAvailable(5678);
      Course bet = new Course("Econ", 234, 4, 1);
      Course cat = new Course("CS", 234, 4, 1);
      Course del = new Course("CS", 234, 4, 1);
      del.setSeatsAvailable(5678);
      Course em = new Course("CS", 234, 4, 1);
      em.setSeatsAvailable(5678);
      em.setProfessor("moun", 3.8);
      Course fk = new Course("CS", 234, 4, 1);
      fk.setProfessor("Mouna", 0);
      Course gdp = new Course("CS", 234, 4, 1);
      Course hij = new Course("CS", 234, 4, 1);
      Course i = new Course("CS", 234, 4, 1);
      Course j = new Course("CS", 234, 4, 1);
      Course k = new Course("CS", 234, 4, 1);


      if (alpine.compareTo(bet) != 1) {
        System.out
            .println("testCompareTo -  problem");
        return false;
      }
      if (bet.compareTo(alpine) != -1) {
        System.out
            .println("testCompareTo -  problem -1");
        return false;
      }
      if (alpine.compareTo(cat) != 1) {
        System.out.println(
            "testCompareTo -  problem");
        return false;
      }
      if (cat.compareTo(alpine) != -1) {
        System.out.println(
            "testCompareTo -  problem");
        return false;
      }
      if (alpine.compareTo(del) != 1) {
        System.out.println(
            "testCompareTo -  problem");
        return false;
      }
      if (del.compareTo(alpine) != -1) {
        System.out.println(
            "testCompareTo -  problem");
        return false;
      }
      if (alpine.compareTo(em) != 1) {
        System.out.println(
            "testCompareTo -  problem");
        return false;
      }
      if (em.compareTo(alpine) != -1) {
        System.out.println(
            "testCompareTo -  problem -1");
        return false;
      }
      if (fk.equals(alpine) && fk.compareTo(alpine) != 0) {
        System.out.println("testCompareTo -  problem 0");
        return false;
      }
    } catch (Exception e) {
      System.out.println("testCompareTo -  problem");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This method must test the other methods in CourseQueue (isEmpty, size, peek). Verify normal
   * cases and error cases, as well as a filled and re-emptied queue.
   * 
   * Once you have completed this method, implement the required methods in CourseQueue and verify
   * that they work correctly.
   * 
   * @see CourseQueue
   * @return true if CourseQueue's other methods are implemented correctly; false otherwise
   */
  public static boolean testCourseQueue() {
    try {
      try {
        CourseQueue alpia = new CourseQueue(-1);
        System.out.println(
            "testCourseQueue - did not throw an exception");
        return false;
      } catch (IllegalArgumentException e) {

      }
      try {
        CourseQueue alpia = new CourseQueue(0);
        System.out.println(
            "did not throw an exception");
        return false;
      } catch (IllegalArgumentException e) {

      }
      CourseQueue aapia = new CourseQueue(100);
      if (!aapia.isEmpty()) {
        System.out.println(
            "no courses returned false");
        return false;
      }
      if (aapia.size() != 0) {
        System.out.println(
            " with no courses did not return 0");
        return false;
      }
      try {
        aapia.peek();
        System.out.println(
            " did not throw an exception");
        return false;
      } catch (NoSuchElementException e) {

      }

      Course alpia = new Course("CS", 10, 5, 1);
      alpia.setProfessor("Hobbes", 5);
      Course beta = new Course("CS", 10, 5, 1);
      beta.setProfessor("Hobbes", 0);


      aapia.enqueue(alpia);
      if (aapia.isEmpty()) {
        System.out.println(
            "testCourseQueue ");
        return false;
      }
      if (aapia.size() != 1) {
        System.out.println(
            " did not return 1");
        return false;
      }
      if (!aapia.peek().equals(alpia)) {
        System.out.println(
            "not return the right Course");
        return false;
      }
      aapia.enqueue(beta);
      if (aapia.isEmpty()) {
        System.out.println(
            "th two courses returned true");
        return false;
      }
      if (aapia.size() != 2) {
        System.out.println(
            " two courses did not return 2");
        return false;
      }
      if (!aapia.peek().equals(alpia)) {
        System.out.println(
            " did not return the right Course");
        return false;
      }
      aapia.dequeue();
      if (aapia.isEmpty()) {
        System.out.println(
            "CourseQueue with one courses returned true");
        return false;
      }
      if (aapia.size() != 1) {
        System.out.println(
            "tth one courses did not return 1");
        return false;
      }
      if (!aapia.peek().equals(beta)) {
        System.out.println(
            "full CourseQueue did not return the right Course");
        return false;
      }
      aapia.dequeue();
      if (!aapia.isEmpty()) {
        System.out.println(
            " no courses returned false");
        return false;
      }
      if (aapia.size() != 0) {
        System.out.println(
            " did not return 0");
        return false;
      }
      try {
        aapia.peek();
        System.out.println(
            "CourseQueue did not throw an exception");
        return false;
      } catch (NoSuchElementException e) {

      }
      
      
      CourseQueue c = new CourseQueue(5);
      Course c1 = new Course("CS", 200, 3, 10);
      Course c2 = new Course("CS", 200, 3, 10);
      c.enqueue(c1);
      c.enqueue(c2);
      CourseQueue checkCopy = c.deepCopy();
      if (!c.peek().equals(checkCopy.peek())) {
        System.out.println("me peek value as original");
        return false;
      }
      
      
    } catch (Exception e) {
      System.out.println("some other exception");
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * This method must test the enqueue and dequeue methods in CourseQueue. Verify normal cases and
   * error cases, as well as filling and emptying the queue.
   * 
   * You may also test the percolate methods directly, though this is not required.
   * 
   * Once you have completed this method, implement the enqueue/dequeue and percolate methods in
   * CourseQueue and verify that they work correctly, then move on to testCourseIterator().
   * 
   * @see CourseQueue#enqueue(Course)
   * @see CourseQueue#dequeue()
   * @return true if the CourseQueue enqueue/dequeue implementations are correct; false otherwise
   */
  public static boolean testEnqueueDequeue() {
    try {
      Course alia = new Course("CS", 100, 1, 1);// major, seats, prof, high rating
      alia.setProfessor("Mouna", 5);
      Course ber = new Course("CS", 100, 1, 1);// major, seats, prof, low rating
      ber.setProfessor("Mouna", 0);
      Course cod = new Course("CS", 100, 1, 1);// major, seats, no prof
      Course doc = new Course("CS", 100, 1, 0);// major, no seats, prof, high rating
      doc.setProfessor("Mouna", 5);
      Course efg = new Course("CS", 100, 1, 0);// major, no seats, prof, low rating
      efg.setProfessor("Mouna", 5);
      Course fgh = new Course("CS", 100, 1, 0);// major, no seats, no prof

      Course ghi = new Course("Math", 100, 1, 1);// non major, seats, prof, high rating
      ghi.setProfessor("Mouna", 5);
      Course hij = new Course("Math", 100, 1, 1);// non major, seats, prof, low rating
      hij.setProfessor("Mouna", 0);
      Course ijk = new Course("Math", 100, 1, 1);// non major, seats, no prof
      Course jkl = new Course("Math", 100, 1, 0);// non major, no seats, prof, high rating
      jkl.setProfessor("Mouna", 5);
      Course klm = new Course("Math", 100, 1, 0);// non major, no seats, prof, low rating
      klm.setProfessor("Mouna", 0);
      Course lmn = new Course("Math", 100, 1, 0);// non major, no seats, no prof



      // testing enqueue/dequeue error cases
      CourseQueue zab = new CourseQueue(2);
      try {
        zab.dequeue();
        System.out.println(
            "did not throw an exception");
        return false;
      } catch (NoSuchElementException e1) {

      }
      Course nul = null;
      try {
        zab.enqueue(nul);
        System.out
            .println("did not throw an exception");
        return false;
      } catch (NullPointerException e1) {

      }
      zab.enqueue(alia);
      zab.enqueue(alia);
      try {
        zab.enqueue(alia);
        System.out.println(
            "tion");
        return false;
      } catch (IllegalStateException e1) {

      }

      // enqueueing in reverse priority order, every iteration should swap
      CourseQueue qReverse = new CourseQueue(100);
      qReverse.enqueue(lmn);
      if (!qReverse.peek().equals(lmn)) {
        System.out.println("tt at the top");
        return false;
      }
      qReverse.enqueue(klm);
      if (!qReverse.peek().equals(klm)) {
        System.out.println("tesse (k) is not at the top");
        return false;
      }
      qReverse.enqueue(jkl);
      if (!qReverse.peek().equals(jkl)) {
        System.out.println("testEn(j) is not at the top");
        return false;
      }
      qReverse.enqueue(ijk);
      if (!qReverse.peek().equals(ijk)) {
        System.out.println("te is not at the top");
        return false;
      }
      qReverse.enqueue(hij);
      if (!qReverse.peek().equals(hij)) {
        System.out.println("testy course he top");
        return false;
      }
      qReverse.enqueue(ghi);
      if (!qReverse.peek().equals(ghi)) {
        System.out.println("testrse (g) is not at the top");
        return false;
      }
      qReverse.enqueue(fgh);
      if (!qReverse.peek().equals(fgh)) {
        System.out.println("tests not at the top");
        return false;
      }
      qReverse.enqueue(efg);
      if (!qReverse.peek().equals(efg)) {
        System.out.println("t is not at the top");
        return false;
      }
      qReverse.enqueue(doc);
      if (!qReverse.peek().equals(doc)) {
        System.out.println("teot at the top");
        return false;
      }
      qReverse.enqueue(cod);
      if (!qReverse.peek().equals(cod)) {
        System.out.println("tesst at the top");
        return false;
      }
      qReverse.enqueue(ber);
      if (!qReverse.peek().equals(ber)) {
        System.out.println("tests not at the top");
        return false;
      }
      qReverse.enqueue(alia);
      if (!qReverse.peek().equals(alia)) {
        System.out.println("testEn) top");
        return false;
      }

      // time to dequeue
      if (!qReverse.dequeue().equals(alia)) {
        System.out.println("teseturned");
        return false;
      }
      if (!qReverse.peek().equals(ber)) {
        System.out.println(
            "twas not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(ber)) {
        System.out.println("tesot returned");
        return false;
      }
      if (!qReverse.peek().equals(cod)) {
        System.out.println(
            "tese (b) was not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(cod)) {
        System.out.println("testEwas not returned");
        return false;
      }
      if (!qReverse.peek().equals(doc)) {
        System.out.println(
            "testnce (b) was not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(doc)) {
        System.out.println("testE) was not returned");
        return false;
      }
      if (!qReverse.peek().equals(efg)) {
        System.out.println(
            "testEnqueueueing once (b) was not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(efg)) {
        System.out.println("testEnqu (a) was not returned");
        return false;
      }
      if (!qReverse.peek().equals(fgh)) {
        System.out.println(
            "testEns not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(fgh)) {
        System.out.println("testEnqueot returned");
        return false;
      }
      if (!qReverse.peek().equals(ghi)) {
        System.out.println(
            " (b) was not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(ghi)) {
        System.out.println("testEnquas not returned");
        return false;
      }
      if (!qReverse.peek().equals(hij)) {
        System.out.println(
            "tesb) was not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(hij)) {
        System.out.println(" not returned");
        return false;
      }
      if (!qReverse.peek().equals(ijk)) {
        System.out.println(
            "testEnqueueDes not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(ijk)) {
        System.out.println("testEnqueu was not returned");
        return false;
      }
      if (!qReverse.peek().equals(jkl)) {
        System.out.println(
            "testEnq(b) was not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(jkl)) {
        System.out.println("testEnqnot returned");
        return false;
      }
      if (!qReverse.peek().equals(klm)) {
        System.out.println(
            "testEnqueueDequeue -s not correct");
        return false;
      }
      if (!qReverse.dequeue().equals(klm)) {
        System.out.println("testEnque was not returned");
        return false;
      }
      if (!qReverse.peek().equals(lmn)) {
        System.out.println(
            "teorrect");
        return false;
      }
      if (!qReverse.dequeue().equals(lmn)) {
        System.out.println("testEnqua) was not returned");
        return false;
      }
      try {
        qReverse.peek();
        System.out.println(
            "testEnue did not throw an exception");
        return false;
      } catch (NoSuchElementException e1) {

      }

      // enququing in priority order = no swaps needed
      CourseQueue qInOrder = new CourseQueue(100);
      qInOrder.enqueue(alia);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnquis not at the top");
        return false;
      }
      qInOrder.enqueue(ber);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqueueDequeunot at the top");
        return false;
      }
      qInOrder.enqueue(cod);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqueueD top");
        return false;
      }
      qInOrder.enqueue(doc);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testE) is not at the top");
        return false;
      }
      qInOrder.enqueue(efg);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testt at the top");
        return false;
      }
      qInOrder.enqueue(fgh);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqueuhe top");
        return false;
      }
      qInOrder.enqueue(ghi);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqse (a) is not at the top");
        return false;
      }
      qInOrder.enqueue(hij);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEhe top");
        return false;
      }
      qInOrder.enqueue(ijk);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnquenot at the top");
        return false;
      }
      qInOrder.enqueue(jkl);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqu (a) is not at the top");
        return false;
      }
      qInOrder.enqueue(klm);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqot at the top");
        return false;
      }
      qInOrder.enqueue(lmn);
      if (!qInOrder.peek().equals(alia)) {
        System.out.println("testEnqueat the top");
        return false;
      }

      // time to dequeue
      if (!qInOrder.dequeue().equals(alia)) {
        System.out.println("testEnqot returned");
        return false;
      }
      if (!qInOrder.peek().equals(ber)) {
        System.out.println(
            "testEnqueueDequeue -(b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(ber)) {
        System.out.println("tested");
        return false;
      }
      if (!qInOrder.peek().equals(cod)) {
        System.out.println(
            "testEnquce (b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(cod)) {
        System.out.println("t returned");
        return false;
      }
      if (!qInOrder.peek().equals(doc)) {
        System.out.println(
            "testEce (b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(doc)) {
        System.out.println("testEn not returned");
        return false;
      }
      if (!qInOrder.peek().equals(efg)) {
        System.out.println(
            "testEnquence (b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(efg)) {
        System.out.println("testEnqueue(a) was not returned");
        return false;
      }
      if (!qInOrder.peek().equals(fgh)) {
        System.out.println(
            "testEnqueu was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(fgh)) {
        System.out.println("testEn) was not returned");
        return false;
      }
      if (!qInOrder.peek().equals(ghi)) {
        System.out.println(
            "testEnqueueDequeu(b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(ghi)) {
        System.out.println("testEnqueueDnot returned");
        return false;
      }
      if (!qInOrder.peek().equals(hij)) {
        System.out.println(
            "testEnqueueDeque (b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(hij)) {
        System.out.println("testEnque(a) was not returned");
        return false;
      }
      if (!qInOrder.peek().equals(ijk)) {
        System.out.println(
            "testEnqueueDequence (b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(ijk)) {
        System.out.println("testEnqueu(a) was not returned");
        return false;
      }
      if (!qInOrder.peek().equals(jkl)) {
        System.out.println(
            "testEnq(b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(jkl)) {
        System.out.println("testEns not returned");
        return false;
      }
      if (!qInOrder.peek().equals(klm)) {
        System.out.println(
            "testEnqcorrect");
        return false;
      }
      if (!qInOrder.dequeue().equals(klm)) {
        System.out.println("testEnqueuee (a) was not returned");
        return false;
      }
      if (!qInOrder.peek().equals(lmn)) {
        System.out.println(
            "testEnqueueD (b) was not correct");
        return false;
      }
      if (!qInOrder.dequeue().equals(lmn)) {
        System.out.println("testE(a) was not returned");
        return false;
      }
      try {
        qInOrder.peek();
        System.out.println(
            "testEnqurow an exception");
        return false;
      } catch (NoSuchElementException e1) {

      }


      // enququing in random order
      CourseQueue qRandom = new CourseQueue(100);
      qRandom.enqueue(ghi);
      if (!qRandom.peek().equals(ghi)) {
        System.out.println("testEnqs not at the top");
        return false;
      }
      qRandom.enqueue(fgh);
      if (!qRandom.peek().equals(fgh)) {
        System.out.println("testEnqueu is not at the top");
        return false;
      }
      qRandom.enqueue(hij);
      if (!qRandom.peek().equals(fgh)) {
        System.out.println("testE is not at the top");
        return false;
      }
      qRandom.enqueue(efg);
      if (!qRandom.peek().equals(efg)) {
        System.out.println("testEnqy course (e) is not at the top");
        return false;
      }
      qRandom.enqueue(ijk);
      if (!qRandom.peek().equals(efg)) {
        System.out.println("tes) is not at the top");
        return false;
      }
      qRandom.enqueue(doc);
      if (!qRandom.peek().equals(doc)) {
        System.out.println("testEnrse (d) is not at the top");
        return false;
      }
      qRandom.enqueue(jkl);
      if (!qRandom.peek().equals(doc)) {
        System.out.println("testEnqueueDequ(d) is not at the top");
        return false;
      }
      qRandom.enqueue(cod);
      if (!qRandom.peek().equals(cod)) {
        System.out.println("tes at the top");
        return false;
      }
      qRandom.enqueue(klm);
      if (!qRandom.peek().equals(cod)) {
        System.out.println("testEnqueueDequ is not at the top");
        return false;
      }
      qRandom.enqueue(ber);
      if (!qRandom.peek().equals(ber)) {
        System.out.println("testEnq) is not at the top");
        return false;
      }
      qRandom.enqueue(lmn);
      if (!qRandom.peek().equals(ber)) {
        System.out.println("testEnqueueDequeis not at the top");
        return false;
      }
      qRandom.enqueue(alia);
      if (!qRandom.peek().equals(alia)) {
        System.out.println("testEnqus not at the top");
        return false;
      }

      // time to dequeue
      if (!qRandom.dequeue().equals(alia)) {
        System.out.println("testEnq not returned");
        return false;
      }
      if (!qRandom.peek().equals(ber)) {
        System.out.println(
            "testEnqueueDequeue - was not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(ber)) {
        System.out.println("tevalue (a) was not returned");
        return false;
      }
      if (!qRandom.peek().equals(cod)) {
        System.out.println(
            "testEnqus not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(cod)) {
        System.out.println("testEnqueueDequeue - dt returned");
        return false;
      }
      if (!qRandom.peek().equals(doc)) {
        System.out.println(
            "testEnqueueDeqce (b) was not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(doc)) {
        System.out.println("testEnqueualue (a) was not returned");
        return false;
      }
      if (!qRandom.peek().equals(efg)) {
        System.out.println(
            "testEnq once (b) was not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(efg)) {
        System.out.println("testEnqueueDequnot returned");
        return false;
      }
      if (!qRandom.peek().equals(fgh)) {
        System.out.println(
            "testE not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(fgh)) {
        System.out.println("tesrned");
        return false;
      }
      if (!qRandom.peek().equals(ghi)) {
        System.out.println(
            "testEn(b) was not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(ghi)) {
        System.out.println("tes not returned");
        return false;
      }
      if (!qRandom.peek().equals(hij)) {
        System.out.println(
            "testEnqueg once (b) was not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(hij)) {
        System.out.println("testEnqueueDequrned");
        return false;
      }
      if (!qRandom.peek().equals(ijk)) {
        System.out.println(
            "testEnqueuot correct");
        return false;
      }
      if (!qRandom.dequeue().equals(ijk)) {
        System.out.println("testEnquenot returned");
        return false;
      }
      if (!qRandom.peek().equals(jkl)) {
        System.out.println(
            "testEnqot correct");
        return false;
      }
      if (!qRandom.dequeue().equals(jkl)) {
        System.out.println("testEnquenot returned");
        return false;
      }
      if (!qRandom.peek().equals(klm)) {
        System.out.println(
            "testEnqueuwas not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(klm)) {
        System.out.println("testalue (a) was not returned");
        return false;
      }
      if (!qRandom.peek().equals(lmn)) {
        System.out.println(
            "testEnqueuing once (b) was not correct");
        return false;
      }
      if (!qRandom.dequeue().equals(lmn)) {
        System.out.println("testEnqueuue (a) was not returned");
        return false;
      }
      try {
        qRandom.peek();
        System.out.println(
            "testEnqueuenot throw an exception");
        return false;
      } catch (NoSuchElementException e1) {

      }



    } catch (Exception e) {
      System.out.println("testexception");
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * This method must test the CourseIterator class. The CourseIterator iterates through a deep copy
   * of a CourseQueue in decreasing order of priority, returning each Course object in turn.
   * 
   * Once you have completed this method, implement the CourseIterator class and make CourseQueue
   * into an Iterable class. Verify that this works correctly, and then move on to the final test
   * method: testCourseReg().
   * 
   * @see CourseIterator
   * @return true if the CourseIterator implementation is correct; false otherwise
   */
  public static boolean testCourseIterator() {
    try {
      Course abc = new Course("CS", 1, 1, 1);// major, seats, prof, high rating
      abc.setProfessor("Mouna", 5);
      Course bcd = new Course("CS", 1, 1, 1);// major, seats, prof, low rating
      bcd.setProfessor("Mouna", 0);
      Course cde = new Course("CS", 1, 1, 1);// major, seats, no prof
      Course def = new Course("CS", 1, 1, 0);// major, no seats, prof, high rating
      def.setProfessor("Mouna", 5);
      Course efg = new Course("CS", 1, 1, 0);// major, no seats, prof, low rating
      efg.setProfessor("Mouna", 5);
      Course fgh = new Course("CS", 1, 1, 0);// major, no seats, no prof

      Course ghi = new Course("Econ", 1, 1, 1);// non major, seats, prof, high rating
      ghi.setProfessor("Mouna", 5);
      Course hij = new Course("Econ", 1, 1, 1);// non major, seats, prof, low rating
      hij.setProfessor("Mouna", 0);
      Course ijk = new Course("Econ", 1, 1, 1);// non major, seats, no prof
      Course jkl = new Course("Econ", 1, 1, 0);// non major, no seats, prof, high rating
      jkl.setProfessor("Mouna", 5);
      Course klm = new Course("Econ", 1, 1, 0);// non major, no seats, prof, low rating
      klm.setProfessor("Mouna", 0);
      Course lmn = new Course("Econ", 1, 1, 0);// non major, no seats, no prof

      CourseQueue queue1 = new CourseQueue(100);
      queue1.enqueue(abc);
      queue1.enqueue(bcd);
      queue1.enqueue(cde);
      queue1.enqueue(def);
      queue1.enqueue(efg);
      queue1.enqueue(fgh);
      queue1.enqueue(ghi);
      queue1.enqueue(hij);
      queue1.enqueue(ijk);
      queue1.enqueue(jkl);
      queue1.enqueue(klm);
      queue1.enqueue(lmn);
      CourseIterator c_it = new CourseIterator(queue1);
      if (!c_it.hasNext()) {
        System.out.println("testCourseIterator - haste still remain");
        return false;
      }
      if (!c_it.next().equals(abc)) {
        System.out.println("testCurse");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCoen element to iterate still remain");
        return false;
      }
      if (!c_it.next().equals(bcd)) {
        System.out.println("testCourseItera the correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCoursein");
        return false;
      }
      if (!c_it.next().equals(cde)) {
        System.out.println("testCoursthe correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCourseo iterate still remain");
        return false;
      }
      if (!c_it.next().equals(def)) {
        System.out.println("testCo correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCour element to iterate still remain");
        return false;
      }
      if (!c_it.next().equals(efg)) {
        System.out.println("testCours Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCo to iterate still remain");
        return false;
      }
      if (!c_it.next().equals(fgh)) {
        System.out.println("testCourseIterator - nexe");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCo iterate still remain");
        return false;
      }
      if (!c_it.next().equals(ghi)) {
        System.out.println("testCourcorrect Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCourrate still remain");
        return false;
      }
      if (!c_it.next().equals(hij)) {
        System.out.println("testCourn the correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("tesement to iterate still remain");
        return false;
      }
      if (!c_it.next().equals(ijk)) {
        System.out.println("testCourseIte correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCiterate still remain");
        return false;
      }
      if (!c_it.next().equals(jkl)) {
        System.out.println("testCe correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCourset to iterate still remain");
        return false;
      }
      if (!c_it.next().equals(klm)) {
        System.out.println("testCourseIt correct Course");
        return false;
      }
      if (!c_it.hasNext()) {
        System.out.println("testCourseIterant to iterate still remain");
        return false;
      }
      if (!c_it.next().equals(lmn)) {
        System.out.println("testCour return the correct Course");
        return false;
      }
      if (c_it.hasNext()) {
        System.out.println("testCourseIo more elements to iterate");
        return false;
      }
      try {
        c_it.next();
        System.out.println("testCourseIters to call did not throw exception");
        return false;
      } catch (NoSuchElementException e1) {
        
      }
      
      
      
    } catch (Exception e) {
      System.out.println("testCouother exception");
      e.printStackTrace();
      return false;
    }
    

    return true;
  }

  /**
   * This method must test the constructor and three methods of the CourseReg class (setCreditLoad,
   * add, and getRecommendedCourses). Verify normal cases and error cases.
   * 
   * Once you have completed this method, implement CourseReg and verify that it works correctly.
   * Then you're DONE! Save and submit to gradescope, and enjoy being DONE with programming
   * assignments in CS 300 !!!
   * 
   * @see CourseReg
   * @return true if CourseReg has been implemented correctly; false otherwise
   */
  public static boolean testCourseReg() {
    try {
      try {
        CourseReg abc = new CourseReg(0, 3);
        System.out.println("testCourseRegdid not throw an error");
        return false;
      } catch (IllegalArgumentException e) {
        
      }
      try {
        CourseReg abc = new CourseReg(-10, 3);
        System.out.println("testCoursve capacity did not throw an error");
        return false;
      } catch (IllegalArgumentException e) {
        
      }
      try {
        CourseReg abc = new CourseReg(10, 0);
        System.out.println("testCourseReg -ad did not throw an error");
        return false;
      } catch (IllegalArgumentException e) {
        
      }
      try {
        CourseReg abc = new CourseReg(100, -1);
        System.out.println("testCourseeditload did not throw an error");
        return false;
      } catch (IllegalArgumentException e) {
        
      }
      
      CourseReg a = new CourseReg(4, 1);
      
      try {
        a.setCreditLoad(0);
        System.out.println("testCourseReow an error");
        return false;
      } catch (IllegalArgumentException e) {
        
      }
      try {
        a.setCreditLoad(-1);
        System.out.println("testCourseRegot throw an error");
        return false;
      } catch (IllegalArgumentException e) {
        
      }
      
      a.setCreditLoad(7);
      
      Course bcd = new Course("CS", 100, 4, 1);
      Course cde = new Course("Math", 101, 1, 0);
      Course def = new Course("CS", 200, 3, 1);
      Course efg = new Course("CS", 300, 1, 0);
      Course fgh = new Course("CS", 300, 1, 0);
      Course ghi = new Course("CS", 300, 1, 0);
      try{
      if (!a.add(bcd)) {
        System.out.println("testCourseReg - add course to non full queue returned false");
        return false;
      }
      if (!a.add(cde)) {
        System.out.println("testCourseReg - add course to non full queue returned false");
        return false;
      }
      if (!a.add(def)) {
        System.out.println("testCourseReg - add course to non full queue returned false");
        return false;
      }
      if (!a.add(efg)) {
        System.out.println("testCourseReg - add course to full queue returned true");
        return false;
      }}
      catch(Exception e){
        return false;
      }
      
      
     CourseReg aa = new CourseReg(3, 4);
     //an open CS course worth 3 credits, a closed CS course worth 3 credits, and a non-CS course worth 1 credit
     Course x = new Course("CS", 100, 3, 1);
     Course y = new Course("CS", 200, 3, 0);
     Course z = new Course("Math", 100, 1, 1);

      try{
      aa.add(z);
      aa.add(y);
      aa.add(x);}
      catch(Exception e){
        return false;
      }
//      System.out.println("\n");
//      System.out.println("case1\n" + a.getRecommendedCourses());
//      System.out.println("case2\n" + aa.getRecommendedCourses());
      
      if (!a.getRecommendedCourses().trim().equals("CS 100 (1 seats)\nCS 200 (1 seats)")) {
        System.out.println("testCourseReg case 1 - getRecommendedCourses printed incorrect courses");
        return false;
      }
      if (!aa.getRecommendedCourses().trim().equals("CS 100 (1 seats)")) {
        System.out.println("testCourseReg case 2- getRecommendedCourses printed incorrect courses");
        return false;
      }
    } catch (Exception e) {
      System.out.println("testCourseReg - methods threw some other exception");
      e.printStackTrace();
      return false;
    }
    
    return true;
  }

  /**
   * This method calls all test methods defined by us; you may add additional methods to this if you
   * like. All test methods must be public static boolean.
   * 
   * @return true if all tests in this class return true; false otherwise
   */
  public static boolean runAllTests() {
    boolean testVal = true;

    // test Course
    System.out.print("testCourse(): ");
    if (!testCourse()) {
      System.out.println("FAIL");
      testVal = false;
    } else {
      System.out.println("pass");
    }

    // test compareTo
    System.out.print("testCompareTo(): ");
    if (!testCompareTo()) {
      System.out.println("FAIL");
      testVal = false;
    } else {
      System.out.println("pass");
    }

    // test CourseIterator
    System.out.print("testCourseIterator(): ");
    if (!testCourseIterator()) {
      System.out.println("FAIL");
      testVal = false;
    } else {
      System.out.println("pass");
    }

    // test CourseQueue enqueue/dequeue
    System.out.print("testEnqueueDequeue(): ");
    if (!testEnqueueDequeue()) {
      System.out.println("FAIL");
      testVal = false;
    } else {
      System.out.println("pass");
    }

    // test CourseQueue
    System.out.print("testCourseQueue(): ");
    if (!testCourseQueue()) {
      System.out.println("FAIL");
      testVal = false;
    } else {
      System.out.println("pass");
    }

    // test CourseReg
    System.out.print("testCourseReg(): ");
    if (!testCourseReg()) {
      System.out.println("FAIL");
      testVal = false;
    } else {
      System.out.println("pass");
    }

    return testVal;
  }

  /**
   * Calls runAllTests() so you can verify your program
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
    runAllTests();
  }
}
