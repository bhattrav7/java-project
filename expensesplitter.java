import java.util.ArrayList;
import java.util.Scanner;

public class expensesplitter 
{
    public static void main(String[] args)
    {

    int total=0;
    boolean add=true;
    String payer="";
    int amt=0;
    int p=0;
    

    Scanner sc=new Scanner(System.in);
   
    
    System.out.println("How many people?");
    p=sc.nextInt();
    sc.nextLine();
    String[] names=new String[p];
    System.out.println("Enter names of people");
    for(int i=0;i<p;i++)
    {
        names[i]=sc.nextLine();
    }
    
    
    
    double[] paid=new double[p];
    double[] owe=new double[p];



    while(add)
    {
     System.out.println("Who paid?");
     payer=sc.nextLine();
     System.out.println("How much?");
     amt=sc.nextInt();
     sc.nextLine();

     for(int i=0;i<p;i++)
     {
        if(names[i].equalsIgnoreCase(payer))

            {
                paid[i]+=amt;          
            }
     }
        total+=amt;
        amt=0;
        payer="";
        System.out.println("PRESS 1 TO ADD MORE EXPENSES");
        System.out.println("PRESS 2 TO CALCUATE BALANCES");
        int choice=sc.nextInt();
        sc.nextLine();
        if(choice==1)
            continue;
        else if(choice==2)
            break;
    }
    double each=(double)total/p;
    System.out.printf("EACH PERSON PAYS: %.2f%n",each);
    for(int i=0;i<p;i++)
    {
        owe[i]=each-paid[i];

    }
    
    for(int i=0;i<p;i++)
    {
        if(owe[i]>0)
            System.out.printf("%s owes %.2f%n",names[i],owe[i]);
        else if(owe[i]<0)
            System.out.printf("%s gets back %.2f%n",names[i],-owe[i]);
        else
            System.out.println(names[i]+" is settled up");
    }
sc.close();
ArrayList<String> debtors=new ArrayList<>();
ArrayList<String> receivers=new ArrayList<>();
ArrayList<Double> debtamt=new ArrayList<>();
ArrayList<Double> recamt=new ArrayList<>();

for(int i=0;i<p;i++)
{
    if(owe[i]>0)
    {
        debtors.add(names[i]);
    debtamt.add(owe[i]);
    }
    else if(owe[i]<0)
    {
        receivers.add(names[i]);
        recamt.add(-(owe[i]));
    }

}
for(int i=0;i<debtamt.size()-1;i++)
{
    for(int j=0;i<debtamt.size()-1-i;i++)
    {
        if(debtamt.get(j)<debtamt.get(j+1))
        {
            Double temp=debtamt.get(j);
            debtamt.set(j,debtamt.get(j+1));
            debtamt.set(j+1,temp);


        String tempn=debtors.get(j);
            debtors.set(j,debtors.get(j+1));
            debtors.set(j+1,tempn);          
        }

    }
}
for(int i=0;i<recamt.size()-1;i++)
{
    for(int j=0;i<recamt.size()-1-i;i++)
    {
        if(recamt.get(j)<recamt.get(j+1))
        {
            Double temp=recamt.get(j);
            recamt.set(j,recamt.get(j+1));
            recamt.set(j+1,temp);


        String tempn=receivers.get(j);
            receivers.set(j,receivers.get(j+1));           
            receivers.set(j+1,tempn);          
        }

    }

}
System.out.println("HOW TO BALANCE");
int d=0;
int r=0;

while(d<debtors.size() && r<receivers.size())
{
    double debt=debtamt.get(d);
    double rec=recamt.get(r);

    if(debt==rec)
    {
    System.out.printf("%s pays %s %.2f%n", debtors.get(d), receivers.get(r), debt);
     d++;
     r++;
    }
    else if(debt>rec)
    {
    System.out.printf("%s pays %s %.2f%n", debtors.get(d), receivers.get(r), rec);
    debtamt.set(d,debt-rec);
    r++;
    }
    else
    {
    System.out.printf("%s pays %s %.2f%n", debtors.get(d), receivers.get(r), debt);
     recamt.set(r,rec-debt);
     d++;
    }
}
    }
}
