import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RejseKort {

private int balance;
private boolean checked;
private int timeofcheckin;
private List<Integer> arrayofx;
private List<Integer> arrayofy;


    public RejseKort(){
    balance = 100;
    checked = false;
    timeofcheckin = 0;
    arrayofx = new ArrayList<>();
    arrayofy = new ArrayList<>();
    
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

    public boolean isCheckedIn(int timeStamp){
        int difference = 0;

        if(timeStamp> timeofcheckin){
            difference = timeStamp - timeofcheckin;
        } else difference = timeofcheckin - timeStamp;

        boolean success = difference <= 120;

        if(checked == true && success){
            return true;
        } else return false;

    }

    public void checkIn(int x, int y, int timeStamp){

        int differenceofcheckin;
        arrayofx.add(x);
        arrayofy.add(y);
        
        if(timeStamp > timeofcheckin) {
            differenceofcheckin = timeStamp - timeofcheckin;
        } else differenceofcheckin = timeofcheckin - timeStamp;

        if(balance < 100){
            int difference = 100-balance;
            System.out.println("Not enough money in account to check in. Please deposit at least " + difference + " DKK");
        }
        else if(checked == false && balance >= 100){
            checked = true;
            timeofcheckin += timeStamp;
            System.out.println("Checked in");
        }

         else if(checked == true){
            System.out.println("Continued journey (" + differenceofcheckin+ " minutes since last check in)");
            timeofcheckin = timeStamp;
        }

    }

    public void checkOut(int x, int y, int timeStamp){
        int differenceofcheckin;
        
        if(timeStamp > timeofcheckin) {
            differenceofcheckin = timeStamp - timeofcheckin;
        } else differenceofcheckin = timeofcheckin - timeStamp;

        arrayofx.add(x);
        arrayofy.add(y);

        Collections.sort(arrayofx);
        Collections.sort(arrayofy);
      
        int maxX = arrayofx.get(arrayofx.size()-1);
        int minX = arrayofx.get(0);
        int maxY = arrayofy.get(arrayofy.size()-1);
        int minY = arrayofy.get(0);

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

            System.out.println("Checked out! " + differenceofcheckin + " minutes since last check in. Price is " + ticketprice + 
            " DKK, remaining balance is " + newbalance + " DKK");

            timeofcheckin = 0;
            balance = newbalance;

        } else if(ticketprice < 50){

            checked = false;
            newbalance = balance - ticketprice;

            System.out.println("Checked out! " + differenceofcheckin + " minutes since last check in. Price is " + ticketprice + 
            " DKK, remaining balance is " + newbalance + " DKK");

            timeofcheckin = 0;
            balance = newbalance;

        } 
       
        

    }





}
