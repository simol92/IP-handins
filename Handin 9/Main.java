public class Main {
    
    public static void main(String[] args) {

        RejseKort r1 = new RejseKort();

        r1.checkIn(3, 4, 200);
        r1.isCheckedIn(250);
        r1.checkIn(1, 2, 300);
        r1.isCheckedIn(350);
        r1.checkIn(4, 5, 400);
        r1.isCheckedIn(450);
        r1.checkOut(3, 4, 500);

    }

}
