import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

public class AETests {
    @Test
    public void Test1(){
        GraphAE ae = new GraphAE<>(); // AE instance
        RoadAE roads = new RoadAE(); //the roads class
        DistanceReaderAE loader = new DistanceReaderAE(); //data loader making instance of DW 
        BackendAE backend = new BackendAE<>(roads, loader, ae); //backend instance
        
        backend.loadRoads(null);//creating a graph with random cities
        List path = backend.getShortestPath("Chicago", "Tucson", 150);

        for(int i =0; i < path.size();i++){
            System.out.println(path.get(i));
        }
        





    }
}
