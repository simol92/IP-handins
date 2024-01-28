public class Task {
private String task;
private int priority;
private int amountoftime;


    public Task(String task, int priority, int amountoftime) {
        this.task = task;
        this.priority = priority;
        this.amountoftime = amountoftime;
    }

    public String toString(){
        String minutes = " takes " + amountoftime + " minutes";
        String result = "";
        int p = priority;

        switch(p){
            case 1:
            result = task + minutes + " and has priority very important";
            break;

            case 2:
            result = task + minutes + " and has priority important";
            break;

            case 3: 
            result = task + minutes + " and has priority unimportant";
            break;

            case 4: 
            result = task + minutes + " and has priority after learn Portuguese";
            break;
        }

        return result;
    }

    public int getMinutes(){
        return amountoftime;
    }

    public int getPriority(){
        return priority;
    }

    public int getAmountofTime(){
        return amountoftime;
    }



}
