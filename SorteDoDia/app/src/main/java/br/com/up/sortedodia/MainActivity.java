package br.com.up.sortedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTittle;
    private Button buttonAction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewTittle = findViewById(R.id.text_tittle);
        buttonAction = findViewById(R.id.button_action);

        textViewTittle.setText("Ola Mundão, Ele capota, não gira");

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewTittle.setText("Ola Mundo");
            }
        };
        buttonAction.setOnClickListener(listener);
    }
}