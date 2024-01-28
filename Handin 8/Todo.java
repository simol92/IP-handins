import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Todo{

private List<Task> tasks;
private int totalrunningoftime;

    public Todo(){
        tasks = new ArrayList<>();
        totalrunningoftime = 0;
    }

    public void addTask(String description, int priority, int minutes){

        if(priority > 4 || priority <= 0){
            System.out.println(description + " has invalid priority");
        } else if (minutes < 0){
            System.out.println(description + " has invalid workload");
        } else {
            Task task = new Task(description, priority, minutes);
            tasks.add(task);
        }

    }

    public void print(){
        if(tasks.isEmpty()){
            System.out.println("Todo:");
            System.out.println("-----");
            System.out.println("You're all done for today! #TodoZero");
        } else {

            System.out.println("Todo:");
            System.out.println("-----");
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }

        if(totalrunningoftime > 0){
            System.out.println(totalrunningoftime + " minutes of work done!");
        }

    }

    //overvej try catch block! 
    public void completeTask(int index){
        
        try{
            Task task = tasks.get(index);
            totalrunningoftime += task.getMinutes();
            tasks.remove(task);
        } catch(IndexOutOfBoundsException e){
            System.out.println("Invalid index");
        }

    }

    public void printPriority(int limit){
        
        System.out.println("Filtered todo:");
        System.out.println("--------------");


            List<Task> priority = new ArrayList<>();
            for (Task task : tasks) {
                if(task.getPriority() <= limit){
                    priority.add(task);
                }
            }


            // for (Task task : priority) {
            //     if(priority.isEmpty()){
            //         System.out.println("No tasks with given priority");
            //     } else {
            //         System.out.println(task.toString());
            //     }

            // }
            //https://stackoverflow.com/questions/38021061/how-to-use-if-else-logic-in-java-8-stream-foreach

            priority.stream().forEach(task-> {
                if(priority.isEmpty()){
                    System.out.println("No tasks with given priority");
                } else {
                    System.out.println(task.toString());
                }
            }
            );

    }


    public void printPrioritized(){

        Comparator<Task> priority = Comparator.comparing(Task::getPriority);
        Comparator<Task> time = Comparator.comparing(Task::getAmountofTime);
        
        System.out.println("Prioritized todo:");
        System.out.println("-----------------");
        
        tasks.sort(priority.thenComparing(time));
        
        tasks.forEach(task -> 
        System.out.println(task.toString()));

        //     Comparator<Task> com = new Comparator<Task>() {
        //     public int compare(Task t1, Task t2){
        //         if(t1.getPriority() > t2.getPriority()){
        //             return 1;
        //         } else return -1;
                
        //     }
        // };

        // Comparator<Task> time = new Comparator<Task>() {
        //     public int compare(Task t1, Task t2){
        //         if(t1.getAmountofTime() < t2.getAmountofTime()){
        //             return 1;
        //         } else return -1;

        //     }
        // };

    }

}
