import com.example.Methods;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        Methods m=new Methods();
        try {
            String v1;
            do {
                System.out.println("a. Add personal details");
                System.out.println("b. Store details in File");
                System.out.println("c. Iterate over Details");
                System.out.println("Q/q to Quit ");
                v1 = sc.next();
                if((v1.equals("a") || v1.equals("A"))){
                    m.addDetails(sc);
                }
                if ((v1.equals("b") || v1.equals("B"))) {
                    m.writeFile();
                }
                if ((v1.equals("c") || v1.equals("C"))){
                    m.displayDetails();
                }

            } while (!( v1.equals("q") || v1.equals("Q")) &&(v1.equals("a") || v1.equals("A") || v1.equals("b") || v1.equals("B") || v1.equals("c") || v1.equals("C")));

        } catch (Exception e) {
            System.out.println("Exception Error");
        }

    }
}