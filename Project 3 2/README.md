Group CU Project Three Proposal

GROUP: CU
TA NAME: Rahul
FLIPGRID: https://flip.com/f39e5f30
TA EMAIL: rahul.choudhary@wisc.edu



Name
Email
Team
P1 Role
P2 Role
P3 Role
Skanda Vyas Srinivasan
svsrinivasa2@wisc.edu
Red
BD
DW
FD
Yashman Singh
ypsingh@wisc.edu
Red
FD
AE
BD
Samir Simha
ssimha2@wisc.edu
Red
FD
BD
AE
Zain Siddiqui
zsiddiqui6@wisc.edu
Red
BD
FD
DW
Colin Shaw
cjshaw3@wisc.edu
Blue
BD
DW
FD
Chaitanya Sharma
csharma4@wisc.edu
Blue
FD
AE
BD
Pushpit Singh
psingh76@wisc.edu
Blue
FD
BD
AE
Aditi Shah
aashah25@wisc.edu
Blue
BD
FD
DW



Brief Project Description:
This project implements Dijkstra’s algorithm for cities in Turkey to provide the shortest distance between two cities by road. The aim is to create a simplified version of a Maps software that helps users (potential travelers) plan movement by road. 
Representative Tasks Performed Using this Application:
The DW will record a video showing that the graphviz(gv/dot) file can be successfully parsed to create a graph with correct weights. This will be determined by finding out how many cities and roads are in the the graph, and getting certain origin (Adana) and destination (Kayseri) cities using the getter methods, checking if there is a road between the two cities, and then getting the distance in km (332) using its getter method.  (demo by DataWrangler)
The AE will create a video showing how the path between two cities change depending on clearance height. Load the data and then check the path and cost between “Trabzon” and “Batman” at clearances 220, 201, 180 and show/explain why the path/cost is different (demo by <Algorithm Engineer>)
The BD will create a video showing how cities can be removed. Load the data and then check for the city “Sivas“. Check the path and cost between “Kayseri” and “Giresun” at clearances 300. Then remove Sivas and check for the city “Sivas“. Check the path and cost between “Kayseri” and “Giresun” at clearances 300, and show /explain why the path/cost is different (demo by <Backend Developer>)
The FD will make a video showing that the program regonizes there are no paths between two cities. Check the path between “Bayburt” and “Sinop” at clearance 170. Then again at clearance 160. Then remove “Ordu”. Check again for a path at clearance 170. Explain why there is no path now. (demo by <Frontend Developer>)


Data Wrangler (DW) Role: Zain Siddiqui, Aditi Shah
<brief description of this role’s primary responsibilities for this project>
The DW will help application data load and will generate the graphviz file for the distance between Turkish cities. 
Data Description:
<brief description of the data being loaded by this project… be sure to include the format of this 
data, important fields used by this project, and the source of this data>
The data being loaded in creates a very rudimentary version of Maps to connect major Turkish cities via their shortest roads. The data is loaded as a directed graph, in graphviz(dot/gv) format. Each node represents a city and edge weights from each node represent the direct distance (km) by road to another node (city). The following datasheet is being referred to: https://www.kaggle.com/datasets/ahmetomer/turkey-city-distances. Note that this data set is in csv format, so the DataWranger is going to convert this dataset to a gv format.
Development Responsibilities:
<list this role’s development responsibilities and how they relate to the contributions of other developers… include the names of the java classes that they are responsible for developing, and be sure to list java interfaces for these classes>

public interface RoadInterface {

  // returns origin city
  public String getOriginCity();

  // returns destination city
  public String getDestinationCity();
  
  // returns origin to destination distance in km
  public int getDistance();

  // returns the maximum clearance needed to travel on this road
  public int getClearance();
}

—---------------------------------------------------------------------
/**
* Interface to read from a gv file and create the graph
**/
public interface DistanceReaderInterface {

  // Loads the graph from the file and returns the list of roads
  public List<RoadInterface> loadRoads(String filename) throws FileNotFoundException;

  // Loads the graph from the file and returns the list of cities
  public List <String> loadCities(String filename) throws  FileNotFoundException;
}

Presentation Responsibilities:
<describe this role’s presentation responsibilities for this project>
The DW will record a video showing that the graphviz(gv/dot) file can be successfully parsed to create a graph with correct weights. This will be determined by finding out how many cities and roads are in the the graph, and getting certain origin (Adana) and destination (Kayseri) cities using the getter methods, checking if there is a road between the two cities, and then getting the distance in km (332) using its getter method.  (demo by DataWrangler)


