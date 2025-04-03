package com.example.checkbox;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private CheckBox cbVermelho, cbAzul, cbVerde, cbRosa;
    private RadioGroup rg;
    private RadioButton rbOpcao1, rbOpcao2, rbOpcao3, rbOpcao4;
    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        cbAzul = findViewById(R.id.cbAzul);
        cbRosa = findViewById(R.id.cbRosa);
        cbVerde = findViewById(R.id.cbVerde);
        cbVermelho = findViewById(R.id.cbVermelho);

        textResultado = findViewById(R.id.textResultado);

        btnSet  = findViewById(R.id.btnSet);

        rg = findViewById(R.id.rg);
        rbOpcao1 = findViewById(R.id.rbOpcao1);
        rbOpcao2 = findViewById(R.id.rbOpcao2);
        rbOpcao3 = findViewById(R.id.rbOpcao3);
        rbOpcao4 = findViewById(R.id.rbOpcao4);

        // radioButton();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void enviar(View v) {
      // checkBox();
      radioButton();
    }

    // Método para tratar o RadioGroup

    public void radioButton() {

        if(rbOpcao1.isChecked()) {
            textResultado.setText("Opção 1 Selecionada");
        }
        /*rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbOpcao1) {
                    textResultado.setText("Opção 1 Selecionada");
                } else if(checkedId == R.id.rbOpcao2) {
                    textResultado.setText("Opção 2 Selecionada");
                } else if(checkedId == R.id.rbOpcao3) {
                    textResultado.setText("Opção 3 Selecionada");
                } else if(checkedId == R.id.rbOpcao4) {
                    textResultado.setText("Opção 4 Selecionada");
                }
            }
        }); */
    }

    // Método para tratar o CheckBox

    public void checkBox() {

        String texto = "Sem Cor Selecionada";

        if(cbVermelho.isChecked()) {
            // String corSelecionada = "Vermelho" Aqui vai obter a cor selecionada
            String corSelecionada = cbVermelho.getText().toString();
            texto = corSelecionada; // Aqui vai o contéudo da resposta
        }

        if(cbVerde.isChecked()) {
            String corSelecionada = cbVerde.getText().toString();
            texto = texto + " " + corSelecionada;
        }

        if(cbAzul.isChecked()) {
            String corSelecionada = cbAzul.getText().toString();
            texto = texto + " " + corSelecionada;
        }

        if(cbRosa.isChecked()) {
            String corSelecionada = cbRosa.getText().toString();
            texto = texto + " " + corSelecionada;
        }

        textResultado.setText(texto);
    }
}