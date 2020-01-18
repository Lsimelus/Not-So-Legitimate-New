import java.util.Scanner;
/**
 * Calls the methods required for function to run
 *
 * @author Lyndbergh Simelus
 * @version 9/14/2019
 */
public class Controller
{
    /**
     * Main method
     * Calls of the function to make the program run
     *
     * @param None
     * @return    None
     */
    public static void main(String args[]){
        Database data = new Database();
        data.Scrape();//gets all of the info from the local folders
        Event emptyEvent = new Event("","","","","","","");//Only created to make the initial event
        
        Scanner sc = new Scanner(System.in);
        String input = "";
        Report BreakingNews;
        
        while (!(input.equals("end"))){
            emptyEvent = data.Maker(emptyEvent);
            BreakingNews = new Report(emptyEvent);
            System.out.println(BreakingNews.Dialogue());
            BreakingNews.Display();
            input = sc.nextLine();
            
            for(int i= 0;i<50; i++){
                System.out.println();
            }
        }
    }
    
}