Algorithm Engineer (AE) Role: Samir Simha, Pushpit Singh
<brief description of this role’s primary responsibilities for this project>
Capabilities Added to Required Data Structure:
The Algorithm Engineer needs to implement the Dijkstra’s algorithm which implements the interfaces of the Data Wrangler and the Backend Engineer. 
Development Responsibilities: 
Implement the Djikstra algorithm 
Add and remove the nodes
Add and remove the edge
Check if the tree contains the node
Returns the number of nodes
Returns the number of edges
Presentation Responsibilities:The AE will create a video showing how the path between two cities change depending on clearance height. Load the data and then check the path and cost between “Trabzon” and “Batman” at clearances 220, 201, 180 and show/explain why the path/cost is different
import java.util.List;
import java.util.NoSuchElementException;
/**
* This ADT represents a directed graph data structure with only positive edge
* weights.  Duplicate node values are not allowed.
*
* @param City is the City stored at each graph node
* @param EdgeType is the numeric data type stored at each graph edge, with a
*                 doubleValue() method and is the distance between two cities that always returns a value >=0.0
*/
public interface GraphAEInterface<NodeType,EdgeType extends Number> extends GraphADT<NodeType,EdgeType>{
  
   /**
    * Insert a new node into the graph.
    *
    * @param city is the data item stored in the new node
    * @return true if the data is unique and can be inserted into a new node,
    *         or false if this data is already in the graph
    * @throws NullPointerException if data is null
    */
    @Override
   public boolean insertNode(NodeType data);
   
   /**
    * Remove a node from the graph.
    * And also remove all edges adjacent to that node.
    *
    * @param data is the data item stored in the node to be removed
    * @return true if a vertex with data is found and removed, or
    *         false if that data value is not found in the graph
    * @throws NullPointerException if data is null
    */
   public boolean removeNode(NodeType data);
 /**
    * Check whether the graph contains a node with the provided data.
    *
    * @param data the node contents to check for
    * @return true if data item is stored in a node within the graph, or
              false otherwise
    */
    public boolean containsNode(NodeType data);
  
    /**
     * Return the number of nodes in the graph
     *
     * @return the number of nodes in the graph
     */
    public int getNodeCount();
    /**
     * Insert a new directed edge with positive edges weight into the graph.
     * Or if an edge between pred and succ already exists, update the data
     * stored in hat edge to be weight.
     *
     * @param pred is the data item contained in the new edge's predecesor node
     * @param succ is the data item contained in the new edge's successor node
     * @param weight is the non-negative data item stored in the new edge
     * @return true if the edge could be inserted or updated, or
     *         false if the pred or succ data are not found in any graph nodes
     */
    public boolean insertEdge(NodeType pred, NodeType succ, EdgeType weight);
   
    /**
     * Remove an edge from the graph.
     *
    * @param pred the data item contained in the source node for the edge
    * @param succ the data item contained in the target node for the edge
    * @return true if the edge could be removed, or
    *         false if such an edge is not found in the graph
    */
    public boolean removeEdge(NodeType pred,NodeType succ);
  
    /**
     * Check if edge is in the graph.
     *
     * @param pred the data item contained in the source node for the edge
     *     * @param succ the data item contained in the target node for the edge
    * @return true if the edge is found in the graph, or false other
    */
   public boolean containsEdge(NodeType pred, NodeType succ);
  
   /**
    * Return the data associated with a specific edge.
    *
    * @param pred the data item contained in the source node for the edge
    * @param succ the data item contained in the target node for the edge
    * @return the non-negative data from the edge between those nodes
    * @throws NoSuchElementException if either node or the edge between them
    *         are not found within this graph
    */
   public EdgeType getEdge(NodeType pred,NodeType succ);
   /**
    * Return the number of edges in the graph.
    *
    * @return the number of edges in the graph
    */
   public int getEdgeCount();
   /**
    * Returns the list of data values from nodes along the shortest path
    * from the node with the provided start value through the node with the
    * provided end value.  This list of data values starts with the start
    * value, ends with the end value, and contains intermediary values in the
    * order they are encountered while traversing this shorteset path.  This
    * method uses Dijkstra's shortest path algorithm to find this solution.
    *
    * @param start the data item in the starting node for the path
    * @param end the data item in the destination node for the path
    * @return list of data item from node along this shortest path
    */
   public List<NodeType> shortestPathData(NodeType start, NodeType  end, int groundClearance);
  
   /**
    * Returns the cost of the path (sum over edge weights) of the shortest
    * path freom the node containing the start data to the node containing the
    * end data.  This method uses Dijkstra's shortest path algorithm to find
    * this solution.
    *
    * @param start the data item in the starting node for the path
    * @param end the data item in the destination node for the path
    * @return the cost of the shortest path between these nodes
    */
   public double shortestPathCost(NodeType start, NodeType end,int groundClearance);
 
   
  
}


Backend Developer (BD) Role: Yashman Singh, Chaitanya Sharma
The backend developer writes code that makes use of the Graph data structure and Dijkstra's shortest path algorithm to find the shortest path between 2 cities.
Backend Functionality Description:
The backend developer for this project designs and implements the application's server-side logic. They are responsible for creating API endpoints that the frontend will use to interact with the application. These endpoints will allow users to perform various operations such as creating and modifying graph nodes and edges, querying the graph for specific information, and computing Dijkstra's shortest path algorithm. These operations will make use of the GraphADT which is being extended by the AlgorithmEngineer.
Development Responsibilities:
Load Data that is returned by the DW
Add the cities and paths to the graph data structure
Using the Algorithm Engineer’s implementation of the shortest path algorithm to find the shortest path between cities
Return information about the graph such as whether the graph contains a particular city, or the number of edges/cities in the graph
import java.io.FileNotFoundException;
import java.util.List;

