import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Hello " + name);
        

        //powerball array 
        int[] lottery = new int[5];
        int magicNumber;

        System.out.println("\n Would you like to continue to the interactive portion? " + name + "? (yes / no) ");
        String ans = input.nextLine();

        boolean toContinue = true;
        if (ans.equals ("no")) {
            toContinue = false;
            System.out.println("Please return later to complete the survey.");
        }
        while (toContinue) {
            System.out.println("We will gather some information from you to generate your winning numbers. ");
            

            //questions

            //fav pet
            System.out.println("\n What is the name of your favorite pet? ");
            String favPet = input.nextLine();

            //fav pet age 
            System.out.println("\n What is the age of your favorite pet? ");
            int petAge = input.nextInt();
            input.nextLine();

            //fav number
            System.out.println("\nEnter your favorite number: ");
            int favNum = input.nextInt();
            input.nextLine();
        
            int quartNum = 0;
            System.out.println("\n Do you have a favorite quarterback? (yes/no): ");
            String favQback = input.nextLine();
            if (favQback.equals ("yes")) {
                System.out.println("\n What is their jersey number? ");
                quartNum = input.nextInt();
                input.nextLine();
            } else {
                System.out.println("Thats fine, we'll just use your favorite number.");
            }

            //more questions

            System.out.println("\n What is the 2-digit model year of your car?");
            int carYear = input.nextInt();
            input.nextLine();

            System.out.println("\nWhat is the first name of your favorite actor/actress?");
            String favAct = input.nextLine();

            System.out.println("\nEnter a random number between 1 and 50: ");
            int ranNum = input.nextInt();
            input.nextLine();

            System.out.println("This is the end of the questionnaire!");
            System.out.println("Would you like to do the questions again and find out your answers? (redo/end)");
            String endofQues = input.nextLine();

           if (favQback.equals("yes")){
               lottery[0] = getLotteryZero(quartNum, petAge, favNum);
               magicNumber = getMagicNumber(quartNum);
           } else {
               lottery[0] = getLotteryZeroNoQuart(petAge, favNum);
               magicNumber = getMagicNumber(ranNum);
           }

           lottery[1] = getLotteryOne(favPet);

           lottery[2] = getLotteryTwo(ranNum, carYear);

           lottery[3] = getLotteryThree(ranNum);

           lottery[4] = getLotteryFour(favAct);

           if (endofQues.equals("redo")) {
               System.out.println("..preparing for next questionaire...");
            } else {
                toContinue = false;
                System.out.println("...building your results...");
            

                Arrays.sort(lottery);
                System.out.println("Lottery numbers: " + Arrays.toString(lottery));
                System.out.println("Magic ball: " + magicNumber);
            
            }

    }
    input.close();
    }

    public static int getLotteryZero(int quart, int pet, int lucky) {
        int total = quart + pet + lucky;
        while (total > 75) {
            total -= 75;
        }
        return total;
    }

    public static int getLotteryZeroNoQuart(int pet, int lucky) {
        int total = pet + lucky;
        while (total > 75) {
            total -= 75;
        }
        return total;
    }

    public static int getLotteryOne(String pet) {
        int charAtThree = (int) pet.charAt(2);
        while (charAtThree > 75) {
            charAtThree -= 75; 
        }
        return charAtThree;
    }

    public static int getLotteryTwo(int car, int num) {
        int total = car + num;
        while (total > 75) {
            total -= 75;
        }
        return total;
    }

    public static int getLotteryThree(int favNum) {
        return favNum;
    }

    public static int getLotteryFour(String favAct) {
        int first = (int) favAct.charAt(0);
        while (first >75) {
            first -= 75;
        }
        return first;
    }

    public static int getMagicNumber(int num) {
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        num *= n;
        while (num > 75) {
            num -= 75;
        }
        return num;
    }  
  
}   


    



