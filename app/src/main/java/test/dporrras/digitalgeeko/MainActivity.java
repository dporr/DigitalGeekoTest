package test.dporrras.digitalgeeko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private HashMap<String,Integer> map;
    private int ROW_NAME = 1;
    private int minCol,maxCol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new HashMap<String, Integer>();
        minCol = 9;
        maxCol = 7;
        parseFile("s");
            findMinDifference();
    }
    /**
     * @author: dporras
     * @param filename to open
     * Open a raw .dat file and parses the text
     * **/
    private void parseFile(String filename){
        //Api 19 needed to use try-with-resources
        try(InputStream file = getApplicationContext().getResources().openRawResource(R.raw.football)){
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while(scanner.hasNext()){
                String[] fields = scanner.next().split("\\s+");
                if(fields.length > minCol)
                    cleanInput(fields,minCol,maxCol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @author: dporras
     * @param fields a String array representing a row
     * @param minCol column number containing min values
     * @param maxCol col number containing max values
     * Check if read line is a valid table row and stores relevant fields from it
     * **/
    private void cleanInput(String[] fields,int minCol,int maxCol){
        int minValue =  0;
        int maxValue = 0;
       try{
           minValue = Integer.parseInt(fields[minCol]);
           maxValue = Integer.parseInt(fields[maxCol]);
           map.put(fields[ROW_NAME],Math.abs(maxValue - minValue));
           //Log.i("MIN",fields[minCol]);
         // Log.i("Max",fields[maxCol]);
        }catch(NumberFormatException nfe){
           //Log.i("ACTION","SK");
           return;//if not a valid row ignore it
        }
    }

    /**
     * @author: dporras
     * @return the key with the min value from a hasmap
=    ***/
    private String findMinDifference(){
        // find minimum first
        int min = Integer.MAX_VALUE;
        for(HashMap.Entry<String, Integer> entry : map.entrySet()) {
            min = Math.min(min, entry.getValue());
        }
        Map.Entry<String, Integer> minEntry = null ;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            //Log.i(">>>>>MESSAGE:",entry.getKey() +" "+entry.getValue());
            if (minEntry == null || entry.getValue().intValue() <= min)
            {
                minEntry = entry;
            }
        }
        Log.i(">>>>MENOR:",minEntry.getKey());
        return minEntry.getKey();
    }
}
