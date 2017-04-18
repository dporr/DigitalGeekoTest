package test.dporrras.digitalgeeko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * @author: dporras
     * @param filename to open
     * Open a raw .dat file and parses the text
     * **/
    private void parseFile(String filename){
        //Uso de api 19 por soportortar try-with-resources
        try(InputStream file = getApplicationContext().getResources().openRawResource(R.raw.football)){
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            while(scanner.hasNext()) Log.i("message: ",scanner.next());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
