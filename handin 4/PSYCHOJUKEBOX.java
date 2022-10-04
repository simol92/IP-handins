import java.util.Scanner;

public class PSYCHOJUKEBOX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //assigning variables to input files
        int ANTAL = input.nextInt();
        String BEHOLDER = input.next();
        String AF = input.next();
        String SPRITZ = input.next();

        // creating a new BEHOLDER string without the s at last
        // removing the last char via substring method from BEHOLDER

        String BEHOLDERUDENS = BEHOLDER.substring(0, BEHOLDER.length()-1); 

        //forloop for printing down to 2
        for(int i = ANTAL; i > 2; i--){
            System.out.println(i + " " + BEHOLDER + " " + AF + " " + SPRITZ + " on the wall");
            System.out.println(i + " " + BEHOLDER + " " + AF + " " + SPRITZ);
            System.out.println("Take one down, pass it around");
            System.out.println((i-1) + " " + BEHOLDER + " " + AF + " " + SPRITZ + " on the wall");
            System.out.println();
        }
        System.out.println("2 " + BEHOLDER + " " + AF + " " + SPRITZ + " on the wall");
        System.out.println("2 " + BEHOLDER + " " + AF + " " + SPRITZ);
        System.out.println("Take one down, pass it around");
        System.out.println("One " + BEHOLDERUDENS + " " + AF + " " + SPRITZ + " on the wall");
        System.out.println();
        System.out.println("One " + BEHOLDERUDENS + " " + AF + " " + SPRITZ + " on the wall");
        System.out.println("One " + BEHOLDERUDENS + " " + AF + " " + SPRITZ);
        System.out.println("Take one down, pass it around");
        System.out.println("No more " + BEHOLDER + " " + AF + " " + SPRITZ + " on the wall");

        input.close();
    }
}
