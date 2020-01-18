import java.util.Arrays;

/**
 * Event Structure
 * It holds string values of event
 *
 * @author Lyndbergh Simelus
 * @version 9/14/2019
 */

public class Event
{
    private static String[] info = new String[7];//Holds all of the information of the event and is passed around
    
    /**
     * 
     * Constructor of Event Object
     * 
     * @param String of the two famous people,String of topic, String of location
     * String of the relationship between the two people,
     * String of the second persons reaction
     * String of the first persons original quote
     * 
     * @return None
     */
    public Event(String PersonA, String PersonB, String Topic, String Location, 
    String Relationship, String Reaction, String Quote){
        info[0] = PersonA;
        info[1] = PersonB;
        info[2] = Topic;
        info[3] = Location;
        info[4] = Relationship;
        info[5] = Reaction;
        info[6] = Quote;
    }
    
    /**
     * Gets all of the information of String in list
     * 
     * @param None
     * @return List of event features
     */
    public String[] getInfo(){
        return info;
    }
}
