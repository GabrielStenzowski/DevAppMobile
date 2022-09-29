package br.com.up.listadepresentes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.up.listadepresentes.adapters.GiftAdapter;
import br.com.up.listadepresentes.models.Gift;
import br.com.up.listadepresentes.repositories.GiftRepository;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAddGift;
    private RecyclerView recyclerViewGifts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewGifts = findViewById(R.id.recycler_gift);
        fabAddGift = findViewById(R.id.fab_add_gift);

        recyclerViewGifts.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        RecyclerView.VERTICAL,
                        false
                )
        );

        fabAddGift.setOnClickListener(
                new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(
                        getApplicationContext(),
                        AddGiftActivity.class
                );

                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Gift> gifts = GiftRepository
                .getInstance().getAll();

        if(gifts.size() > 0){

        }
        recyclerViewGifts.setAdapter(new GiftAdapter(gifts));
    }
}