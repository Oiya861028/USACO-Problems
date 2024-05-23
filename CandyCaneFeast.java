import java.util.Arrays;
import java.util.Scanner;
public class CandyCaneFeast {
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // System.out.println();
        // String firstLine = sc.nextLine(); //String containing the num of cows and candycane
        // String[] temp = firstLine.split(" ");
        // int N = Integer.parseInt(temp[0]); //num of cows
        // int M = Integer.parseInt(temp[1]); //num of candy
        
        // System.out.println();
        // String secondLine = sc.nextLine(); //String contains the height of cows
        // temp = secondLine.split(" ");
        // int[] cows = new int[N]; 
        // for(int i=0;i<cows.length;i++) cows[i] = Integer.parseInt(temp[i]); 

        // System.out.println();
        // String thirdLine = sc.nextLine(); //String contains the height of M candy canes
        // temp = thirdLine.split(" ");
        // int[] candyCane = new int[M]; 
        // for(int i=0;i<M;i++) candyCane[i] = Integer.parseInt(temp[i]); 
        // SYstem.out.println(Arrays.toString(candyCane));
        int[] cows = {3, 2, 5};
        int[] candyCane = {6, 1};
        int N = 3;
        int M = 2;
        feed(cows, candyCane, N, M);
    }
    public static void feed(int[] cows, int[] candyCanes, int N, int M){
        /*
         * Feeds N cows M candyCanes in an order from low to highest height then repeat til all candies ran out
         * Parameters:
         * cows - array of cows with their height
         * candyCanes - array of candy canes with their height
         * N - number of cows 
         * M - number of candyCanes 
         * Returns:
         * None
         * Prints out the final height of each cow in seperate rows
         */

        for(int candy: candyCanes){
            int curHeight = 1;
            for(int i=0;i<cows.length;i++) {
                if(curHeight>cows[i]) continue;
                if(curHeight>candy) break;
                else {
                    int digesting = 0;
                    while(curHeight <= cows[i] && curHeight<=candy) {
                        digesting++;
                        curHeight++;
                    }
                    cows[i] += digesting;
                }
            }
        } 
        for(int cow: cows) System.out.println(cow);
    }
}