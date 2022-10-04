package Handin6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Spl {

private ArrayList<Integer> amount1 = new ArrayList<>();
private ArrayList<String> unitandname = new ArrayList<>();
private HashMap<String, Integer> available = new HashMap<>();

private ArrayList<Integer> amount2 = new ArrayList<>();
private ArrayList<String> unitandname2 = new ArrayList<>();
private HashMap<String, Integer> recipe = new HashMap<>();

HashMap<String, Integer> sortedrecipe = new HashMap<>();

    public Spl(){
    
    }
    
    public void setAvailable(int amount, String unit, String name){

        if(unit.equalsIgnoreCase("kg")){
            unit = "g";
            amount = amount * 1000;
            amount1.add(amount);
            unitandname.add(unit + " " + name);
        } else {
            amount1.add(amount);
            unitandname.add(unit + " " + name);
        }
        for(int i = 0; i < Math.min(amount1.size(), unitandname.size()); i++){
            available.put(unitandname.get(i),amount1.get(i)) ;
        }

    }   
  
    public void setRecipe(int amount, String unit, String name){
        String unitandname = "";

        // if unit is equal to kg, replace it with g and change amount to amount*1000 and add to the two arraylists
        if(unit.equalsIgnoreCase("kg")){
            unit = "g";
            amount = amount * 1000;
            unitandname += unit + " " + name;
            amount2.add(amount);
            unitandname2.add(unitandname);

        // if unit is equal to g, just add to the arraylists 
        } else {
            unitandname += unit + " " + name;
            amount2.add(amount);
            unitandname2.add(unitandname);
        }
        
        // if unitandname already exist in the map, add old and new value together
        for(int i = 0; i < unitandname2.size(); i++){
            if(unitandname.equals(unitandname2.get(i))){
                    // if the old amount is higher than the new --> the value will be (old minus new)

                    if(amount2.get(i) > amount){
                        recipe.replace(unitandname2.get(i), amount2.get(i), amount2.get(i)-amount);

                    // if the old amount is lower than the new --> the value will be (new minus old)
                    } else if (amount2.get(i) < amount){
                        recipe.replace(unitandname2.get(i), amount2.get(i), amount - amount2.get(i));

                    // if the old amount equal to the the new --> the value will be the same   
                    } else if (amount2.get(i) == amount){
                        recipe.replace(unitandname2.get(i), amount2.get(i), amount2.get(i));
                    } 

        // in unitandname does not exist in the map, just add to map.
            } else recipe.put(unitandname2.get(i),amount2.get(i));
        }

        
    }
    public void compareRecipeWithAvailable(){
            
            
        }    
        
    public HashMap<Integer, String> reversemap(HashMap<String, Integer> recipe){

        //when we're done with the comparing the two hashmaps, we need to swap the keys and values to be presented correctly
            HashMap<Integer,String> rev = new HashMap<>();

            for(HashMap.Entry<String,Integer> entry : recipe.entrySet())
                rev.put(entry.getValue(), entry.getKey());

        return rev;
    }

    public void printShoppingList(){
        ArrayList<String> shoppinglist = new ArrayList<>();
        System.out.println("Shopping List: ");
        
        for (HashMap.Entry<Integer, String> entry : reversemap(sortedrecipe).entrySet()) {

            shoppinglist.add(entry.getKey() + " " + entry.getValue());
        }

        for (String string : shoppinglist) {
            System.out.println(string);
        }

    }

    
   

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            
            ShoppingList l1 = new ShoppingList();

            String available = input.next();
            // while(input.hasNextInt() && input.hasNext() && input.hasNext()){
                
                l1.setAvailable(input.nextInt(), input.next(), input.next());
                // l1.setAvailable(input.nextInt(), input.next(), input.next());
                // l1.setAvailable(input.nextInt(), input.next(), input.next());
                // l1.setAvailable(input.nextInt(), input.next(), input.next());
              
                // if(input.hasNext().isEmpty())
                
            // }

            // while(input.hasNextLine()){
            String recipe = input.next();
            int recipenr = input.nextInt();
                l1.setRecipe(input.nextInt(), input.next(), input.next());
                l1.setRecipe(input.nextInt(), input.next(), input.next());
                
                // l1.setRecipe(input.nextInt(), input.next(), input.next());
                // l1.setRecipe(input.nextInt(), input.next(), input.next());
            // String recipe2 = input.next();
            // int recipenr2 = input.nextInt();

            //     l1.setRecipe(input.nextInt(), input.next(), input.next());
            //     l1.setRecipe(input.nextInt(), input.next(), input.next());
                // l1.setRecipe(input.nextInt(), input.next(), input.next());
                // l1.setRecipe(input.nextInt(), input.next(), input.next());
                // l1.setRecipe(input.nextInt(), input.next(), input.next());
           
            l1.sortoutRecipe();


            l1.printShoppingList(l1.compareAwithR());






        }


    }

