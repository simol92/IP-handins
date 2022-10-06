package Handin6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.apple.laf.resources.aqua;

public class Spl {

private ArrayList<Integer> amount1 = new ArrayList<>();
private ArrayList<String> unitandname = new ArrayList<>();


private ArrayList<Integer> amount2 = new ArrayList<>();
private ArrayList<String> unitandname2 = new ArrayList<>();


        public Spl(){
        
        }
        
        public void setAvailable(int amount, String unit, String name){
        String uae1 =name;


            if(unit.contains("kg")){
                unit = "g";
                amount = amount * 1000;
                uae1 = name;
                amount1.add(amount);
                unitandname.add(uae1);
                
               
            } else {
                amount1.add(amount);
                unitandname.add(uae1);
            
                
            }
        }   
        // VIRKER!!
        public void removeduplicates(int amount, String unit, String name){
            String duplicates =name;
            int amounttt = 0;
            int size = unitandname2.size()-1;
            
            for(int i = 0; i<unitandname2.size()-1; i++){
                if(unitandname2.get(i).contains(duplicates)){
                    unitandname2.add(duplicates);
                    unitandname2.remove(unitandname2.get(i));
                    
                            amounttt += amount2.get(i)+amount;
                            amount2.add(amounttt);
                            amount2.remove(amount2.get(i));

                          
                        }
                
           }

        
        }

        //VIRKER!!
        public void setRecipe(int amount, String unit, String name){
            String unitandname3 =name;
                
                if(unit.equalsIgnoreCase("kg")){
                    unit = "g";
                    amount = amount * 1000;
                    unitandname3 =name;
                    if(unitandname2.contains(unitandname3)){
                        removeduplicates(amount, unit, name);
                        
                    } else {
                        
                    amount2.add(amount);
                    unitandname2.add(unitandname3);
                  
                }
                    
                } else {
                    
                    if(unitandname2.contains(unitandname3)){
                        removeduplicates(amount, unit, name);
                       
                    } else {
                    amount2.add(amount);    
                    unitandname2.add(unitandname3);
                   
                }
            
            }
        }
        
        //VIRKER ENDELIG!
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
                                result += String.valueOf(unitandname2.get(i)).concat(" " + result1);
                                compare1.add(result);

                                
                            } else if(amount1.get(j) > (amount2.get(i))){
                                int result1 = amount1.get(j)-amount2.get(i);
                                String result = "";
                                result += String.valueOf(unitandname2.get(i)).concat(" " + result1);
                                compare1.add(result);
                            } else {
                                
                            }
    
                        } 
                    }
                } else {
                    int result1 = amount2.get(i);
                    String result = "";
                    result += String.valueOf(unitandname2.get(i)).concat(" " + result1);
                    compare1.add(result);
                
                }
            }
    
            return compare1;
        }    

        public void sortRecipe(){
    

        }
        
        
        public void printShoppingList(ArrayList<String> input){
            
        //Eneste jeg mangler er at kunne sortere i alfabetisk rækkefølge efter "name".
        /*
         * Jeg har et object nede i main der hedder "l1.printShoppingList(l1.compare());"
         * 
         * Det object har ovenstående "compare" metode der returnerer et array, hvor elementerne er en kombineret udgave af amount, unit og name.
         * 
         * dvs. element 1 kan være "100 g fish"
         * 
         * Nu står jeg bare og skal kunne sortere et arrayet med f.eks "100 g fish" fra "fish" og ikke "100"
         * 
         * hjælp plx 
         * 
         */
        ArrayList<String> finalamount = new ArrayList<>();
        ArrayList<String> finalname = new ArrayList<>();
        
        ArrayList<String> FINAL = new ArrayList<>();
        String unitt = "g";

            System.out.println("Shopping List: ");
            Collections.sort(input);
            

            for (String string : input) {

                for (String string2 : string.split(" ")) {
                    String regex = "[0-9]+";
                    if(Pattern.matches(regex, string2)){
                        finalamount.add(string2);

                    } else {
                        
                        finalname.add(string2);
                    }
                    
                    
                }
            }

            for(int i = 0; i < input.size(); i++){

                FINAL.add(finalamount.get(i) + " " + unitt + " " + finalname.get(i));

                System.out.println(FINAL.get(i));
            }
            
                    // String temp = "apple 500";
                    // String temp2 = temp.split(" ");
    
                    // String [] arr = string.split(" ");
                    // String [] arr2 = string.split(" ", );
    
                    // for(int i = 0; i < arr2.length-1; i++){
                    //     System.out.println(arr2[i]);
                    // }

                // String temp = "apple 500";
                // String temp2 = temp.split(" ");

                // String [] arr = string.split(" ");
                // String [] arr2 = string.split(" ", );

                // for(int i = 0; i < arr2.length-1; i++){
                //     System.out.println(arr2[i]);
                // }
    
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






                        }


                    }

