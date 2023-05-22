import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.NoSuchElementException;
/**
 * tests the implementation of AE
 */
public class AETests {
    /**
     * Testing for a mid size car and finding the most effecient 
     * route
     */
    @Test
    public void Test1(){
        GraphAE ae = new GraphAE<>(); // AE instance
        RoadAE roads = new RoadAE(); //the roads class
        DistanceReaderAE loader = new DistanceReaderAE(); //data loader making instance of DW 
        BackendAE backend = new BackendAE<>(roads, loader, ae); //backend instance
        
        backend.loadRoads(null);//creating a graph with random cities
        List path = backend.getShortestPath("Chicago", "Tucson", 150);

        //returns the path which can only be traasvered with a car which has high ground clearance
        assertEquals(path.get(0),"Chicago");
        assertEquals(path.get(1),"Milwaukee");
        assertEquals(path.get(2),"New York");
        assertEquals(path.get(3),"Tucson");
        

    }

    /*
     *checks if the shortest path cost for a car which is mid size or higher 
     *is correct 
     */
    @Test
    public void Test2(){
        GraphAE ae = new GraphAE<>(); // AE instance
        RoadAE roads = new RoadAE(); //the roads class
        DistanceReaderAE loader = new DistanceReaderAE(); //data loader making instance of DW 
        BackendAE backend = new BackendAE<>(roads, loader, ae); //backend instance
        
        backend.loadRoads(null);//creating a graph with random cities
       // List path = backend.getShortestPath("Chicago", "Tucson", 150);

        assertEquals(backend.getPathCost("Chicago","Tucson",150 ),150);

    }

    /**
     * should throw an error if the car which 
     * user is entering has a low ground clearance 
     * and cannot reach the destination
     */
    @Test
    public void Test3(){
        try{
            GraphAE ae = new GraphAE<>(); // AE instance
            RoadAE roads = new RoadAE(); //the roads class
            DistanceReaderAE loader = new DistanceReaderAE(); //data loader making instance of DW 
            BackendAE backend = new BackendAE<>(roads, loader, ae); //backend instance
            
            backend.loadRoads(null);//creating a graph with random cities
            List path = backend.getShortestPath("Chicago", "Tucson", 100);

        }
        catch(Exception e){
            assertEquals(e instanceof NoSuchElementException, true);
        }

    }

    /**
     * checking if the user's car with low 
     * ground clearance can transverse the road 
     * and take the right path
     */
    @Test
    public void Test4(){
        GraphAE ae = new GraphAE<>(); // AE instance
        RoadAE roads = new RoadAE(); //the roads class
        DistanceReaderAE loader = new DistanceReaderAE(); //data loader making instance of DW 
        BackendAE backend = new BackendAE<>(roads, loader, ae); //backend instance
        
        backend.loadRoads(null);//creating a graph with random cities
        List path = backend.getShortestPath("Chicago", "New York", 110);

        assertEquals(path.get(0),"Chicago");
        assertEquals(path.get(1),"Milwaukee");
        assertEquals(path.get(2),"New York");
    }

    /*
     * checking if the path cost returned from the 
     * sports car ground clearance on the path is correct
     */
    @Test
    public void Test5(){
        GraphAE ae = new GraphAE<>(); // AE instance
        RoadAE roads = new RoadAE(); //the roads class
        DistanceReaderAE loader = new DistanceReaderAE(); //data loader making instance of DW 
        BackendAE backend = new BackendAE<>(roads, loader, ae); //backend instance
        
        backend.loadRoads(null);//creating a graph with random cities
       // List path = backend.getShortestPath("Chicago", "Tucson", 150);

        assertEquals(backend.getPathCost("Chicago","New York",110 ),80);
    }

    


}
