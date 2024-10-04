package TcsSets;

import java.util.Arrays;

public class CalculateBusFare {
    // Distance between consecutive stops (in meters)
    static int[] Path = {800, 600, 750, 900, 1400, 1200, 1100, 1500};

    // Abbreviations of bus stop names
    static String[] BusStops = {"TH", "GA", "IC", "HA", "TE", "LU", "NI", "CA"};

    public static void main(String[] args) {

        String src="TH";
        String dest="TE";


        int srcIndex= Arrays.asList(BusStops).indexOf(src);
        int destIndex=Arrays.asList(BusStops).indexOf(dest);

        if(srcIndex == -1 || destIndex==-1){
            System.out.println("Invalid points");
        }

        //calculating distances

        int clockWiseDist=0;
        int antiClockWiseDist=0;



        for(int i=srcIndex; i!=destIndex ; i=(i+1) % BusStops.length){
                clockWiseDist += Path[i];
        }

        for(int i=srcIndex; i != destIndex; i=(i-1 + BusStops.length) % BusStops.length){
            antiClockWiseDist += Path[(i-1+BusStops.length) % BusStops.length];
        }

        System.out.println(clockWiseDist+" "+antiClockWiseDist);

        int minDistance=Math.min(clockWiseDist,antiClockWiseDist);

        double fare=Math.ceil((double) minDistance/1000) * 5;

        System.out.println(String.format("%.1f INR",fare));
    }
}
