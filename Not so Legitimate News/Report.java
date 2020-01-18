import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

/**
 * Generates text and visuals for the event that is recieved
 * The text and image is based on the contents of the event
 *
 * @ Lyndbergh Simelus
 * @ 9/14/2019
 */
public class Report
{
    private static String[] data;
    
    /**
     * Constructor for report
     *
     * @param The one event being reported
     * @return    None
     */
    public Report(Event news){
        data = news.getInfo();
    }
    
    /**
     * Generate text out put with event description
     *
     * @param None
     * @return String of designed text
     */
    public String Dialogue(){
        String paragraph = "BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!BREAKING NEWS!!!\n\n"
        + "Today on Not So Legitimate news, we got incoming BREAKING news from one of our reporters\n\n" +
        "Here is the inside scoop:\n"
        + "Just last night at " + data[3]+ ". " + data[0] + " was asked about their opinions on " + data[2] + ".\n"
        + "And their response shocked what seemed half the world\n" + 
        "This is what they said: \n       " + data[6] 
        + ".\nEven " + data[0] + "'s " + data[4]+ ", "+ data[1] + ",had something to say.\n" 
        + data[1] + " said, \n       " + data[5] + " on Twitter this morning!\n" 
        + "We will keep you updated as more of this not so legitimate news comes out.\n"
        + "\nPress enter to find out more Fake News. \nType end to leave the program.";
        
        return paragraph;
    }
    
    /**
     * Create visual images based of event info, using JFrame
     *
     * @param None
     * @return    None
     */
    public void Display(){
       JPanel container = new JPanel();//Will hold all of the pictures and will go inside the JFrame
       container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));//
       
       JLabel pic1;
       JLabel pic2;
       JLabel pic3;
       JLabel pic4;
       
       try{
           //gets image from folders
           BufferedImage myPicture1 = ImageIO.read(new File("header.jpg")); 
           BufferedImage myPicture2 = ImageIO.read(new File("people/" + data[0]+".jpeg"));
           BufferedImage myPicture3 = ImageIO.read(new File("twitter.gif"));
           BufferedImage myPicture4 = ImageIO.read(new File("people/" + data[1]+".jpeg"));
           
           //puts the image on a label, incorporating Javax
           pic1 = new JLabel(new ImageIcon(myPicture1));
           pic2 = new JLabel(new ImageIcon(myPicture2));
           pic3 = new JLabel(new ImageIcon(myPicture3));
           pic4 = new JLabel(new ImageIcon(myPicture4));
           
           //adds JLabels to Jpanel
           container.add(pic1);
           container.add(pic2);
           container.add(pic3);
           container.add(pic4); 
       }catch (Exception e){
           System.err.println("Database could not load" + e.toString());
       }
       
       JScrollPane scroll = new JScrollPane(container); //Adds scrolling feature in fram
       
       JFrame f = new JFrame();
       f.add(scroll);
       f.setVisible(true);
       f.setSize(740, 1000);
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
