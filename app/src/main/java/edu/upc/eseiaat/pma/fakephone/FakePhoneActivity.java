package edu.upc.eseiaat.pma.fakephone;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.id.message;

public class FakePhoneActivity extends AppCompatActivity {

    public static final String TOTAL_PHONE = "correct_answer";

    @Override
    protected void onSaveInstanceState(Bundle outState) { // CUIDADO HEM D'AGAFAR EL QUE NO TE DOS PARAMETRES
        Log.i("lifecycle","onSaveInstanceState");

        super.onSaveInstanceState(outState); // objecto con 'all' lo que quieres guardar
        // Tot el que guardem a la motxilla amb el Put
        outState.putString(TOTAL_PHONE, "total_phone");
    }


    EditText total_phone, final_num;

    private int numbers [] = {
        R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_phone);

        total_phone = (EditText) findViewById(R.id.label_phone);


    }

    private void startOver() {
        final_num = (EditText) findViewById(R.id.label_phone);
        final_num.setText(total_phone.getText().toString());

    }



    public void click (View v){

        Button boto = (Button) v; // convertim el widget (v)que es un view qualsevol a en un botó
        final_num = (EditText) findViewById(R.id.label_phone);

        String s = boto.getText().toString();
        final_num.setText(total_phone.getText().toString()+s);


    }



    public void call ( View v){
        

       /* String message =

                String.format("Trucant: %d\n",
                        final_num);*/
        // Cuadro de dialogo

        AlertDialog.Builder builder = new AlertDialog.Builder(this); // objeto builder
        builder.setTitle(R.string.calling); // Título del mensaje
        String c=getResources().getString(R.string.number);

      builder.setMessage(c+(final_num.getText())); // el contenido
        builder.setCancelable(true); // no se puede ir para atras


       /*builder.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() { // Esta okei, acabar
            @Override
           public void onClick(DialogInterface dialogInterface, int i) {
                onSaveInstanceState(); //
                // QuizActivity.this.finish() seria lo mismo
            }
        });*/


       builder.setNegativeButton(R.string.start_over, new DialogInterface.OnClickListener() { // no, m'he he equivocado
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startOver();
            }
        });
        builder.create().show(); // crearlo

    }




}
