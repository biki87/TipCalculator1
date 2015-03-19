package il.ac.huji.tipcalculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Float;


public class TipCalculatorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        //get the calculate button
        Button btn = (Button)findViewById(R.id.btnCalculate);
        //set event listener
        btn.setOnClickListener(calculateListener);
    }

    //event listener for calculate button
    private View.OnClickListener calculateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //get the entered text
            EditText text = (EditText)findViewById(R.id.edtBillAmount);
            //covert to float and calculate 12%
            float amount = (float) ((Float.parseFloat(text.getText().toString()))*0.12);

            //get checkbox and check if amount should be rounded
            CheckBox checkBox = (CheckBox)findViewById(R.id.chkRound);
            boolean isRound = checkBox.isChecked();

            // get tip result text
            TextView tipResult = (TextView)findViewById(R.id.txtTipResult);

            //if amount to be rounded, round and set the tip result text
            if(isRound){
                float roundedResult = Math.round(amount);
                String result = Float.toString(roundedResult);
                tipResult.setText("Tip: $"+result);
            }
            //else, set the result text without rounding
            else{
                String result = Float.toString(amount);
                tipResult.setText("Tip: $"+result);
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tip_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}