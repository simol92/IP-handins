package Handin6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import org.w3c.dom.ls.LSException;

public class ShoppingList {

private ArrayList<Integer> amount1 = new ArrayList<>();
private ArrayList<String> unitandname = new ArrayList<>();

private ArrayList<Integer> amount2 = new ArrayList<>();
private ArrayList<String> unitandname2 = new ArrayList<>();


    public ShoppingList(){
    
    }
    
    public ArrayList<String> setAvailable(int amount, String unit, String name){
        ArrayList<String> setavailable = new ArrayList<>();

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
            setavailable.add(amount1.get(i) + " " + unitandname.get(i));
        }
        
        return setavailable;
    }
    public ArrayList<String> compareAwithR(){
        ArrayList<String> newrecipe = new ArrayList<>();
        ArrayList<String> compare1 = new ArrayList<>();
        int amount = 0;

        for(int l = 0; l < unitandname2.size(); l++) {
            // are there duplicates?
            if (unitandname2.contains(unitandname2.get(l))){
                for(int k = 0; k < unitandname2.size(); k++){
                    if(unitandname2.get(l).contains(unitandname2.get(k))){
                        if(amount2.get(l) > amount2.get(k)) {

                            amount = amount2.get(l) - amount2.get(k);
                        } else {
                            amount = amount2.get(k) - amount2.get(l);
                    
                
            }}}} 

    for(int i = 0; i < unitandname2.size(); i++){
        if(unitandname.contains(unitandname2.get(i))){
            for(int j = 0; j < unitandname.size(); j++){
                if(unitandname2.get(i).contains(unitandname.get(j))){
                    if(amount1.get(j) < (amount2.get(i))){
                        int result1 = amount2.get(i) - amount1.get(j);
                        String result = "";
                        result += String.valueOf(result1).concat(" " + unitandname2.get(i));
                        compare1.add(result);
                    } 

                } 
            }
        } else {
            int result1 = amount2.get(i);
            String result = "";
            result += String.valueOf(result1).concat(" " + unitandname2.get(i));
            compare1.add(result);
        }
    }

        return compare1;
    }    
    
  
    public ArrayList<String> setRecipe(int amount, String unit, String name){
        ArrayList<String> setrecipe = new ArrayList<>();

        if(unit.equalsIgnoreCase("kg")){
            unit = "g";
            amount = amount * 1000;
            amount2.add(amount);
            unitandname2.add(unit + " " + name);
        } else {
            amount2.add(amount);
            unitandname2.add(unit + " " + name);
        }
        for(int i = 0; i < Math.min(amount2.size(), unitandname2.size()); i++){
            setrecipe.add(amount2.get(i) + " " + unitandname2.get(i));
        }

        return setrecipe;
    }

    

    public void printShoppingList(ArrayList<String> input){
        
        System.out.println("Shopping List: ");
        Collections.sort(input);
        for(int i = 0; i < input.size(); i++){
            System.out.println(input.get(i));
        }

    }

    
   

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            
            ShoppingList l1 = new ShoppingList();

            String available = input.next();
            // while(input.hasNextInt() && input.hasNext() && input.hasNext()){
                
                l1.setAvailable(input.nextInt(), input.next(), input.next());
                l1.setAvailable(input.nextInt(), input.next(), input.next());
                l1.setAvailable(input.nextInt(), input.next(), input.next());
                l1.setAvailable(input.nextInt(), input.next(), input.next());
                
                // if(input.hasNext().isEmpty())
                
            // }

            // while(input.hasNextLine()){
            String recipe = input.next();
            int recipenr = input.nextInt();
            
            // while(input.hasNextInt() && input.hasNext() && input.hasNext()){

                l1.setRecipe(input.nextInt(), input.next(), input.next());
                l1.setRecipe(input.nextInt(), input.next(), input.next());
                l1.setRecipe(input.nextInt(), input.next(), input.next());
                  l1.setRecipe(input.nextInt(), input.next(), input.next());
             
                  String recipe2 = input.next();
                  int recipenr2 = input.nextInt();
                  
                  // while(input.hasNextInt() && input.hasNext() && input.hasNext()){
      
                      l1.setRecipe(input.nextInt(), input.next(), input.next());
                      l1.setRecipe(input.nextInt(), input.next(), input.next());
                      l1.setRecipe(input.nextInt(), input.next(), input.next());
                        l1.setRecipe(input.nextInt(), input.next(), input.next());
                        l1.setRecipe(input.nextInt(), input.next(), input.next());
                
            // }}

            l1.printShoppingList(l1.compareAwithR());






        }


    }