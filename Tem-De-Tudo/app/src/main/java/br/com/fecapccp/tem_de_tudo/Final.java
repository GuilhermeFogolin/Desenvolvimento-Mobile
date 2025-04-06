package br.com.fecapccp.tem_de_tudo;

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

public class Final extends AppCompatActivity {

    private TextView tv_final;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final);

        Log.i("Ciclo de Vida", "Tela final - onCreate");

        tv_final = findViewById(R.id.tv_final);
        btnFechar = findViewById(R.id.btnFechar);

        // Recebendo os dados da tela de cadastro: Intent e itens extras.

        Bundle bundle = getIntent().getExtras();

        String nome = bundle.getString("nome");

        // Imprimindo o resultado:

        tv_final.setText("Seja muito bem-vindo(a), " + nome + "!");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela final - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela final - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela final - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela final - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela final - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela final - onStart");
    }

    // Função para retornar para tela principal:
    public void fechar(View v) {
        Intent intent = new Intent(Final.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}