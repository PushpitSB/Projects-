#Target to run tests
runTests: AETests.class
	java -jar junit5.jar -cp . --select-class=BackendDeveloperTests
AETests.class: GraphAE.class AETests.java 
	javac -cp .:junit5.jar AETests.java

GraphAE.class: compileInterfaces GraphAE.java
	javac GraphAE.java
compileInterfaces: BaseGraph.java GraphADT.java BackendInterface.java GraphAEInterface.java DistanceReaderInterface.java FrontendInterface.java
	javac BaseGraph.java
	javac GraphADT.java
	javac BackendInterface.java
	javac GraphAEInterface.java
	javac DistanceReaderInterface.java
	javac FrontendInterface.java


# clear out all compiled .class files and temporary~ files
clean:
	rm -f *.class
	rm -f *~
