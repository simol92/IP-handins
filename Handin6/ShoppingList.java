package Handin6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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
    //arraylist input --> a way to put the sorted recipe arraylist into 
    public ArrayList<String> compareAwithR(){
        ArrayList<String> compare1 = new ArrayList<>();
        
        //Trying to loop over each "g (name)", when finding those who are the same, their amounts will get subtracted from each other. 
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

    public void sortoutRecipe(){
    ArrayList<String> newrecipelist = new ArrayList<>();
    int amount = 0;
    String name = "";
    
    for(int l = 0; l < unitandname2.size()-1; l++) {
        // are there duplicates?
        if (unitandname2.contains(unitandname2.get(l))){
            for(int k = 0; k < unitandname2.size()-1; k++){
                if(unitandname2.get(l).contains(unitandname2.get(k))){
                    if(amount2.get(l).equals(amount2.get(k))) {
                        if(unitandname2.get(k).equals(unitandname2.get(l))){
                                unitandname2.remove(unitandname2.get(k));
                                
                                name = unitandname2.get(l);
                                amount = (amount2.get(l) + amount2.get(k));
                            
                                amount2.remove(amount2.get(k));
                                amount2.remove(amount2.get(l));

                                unitandname2.add(name);
                                amount2.add(amount);
                        } else {
                            name = unitandname2.get(k);
                            amount = (amount2.get(k));
                
                            unitandname2.remove(unitandname2.get(k));
                            amount2.remove(amount2.get(k));
                
                            unitandname2.add(name);
                            amount2.add(amount);
                            System.out.println(name +" "+ amount);
                        }
                      
                        
                    // } else {
                    //         name = unitandname2.get(k);
                    //         amount += amount2.get(k);
                    //         System.out.println(amount + " " + name);
                    //         unitandname2.remove(unitandname2.get(k));
                    //         unitandname2.remove(unitandname2.get(l));
                    //         amount2.remove(amount2.get(k));
                    //         amount2.remove(amount2.get(l));
    
                    //         unitandname2.add(name);
                    //         amount2.add(amount);
    
                    //         System.out.println(amount + " " + name);
                    // }
            
        } else {

            name = unitandname2.get(k);
            amount = (amount2.get(l) + amount2.get(k));
         
            unitandname2.remove(unitandname2.get(k));
            unitandname2.remove(unitandname2.get(l));
            amount2.remove(amount2.get(k));
            amount2.remove(amount2.get(l));

            unitandname2.add(name);
            amount2.add(amount);
            
            // unitandname2.remove(unitandname2.get(k));
            // amount2.remove(amount2.get(k));
       
    
            
        }
    }}}}
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