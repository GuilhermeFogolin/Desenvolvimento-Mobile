package br.com.fecapccp.lanche_facil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityResumo extends AppCompatActivity {

    private TextView tv_nome;
    private TextView tv_pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo);

        tv_nome = findViewById(R.id.tv_nome);
        tv_pedido = findViewById(R.id.tv_pedido);

        // Recuperando os dados da Intent

        String nome = getIntent().getStringExtra("nome");
        String pedido = getIntent().getStringExtra("pedido");

        // Impressão dos dados

        tv_nome.setText("Caro(a), " + nome + "!");
        tv_pedido.setText("Seu pedido foi: " + pedido + ". Agradecemos a preferência! 🍟");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela resumo - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela resumo - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela resumo - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela resumo - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela resumo - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela resumo - onStart");
    }

    public void voltar(View v) {
        Intent intent = new Intent(ActivityResumo.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}