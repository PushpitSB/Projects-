P04 Exceptional Vending Machine

In this assignment, we implemented an expanded version of the p01 Vending Machine
program. This new version involves the use of instantiable classes and exception handling.
The version of the p01 vending machine program used procedural programming (the vending
machine represented by an oversize array was passed as input to all the static methods). Also,
you might have noticed that the p01 program was not robust. The program crashes in the case
of bad input passed to some methods (for instance an item expiration date not parsable to
an integer). We’ll try to cope with these limitations in this new version of our program. The
following new features will be added to the vending machine program.

• Throwing exceptions to report bugs or misuse of methods or operations.

• Loading a set of new items to the vending machine from a file.


• Saving the summary of the vending machine in a file.

• Develop unit tests to check the correctness of the implementation of the different operations
  supported by our exceptional vending machine.
