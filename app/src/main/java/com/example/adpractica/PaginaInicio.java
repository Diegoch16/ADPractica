package com.example.adpractica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class PaginaInicio extends AppCompatActivity {

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_inicio);

        boton = (Button) findViewById(R.id.btnArrancar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent arrancar = new Intent(PaginaInicio.this, PaginaPrincipal.class);
                startActivity(arrancar);

            }
        });
    }
}
