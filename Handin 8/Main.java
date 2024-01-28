public class Main {
    
    public static void main(String[] args) {
        
        Task lol = new Task("lort", 4, 15);
        Task lol2 = new Task("lort", 4, 15);

        Todo todo = new Todo();
        todo.addTask("Cook dinner", 1, 45);
        todo.addTask("Pickup kids", 1, 15);
		todo.addTask("Do dishes", 2, 30);
		todo.addTask("Phone mom", 3, 240);
		todo.addTask("Read chapter 10 of BlueJ book", 4, 180);
       
        System.out.println();
        todo.printPrioritized();
    }


}
