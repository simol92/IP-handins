import java.util.ArrayList;

public class Forest {
    
    private ArrayList<Tree> trees;
    // The constructor creates an array of type Tree class
    public Forest() {
     trees = new ArrayList<>();  
    } 
    // This mutator method creates a tree object inside the array
    public void addTree(int growthPct) {
        trees.add(new Tree(growthPct));
    } 
    // This access method returns a String thats concatenated both the Forest toString and all the trees toString inside the array via external method call
    public String toString(){

        String result = "Forest(";
        
        for (Tree tree : trees) {
            result = result + tree.toString();
        }
        result = result + ")";
        return result;
    } 
    // this mutator method grows all the trees inside the forest via a for each loop and external method call
    public void growOneYear(){
        for(Tree tree : trees) {
            tree.growOneYear();
      } 
    }
}
    