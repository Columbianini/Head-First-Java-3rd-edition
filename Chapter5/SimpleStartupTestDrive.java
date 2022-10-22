import java.util.Random;
import java.util.*;
public class SimpleStartupTestDrive {
    // public static void main(String[] args) {
    //     SimpleStartup simpleStartup = new SimpleStartup();
    //     int[] myLoc = new int[]{2, 3, 4};
    //     simpleStartup.setLocationCells(myLoc);
    //     int userGuess = 2;
    //     String result = simpleStartup.checkYourself(userGuess);
    //     String testResult = "failed";
    //     if (result.equals("hit")){
    //         testResult = "passed";
    //     }
    //     System.out.println(testResult);
    // }
    public static void main(String[] args) {
        int numOfGuesses = 0;
        Random rand = new Random(42);
        int randomNum = rand.nextInt(5);
        int[] myLoc = new int[3];
        for(int i=0;i<myLoc.length;i++){
            myLoc[i] = randomNum++;
        }
        SimpleStartup game = new SimpleStartup();
        game.setLocationCells(myLoc);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.print("enter a number: ");
            int userGuess = sc.nextInt();
            numOfGuesses++;
            String result = game.checkYourself(userGuess);
            if(result=="kill"){
                break;
            }
        }
        System.out.println("You took "+ Integer.toString(numOfGuesses) + " guesses");
    }
}
