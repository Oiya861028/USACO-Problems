import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class CowCollege {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){ 
        System.out.print("How many cows? ");
        int numCows = sc.nextInt();
        sc.nextLine();
        System.out.println("Maximum Tuition: ");
        String tuition = sc.nextLine();
        String[] tuitions = tuition.split("\\s");
        HashMap<String, Integer> tuitionCounter = new HashMap<String,Integer>();
        System.out.println(Arrays.toString(tuitions));
        for(String t:tuitions) {
            if(tuitionCounter.containsKey(t)) tuitionCounter.replace(t, tuitionCounter.get(t)+1);
            else tuitionCounter.put(t, 1);
        }
        tuitionCounter.forEach((key, value) -> System.out.println(key + " " + value));
    }
}