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
        HashMapKeyCached<String, Integer> tuitionCounter = new HashMapKeyCached<String,Integer>();
        System.out.println(Arrays.toString(tuitions));
        for(String t:tuitions) {
            if(tuitionCounter.containsKey(t)) tuitionCounter.replace(t, tuitionCounter.get(t)+1);
            else tuitionCounter.put(t, 1);
        }
        System.out.println("Lowest key_value pair:" + tuitionCounter.getlowestK()+"-"+tuitionCounter.get(tuitionCounter.getlowestK()));
        System.out.println("Highest key_value pair:" + tuitionCounter.getHighestK()+"-"+tuitionCounter.get(tuitionCounter.getHighestK()));

    }
    public static void calculateRevenue(HashMap<String, Integer> tuition, int numCows){
        HashMap<Integer,Integer> tally = new HashMap<Integer,Integer>();
    }
    @SuppressWarnings("rawtypes")
    public static class HashMapKeyCached<K extends Comparable, V> extends HashMap<K, V> {
        K lowestValueKey, highestValueKey;
        @SuppressWarnings("unchecked")
        @Override
        public V put(K key, V value) {
            if(lowestValueKey==null || highestValueKey == null) {
                lowestValueKey = key;
                highestValueKey = key;
            }
            else if(key.compareTo(lowestValueKey)<0) {
                lowestValueKey = key;
            }
            else if(key.compareTo(highestValueKey)>0) {
                highestValueKey = key;
            }
            return super.put(key, value);
        }
        public K getlowestK() {
            return lowestValueKey;
        }
        public K getHighestK(){
            return highestValueKey;
        }
    }
}