import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * @author Simon Olafsson
 */

public class ProfanitFilter {
// private ArrayList<String> lines = new ArrayList<>();
private List<String> swearwords = new ArrayList<>();

    public ProfanitFilter(String input) {
        swearwords = List.of(input.split(" "));   
    }

/*
 *   String punctuationMarks = "[.!?,\\-]";
        String wordWithoutPunctioationMarks = word.replaceAll("\\p{Punct}", "");
        if(swearwords.contains(wordWithoutPunctioationMarks)){
            return true;
        }
        else  {
            return false;
        }
 */
public boolean isSwearWord(String s, List<String> l){
    String word = s.replaceAll("\\p{Punct}", "");
    for (String string : l){
       if (string.equalsIgnoreCase(word)){
           return true;
        }
    }
   return false;
 }
    
    public boolean notSwearWord(String word){
        String wordWithoutPunctioationMarks = word.replaceAll("\\p{Punct}", "");
        if(swearwords.contains(wordWithoutPunctioationMarks)){
            return true;
        }
        else  {
            return false;
        }
    }
            

    public String ReplaceWord(String wordToBeReplaced){
        String BuildingBlock = "*&#$%";

        String censoredword = wordToBeReplaced;

        int indexOfWordToBeRaplaced = 0;
        int indexOfBuildingBlock = 0;
        //replacing characters in wordToBeReplaced with symbols from buildingblock

        for(int i=0; i<wordToBeReplaced.length(); i++){
            //get symbol from buildingblock and replacing characters from wordtobereplaced with symbols from buildingblock
            String character = "" + censoredword.charAt(indexOfWordToBeRaplaced); //This lines converts the character to a string because the regex below needs a string and not a char.
            //if character does NOT contain punctuationmarks
            if(!Pattern.matches("\\p{Punct}", character)){
                    censoredword = censoredword.substring(0, indexOfWordToBeRaplaced) + BuildingBlock.charAt(indexOfBuildingBlock) + censoredword.substring(indexOfWordToBeRaplaced+ 1);
            }
            indexOfWordToBeRaplaced++;
            
            //If end of building block is reached then start from startfuck
            if(indexOfBuildingBlock==BuildingBlock.length()-1){
                indexOfBuildingBlock=0;
            }
            else{
                indexOfBuildingBlock++;
            }
        
        } 
         return censoredword;}
       
    

    

    //using isSwearWord and ReplaceWord methods to filter out the swearwords with symbols
    public void fixAndPrintLine(String line){
        String censoredLine = "";

        //Split line into words that we can work with
        String[] wordsInLine = line.split(" ");
        
        //Replace all swearword in this line
        for (String word : wordsInLine) {
            if(isSwearWord(word,swearwords)){
                //Build new line without censur
                censoredLine = censoredLine + ReplaceWord(word) + " ";
            }
            else{
                //Build new line with censur
                censoredLine = censoredLine + word + " ";
            }
        }
        //Print
        System.out.print(censoredLine);
    }
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ProfanitFilter filter = new ProfanitFilter(input.nextLine());
        String scannedLine = "";
        while(input.hasNextLine()){
            //Read line
            scannedLine += input.nextLine() + " ";
            //Fix and print line
        }
        filter.fixAndPrintLine(scannedLine);
    }
}
