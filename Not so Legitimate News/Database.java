import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.util.Random;

/**
 * Calls the methods required for function to run
 *
 * @author Lyndbergh Simelus
 * @version 9/14/2019
 */
public class Database
{   
    //Text File name
    private static final String PEOPLEF = "people.txt";
    private static final String EVENTF = "event.txt";
    private static final String PLACESF = "places.txt";
    private static final String RELATIONSHIPF= "relationship.txt";
    private static final String REACTF= "reaction.txt";
    private static final String QUOTESF= "quotes.txt";
    
    //Will hold of he content inside of the files
    private static ArrayList<String> peopleL = new ArrayList();
    private static ArrayList<String> eventL = new ArrayList();
    private static ArrayList<String> placesL = new ArrayList();
    private static ArrayList<String> relationshipL = new ArrayList();
    private static ArrayList<String> reactsL = new ArrayList();
    private static ArrayList<String> quotesL = new ArrayList();
    
    //list of file names
    private static String[] FILES = new String[] {"people.txt",
    "event.txt",
    "places.txt",
    "relationship.txt",
    "reaction.txt",
    "quotes.txt",};
    
    /**
     * Takes in an event and make sure none events repeat
     * This is where the low-order markov chain happens
     *
     * @param Old event
     * @return New event
     */
    public Event Maker(Event info){
        String[] data = info.getInfo();//gets the state of the previous report
        
        String[] newInfo = new String[7];//will be filled with the new event info
        
        for (int i = 0; i < data.length; i++){
            ArrayList collector = new ArrayList();
            switch(i){
                case 0:
                    collector = peopleL;
                    break;
                case 1:
                    collector = peopleL;
                    break;
                case 2:
                    collector = eventL;
                    break;
                case 3:
                    collector = placesL;
                    break;
                case 4:
                    collector = relationshipL;
                    break;
                case 5:
                    collector = reactsL;
                    break;
                case 6:
                    collector = quotesL;
                    break;
            }
            newInfo[i] = getNewAndRandom(collector, data[i]); //gets new info based off of the last. It only takes the mos recent report so it is 
            //low order markov chain
        }
        
        Event temp = new Event(newInfo[0],newInfo[1],newInfo[2],newInfo[3],
        newInfo[4],newInfo[5],newInfo[6]);//create an event with new info
        
        return temp;
    }
    
    /**
     * Get new event that is not the same as the previous event
     *
     * @param List of all possible new values of event feature,String of old event feature
     * @return Get new random variable that is not the same as the one passed in
     */
    public String getNewAndRandom(ArrayList<String> fullList, 
    String previousSelection){
        String newVal = previousSelection;
        int n;
        Random rand = new Random();
        while (newVal == previousSelection){//goes until random finds a new value
            n = rand.nextInt(fullList.size());
            newVal = fullList.get(n);
        }
        return newVal;
    }   

    /**
     * Parse the text file and put the information into ArrayList
     *
     * @param None
     * @return None
     */
    public void Scrape (){
        Scanner scan = new Scanner(System.in);
        
        for (String fileName : FILES) {//Loops through every single file name
            try {
                scan = new Scanner(new File(fileName));
            }catch (Exception e) {
                 System.err.println("Database could not load" + e.toString());
            }
             
            ArrayList collector;
            switch(fileName){
                case PEOPLEF:
                    collector = peopleL;//makes sure that the information is passed into the correct list
                    break;
                case EVENTF:
                    collector = eventL;
                    break;
                case PLACESF:
                    collector = placesL;
                    break;
                case RELATIONSHIPF:
                    collector = relationshipL;
                    break;
                case REACTF:
                    collector = reactsL;
                    break;
                case QUOTESF:
                    collector = quotesL;
                    break;
                default:
                    throw new IllegalArgumentException("File not found");
            }
            
            while (scan.hasNext()) {
                collector.add(scan.nextLine());//add information to file
            }
            scan.close(); // done reading the file, close the Scanner
        }
    
    }
}
