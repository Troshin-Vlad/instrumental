import java.util.Scanner;

public class User {
    public String input(){
        Scanner scan = new Scanner(System.in);
        System.out.print(": ");

        return scan.nextLine();
    }
}
