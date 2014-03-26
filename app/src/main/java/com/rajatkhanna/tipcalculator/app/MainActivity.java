package com.rajatkhanna.tipcalculator.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    EditText etBill,etTip;
    TextView tvAmt;
    RadioGroup rgTipSelector;
    RadioButton rbTen,rbTwelve,rbFifteen ;
    Button btnCalculate ;
    double tip = 10.0;
    double amount = 0,bill,tipAmt =0.0;
    String b,amt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

    }

    private void initialize() {
        etBill = (EditText) findViewById(R.id.etBill);
        etTip = (EditText) findViewById(R.id.etTip);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        rgTipSelector = (RadioGroup) findViewById(R.id.radioGroup);
        btnCalculate.setOnClickListener(this);
        tvAmt = (TextView) findViewById(R.id.tvAmt);
        rbTen = (RadioButton) findViewById(R.id.rbTen);
        rbTwelve = (RadioButton) findViewById(R.id.rbtwelve);
        rbFifteen = (RadioButton) findViewById(R.id.rbfifteen);

        rgTipSelector.setOnCheckedChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {


        try{

            String tipEt;
                tipEt = etTip.getText().toString();
            tipAmt = Double.parseDouble(tipEt);
           amount = bill + tipAmt;
           amt = String.format("%.2f",amount);
           tvAmt.setText(amt);

        }catch (NumberFormatException e){
            Toast.makeText(this,"Not a Valid Number",Toast.LENGTH_LONG);
        }



    }
    private void calculateTip(){
        String t;
        b = etBill.getText().toString();
        bill = Double.parseDouble(b);

        t= String.format("%.2f",bill * (tip/100));
        etTip.setText(t);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rbTen:
                tip = 10.0;
                calculateTip();

                break;
            case R.id.rbtwelve:
                tip = 12.5;
                calculateTip();
                break;
            case R.id.rbfifteen:
                tip = 15.0;
                calculateTip();
                break;

        }
    }
}
