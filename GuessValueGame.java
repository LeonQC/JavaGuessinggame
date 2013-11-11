/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package guessvalue;
import java.io.FileReader;
import java.util.*;
/**
 *
 * @author ContEd Student
 */
public class GuessValueGame 
{

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws java.io.FileNotFoundException 
    {
        // TODO code application logic here

        Scanner inFile=new Scanner(new FileReader("value.txt"));
        Scanner console=new Scanner(System.in);
        int targetValue;
        targetValue=inFile.nextInt();
        inFile.close();

        boolean requestExit=false;
        while(!requestExit)
        {
            System.out.println("Guess the secret value in magic file(1-100):");
            
            boolean success=false;
            int guessTimes=5;
            while(!success && guessTimes>0 )
            {
                int input=0;
                input=console.nextInt();

                if (input>targetValue)
                {
                    if(1==guessTimes)
                        System.out.println("The value is less than "+input+".");
                    else
                        System.out.println("The value is less than "+input+". Guess again:");
                }
                else
                    if(input<targetValue)
                    {
                        if(1==guessTimes)
                            System.out.println("The value is greater than "+input+".");
                        else
                            System.out.println("The value is greater than "+input+". Guess again:");
                    }
                    else if(input==targetValue)
                    {
                        System.out.println("Congratulations! You got it!");
                        success=true;
                        requestExit=true;                        
                    }
                guessTimes--;
            }

            if(!success)
            {                            
                System.out.println("Unfortunetely. You lost :(");                 
                System.out.println("Do you want to try again... Y/N?");
                
                String guessAgain;
                guessAgain=console.next();                
                if(guessAgain.equalsIgnoreCase("N")) requestExit=true;
            }
                

        }
    }
}
