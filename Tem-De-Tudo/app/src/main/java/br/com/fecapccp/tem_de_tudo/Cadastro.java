package br.com.fecapccp.tem_de_tudo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Cadastro extends AppCompatActivity {

    private Button btnCadastrar;
    private EditText et_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);

        Log.i("Ciclo de Vida", "Tela cadastro - onCreate");

        btnCadastrar = findViewById(R.id.btnCadastrar);
        et_nome = findViewById(R.id.et_nome);

        btnCadastrar.setOnClickListener(view -> {
            cadastro();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnCadastro), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela cadastro - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela cadastro - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela cadastro - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela cadastro - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela cadastro - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela cadastro - onStart");
    }

    private void cadastro() {

        String nome = et_nome.getText().toString();

        // Recuperando valores e inicializando a intent

        Intent intent = new Intent(this, Final.class);
        intent.putExtra("nome", nome);
        startActivity(intent);

    }
}