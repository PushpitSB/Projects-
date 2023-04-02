
// TODO Complete file header must be added here
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    PO9 chugimon
// Course:   CS 300 Fall 2022
//
// Author:   Pushpit Singh
// Email:  psingh76@wisc.edu
// Lecturer:  Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////

public class Chugimon implements Comparable<Chugimon>{

    public static final int MAX_ID =151; //The maximum ID number
    public static final int MIN_ID = 1; //The minimum ID number
    private final String NAME; //The name of the Chugimon
    private final int FIRST_ID; //The first ID of the Chugimon
    private final int SECOND_ID; // The second ID of the Chugimon
    private final ChugiType PRIMARY_TYPE; //The primary type of the Chugimon; cannot be null; cannot be the same as the secondary type
    private final ChugiType SECONDARY_TYPE; //The secondary type of the Chugimon; may be null; cannot be the same as the primary type
    private final double HEIGHT; //The height of the Chugimon in meters
    private final double WEIGHT; //The weight of the Chugimon in kilograms

    /**
     * checks if ID is in bounds 
     * @param ID - the ID Chugimon
     * @return - true if the ID is in bounds,
     */
    private static boolean boundsChecker(int ID){
        return ID >= MIN_ID && ID <= MAX_ID; // checks if it is bounds
    }

    /**
     * Creates a new Chugimon with specific first and second IDs and initializes all its data fields accordingly.
     * @param firstID - the first ID of the Chugimon, between 1-151
     * @param secondID - the second ID of the Chugimon, between 1-151
     * @throws IllegalArgumentException - if the first and second ID are out of bounds or equal to each other.
     */
    public Chugimon(int firstID, int secondID){
        //checks if the first ID is qual to the second ID and both of them are in bounds using private helper method.
        if(firstID == secondID || !boundsChecker(secondID) || !boundsChecker(firstID)){
            //if any of it returns true then throw an error
            throw new IllegalArgumentException(" first and second ID are out of bounds or equal to each other.");
        }
        else{
            //initializing defaault values
            NAME = ChugidexUtility.getChugimonName(firstID,secondID);
            this.FIRST_ID = firstID;
            this.SECOND_ID = secondID;
            PRIMARY_TYPE = ChugidexUtility.getChugimonTypes(firstID, secondID)[0];
            SECONDARY_TYPE = ChugidexUtility.getChugimonTypes(firstID, secondID)[1];
            HEIGHT = ChugidexUtility.getChugimonHeight(firstID, secondID);
            WEIGHT = ChugidexUtility.getChugimonWeight(firstID, secondID);


        } 
    }
    /**
     * Gets the name of this Chugimon
     * @return - the name of the Chugimon
     */
    public String getName(){
        return NAME; 
    }
    /**
     * Gets the first ID of this Chugimon
     * @return - the first ID of the Chugimon
     */
    public int getFirstID(){
    return FIRST_ID;
    } 
    /**
     * Gets the second ID of thid Chugimon
     * @return - the second ID of the Chugimon
     */
    public int getSecondID(){
        return SECOND_ID;
    }
    /**
     * Gets the primary type of this Chugimon
     * @return - the primary type of the Chugimon
     */
    public ChugiType getPrimaryType(){
        return PRIMARY_TYPE;
    }
    /**
     * Gets the secondary type of this Chugimon
     * @return the secondary type of the Chugimon
     */
    public ChugiType getSecondaryType(){
        return SECONDARY_TYPE;
    }
    /**
     * Gets the height of this Chugimon
     * @return the height of the Chugimon
     */
    public double getHeight(){
        return HEIGHT;
    }
    /**
     * Gets the the weight of the Chugimon.
     * @return - the weight of the Chugimon.
     */
    public double getWeight(){
        return WEIGHT;
    }
    /**
     * Determines the ordering of Chugimon. Chugimon are ordered by: 1) name (alphabetical) 2)
     *  the first ID (if name is equal). The one with the smaller first ID is less than the other. 3)
     *  the second ID (if name and first ID are equal). The one with the smaller second ID is less than the other.
     *  A Chugimon with identical #1-3 are considered equal.
     * @param otherChugi -  the other Chugimon to compare this Chugimon to.
     * @return -  a negative int if this Chugimon is less than other, a positive int if this Chugimon is greater than other, or 0 if this and the other Chugimon are equal.
     */
    @Override
    public int compareTo(Chugimon otherChugi){
        //check whose name is first 
            int comp = this.getName().compareTo(otherChugi.getName()); //comparing both the strings 
            
        //check whose first ID is lower if names are equal 
        if(comp == 0){
            if(this.getFirstID() > otherChugi.getFirstID()){
                return 1;
            }
            else if(this.getFirstID() < otherChugi.getFirstID()){
                return -1;
            }
            else {
                     //if the name and first ID is same then compare the secondID 
                     if(this.getSecondID() > otherChugi.getSecondID()){
                        return 1;
                    }
                    else if(this.getSecondID() < otherChugi.getSecondID()){
                        return -1;
                    }
                    //if all the three are same then return equal
                    else{
                        return 0;
                    }
            }
        }
        else{
            return comp;
        }

       
        
        
    }
    /**
     * A Chugimon's String representation is its name followed by "#FIRST_ID.SECOND_ID" -- Example: "Zapchu#145.25"
     * @returna-  String representation of this Chugimon
     * @Overrides - toString in class Object
     */
    @Override
    public String toString(){
        return this.NAME + "#" + this.FIRST_ID + "." + this.SECOND_ID;

    }
    /**
     * Equals method for Chugimon. This Chugimon equals another object if other is a Chugimon with the exact same name, and their both first and second IDs match.
     * @param - other - Object to determine equality against this Chugimon
     * @returns - true if this Chugimon and other Object are equal, false otherwise
     */
    @Override
    public boolean equals(Object other){
        if(other instanceof Chugimon){
            if(this.compareTo((Chugimon)other) == 0){
                return true;
            }
        
        }
         return false;
    }





}
