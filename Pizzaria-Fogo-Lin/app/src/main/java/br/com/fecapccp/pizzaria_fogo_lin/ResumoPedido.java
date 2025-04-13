package br.com.fecapccp.pizzaria_fogo_lin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ResumoPedido extends AppCompatActivity {

    private TextView pizzaIntent, tamanhoIntent, pagamentoIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);

        Log.i("Ciclo de Vida", "Tela ResumoPedido - onCreate");

        // Vinculando os TextViews com as views pelo ID:

        pizzaIntent = findViewById(R.id.pizzaIntent);
        tamanhoIntent = findViewById(R.id.tamanhoIntent);
        pagamentoIntent = findViewById(R.id.pagamentoIntent);

        // Recuperando os dados da Intent

        ArrayList<String> sabores = getIntent().getStringArrayListExtra("sabores");
        String tamanho = getIntent().getStringExtra("tamanho");
        String pagamento = getIntent().getStringExtra("pagamento");

        // Impressão dos sabores de pizza

        if (sabores != null && !sabores.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String sabor : sabores) {
                sb.append("- ").append(sabor).append("\n");
            }
            pizzaIntent.setText(sb.toString());
        } else {
            pizzaIntent.setText("Nenhum sabor selecionado! ");
        }

        // Impressão do tamanho

        if (tamanho != null && !tamanho.isEmpty()) {
            tamanhoIntent.setText(tamanho);
        } else {
            tamanhoIntent.setText("Tamanho não especificado.");
        }

        // Impressão da forma de pagamento
        if (pagamento != null && !pagamento.isEmpty()) {
            pagamentoIntent.setText(pagamento);
        } else {
            pagamentoIntent.setText("Forma de pagamento não especificada.");
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela ResumoPedido - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela ResumoPedido - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela ResumoPedido - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela ResumoPedido - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela ResumoPedido - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela ResumoPedido - onStart");
    }

    public void voltar(View v) {
        Intent intent = new Intent(ResumoPedido.this, Seletor.class);
        startActivity(intent);
        finish();
    }
}