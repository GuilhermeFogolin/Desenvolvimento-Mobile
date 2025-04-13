package br.com.fecapccp.pizzaria_fogo_lin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class TamanhoPagamento extends AppCompatActivity {

    private RadioGroup rgTamanho, rgPagamento;
    private Button btnFinalizar;

    private ArrayList<String> saboresEscolhidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tamanho_pagamento);

        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onCreate");

        // Vinculando os RadioGroups e botão com as views pelo ID:

        rgTamanho = findViewById(R.id.rgTamanho);
        rgPagamento = findViewById(R.id.rgPagamento);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        // Recuperando os sabores selecionados da tela anterior
        saboresEscolhidos = getIntent().getStringArrayListExtra("sabores");

        // Configurando o clique do botão

        finalizarPedido();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela TamanhoPagamento - onStart");
    }

    public void finalizarPedido() {

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tamanho = recuperandoTamanho();
                String pagamento = recuperandoPagamento();

                if (tamanho != null && pagamento != null) {
                    Intent intent = new Intent(TamanhoPagamento.this, ResumoPedido.class);
                    intent.putStringArrayListExtra("sabores", saboresEscolhidos);
                    intent.putExtra("tamanho", tamanho);
                    intent.putExtra("pagamento", pagamento);
                    startActivity(intent);
                } else {
                    Toast.makeText(TamanhoPagamento.this, "Selecione o tamanho da pizza e a forma de pagamento! 😋", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String recuperandoTamanho() {
        int selectedId = rgTamanho.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            return radioButton.getText().toString();
        }
        return null;
    }
    private String recuperandoPagamento() {
        int selectedId = rgPagamento.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            return radioButton.getText().toString();
        }
        return null;
    }
}