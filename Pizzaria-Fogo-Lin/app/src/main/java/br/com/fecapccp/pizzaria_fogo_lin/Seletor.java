package br.com.fecapccp.pizzaria_fogo_lin;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

public class Seletor extends AppCompatActivity {

    private Button btnContinuar;
    private CheckBox cbCalabresa, cbMarguerita, cbQueijo, cbPortuguesa, cbFrango, cbChocolate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seletor);

        Log.i("Ciclo de Vida", "Tela seletor - onCreate");

        // Vinculando os CheckBoxes e botão com as views pelo ID:

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbMarguerita = findViewById(R.id.cbMarguerita);
        cbQueijo = findViewById(R.id.cbQueijo);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        cbFrango = findViewById(R.id.cbFrango);
        cbChocolate = findViewById(R.id.cbChocolate);

        btnContinuar = findViewById(R.id.btnContinuar);

        // Configurando o clique dos checkboxes:

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            }
        };

        cbCalabresa.setOnCheckedChangeListener(listener);
        cbMarguerita.setOnCheckedChangeListener(listener);
        cbQueijo.setOnCheckedChangeListener(listener);
        cbPortuguesa.setOnCheckedChangeListener(listener);
        cbFrango.setOnCheckedChangeListener(listener);
        cbChocolate.setOnCheckedChangeListener(listener);

        // Configurando o clique do botão "Continuar":

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nenhumCheckBoxSelecionado()) {
                    Toast.makeText(Seletor.this, "Selecione pelo menos um sabor de pizza! 🍕", Toast.LENGTH_SHORT).show();
                } else {
                    Map<String, String> saboresSelecionadosComPreco = obterSaboresSelecionadosComPreco();
                    Intent intent = new Intent(Seletor.this, TamanhoPagamento.class);
                    intent.putExtra("sabores_com_preco", (HashMap<String, String>) saboresSelecionadosComPreco);
                    startActivity(intent);
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de Vida", "Tela seletor - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de Vida", "Tela seletor - onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela seletor - onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de Vida", "Tela seletor - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela seletor - onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de Vida", "Tela seletor - onStart");
    }

    // Verifica se nenhum CheckBox está selecionado
    private boolean nenhumCheckBoxSelecionado() {
        return !cbCalabresa.isChecked() && !cbMarguerita.isChecked() && !cbQueijo.isChecked() &&
                !cbPortuguesa.isChecked() && !cbFrango.isChecked() && !cbChocolate.isChecked();
    }

    // Adicionando os sabores selecionados em um mapa com nome e preço
    private Map<String, String> obterSaboresSelecionadosComPreco() {
        Map<String, String> selecionadosComPreco = new HashMap<>();
        if (cbCalabresa.isChecked()) {
            selecionadosComPreco.put("Calabresa", "29.90");
        }
        if (cbMarguerita.isChecked()) {
            selecionadosComPreco.put("Marguerita", "32.50");
        }
        if (cbQueijo.isChecked()) {
            selecionadosComPreco.put("Cinco queijos", "45.99");
        }
        if (cbPortuguesa.isChecked()) {
            selecionadosComPreco.put("Portuguesa", "38.45");
        }
        if (cbFrango.isChecked()) {
            selecionadosComPreco.put("Frango com catupiry", "37.99");
        }
        if (cbChocolate.isChecked()) {
            selecionadosComPreco.put("Chocolate", "50.00");
        }
        return selecionadosComPreco;
    }
}