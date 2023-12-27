package Task_Week_1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        System.out.println("************ Number prediction game ************");
        // Create a scanner object of the Scanner Class
        Scanner read = new Scanner(System.in);
        // Declare and initialize a flag in order to play the game
        String play = "YES";


        // while loop -1 : Do the user wants to play the game?
         while(play.equals("YES")){
             // Since Random class is present in the util package
             Random randomNum = new Random();
             int randNum = randomNum.nextInt(10); // Specify the bound of the random numbers (the end range)
              //
             int count = 0;
             int predictedNum = -1;
             int chance = 3;


             while((predictedNum != randNum) && (count != chance)){ // bcz predictedNum = -1

                 System.out.println("Guess the number between 0 to 10: ");
                 predictedNum = read.nextInt();
                 chance--;

                 if(predictedNum == randNum){
                     System.out.println("Congratulations, Your are right!");
                     System.out.println("Do you wish to play again: YES / NO ?");
                     play = read.next().toUpperCase();
                 }

                 else if(predictedNum > randNum){
                     System.out.println("Your prediction is high"); // this means that the correct answer is less than the current predicted number
                     System.out.println(chance+" "+"chance(s) more");
                 }
                 else{
                     System.out.println("Your prediction is low"); // this means that the correct answer is more than the current predicted number
                     System.out.println(chance+" "+"chance(s) more");
                 }

             }

         }
        read.close();
    }
}
