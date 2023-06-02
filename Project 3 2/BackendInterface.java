import java.util.List;

public interface BackendInterface<NodeType, EdgeType extends Number> extends GraphADT<NodeType,EdgeType>{

	public List<RoadInterface> loadRoads(String filename);

 	public int cityCount(NodeType node);

	public int edgeCount(EdgeType edge);

	public List<NodeType> getShortestPath(NodeType  start,NodeType end,int groundClearance);

	public double getPathCost(NodeType start,NodeType end,int groundClearance);

	public EdgeType getDistance(NodeType  start,EdgeType end);

	public void addCity(NodeType city);

	public void removeCity(NodeType city);

	public boolean checkCity(NodeType city);

	public boolean checkEdge(NodeType edge);
	
	}
