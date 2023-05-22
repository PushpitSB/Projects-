import java.util.Scanner;

/**
 * Main entry point for starting and running the CHSearch App.
 * 
 * @author AlgorithmEngineer, courtesy of the CS400 course staff.
 */
public class RouteFinderApp {
	public static void main(String[] args) {
		// Use data wrangler's code to load post data
		DistanceReaderInterface postLoader = new DistanceReaderAE();
        RoadInterface road = new RoadAE();
        // Use the backend developer's code to manage all app specific processing
        BackendAE backend = new BackendAE(road,postLoader);
		
		// Use algorithm engineer's code to store and search for data

		// Use the frontend developer's code to drive the text-base user interface
		
	}
}
