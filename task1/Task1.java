package Package1;
//Main-Class: Package3.Task3
//Class-Path: lib/json-simple.jar
public class Task1 {
    public static void main(String [] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]) - 1;
        
        int curr = 1;
        
        do {
            System.out.print(curr);
            curr = (curr + m) % n;
            if (curr == 0) {
                curr = n;
            }
        } while (curr != 1);
    }
}
