import java.util.List;
import java.util.Random;

public class BackendAE<NodeType,EdgeType extends Number> implements BackendInterface<NodeType,EdgeType>{
    RoadInterface road;
    DistanceReaderInterface dInterface;
    GraphAEInterface ae;
    public BackendAE(RoadInterface road2, DistanceReaderInterface postLoader,GraphAEInterface ae) {
        this.road = road2;
        this.dInterface = postLoader;
        this.ae = ae;
    }
    
    @Override
    public boolean insertNode(NodeType data) {
        return ae.insertNode(data);
    }

    @Override
    public boolean removeNode(NodeType data) {
       return ae.removeNode(data);
    }

    @Override
    public boolean containsNode(NodeType data) {
        return ae.containsNode(data);
    }

    @Override
    public int getNodeCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNodeCount'");
    }

    @Override
    public boolean insertEdge(NodeType pred, NodeType succ, EdgeType weight) {
        Random random = new Random();
        int randomInt = random.nextInt(100,200);
        return ae.insertEdge(pred, succ, weight, randomInt);
    }

    @Override
    public boolean removeEdge(NodeType pred, NodeType succ) {
       return ae.removeEdge(pred, succ);
    }

    @Override
    public boolean containsEdge(NodeType pred, NodeType succ) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'containsEdge'");
    }

    @Override
    public EdgeType getEdge(NodeType pred, NodeType succ) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEdge'");
    }

    @Override
    public int getEdgeCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEdgeCount'");
    }

    @Override
    public List<NodeType> shortestPathData(NodeType start, NodeType end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shortestPathData'");
    }

    @Override
    public double shortestPathCost(NodeType start, NodeType end) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'shortestPathCost'");
    }

    @Override
    public List<RoadInterface> loadRoads(String filename) {
        Random random = new Random();
        int x = random.nextInt(100,200);
        int y = random.nextInt(50,650);
        ae.insertNode("Chicago");
        ae.insertNode("Milwaukee");
        ae.insertNode("Connotia");
        ae.insertNode("New York");
        ae.insertNode("Tucson");
        
        
        ae.insertEdge("Chicago", "Milwaukee", 20, 100);
         x = random.nextInt(100,200);
        y = random.nextInt(50,650);

        ae.insertEdge("Milwaukee", "Chicago", 30, 100);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);

        ae.insertEdge("Milwaukee", "Connotia", 40, 100);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);

        ae.insertEdge("Connotia", "Milwaukee", 50, 100);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);

        ae.insertEdge("Milwaukee", "New York", 60,100 );
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);

        ae.insertEdge("New York", "Tucson", 70, 130);

        x = random.nextInt(100,200);
        y = random.nextInt(50,650);
        ae.insertEdge("Connotia" ,"Tucson", 10, 175);





        x = random.nextInt(100,200);
        /* 
        ae.insertEdge("New York", "Milwaukee", y, x);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);
        ae.insertEdge("New York", "Tucson", y, x);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);
        ae.insertEdge("Tucson", "New York", y, x);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);
        ae.insertEdge("Tucson", "Connotia", y, x);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);
        ae.insertEdge("Connotia", "Tucson", y, x);
        x = random.nextInt(100,200);
        y = random.nextInt(50,650);


*/



        return null;

    }

    @Override
    public int cityCount(NodeType node) {
        return ae.getNodeCount();
    }

    @Override
    public int edgeCount(EdgeType edge) {
        return ae.getEdgeCount();
    }

    @Override
    public List<NodeType> getShortestPath(NodeType start, NodeType end, int groundClearance) {
       return ae.shortestPathData(start, end, groundClearance);
    }

    @Override
    public double getPathCost(NodeType start, NodeType end, int groundClearance) {
        return ae.shortestPathCost(start, end, groundClearance);
    }

    @Override
    public EdgeType getDistance(NodeType start, EdgeType end) {
        return null;
    }

    @Override
    public void addCity(NodeType city) {
        ae.insertNode(city);
    }

    @Override
    public void removeCity(NodeType city) {
        ae.removeNode(city);
    }

    @Override
    public boolean checkCity(NodeType city) {
        return ae.containsNode(city);
    }

    @Override
    public boolean checkEdge(NodeType edge) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkEdge'");
    }

    
}
