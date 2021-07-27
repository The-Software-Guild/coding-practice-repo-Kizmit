
import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * @date  7/26/21
 */
public class LuckySevens {
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many whole dollars do you have? ");
        int startingAmount = Integer.parseInt(scanner.nextLine());
        playGame(startingAmount);
    }
    
    static void playGame(int startingAmount){
        Random rng = new Random();
        int die1, die2, currentAmount, maxAmount, maxAmountRollCount, rollCount;
        
        currentAmount = startingAmount;
        maxAmount = startingAmount;
        rollCount = 0;
        maxAmountRollCount = 0;
        
        while(currentAmount > 0){
            rollCount++;
            
            die1 = rng.nextInt(5) + 1;              //Roll the dice
            die2 = rng.nextInt(5) + 1;
            
            if(die1 + die2 == 7){
                currentAmount += 4;                 //Player wins 4 dollars
            }
            else{
                currentAmount -= 1;                 //Player loses 1 dollar
            }
            
            if(currentAmount > maxAmount){          //Track highest earned amount
                maxAmount = currentAmount;
                maxAmountRollCount = rollCount;
            }
        }
        
        //Output results
        System.out.println("You are broke after " + rollCount + " rolls.");
        System.out.println("You should have quit after " + maxAmountRollCount + " rolls when you had $" + maxAmount);
    }
}
