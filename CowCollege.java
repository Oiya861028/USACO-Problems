import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;
public class CowCollege {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){ 
        System.out.print("How many cows? ");
        int numCows = sc.nextInt();
        sc.nextLine();
        System.out.println("Maximum Tuition: ");
        String tuition = sc.nextLine();
        String[] tuitionStr = tuition.split("\\s");
        int[] tuitionArr = new int[numCows];
        int k = 0;
        for(String t:tuitionStr){
            tuitionArr[k] = Integer.parseInt(t);
            k++;
        }
        TreeMap<Integer, Integer> tuitionCounter = new TreeMap<Integer,Integer>();
        for(int t:tuitionArr) {
            if(tuitionCounter.containsKey(t)) tuitionCounter.replace(t, tuitionCounter.get(t)+1);
            else tuitionCounter.put(t, 1);
        }
        calculateRevenue(tuitionCounter, numCows);
    }
    public static void calculateRevenue(TreeMap<Integer, Integer> tuition, int numCows){
        int highestTuition = 0;
        int TuitionPerCow = 0;
        for(Entry<Integer, Integer> n:tuition.entrySet()) {
            int moneyPile = 0; //counting total tuition from charging certain rate
            int tuitionFee = n.getKey(); //how much each cow paying
            SortedMap<Integer,Integer> applicableCows =  tuition.subMap(tuitionFee, tuition.lastKey()+1);
            for(Entry<Integer, Integer> cow: applicableCows.entrySet()) {
                moneyPile += (tuitionFee*cow.getValue());
            }
            if(moneyPile>highestTuition) {
                highestTuition = moneyPile;
                TuitionPerCow = tuitionFee;
            }
        }
        System.out.println(highestTuition + " " + TuitionPerCow);
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