import java.util.ArrayList;
import java.util.List;

public class Pizza extends Food {

// god huskeregel, sæt dit interface på venstre side og klassen, der bruger interfacet på højre
// fx. List <String> toppings = new ArrayList()

protected List<String> toppings;
protected boolean emptypizza = true;

    public Pizza(){
        super("Pizza", 45);
        toppings = new ArrayList<>();
    }

    public void addTopping(String topping){

        toppings.add(topping);
        increasePrice(10);
        emptypizza = false;

    }

    public void setName(String name){
        this.name = name;

    }

    @Override
    public void display(){
    
        if(emptypizza){
            
            System.out.println(price + " kr " + name + " { }");

        } else{
            
            String seperator = "";
            System.out.print(price + " kr " + name + " { ");
            for (String topping : toppings) {
                
                System.out.print(seperator + topping);
                seperator = ", ";
            }
            
            System.out.print(" }");

        }

    }
}
