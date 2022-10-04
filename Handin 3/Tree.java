public class Tree {
    private int age;
    private double height;
    private double growthPct; 
    
       public Tree (double growthPct) {
        height = 0.25;
        age = 1;
        this.growthPct = growthPct;
       }

       public String toString() {
        return "Tree(age = " + age + ", height = " + height + ")"; 

       } 
       public void growOneYear() {
        this.age = age + 1; 
        if (this.height < 20.0) {
        this.height = height * (1 + this.growthPct / 100);
        } if (height > 20) {this.height = 20;}
       
            
        }
        
}







