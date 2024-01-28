import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RK {

private int balance;
private boolean checked;
private int timeofcheckingin;
private List<Integer> startpoint;
private List<Integer> endpoint;


    public RK(){

    balance = 100;
    checked = false;
    timeofcheckingin = 0;
    startpoint = new ArrayList<>();
    endpoint = new ArrayList<>();
    
    }


    public void depositMoney(int dkk){
        
        if(dkk > 0){
            this.balance += dkk;
            System.out.println(dkk + " DKK deposited. New balance: " + balance +" DKK");
        }
        if(dkk == 0){
            System.out.println(dkk + " DKK deposited. New balance: " + balance + " DKK");
        }

        if(dkk < 0){
            System.out.println("Error: Cannot deposit negative amount");
        }

    }

    public int differenceoftime (int timeStamp){
        int timedifference = 0;

        if(timeStamp> timeofcheckingin) timedifference = timeStamp - timeofcheckingin;
        else timedifference = timeofcheckingin - timeStamp;

        return timedifference;
    }

    public boolean isCheckedIn(int timeStamp){
  
        boolean success = differenceoftime(timeStamp) <= 120;

        if(checked == true && success){
            return true;
        } else return false;

    }

    public void checkIn(int x, int y, int timeStamp){

        startpoint.add(x);
        endpoint.add(y);
   
        if(balance < 100){
            int newbalance = 100-balance;
            System.out.println("Not enough money in account to check in. Please deposit at least " + newbalance + " DKK");
        }
        else if(checked == false && balance >= 100){
            checked = true;
            timeofcheckingin = timeStamp;
            System.out.println("Checked in");
        }

         else if(checked == true){
            System.out.println("Continued journey (" + differenceoftime(timeStamp)+ " minutes since last check in)");
            timeofcheckingin = timeStamp;
        }

    }

    public void checkOut(int x, int y, int timeStamp){
    
        startpoint.add(x);
        endpoint.add(y);

        Collections.sort(startpoint);
        Collections.sort(endpoint);
      
        int maxX = startpoint.get(startpoint.size()-1);
        int minX = startpoint.get(0);
        int maxY = endpoint.get(endpoint.size()-1);
        int minY = endpoint.get(0);

        int result = maxX - minX + maxY - minY;
       
        int ticketprice = 12 + result *3;

        int newbalance = 0;

        if(checked == false){
            System.out.println("Error: Cannot check out; Not currently checked in");
        }

        else if(ticketprice > 50){
            ticketprice = 50;
            checked = false;
            newbalance = balance - ticketprice;

            System.out.println("Checked out! " + differenceoftime(timeStamp) + " minutes since last check in. Price is " + ticketprice + 
            " DKK, remaining balance is " + newbalance + " DKK");

            balance = newbalance;

        } else if(ticketprice < 50){

            checked = false;
            newbalance = balance - ticketprice;
            
            System.out.println("Checked out! " + differenceoftime(timeStamp) + " minutes since last check in. Price is " + ticketprice + 
            " DKK, remaining balance is " + newbalance + " DKK");

            balance = newbalance;

        } 
       
        

    }

    public static void main(String[] args) {
        
        RK r1 = new RK();

        r1.checkIn(3, 4, 200);
        r1.isCheckedIn(250);
        r1.checkIn(1, 2, 300);
        r1.isCheckedIn(350);
        r1.checkIn(4, 5, 400);
        r1.isCheckedIn(450);
        r1.checkOut(3, 4, 500);


    }




}


