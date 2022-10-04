public class Main {
    public static void main(String[] args) {
        Forest f1 = new Forest();
        f1.addTree(100);
        f1.addTree(50);
        
        for(int i = 0; i < 10; i++) {
            f1.growOneYear();
        }
        System.out.println(f1.toString());
    }
}
