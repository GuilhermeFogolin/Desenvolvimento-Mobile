package br.com.fecapccp.pizzaria_fogo_lin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Map;

public class ResumoPedido extends AppCompatActivity {

    private TextView pizzaIntent, tamanhoIntent, pagamentoIntent, valorIntent;

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
        valorIntent = findViewById(R.id.valorIntent);

        // Recuperando os dados da Intent

        Map<String, String> saboresComPreco = (Map<String, String>) getIntent().getSerializableExtra("sabores_com_preco");
        String tamanho = getIntent().getStringExtra("tamanho");
        double precoTamanho = getIntent().getDoubleExtra("preco_tamanho", 0.00);
        String pagamento = getIntent().getStringExtra("pagamento");

        // Exibindo os sabores

        if (saboresComPreco != null && !saboresComPreco.isEmpty()) {
            StringBuilder sb = new StringBuilder("");
            double precoSabores = 0.00;
            for (Map.Entry<String, String> entry : saboresComPreco.entrySet()) {
                sb.append("- ").append(entry.getKey()).append(" (R$").append(entry.getValue()).append(")\n");
                precoSabores += Double.parseDouble(entry.getValue());
            }
            pizzaIntent.setText(sb.toString());
        } else {
            pizzaIntent.setText("Nenhum sabor selecionado.");
        }

        // Exibindo o tamanho

        if (tamanho != null && !tamanho.isEmpty()) {
            tamanhoIntent.setText(tamanho);
        } else {
            tamanhoIntent.setText("Tamanho não especificado.");
        }

        // Exibindo a forma de pagamento

        if (pagamento != null && !pagamento.isEmpty()) {
            pagamentoIntent.setText(pagamento);
        } else {
            pagamentoIntent.setText("Forma de pagamento não especificada.");
        }

        // Calculando e imprimindo o valor total

        double valorTotal = 0.00;
        if (saboresComPreco != null) {
            for (String precoStr : saboresComPreco.values()) {
                valorTotal += Double.parseDouble(precoStr);
            }
        }
        valorIntent.setText("Valor Total: R$" + String.format("%.2f", valorTotal));

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