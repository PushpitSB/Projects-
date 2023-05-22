import java.io.FileNotFoundException;
import java.util.List;

/**
* Interface to read from a gv file and create the graph
**/
public interface DistanceReaderInterface {

    // Loads the graph from the file and returns the list of roads
    public List<RoadInterface> loadRoads(String filename) throws FileNotFoundException;
  
    // Loads the graph from the file and returns the list of cities
    public List<String> loadCities(String filename) throws FileNotFoundException;
  }
  