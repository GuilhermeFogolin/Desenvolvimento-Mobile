package br.com.fecapccp.lanche_facil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityPedido extends AppCompatActivity {

    private EditText et_nome;
    private String item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido);

        Log.i("Ciclo de Vida", "Tela pedidos - onCreate");

        et_nome = findViewById(R.id.et_nome);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela pedidos - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela pedidos - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela pedidos - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela pedidos - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela pedidos - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela pedidos - onStart");
    }
    public void selecionarPedido(View v) {
        Button button = (Button) v;
        item = button.getText().toString(); // Selecionando o item do cardápio
    }
    public void resumo(View v) {

        String nome = et_nome.getText().toString();

        if (nome.isEmpty()) {
            Toast.makeText(this, "Por favor, insira seu nome! ⚠️", Toast.LENGTH_SHORT).show();
            return;
        }

        if (item == null) {
            Toast.makeText(this, "Por favor, selecione um item do cardápio. 🍟", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, ActivityResumo.class);
        intent.putExtra("nome", nome);
        intent.putExtra("pedido", item);
        startActivity(intent);
    }
}