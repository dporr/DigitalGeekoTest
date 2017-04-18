package test.dporrras.digitalgeeko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;


public class     MainActivity extends AppCompatActivity implements GlobalValues {
    private RadioGroup rgDataSet;
    private int minCol,maxCol,rowName;
    private String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayoutComponents();
    }
    /*
    *Binds all the layout whitin this screen
    *Add all new UI controls here
    */
    private void initLayoutComponents(){
        rgDataSet = (RadioGroup) findViewById(R.id.rgDataSet);
    }
    /*Launch an activity for displaying results based on checked radio button
    *@param view , the parent view of these componets
    */
    public void showResultActivity(View view){
        if(rgDataSet.getCheckedRadioButtonId() == -1){
            Toast.makeText(getApplicationContext(), "Seleccione un data set a procesar", Toast.LENGTH_SHORT).show();
                return;
        }
        Intent intent = new Intent(this, ResultsActivity.class);
        switch (rgDataSet.getCheckedRadioButtonId()){
            case R.id.rbFootball:
                data = FOOTBALL_DS;
                minCol = F_MIN_COL;
                maxCol = F_MAX_COL;
                rowName = F_ROW_NAME;
                break;
            case R.id.rbWeather:
                data = WHEATER_DS;
                minCol = W_MIN_COL;
                maxCol = W_MAX_COL;
                rowName = W_ROW_NAME;
                break;
        }
        //Add the corresponding options before launch the Activity
        intent.putExtra(MainActivity.DATASET, data);
        intent.putExtra(MainActivity.MIN_COL,minCol);
        intent.putExtra(MainActivity.MAX_COL,maxCol);
        intent.putExtra(MainActivity.ROW_NAME,rowName);
            startActivity(intent);
    }
}
