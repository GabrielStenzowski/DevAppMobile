package br.com.up.sortedodia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTittle;
    private Button buttonAction;
    private ArrayList<String> messages = new ArrayList<>();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewTittle = findViewById(R.id.text_tittle);
        buttonAction = findViewById(R.id.button_action);

        messages.add("Comprar uma coxinha");
        messages.add("Dormi o maximo amanha");
        messages.add("Fazer altos nada");
        messages.add("Sexta feira é dia de maldade");

//        textViewTittle.setText("Ola Mundo...");

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int index = random.nextInt(messages.size());
                String message = messages.get(index);

                textViewTittle.setText(message);

//                textViewTittle.setText("Bom dia, são 7 da manha em malibu");
            }
        };
        buttonAction.setOnClickListener(listener);
    }
}