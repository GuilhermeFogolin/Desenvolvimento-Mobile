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

import java.util.ArrayList;
import java.util.List;

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
        btnContinuar.setEnabled(false); // Inicialmente desabilitado, até selecionar a pizza.

        // Configurando o clique do botão e checkboxes:

        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                verificarSelecao();
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
                List<String> saboresSelecionados = obterSaboresSelecionados();
                if (!saboresSelecionados.isEmpty()) {
                    Intent intent = new Intent(Seletor.this, TamanhoPagamento.class);
                    intent.putStringArrayListExtra("sabores", (ArrayList<String>) saboresSelecionados);
                    startActivity(intent);
                } else {
                    Toast.makeText(Seletor.this, "Selecione pelo menos um sabor de pizza! 🍕", Toast.LENGTH_SHORT).show();
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

    // Validando se alguma pizza foi selecionada.
    private void verificarSelecao() {
        if (cbCalabresa.isChecked() || cbMarguerita.isChecked() || cbQueijo.isChecked() ||
                cbPortuguesa.isChecked() || cbFrango.isChecked() || cbChocolate.isChecked()) {
            btnContinuar.setEnabled(true);
        } else {
            btnContinuar.setEnabled(false);
        }
    }

    // Adicionando os sabores selecionados em uma lista
    private List<String> obterSaboresSelecionados() {
        List<String> selecionados = new ArrayList<>();
        if (cbCalabresa.isChecked()) {
            selecionados.add(cbCalabresa.getText().toString());
        }
        if (cbMarguerita.isChecked()) {
            selecionados.add(cbMarguerita.getText().toString());
        }
        if (cbQueijo.isChecked()) {
            selecionados.add(cbQueijo.getText().toString());
        }
        if (cbPortuguesa.isChecked()) {
            selecionados.add(cbPortuguesa.getText().toString());
        }
        if (cbFrango.isChecked()) {
            selecionados.add(cbFrango.getText().toString());
        }
        if (cbChocolate.isChecked()) {
            selecionados.add(cbChocolate.getText().toString());
        }
        return selecionados;
    }
}