import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * This class extends the BaseGraph data structure with additional methods for
 * computing the total cost and list of node data along the shortest path
 * connecting a provided starting to ending nodes.  This class makes use of
 * Dijkstra's shortest path algorithm.
 */
public class GraphAE<NodeType, EdgeType extends Number>
    extends BaseGraph<NodeType,EdgeType>
    implements GraphAEInterface<NodeType, EdgeType> {

        public Hashtable<NodeType,Node2> nodes2 = new Hashtable<>();

        @Override
        public boolean insertNode(NodeType data) {
            if(nodes2.containsKey(data)) return false; //throws NPE when data's null
            nodes2.put(data,new Node2(data));
            return true;
        }
    
        @Override
        public boolean removeNode(NodeType data) {
            // remove this node from nodes collection
        if(!nodes2.containsKey(data)) return false; // throws NPE when data==null
        Node2 oldNode = nodes2.remove(data);
        // remove all edges entering neighboring nodes from this one
        for(Edge2 edge : oldNode.edgesLeaving)
            edge.successor.edgesEntering.remove(edge);
        // remove all edges leaving neighboring nodes toward this one
        for(Edge2 edge : oldNode.edgesEntering)
            edge.predecessor.edgesLeaving.remove(edge);
        return true;
        }
    
        @Override
        public boolean containsNode(NodeType data) {
            return nodes2.containsKey(data);
        }
    
        @Override
        public boolean insertEdge(NodeType pred, NodeType succ, EdgeType weight,int groundClearance) {
        // find nodes associated with node data, and return false when not found
        Node2 predNode = nodes2.get(pred);
        Node2 succNode = nodes2.get(succ);
        if(predNode == null || succNode == null) return false;
        try {
            // when an edge alread exists within the graph, update its weight
            Edge2 existingEdge = getEdgeHelper(pred,succ);
            existingEdge.data = weight;
        } catch(NoSuchElementException e) {
            // otherwise create a new edges
            Edge2 newEdge = new Edge2(weight,predNode,succNode,groundClearance);
            this.edgeCount++;
        
            // and insert it into each of its adjacent nodes' respective lists
            predNode.edgesLeaving.add(newEdge);
            succNode.edgesEntering.add(newEdge);
        }
            return true;
        }
    
        @Override
        public boolean removeEdge(NodeType pred, NodeType succ) {
              try {
                // when an edge exists
                Edge2 oldEdge = getEdgeHelper(pred,succ);        
                // remove it from the edge lists of each adjacent node
                oldEdge.predecessor.edgesLeaving.remove(oldEdge);
                oldEdge.successor.edgesEntering.remove(oldEdge);
                // and decrement the edge count before removing
                this.edgeCount--;
                return true;
            } catch(NoSuchElementException e) {
                // when no such edge exists, return false instead
                return false;
            }
          
        }
    
        @Override
        public boolean containsEdge(NodeType pred, NodeType succ) {
            return super.containsEdge(pred, succ);
        }
    
        @Override
        public EdgeType getEdge(NodeType pred, NodeType succ) {
            return super.getEdge(pred, succ);
        }
       
        protected Edge2 getEdgeHelper(NodeType pred, NodeType succ) {
            Node2 predNode = nodes2.get(pred);
            // search for edge through the predecessor's list of leaving edges
            for(Edge2 edge : predNode.edgesLeaving){
                // compare succ to the data in each leaving edge's successor

                if(edge.successor.equals(succ))
                    return edge;
            } 
            // when no such edge can be found, throw NSE
            throw new NoSuchElementException("No edge from "+pred.toString()+" to "+
                                             succ.toString());
        }
    
    /**
     * While searching for the shortest path between two nodes, a SearchNode
     * contains data about one specific path between the start node and another
     * node in the graph.  The final node in this path is stored in it's node
     * field.  The total cost of this path is stored in its cost field.  And the
     * predecessor SearchNode within this path is referened by the predecessor
     * field (this field is null within the SearchNode containing the starting
     * node in it's node field).
     *
     * SearchNodes are Comparable and are sorted by cost so that the lowest cost
     * SearchNode has the highest priority within a java.util.PriorityQueue.
     */
    protected class SearchNode implements Comparable<SearchNode> {
        public Node2 node;
        public double cost;
        public SearchNode predecessor;
        public SearchNode(Node2 node, double cost, SearchNode predecessor) {
            this.node = node;
            this.cost = cost;
            this.predecessor = predecessor;
        }
        public int compareTo(SearchNode other) {
            if( cost > other.cost ) return +1;
            if( cost < other.cost ) return -1;
            return 0;
        }
    }

    /**
     * This helper method creates a network of SearchNodes while computing the
     * shortest path between the provided start and end locations.  The
     * SearchNode that is returned by this method is represents the end of the
     * shortest path that is found: it's cost is the cost of that shortest path,
     * and the nodes linked together through predecessor references represent
     * all of the nodes along that shortest path (ordered from end to start).
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return SearchNode for the final end node within the shortest path
     * @throws NoSuchElementException when no path from start to end is found
     *         or when either start or end data do not correspond to a graph node
     */
    protected SearchNode computeShortestPath(NodeType start, NodeType end,int groundClearance) {
        Hashtable<NodeType,SearchNode> visited= null;
        
        if(!nodes2.containsKey(start) || !nodes2.containsKey(end)){
            throw new NoSuchElementException("Invalid data entry found, No such value exsists");
            //Code throws an error if the data isn't found
       }
            visited = new Hashtable<>();//Notes down all the visited nodes
       //creating a minimum priority queue for the nodes transversing from the starter node
       PriorityQueue<SearchNode> pq = new PriorityQueue<>();
       SearchNode path = new SearchNode(nodes2.get(start),0.0,null);
       pq.add(path);
       SearchNode sn = null; 
       while(!pq.isEmpty()){
            sn = pq.remove(); //the current search node which has the minimum edge node
            if(!visited.containsKey(sn.node.data)){
                //adding the node to the hashtable with the visited nodes
                visited.put(sn.node.data,sn);

                //using dijkstra implementation to add the nodes to the queue 
                for(Edge2 edge : sn.node.edgesLeaving){
                    if((groundClearance>edge.groundClearance)) {
                    SearchNode next = new SearchNode((GraphAE<NodeType, EdgeType>.Node2) edge.successor,sn.cost + (int)edge.data,sn);
                    pq.add(next);
                    }
                    else{
                        continue;
                    }
                }
            }
       }
       //Code throws "no such element" exception if the node can't be reached 
       if (visited.containsKey(end) == false) throw new 
            NoSuchElementException("The exact end node isn't reachable in the graph");
    
    return visited.get(end);
    
        
    }

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
    public List<NodeType> shortestPathData(NodeType start, NodeType end, int groundClearance) {
        SearchNode path = computeShortestPath(start,end,groundClearance); //call the helper method
        List<NodeType> pD = new LinkedList<>();
        
        while(!path.node.data.equals(start)){
           //traversing from end to start and adding them to the linked list 
            pD.add(path.node.data);
            path = path.predecessor;
        }
        pD.add(start);
        
        //Reversing the linked list
        List<NodeType> straightWalk = new LinkedList<>();
        for(int i = pD.size()-1; i >=0; i--){
            straightWalk.add(pD.get(i));
        }
        return straightWalk;
    }

    /**
     * Returns the cost of the path (sum over edge weights) of the shortest
     * path from the node containing the start data to the node containing the
     * end data.  This method uses Dijkstra's shortest path algorithm to find
     * this solution.
     *
     * @param start the data item in the starting node for the path
     * @param end the data item in the destination node for the path
     * @return the cost of the shortest path between these nodes
     */
    public double shortestPathCost(NodeType start, NodeType end, int groundClearance) {
       //Call the shortest path function to get the path and the returning cost
       SearchNode pathS = computeShortestPath(start,end,groundClearance);
       return pathS.cost;

    }
     
    protected class Edge2 extends Edge{
        protected int groundClearance;
        //public EdgeType data; // the weight or cost of this edge
        public Edge2(EdgeType data, Node2 pred, Node2 succ,int gc) {
            super(data,pred,succ);
            groundClearance = gc;
        }

    }

    protected class Node2 extends Node{
            public Node2(NodeType data) {
            super(data);
        }
            List<Edge2> edgesLeaving = new LinkedList<>();
            List<Edge2> edgesEntering = new LinkedList<>();
        
        
    }


    

   
}