public interface BackendInterface<NodeType, EdgeType extends Number>{


   public void loadRoads(String filename) throws FileNotFoundException;

   public void loadCities(String filename) throws  FileNotFoundException;

   public int cityCount();


   public int edgeCount();


   public List<NodeType> getShortestPath(NodeType  start,EdgeType end,int GroundClearance);


   public double getPathCost(NodeType start,EdgeType end, int GroundClearance);


   public void addCity(NodeType city);
  
   public void removeCity(NodeType city);

   public void addRoad(NodeType pred,NodeType succ,EdgeType road);


   public void removeRoad(EdgeType road);
   public boolean checkCity(NodeType city);


   public boolean checkEdge(NodeType pred,NodeType succ);

}




Presentation Responsibilities:
The BD will create a video showing how cities can be removed. Load the data and then check for the city “Sivas“. Check the path and cost between “Kayseri” and “Giresun” at clearances 300. Then remove Sivas and check for the city “Sivas“. Check the path and cost between “Kayseri” and “Giresun” at clearances 300, and show /explain why the path/cost is different (demo by <Backend Developer>)


Frontend Developer (FD) Role: Skanda Vyas Srinivasan, Colin Shaw
The Frontend Developer utilizes the FrontendInterface to create a class that accepts user input to call functions created by the Backend Developer.
Log of a Sample Execution of the App:
Welcome,
Choose one of the following options:
[L]oad Data
Find [S]hortest path
Find [D]istance
Find C[O]unt of cities
[A]dd City
[R]emove City
C[H]eck City
Check [P]ath
[Q]uit Program

L

Enter the file you’d like to load in:

File.gv

The file has been loaded

Choose one of the following options:
[L]oad Data
Find [S]hortest path
Find [D]istance
Find C[O]unt of cities
[A]dd City
[R]emove City
C[H]eck City
Check [P]ath
[Q]uit Program


S

Enter City 1: 

Istanbul

Enter City 2:

Ankara

The shortest path between these 2 cities are as such:
İstanbul => Bursa => Fethiye => Trabzon => Ankara

Choose one of the following options:
[L]oad Data
Find [S]hortest path
Find [D]istance
Find C[O]unt of cities
[A]dd City
[R]emove City
C[H]eck City
Check [P]ath
[Q]uit Program

H

Which City do you want to check:

Istanbul

Yes, this city is present


Choose one of the following options:
[L]oad Data
Find [S]hortest path
Find [D]istance
Find C[O]unt of cities
[A]dd City
[R]emove City
C[H]eck City
Check [P]ath
[Q]uit Program

Q


Thank you.





Development Responsibilities:

import java.util.List;
public interface FrontendInterface<NodeType, EdgeType extends Number> {
	//public FD(Scanner input, BackendInterface backend);
	 public void runCommandLoop();
	 public char MainMenu();
	 public void loadRoads();
	 public void loadRoads();
	 public int getCityCount();
	 public int getRoadCount();
	 public void getShortestPath();
	 public void getPathCost();
	 public void addCity();
	 public void removeCity();
	 public void checkCity();
	 public void checkEdge();
}





Presentation Responsibilities:
The FD will make a video showing that the program recognizes there are no paths between two cities. Check the path between “Bayburt” and “Sinop” at clearance 170. Then again at clearance 160. Explain why there is no path now.

Scope and Signatures: 
Ideas for Scoping Up:
We could add distance comparisons with weights based on traffic to provide a more accurate map

We could implement this with other data sets outside cities in turkey
Ideas for Scoping Down:


Outside Libraries and Other Tools:
<briefly describe a couple of ideas for features that could be removed from this project>
Team Signatures: 
Name
Email
Team
Type Name As Signature
Skanda Vyas Srinivasan
svsrinivasa2@wisc.edu
Red
Skanda Vyas Srinivasan
Yashman Singh
ypsingh@wisc.edu
Red
Yashman Singh
Samir Simha
ssimha2@wisc.edu
Red
Samir Simha
Zain Siddiqui
zsiddiqui6@wisc.edu
Red
Zain Siddiqui
Colin Shaw
cjshaw3@wisc.edu
Blue
Colin Shaw
Chaitanya Sharma
csharma4@wisc.edu
Blue
Chaitanya Sharma
Pushpit Singh
psingh76@wisc.edu
Blue
Pushpit Singh
Aditi Shah
aashah25@wisc.edu
Blue
Aditi Shah



TA Feedback:
AE: Almost all of the features are from W2 implementation. Could you add something like multiple stops between origin and destination and then find the shortest path with these constraints? 
Team Response:
We are adding a ground clearance feature which would help to find the path according to the car type

Proposal Amendments:
If your group needs to make any changes to what is described above after the proposal deadline, then 1) make sure everyone in your group agrees with those changes, 2) describe those changes in the first empty row below, and then 3) notify your group’s TA about those changes and whey are being made.  Your TA will then review your request and indicate whether they approve of such changes by adding their initials to the end of that amendment’s row below.

Number
Description
TA Approval
1
Updated the backend interface


2




3




4




5




6




7




8







