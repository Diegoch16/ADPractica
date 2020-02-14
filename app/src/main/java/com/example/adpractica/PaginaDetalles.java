package com.example.adpractica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.adpractica.adapter.DispositivoAdapter;
import com.example.adpractica.models.Dispositivo;



public class PaginaDetalles extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_detalles);

        recibirDatos();

    }

    private void recibirDatos(){

        Bundle extras = getIntent().getExtras();
        String id = extras.getString("id");
        String tiempo = extras.getString("tiempo");
        String nombre = extras.getString("nombre");
        String origen = extras.getString("origen");
        String destino = extras.getString("destino");
        String longitud = extras.getString("longitud");
        String protocolo = extras.getString("protocolo");

        texto =  findViewById(R.id.textView4);
        texto.setText("ID: " +id+ "\nTiempo: " + tiempo+ "\nNombre: "+nombre+ "\nOrigen: "+origen+"\nDestino: "+destino+"\nLongitud: "+longitud+"\nProtocolo: "+protocolo);


    }
}
