import java.util.*;
public class numbergame
 {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("WELCOME TO THE NUMBER GAME");
        int play=1;
        while(play==1)
{
        int c=0;
        int m=0;
   
       
       int num=(int)Math.floor(Math.random()*100+1);

       
       System.out.println("CHOOSE DIFFICULTY");
       System.out.println("PRESS 1 FOR EASY(12 ATTEMPTS)");
       System.out.println("PRESS 2 FOR MEDIUM(7 ATTEMPTS)");
       System.out.println("PRESS 3 FOR HARD(5 ATTEMPTS)");
       int diff=sc.nextInt();

       if(diff==1)
        m=12;
    else if(diff==2)
        m=7;
    else if(diff==3)
        m=5;
    else
    {
        System.out.println("INVALID CHOICE");
        continue;
    }
       
    boolean game=true;
    while(game && c<m)
    {           
        System.out.println("enter your guess");
        int guess=sc.nextInt();
        c++;
        if(guess==num)
        {
            System.out.println("CORRECT! YOU WIN! (:");
           
            game=false;
        }
        else if(num>guess)
        {
            System.out.println("higher");

        
        }
        else 
        {
            System.out.println("lower");
        
        }
        if(game)
        {
            System.out.println("REMAINING ATTEMPS:"+(m-c));
        }
    }
    if(!game)
    System.out.println("IT TOOK YOU "+c+" ATTEMPTS!");
else
{
    System.out.println("GAME OVER! YOU USED UP ALL THE ATTEMPTS ):");
    System.out.println("THE NUMBER WAS "+num);
}

System.out.println("PLAY AGAIN?");
System.out.println("PRESS 1 FOR YES");
System.out.println("PRESS 2 FOR NO");
 play=sc.nextInt();
 if (play==2)
 {
    System.out.println("THANKS FOR PLAYING <3");
    break;
 }
}
sc.close();

    }
}
