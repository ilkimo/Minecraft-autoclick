import java.util.Scanner;

public class AutoClickEnderman {
    public static void main(String[] args) {
        Thread killer = new KillerThread();
        Scanner t = new Scanner(System.in);

        killer.start();
        t.nextLine();

        System.exit(0);
    }
}
