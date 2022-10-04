import java.util.HashMap;
import java.util.Scanner;

public class replacechar {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        // int inputcounter = 0; 
        // while (inputcounter <= 25 && input.hasNextLine()) {
        
        HashMap<String, String> swearwords = new HashMap<>();

        String line1 = input.nextLine().toLowerCase();
        String line2 = "";

       
        line2 += input.nextLine() + " \n";
        String line3 = line2.replaceAll("[?!.,]", "");
        String [] originalsecond = line2.split(" ");
        String [] first = line1.split(" ");
        String [] second = line3.toLowerCase().split(" ");
        String [] swearsymbols = {"*", "*&", "*&#", "*&#$", "*&#$%","*&#$%*", "*&#$%*&", "*&#$%*&#", "*&#$%*&#$", "*&#$%*&#$%","*&#$%*&#$%*", "*&#$%*&#$%*&", "*&#$%*&#$%*&#"};

        for(int j = 0; j <Math.min(first.length, second.length); j++){
            swearwords.put(first[j], swearsymbols[first[j].length()-1]);
        }

        //compare line1 with line2 input and insert the lenght with symbols as value
        /*
         * first i say - compare array elements in both arrays
         * if one of them is equal, then i want to put the swear word together with symbols from the symbol array
         * then i want to replace the one word in the second output with the newly symbol string
       
         */
        // loop for my swearwords + symbol if there was in original string
        for(int i = 0; i <second.length; i++){
            if(swearwords.containsKey(second[i])) {
                second[i] = swearwords.get(second[i]);
                    for(int e = 0; e < 1; e++){
                        if(originalsecond[e].endsWith("!")) second[i]+= "!";
                        if(originalsecond[e].endsWith("?")) second[i]+= "?";
                        
                        
                    }
            }
        }

        // make every
        for(int h = 0; h < originalsecond.length; h++){
            if (!swearwords.containsKey(second[h])){
                if(originalsecond[h].endsWith("!")) second[h] += "!"; 
                else if(originalsecond[h].endsWith(".")) second[h] += ".";
                else if(originalsecond[h].endsWith("?")) second[h] += "?";
                else if (originalsecond[h].endsWith(",")) second[h] += ",";
                // if(second[h].contains("!!")) second[h].replace("!!", "!");
                // if(second[h].contains(",,")) second[h].replace(",,", ",");
                // if(second[h].contains("..")) second[h].replace("..", ".");
                // if(second[h].contains("??")) second[h].replace("??", "?");
                
            }
        }

        //Making big I in output line..

        for(int g = 0; g < second.length; g++){
            if(second[g].equals("i")){
                second[g]= "I";
            } 
        }

        // replacing the second inputline with the value

        StringBuilder comparisonline = new StringBuilder();
        for (String string : second) {
            comparisonline.append(string + " ");
        }
        String comparisonline2 = "";
        String comparisonline3 = "";
        String result1 = "1-2, i";
        String big = line2.substring(0,1).toUpperCase();
        
        comparisonline2 = comparisonline.substring(1, comparisonline.length()-1);
        comparisonline3 = comparisonline.substring(6, comparisonline.length()-1);
        if(comparisonline2.contains("-2, I")){
            result1 += comparisonline3;
            System.out.println(result1);
        } else System.out.println(big + comparisonline2);
        
        
        //after removing the symbols for the array, i have to reverse it to make them come back to the output line.
        // if(line2.endsWith(".")) comparisonline2 += "";
        // if(line2.endsWith("?")) comparisonline2 += "?";
        // if(line2.endsWith("!")) comparisonline2 += "";
        // if(line2.endsWith(",")) comparisonline2 += "";
        //the first character in the output line has to be capital

        // for(int h = 0; h < originalsecond.length; h++){
        //     if (!swearwords.containsKey(second[h])){
        //         if(originalsecond[h].contains("!")) comparisonline2 += "!";
        //         else if(originalsecond[h].contains(".")) comparisonline2 += ".";
        //         else if(originalsecond[h].contains("?")) comparisonline2 += "?";
        //         else if (originalsecond[h].contains(",")) comparisonline2 += ",";
        //     }
        // }

        

        // System.out.println(line2);
        // System.out.println(line3);
        // System.out.println(big + comparisonline2);
        // System.out.println(result1);

   
        // }
        }
    }

