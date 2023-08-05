import java.io.FileReader;
import java.util.Scanner;

public class Task2 {
    public static void main(String [] args) throws Exception {
        FileReader file1 = new FileReader(args[0]);
        FileReader file2 = new FileReader(args[1]);
        Scanner scan1 = new Scanner(file1);
        Scanner scan2 = new Scanner(file2);
        
        float x_center = scan1.nextFloat();
        float y_center = scan1.nextFloat();
        int r = scan1.nextInt();
        r = r * r;
               
        float x, y, leftPart;
        // leftPart - левая часть уравнения окружности
        while (scan2.hasNextLine()) {
            x = scan2.nextFloat();
            y = scan2.nextFloat();
            leftPart = (x - x_center) * (x - x_center) + (y - y_center) * (y - y_center);
            if (leftPart == r) {
                System.out.println(0);
            } else if (leftPart < r) {
                System.out.println(1);
            } else {
                System.out.println(2); 
            }
        }
        
        file1.close();
        file2.close();
    }
}
