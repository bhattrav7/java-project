import java.io.*;
import java.util.*;
public class contactsbook 
{
    public static void main(String[] args) throws IOException
    {
        String path=System.getProperty("user.home")+"/contact.txt";
        ArrayList <String> names=new ArrayList<>();
        ArrayList <String> number=new ArrayList<>();
        FileWriter fw=new FileWriter(path,true);
        BufferedWriter bw=new BufferedWriter(fw);
        BufferedReader br=new BufferedReader(new FileReader(path));
        String line;
        while((line=br.readLine())!=null)
        {
            String[] parts=line.split("\\|");
            names.add(parts[0]);
            number.add(parts[1]);
        }
        Scanner sc=new Scanner(System.in);
        
            boolean found=false;

        boolean exit=false;
        while(!exit)
        {
            System.out.println("====CONTACTS BOOK====");
            System.out.println("1. Search Contact");
            System.out.println("2. View All");
            System.out.println("3. Add Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5.Exit");
            int choice=sc.nextInt();
            sc.nextLine();



            if(choice==5)
            {
                System.out.println("Contacts Closed");
                exit=true;
                bw.close();
                br.close();
               
            }
            else if(choice==3)
            {
                System.out.println("Enter Name");
                
                String name=sc.nextLine();
                
                names.add(name);
                System.out.println("Enter Phone Number");
                String num=sc.nextLine();
                number.add(num);
                System.out.println("Contact Added");


                bw.write(name+"|"+num);
                bw.newLine();
                bw.flush();
                
                name="";
                num="";
            }
           else if(choice==2)
           {
            System.out.println("===CONTACTS LIST===");
            System.out.println("\nNames\t\tPhone Number\n");
            for(int i=0;i<names.size();i++)
            {
                System.out.println(names.get(i)+"\t\t"+number.get(i));

            }
           }
           else if(choice==1)
           {
            found=false;
            System.out.println("Search Name");
            String srch=sc.nextLine();
            for(int i=0;i<names.size();i++)
            {
                if(srch.equalsIgnoreCase(names.get(i)))
                {
                    found=true;
                System.out.println("Name: "+names.get(i)+"\t\tPhone Number: "+number.get(i));
                }
}
if(!found)
{
    System.out.println("Contact Not Found");
}

               
            }
           
           else if(choice==4)
           {
            System.out.println("Enter Name To Delete");
            String dlt=sc.nextLine();
            System.out.println("Are You Sure You Want TO Delete "+dlt);
            System.out.println("1.Yes");
            System.out.println("2.No");
            int sure=sc.nextInt();
            if(sure==1)
            {
            for(int i=0;i<names.size();i++)
            {
                if(dlt.equalsIgnoreCase(names.get(i)))
                {
                    System.out.println("Conact Removed: "+dlt);
                names.remove(i);
                number.remove(i);
                break;
                }

            }
            FileWriter fd=new FileWriter(path,false);
            BufferedWriter bd=new BufferedWriter(fd);
            for(int j=0;j<names.size();j++)
            {
                bd.write(names.get(j)+"|"+number.get(j));
                bd.newLine();
            }
            bd.close();
            }
              else if(sure==2)
            System.out.println("Deletion Cancelled");
           }
          


        }
        sc.close();
    }


    }

