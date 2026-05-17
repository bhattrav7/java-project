import java.util.*;
import java.io.*;
public class moodplayer 
{
public static void main(String[] args) throws IOException
{
    Scanner sc=new Scanner(System.in);
    FileReader fr=new FileReader("songs.txt");
    BufferedReader br=new BufferedReader(fr);
    String line;
    ArrayList <String> allsongs=new ArrayList<>();
    ArrayList <String> allartists=new ArrayList<>();
    ArrayList <String> allmoods=new ArrayList<>();
    ArrayList <String> matchingsongs=new ArrayList<>();
    ArrayList <String> matchingartists=new ArrayList<>();



    while((line=br.readLine())!=null)
    {
        String[] parts=line.split("\\|");
        allsongs.add(parts[0]);
        allartists.add(parts[1]);
        allmoods.add(parts[2]);    

    }
    System.out.println("WHAT MOOD DO YOU WANT TO LISTEN TO?");
    System.out.println("PRESS 1 FOR HYPE");
    System.out.println("PRESS 2 FOR SAD");
    System.out.println("PRESS 3 FOR ROMANTIC");
    System.out.println("PRESS 4 FOR CHILL");
    int choice=sc.nextInt();
    if(choice==1)
    {
        System.out.println("====HYPE PLAYLIST====\n");
    }
    else if(choice==2)
    {
        System.out.println("====SAD PLAYLIST====\n");
    }
    else if(choice==3)
    {
        System.out.println("====ROMANTIC PLAYLIST====\n");
    }
    else if(choice==4)
    {
        System.out.println("====CHILL PLAYLIST====\n");
    }

    for(int i=0;i<allmoods.size();i++)
    {
        if(choice==1)
        {    
            if(allmoods.get(i).equalsIgnoreCase("HYPE"))  
                {
                     matchingsongs.add(allsongs.get(i)); 
                     matchingartists.add(allartists.get(i));                
        System.out.println(allsongs.get(i)+" by "+allartists.get(i));
                }
        }
        else if(choice==2)
        {    
            if(allmoods.get(i).equalsIgnoreCase("SAD"))
                {
                     matchingsongs.add(allsongs.get(i));  
                     matchingartists.add(allartists.get(i));             
        System.out.println(allsongs.get(i)+" by "+allartists.get(i));
                }
        }
        else if(choice==3)
        {    
            if(allmoods.get(i).equalsIgnoreCase("ROMANTIC"))
                {
                     matchingsongs.add(allsongs.get(i)); 
                     matchingartists.add(allartists.get(i));             
        System.out.println(allsongs.get(i)+" by "+allartists.get(i));
                }
        }
        else if(choice==4)
        {    
            if(allmoods.get(i).equalsIgnoreCase("CHILL")) 
            {
                matchingsongs.add(allsongs.get(i));      
                matchingartists.add(allartists.get(i));       
        System.out.println(allsongs.get(i)+" by "+allartists.get(i));
            }
        }
    }
int top=(int)(Math.random()*matchingsongs.size());
System.out.println("\nTOP PICK: "+matchingsongs.get(top)+" by "+matchingartists.get(top));
sc.close();
br.close();   
}
}