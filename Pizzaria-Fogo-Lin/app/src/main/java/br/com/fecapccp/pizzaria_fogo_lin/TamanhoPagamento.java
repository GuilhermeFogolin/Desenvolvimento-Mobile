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

import java.util.HashMap;
import java.util.Map;

public class TamanhoPagamento extends AppCompatActivity {

    private RadioGroup rgTamanho, rgPagamento;
    private Button btnFinalizar;
    private Map<String, String> saboresEscolhidos;
    private String tamanhoSelecionado;
    private double precoTamanhoSelecionado;
    private String pagamentoSelecionado;

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

        // Recupera os sabores com seus preços da tela anterior
        saboresEscolhidos = (HashMap<String, String>) getIntent().getSerializableExtra("sabores_com_preco");

        // Configura a seleção de tamanho
        configurarSelecaoTamanho();

        // Configura a seleção de pagamento
        configurarSelecaoPagamento();

        // Botão para finalizar o pedido
        configurarBotaoFinalizar();

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

    public void configurarSelecaoTamanho() {
        rgTamanho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if (radioButton != null) {
                    tamanhoSelecionado = radioButton.getText().toString();
                } else {
                    tamanhoSelecionado = null;
                }
            }
        });
    }
    public void configurarSelecaoPagamento() {
        rgPagamento.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if (radioButton != null) {
                    pagamentoSelecionado = radioButton.getText().toString();
                } else {
                    pagamentoSelecionado = null;
                }
            }
        });
    }

    public void configurarBotaoFinalizar() {
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tamanhoSelecionado != null && pagamentoSelecionado != null) {
                    Intent intent = new Intent(TamanhoPagamento.this, ResumoPedido.class);
                    intent.putExtra("sabores_com_preco", (HashMap<String, String>) saboresEscolhidos);
                    intent.putExtra("tamanho", tamanhoSelecionado);
                    intent.putExtra("preco_tamanho", precoTamanhoSelecionado);
                    intent.putExtra("pagamento", pagamentoSelecionado);
                    startActivity(intent);
                } else {
                    Toast.makeText(TamanhoPagamento.this, "Selecione o tamanho da pizza e a forma de pagamento! 😋", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}