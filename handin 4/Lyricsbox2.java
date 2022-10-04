import java.util.Scanner;

public class Lyricsbox2 {

    private int number;
    private String container;
    private String drink;
    private String middle;
    private Scanner input = new Scanner(System.in);
    
        public Lyricsbox2() {
        number = input.nextInt();
        container = input.next();
        middle = input.next();
        drink = input.next();
    
        }
        private String removeLastChar()    {
        return container.substring(0, container.length() - 1);  
    
        }
        public void printAll(){
            
    
            while (number > 2){
                System.out.println(number + " " + container + " " + middle + " " + drink + " on the wall");
                System.out.println(number + " " + container + " " + middle + " " + drink);
                System.out.println("Take one down, pass it around");
                System.out.println((number-1) + " " + container + " " + middle + " " + drink + " on the wall");
                System.out.println();
                number--;
            }
                System.out.println("2 " + container + " " + middle + " " + drink + " on the wall");
                System.out.println("2 " + container + " " + middle + " " + drink);
                System.out.println("Take one down, pass it around");
                System.out.println("One " + removeLastChar() + " " + middle + " " + drink + " on the wall");
                System.out.println();
                System.out.println("One " + removeLastChar() + " " + middle + " " + drink + " on the wall");
                System.out.println("One " + removeLastChar() + " " + middle + " " + drink);
                System.out.println("Take one down, pass it around");
                System.out.println("No more " + container + " " + middle + " " + drink + " on the wall");
        }
    
        
    }
