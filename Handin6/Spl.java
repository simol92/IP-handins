package Handin6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Spl {

private ArrayList<Integer> amount1 = new ArrayList<>();
private ArrayList<String> unitandname = new ArrayList<>();
private HashMap<String, Integer> available = new HashMap<>();

private ArrayList<Integer> amount2 = new ArrayList<>();
private ArrayList<String> unitandname2 = new ArrayList<>();
private HashMap<String, Integer> recipe = new HashMap<>();
private HashMap<String, Integer> sortedrecipe = new HashMap<>();

        public Spl(){
        
        }
        
        public void setAvailable(int amount, String unit, String name){
        String uae1 = unit + " " + name;


            if(unit.contains("kg")){
                unit = "g";
                amount = amount * 1000;
                uae1 = unit + " " + name;
                amount1.add(amount);
                unitandname.add(uae1);
                available.put(uae1, amount);
               
            } else {
                amount1.add(amount);
                unitandname.add(uae1);
                available.put(uae1, amount);
                
            }
        }   
        // VIRKER!!
        public void removeduplicates(int amount, String unit, String name){
            String duplicates = unit + " " + name;
            int amounttt = 0;
            int size = unitandname2.size()-1;
            
            for(int i = 0; i<unitandname2.size()-1; i++){
                if(unitandname2.get(i).contains(duplicates)){
                    unitandname2.add(duplicates);
                    unitandname2.remove(unitandname2.get(i));
                    
                            amounttt += amount2.get(i)+amount;
                            amount2.add(amounttt);
                            amount2.remove(amount2.get(i));

                            // if(amount2.get(i) > amount){
                            //     System.out.println(amount2.get(i)+amount);
                            //     amount2.add(amount2.get(i)+amount);
                            //     recipe.replace(duplicates, amount2.get(i), amount2.get(i)+amount);
                               
                            //     amount2.remove(amount2.get(i));
                            //     System.out.println("1");
                            // } else if (amount2.get(i) < amount) {
                            //     amount2.add(amount2.get(i)+amount);
                            //     System.out.println(amount2.get(i)+amount);
                            //     recipe.replace(duplicates, amount2.get(i), amount2.get(i)+amount);
                               
                            //     amount2.remove(amount2.get(i));
                                
                            //     System.out.println("2");
                            // } else if (amount2.get(i) == amount) {
                            //     System.out.println(amount2.get(i)+amount);
                            //     amount2.add(amount+amount);
                            //     recipe.replace(duplicates, amount2.get(i), amount+amount);
                                
                            //     amount2.remove(amount2.get(i));
                            //     System.out.println("3");
                            // }

                        // } else if (amount2.get(i) < amount){
                            
                        //     amount2.add(amount+amount2.get(i));
                        //     recipe.replace(duplicates, amount2.get(i), amount+amount2.get(i));
                           
                        //     amount2.remove(amount2.get(i));
                        //    System.out.println("2");

                        }
                
           }

        
        }

        //VIRKER!!
        public void setRecipe(int amount, String unit, String name){
            String unitandname3 = unit + " "+ name;
                
                if(unit.equalsIgnoreCase("kg")){
                    unit = "g";
                    amount = amount * 1000;
                    unitandname3 = unit + " " + name;
                    if(unitandname2.contains(unitandname3)){
                        removeduplicates(amount, unit, name);
                        
                    } else {
                        
                    amount2.add(amount);
                    unitandname2.add(unitandname3);
                    recipe.put(unitandname3, amount);
                }
                    
                } else {
                    
                    if(unitandname2.contains(unitandname3)){
                        removeduplicates(amount, unit, name);
                       
                    } else {
                    amount2.add(amount);    
                    unitandname2.add(unitandname3);
                    recipe.put(unitandname3, amount);
                 
                }
            
            }
        }
        
        // public void compareAwithR(){
        
        // int A_amount = 0;
        // int R_amount = 0;
        
        // //finding the specific keys within the arraylist for 

        // for(int i = 0; i < unitandname1.size(); i++){
        //     if(unitandname2.contains(unitandname1.get(i))){
        //         for(int j= 0; j<unitandname2.size(); j++){
        //             if(unitandname2.get(j).contains(unitandname1.get(i))){

        //                 A_amount += amount1.get(i);
        //                 R_amount += amount2.get(j);

        //                     if(A_amount > R_amount){
        //                         recipe.replace(unitandname2.get(j), R_amount, A_amount - R_amount);
        
        //                     // if the old amount is lower than the new --> the value will be (new minus old)
        //                     } else if (A_amount < R_amount){
        //                         recipe.replace(unitandname2.get(j), R_amount, R_amount-A_amount );
        
        //                     // if the old amount equal to the the new --> the value will be the same   
        //                     } else if (A_amount == R_amount){
        //                         recipe.replace(unitandname2.get(j), R_amount, R_amount);
        //                     } 

        //                 }
        //             }
        //         }
        //     }
            
        
        
        // for (HashMap.Entry<String, Integer> entry : recipe.entrySet()) {
        //     System.out.println(entry.getKey()+" : "+entry.getValue());
        // }

        // }
        // public HashMap<Integer, String> reversemap(HashMap<String, Integer> recipe){

        //     //when we're done with the comparing the two hashmaps, we need to swap the keys and values to be presented correctly
        //         HashMap<Integer,String> rev = new HashMap<>();

        //         for(HashMap.Entry<String,Integer> entry : recipe.entrySet())
        //             rev.put(entry.getValue(), entry.getKey());

        //     return rev;
        // }
        public ArrayList<String> compare(){
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
        // public void printShoppingList(){
        //     ArrayList<String> shoppinglist = new ArrayList<>();
        //     System.out.println("Shopping List: ");
            
        //     for (HashMap.Entry<Integer, String> entry : reversemap(recipe).entrySet()) {

        //         shoppinglist.add(entry.getKey() + " " + entry.getValue());
        //     }

        //     for (String string : shoppinglist) {
        //         System.out.println(string);
        //     }

        // }
        
        public void sortArray(){
            
            List<String> list1 = new ArrayList<>(unitandname2.size());
            List<String> list2 = new ArrayList<>(unitandname2.size());
            for (String s : compare()) {
                int index = s.indexOf('g');
                // Add what we have before the separator in list1
                list1.add(s.substring(0, index));
                // Add what we have after the separator in list2
                list2.add(s.substring(index + 1));
            }
            Collections.sort(list1);
            for(int i= 0; i < list1.size(); i++){
                System.out.println(list1.get(i));
            }

            Collections.sort(list2);
            for(int i = 0; i < list2.size(); i++){
                System.out.println(list2.get(i));
            }

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
    
    Spl l1 = new Spl();

    String available = input.next();
    // // // while(input.hasNextInt() && input.hasNext() && input.hasNext()){
        
        l1.setAvailable(input.nextInt(), input.next(), input.next());
        l1.setAvailable(input.nextInt(), input.next(), input.next());
        l1.setAvailable(input.nextInt(), input.next(), input.next());
        l1.setAvailable(input.nextInt(), input.next(), input.next());
        
        // if(input.hasNext().isEmpty())
        
    // }

    // while(input.hasNextLine()){
    // String recipe = input.next();
    // int recipenr = input.nextInt();
    //     l1.setRecipe(input.nextInt(), input.next(), input.next());
        
        // l1.setRecipe(input.nextInt(), input.next(), input.next());
        

        // l1.setRecipe(input.nextInt(), input.next(), input.next());
    String recipe2 = input.next();
    int recipenr2 = input.nextInt();

        l1.setRecipe(input.nextInt(), input.next(), input.next());
        l1.setRecipe(input.nextInt(), input.next(), input.next());
        
        l1.setRecipe(input.nextInt(), input.next(), input.next());
        l1.setRecipe(input.nextInt(), input.next(), input.next());
        
        

        String recipe = input.next();
        int recipenr = input.nextInt();
    
            l1.setRecipe(input.nextInt(), input.next(), input.next());
            l1.setRecipe(input.nextInt(), input.next(), input.next());
            
            l1.setRecipe(input.nextInt(), input.next(), input.next());
            l1.setRecipe(input.nextInt(), input.next(), input.next());
            l1.setRecipe(input.nextInt(), input.next(), input.next());

        
        l1.printShoppingList(l1.compare());
        
        l1.sortArray();






        }


    }

