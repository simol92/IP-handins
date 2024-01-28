import java.util.ArrayList;
import java.util.List;

public class Order implements CreditCard{

    protected List<Food> ordered;

    public Order(){
        ordered = new ArrayList<>();
    }

    public void addFood(Food food){
        
        ordered.add(food);
    }

    public int total(){
        int amount = 0; 

        for (Food food : ordered) {
            amount += food.getPrice();
        }

        return amount;
    }   

    public void display(){

        for (Food food : ordered) {
            food.display();
        }
        System.out.println("\n" + total() + " kr TOTAL");

    }

    
    public boolean payWith(CreditCard card){
       boolean success = card.withdraw(total());

       if(success){
        return true;
       } else {
        System.out.println("ERROR: Payment failed");
        return false;
       }

    }

    @Override
    public boolean withdraw(int amount) {
        return true;
    }

}
