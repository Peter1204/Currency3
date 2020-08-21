package com.home.currency;

import android.content.DialogInterface;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();

    }

    private void findviews() {
        tw = findViewById(R.id.itd);
    }

    public void GO  (View view){

        if("".equals(tw.getText().toString().trim())){
            new AlertDialog.Builder(this)
                    .setTitle("Problem")
                    .setMessage("Please enter your NTD amount")
                    .setPositiveButton("OK",null)
                    .show();
        }else {
            String ts = tw.getText().toString();
            float tw_to_us = Float.parseFloat(ts);
            float usd = tw_to_us / 30.9f;
            new AlertDialog.Builder(this)
                    .setTitle("result")
                    .setMessage("USD is " + usd)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            tw.setText("");
                        }
                    })
                    .show();
        }
    }


}
