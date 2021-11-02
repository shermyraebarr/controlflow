
public class AschiChars {
    public static void main(String[] args){
        System.out.println("The valid numbers are: ");
        printNumbers();
        System.out.println("The valid lowercase letters are: ");
        printLowerCase();
        System.out.println("The valid uppercase letters are: ");
        printUpperCase();
    }
    public static void printNumbers(){
        // nums 48-57
        for (int i = 48; i < 57; i++) {
            System.out.println((char)i);
        }
        System.out.println((char)57 + "\n");

    }
    public static void printLowerCase() {
        // valid lowercase 
        for (int i = 97; i <= 122; i++) {
            System.out.println((char)i);
        }
            System.out.println();
    }
        public static void printUpperCase() {
            //valid uppercase 
            for(int i = 65; i < 90; i++) {
                System.out.println((char)i + " ");
            }
            System.out.println((char)90 + "\n");
        }        
 }

