import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class Task4 {
    public static void main(String [] args) throws Exception {
        FileReader file = new FileReader(args[0]);
        Scanner sc = new Scanner(file);
        ArrayList<Integer> nums = new ArrayList<>();
        while (sc.hasNextLine()) {
            nums.add(sc.nextInt());
        }
        
        Collections.sort(nums);
        int mediana = nums.get(nums.size() / 2);
        int sum = 0;
        for (int num: nums) {
            sum += Math.abs(num - mediana);
        }
        
        System.out.println(sum);
        file.close();
    }
}
