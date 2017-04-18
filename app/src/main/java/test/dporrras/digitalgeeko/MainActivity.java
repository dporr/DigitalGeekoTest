package test.dporrras.digitalgeeko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity implements GlobalValues {
    private RadioGroup rgDataSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    *Binds all the layout whitin this screen
    *Add all new UI controls here
    */
    private void initLayoutComponents(){
        rgDataSet = (RadioGroup) findViewById(R.id.rgDataSet);
    }

}
