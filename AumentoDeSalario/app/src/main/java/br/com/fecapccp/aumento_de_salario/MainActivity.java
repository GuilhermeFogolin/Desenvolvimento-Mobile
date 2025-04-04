package br.com.fecapccp.aumento_de_salario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tv_resultado;
    private EditText et_sal;
    private RadioButton rb40, rb45, rb50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv_resultado = findViewById(R.id.tv_resultado);
        et_sal = findViewById(R.id.et_sal);
        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcularAumento(View v) {
        aumento();
    }

    public void aumento() {

        String salario = et_sal.getText().toString();
        double total = 0;

        // Convertendo para numérico

        double sal = Double.parseDouble(salario);

        // Validação do salário

        if(rb40.isChecked()) {
            total = sal * 1.4;
        }
        if(rb45.isChecked()) {
            total = sal * 1.45;
        }
        if(rb50.isChecked()) {
            total = sal * 1.5;
        }

      // Exibindo o resultado

      String salarioFinal = String.format("%.2f", total);
      tv_resultado.setText("R$" + salarioFinal);

    }
}