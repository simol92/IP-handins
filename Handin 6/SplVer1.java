import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Spl {

private ArrayList<Integer> amount1 = new ArrayList<>();
private ArrayList<String> unitandname = new ArrayList<>();


private ArrayList<Integer> amount2 = new ArrayList<>();
private ArrayList<String> unitandname2 = new ArrayList<>();


        public Spl(){
        
        }
        
        public void setAvailable(String input){
        if(!input.equals("AVAILABLE") && !input.equals("RECIPE 1")){
        String st = input;
        String st1=st.replaceAll("[^A-Za-z]", "");
        String st2=st.replaceAll("[^0-9]", "");
        String name1 = "";

        if(st.contains("kg")){
            name1 += st1.substring(2,st1.length()).trim();
        } else {
            name1 += st1.substring(1,st1.length()).trim();
        }
        
        int amount = Integer.parseInt(st2);
        
    
    
                if(st.contains("kg")){

                    amount = amount * 1000;
                    amount1.add(amount);
                    unitandname.add(name1);
                    
                   
                } else {
                    amount1.add(amount);
                    unitandname.add(name1);
                
                    
                }}
            }   
        // VIRKER!!
        public void removeduplicates(int amount, String name){
            String duplicates =name;
            int amounttt = 0;
            int size = unitandname2.size()-1;
            
            for(int i = 0; i<unitandname2.size()-1; i++){
                if(unitandname2.get(i).equals(duplicates)){
                    unitandname2.add(duplicates);
                    unitandname2.remove(unitandname2.get(i));
                    
                            amounttt += amount2.get(i)+amount;
                            amount2.add(amounttt);
                            amount2.remove(amount2.get(i));

                          
                        }
                
           }

        
        }

        //VIRKER!!
        public void setRecipe(String input){
        if(!input.equals("AVAILABLE") && !input.contains("RECIPE")){

        String r1 = input;
        String str1=r1.replaceAll("[^A-Za-z]", "");
        String str2=r1.replaceAll("[^0-9]", "");
        String namer2 = "";
        
            if(r1.contains("kg")){
                namer2 += str1.substring(2,str1.length()).trim();
                
            } else {
                namer2 += str1.substring(1,str1.length()).trim();
                
            }

            int amountr2 = Integer.parseInt(str2);
            
                
                if(r1.contains("kg")){
                    amountr2 = amountr2 * 1000;
                   
                    if(unitandname2.contains(namer2)){
                        
                        removeduplicates(amountr2, namer2);
                        
                    } else {
                        
                    amount2.add(amountr2);
                    unitandname2.add(namer2);
                  
                }
                    
                } else {
                    
                    if(unitandname2.contains(namer2)){
                        removeduplicates(amountr2, namer2);
                       
                    } else if (amountr2 == 0){
                        
                    } else {
                        
                        amount2.add(amountr2);    
                        unitandname2.add(namer2);
                        
                }
            
            }}
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
                                
                            } else if(amount2.get(i).equals(0)){
                                
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
            
    
    
            }

                public static void main(String[] args) {
                    Scanner input = new Scanner(System.in);
                    
                    
                    Spl l1 = new Spl();

                    while(input.hasNextLine()){
                        String line = input.nextLine();
                        if(!line.equals("RECIPE 1")){
                            l1.setAvailable(line);
                        } else {
                            break;
                        }
                            
            
                    }
                    
                    while(input.hasNextLine()){
                        String line2 = input.nextLine();
                        if(!line2.isEmpty()){
                            l1.setRecipe(line2);
                        } else {
                            break;
                        }
                        
                        
                    }

                   
                   l1.printShoppingList(l1.compare());
                   
                   
                    
                }
                
                    

        }
    
    
            



