import java.util.Random;
import java.util.Scanner;
public class number
{
    public static void main(String ...args)
    {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);

        int totalrounds =3;
        int totalattempts  =7;
        int i=1,score=0;

        System.out.println("===========================================================");
        System.out.println("                  Numner Guessing Gamae                    ");
        System.out.println("===========================================================");
        System.out.println();
        System.out.println("Guss the number!!");
        System.out.println();
        System.out.println("<> Computer will generate a random no between 1 to 100 and you have to guess either, between these range");
        System.out.println("<> You have to guess it in 7 attempts");
        System.out.println("<> Three rounds will be conducted let's see the score at the end... :)");
        System.out.println();
        System.out.println();
        System.out.println("Ready to play !!! (y/n)");
        char c= sc.next().charAt(0);

        if(c=='y' || c=='Y')
        {
            while(i<=totalrounds)
            {
                System.out.println("                  Round "+i+"                    ");
                int attempts=1,guessedno;
                int randomno=r.nextInt(100)+1;
                System.out.println("Guess No. between 1 to 100");
                do
                {
                    if(attempts==7)
                    {
                        System.out.println("<...> Be careful !! last try");
                    }
                    guessedno = sc.nextInt();
                    if(guessedno<randomno)
                    {
                        System.out.println("its low , Guess higher one");
                    }
                    else if(guessedno>randomno)
                    {
                        System.out.println("its high , Guess lower one");
                    }
                    else
                    {
                        System.out.println("Awesome !!! You Guessed it right .");
                        score++;
                        break;
                    }
                    attempts++;
                }while(attempts<=totalattempts);

                if(attempts > totalattempts)
                {
                    System.out.println("Your attempts are over  :(");
                    System.out.println("No. was " + randomno);
                }
                
                System.out.println();
                System.out.println();

                try 
                {
                    Thread.sleep(2000);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }

                i++;
            }
            System.out.println("Your score is  " + score);

            switch (score) 
            {
                case 0:
                    System.out.println("Nice try!");
                    break;
                case 1:
                    System.out.println("Good performance !!!");
                    break;
                case 2:
                    System.out.println("Great performance !!!");
                    break;
                case 3:
                    System.out.println("Outstanding performance !!!");
                    break;
                default:
                    break;
            }
            System.out.println();
            System.out.println();
            System.out.println("Hope you had fun! :)");
            System.out.println();
        }
        else
        {
            System.out.println("see you next time...");
        }
        sc.close();
    }
}
