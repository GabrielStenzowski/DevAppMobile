package com.example.tictactoegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    private int quantidade;
    private int jogador;
    private int mat[][] = new int[3][3];
    private Button botao[] = new Button[9];
    private String ganhador;
    private String jogador1;
    private String jogador2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantidade = 1;
        jogador = 1;
        botao[0] = findViewById(R.id.bnt_1);
        botao[1] = findViewById(R.id.bnt_2);
        botao[2] = findViewById(R.id.bnt_3);
        botao[3] = findViewById(R.id.bnt_4);
        botao[4] = findViewById(R.id.bnt_5);
        botao[5] = findViewById(R.id.bnt_6);
        botao[6] = findViewById(R.id.bnt_7);
        botao[7] = findViewById(R.id.bnt_8);
        botao[8] = findViewById(R.id.bnt_9);

        botao[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[0],0,0);

            }
        });

        botao[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[1],0, 1);
            }
        });

        botao[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[2],0,2);
            }
        });

        botao[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[3],1,0);
            }
        });

        botao[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[4],1,1);
            }
        });

        botao[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[5],1,2);
            }
        });

        botao[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[6],2,0);

            }
        });

        botao[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[7], 2,1);

            }
        });

        botao[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jogadaAtual(botao[8],2, 2);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.principal_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        switch (item.getItemId()) {

            case R.id.itemNovo:
                limpar();

                final EditText editText2 = new EditText(this);
                AlertDialog.Builder segundoJogador = new AlertDialog.Builder(this);
                segundoJogador.setMessage("Digite o nome do jogador 2: ");
                segundoJogador.setTitle("JOGADOR 2");
                segundoJogador.setView(editText2);
                segundoJogador.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jogador2 = editText2.getText().toString();
                    }
                });
                segundoJogador.create();
                segundoJogador.show();


                final EditText editText = new EditText(this);
                AlertDialog.Builder primeiroJogador = new AlertDialog.Builder(this);
                primeiroJogador.setMessage("Digite o nome do jogador 1: ");
                primeiroJogador.setTitle("JOGADOR 1");
                primeiroJogador.setView(editText);
                primeiroJogador.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        jogador1 = editText.getText().toString();
                    }
                });
                primeiroJogador.create();
                primeiroJogador.show();

               //Toast.makeText(getApplicationContext(), "inicia um novo jogo", Toast.LENGTH_LONG).show();
            break;
        }

        return  super.onOptionsItemSelected(item);
    }

    public void jogadaAtual(Button botao,int x, int y){
        botao.setEnabled(true);
        if(jogador==1){
            mat[x][y]=1;
            botao.setText("X");
            jogador=2;
            ganhador=jogador1;
            verificarJogada(1);
        }
        else{
            mat[x][y]=2;
            botao.setText("O");
            jogador=1;
            ganhador=jogador2;
            verificarJogada(2);
        }
        quantidade++;
    }

    public boolean vitoria(int x){

        for(int i=0;i< mat.length;i++){

            if(mat[i][0]==x && mat[i][1]==x && mat[i][2]==x){
                return true;
            }
            if(mat[0][i]==x && mat[1][i]==x && mat[2][i]==x){
                return true;
            }
        }
        if(mat[0][0]==x && mat[1][1]==x && mat[2][2]==x){
            return true;
        }
        if(mat[0][2]==x && mat[1][1]==x && mat[2][0]==x){
            return true;
        }
        return false;
    }

    public void verificarJogada(int x) {
        if (vitoria(x) == true) {

            AlertDialog.Builder alertaGanhador = new AlertDialog.Builder(this);
            alertaGanhador.setTitle("Ganhador Ganhador Galinha pro Jantar!!!");
            alertaGanhador.setMessage("Vendedor: " + ganhador + "Venceu!");
            alertaGanhador.setIcon(android.R.drawable.star_on);
            alertaGanhador.setPositiveButton("OK", null);
            alertaGanhador.create();
            alertaGanhador.show();
            acabou();
        }
    }
    public void acabou(){
            for(int i=0;i<9;i++){
                botao[i].setEnabled(false);
            }
        }
    public void limpar(){
            for(int i=0;i<9;i++){
                botao[i].setEnabled(true);
                botao[i].setText("");
            }
            for(int x=0;x<3;x++){
                for (int y=0;y<3;y++){
                   mat[x][y]=0;
                }
            }
            jogador=1;
            jogador1="";
            jogador2="";
            ganhador="";

    }
}