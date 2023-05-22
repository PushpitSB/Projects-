public interface FrontendInterface {
    //public FrontendInterface(Scanner userInput, BackendInterface backend);
/**
Runs the command loop to prompt the user for input and perform various operations based on user's choices
*/
public void runCommandLoop();
/**
Prompts the user to select an option from the menu and returns the selected option as a character.
@return The character the user selected
*/
public char mainMenuPrompt();
/**
Loads data into the backend from a file or other source
*/
public void loadData();
/**
Finds the shortest path between two cities and displays it to the user
*/
public void findShortestPath();
/**
Finds the distance between two nodes and displays it to the user
*/
public void getDistance();
/**
Allows the user to get the backend's count of the cities 
*/
public void getCityCount();
/**
Allows the user to add a city to the backend's list of cities
*/
public void addCity();
/**
Allows the user to remove a city from the backend's list of cities 
*/
public void removeCity();

}
