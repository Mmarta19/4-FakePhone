package edu.upc.eseiaat.pma.fakephone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FakePhoneActivity extends AppCompatActivity {

    EditText total_phone;

    private int numbers [] = {
        R.id.btn0, R.id.btn1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_phone);

        total_phone = (EditText) findViewById(R.id.label_phone);

    }



    public void click (View v){
        Button boto = (Button) v; // convertim el widget (v)que es un view qualsevol a en un botó
        String s = boto.getText().toString();

        total_phone.setText(s);



    }



}
