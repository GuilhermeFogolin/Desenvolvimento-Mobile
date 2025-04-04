package br.com.fecapccp.sistema_de_compras;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tv_resultado;
    private CheckBox arroz, leite, carne, feijao, refri, macarrao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv_resultado = findViewById(R.id.tv_resultado);
        arroz = findViewById(R.id.arroz);
        leite = findViewById(R.id.leite);
        carne = findViewById(R.id.carne);
        feijao = findViewById(R.id.feijao);
        refri = findViewById(R.id.refri);
        macarrao = findViewById(R.id.macarrao);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void somar(View v) {
        calculo();
    }
    public void calculo() {

        double soma = 0;
        double resArroz = 2.69,
                resLeite = 2.70,
                resCarne = 16.70,
                resFeijao = 3.38,
                resRefri = 3.00,
                resMacarrao = 4.50;

        if (arroz.isChecked()) {
            soma += resArroz;
        }

        if (leite.isChecked()) {
            soma += resLeite;
        }

        if (carne.isChecked()) {
            soma += resCarne;
        }

        if (feijao.isChecked()) {
            soma += resFeijao;
        }

        if (refri.isChecked()) {
            soma += resRefri;
        }

        if (macarrao.isChecked()) {
            soma += resMacarrao;
        }

        String resultado = String.format("%.2f", soma);
        tv_resultado.setText("Total: R$" + resultado);
    }

}