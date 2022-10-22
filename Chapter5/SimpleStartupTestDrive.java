import java.util.Random;
import java.util.*;
public class SimpleStartupTestDrive {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        Random rand = new Random(42);
        int randomNum = rand.nextInt(5);
        ArrayList<Integer> myLoc = new ArrayList<Integer>();
        for(int i=0;i<3;i++){
            myLoc.add(randomNum++);
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
