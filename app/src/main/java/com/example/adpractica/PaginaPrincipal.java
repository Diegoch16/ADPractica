package com.example.adpractica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adpractica.adapter.DispositivoAdapter;
import com.example.adpractica.listener.DispositivoAdapterListener;
import com.example.adpractica.models.Dispositivo;

import java.util.ArrayList;
import java.util.List;

public class PaginaPrincipal extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina_principal);

        Button boton = (Button) findViewById(R.id.btnBuscar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    BuscarDispositivos();

            }
        });



    }

    private void BuscarDispositivos() {

        RecyclerView contenedor = findViewById(R.id.padina_principal_rec);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        //GridLayoutManager manager = new GridLayoutManager(this, 4);
        //LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        contenedor.setLayoutManager(manager);


        DispositivoAdapterListener listener = new DispositivoAdapterListener() {
            @Override
            public void click(Dispositivo item) {
                Intent arrancar = new Intent(PaginaPrincipal.this, PaginaDetalles.class);
                String i =  String.valueOf(item.getId());
                String t = String.valueOf(item.getTiempo());
                String n = item.getNombre();
                String o = item.getOrigen();
                String d = item.getDestino();
                String l = String.valueOf(item.getLongitud());
                String p = item.getProtocolo();

                arrancar.putExtra("id",i);
                arrancar.putExtra("tiempo",t);
                arrancar.putExtra("nombre",n);
                arrancar.putExtra("origen",o);
                arrancar.putExtra("destino",d);
                arrancar.putExtra("longitud",l);
                arrancar.putExtra("protocolo",p);

                startActivity(arrancar);

            }
        };


        List<Dispositivo> items = new ArrayList<>();

        Dispositivo telefono, telefono2, telefono3, telefono4, telefono5, tablet1, ordenador1, ordenador2, tablet2, telefono6;

        telefono = new Dispositivo();
        telefono2 = new Dispositivo();
        telefono3 = new Dispositivo();
        telefono4 = new Dispositivo();
        telefono5 = new Dispositivo();
        tablet1 = new Dispositivo();
        ordenador1 = new Dispositivo();
        ordenador2 = new Dispositivo();
        tablet2 = new Dispositivo();
        telefono6 = new Dispositivo();

        telefono.id = 0;
        telefono.tiempo = 5.678;
        telefono.nombre = " Samsung Galaxy 7";
        telefono.origen = "192.168.0.17";
        telefono.destino = "192.168.9.20";
        telefono.longitud = 42;
        telefono.protocolo = "ICMP";

        telefono2.id = 1;
        telefono2.tiempo = 4.678;
        telefono2.nombre = " Samsung Galaxy 5";
        telefono2.origen = "192.168.2.7";
        telefono2.destino = "192.168.10.20";
        telefono2.longitud = 27;
        telefono2.protocolo = "UDP";

        telefono3.id = 2;
        telefono3.tiempo = 3.123;
        telefono3.nombre = " Samsung A5";
        telefono3.origen = "192.168.0.1";
        telefono3.destino = "192.168.0.2";
        telefono3.longitud = 24;
        telefono3.protocolo = "ICMP";

        telefono4.id = 3;
        telefono4.tiempo = 2.890;
        telefono4.nombre = " Aquaris BQ Plus";
        telefono4.origen = "192.170.5.8";
        telefono4.destino = "192.173.10.20";
        telefono4.longitud = 72;
        telefono4.protocolo = "ICMP";

        telefono5.id = 4;
        telefono5.tiempo = 3.210;
        telefono5.nombre = " LGK9";
        telefono5.origen = "192.180.9.21";
        telefono5.destino = "192.169.9.20";
        telefono5.longitud = 33;
        telefono5.protocolo = "UDP";

        tablet1.id = 5;
        tablet1.tiempo = 1.234;
        tablet1.nombre = " IPad mini";
        tablet1.origen = "192.190.34.4";
        tablet1.destino = "192.195.11.22";
        tablet1.longitud = 33;
        tablet1.protocolo = "SSDP";

        ordenador1.id = 6;
        ordenador1.tiempo = 0.056;
        ordenador1.nombre = " Desktop -3THCP9";
        ordenador1.origen = "192.168.14.1";
        ordenador1.destino = "192.168.14.2";
        ordenador1.longitud = 56;
        ordenador1.protocolo = "ICMP";

        ordenador2.id = 7;
        ordenador2.tiempo = 0.100;
        ordenador2.nombre = " Desktop -4HTPV4";
        ordenador2.origen = "192.175.2.7";
        ordenador2.destino = "192.176.12.2";
        ordenador2.longitud = 27;
        ordenador2.protocolo = "SSDP";

        tablet2.id = 8;
        tablet2.tiempo = 1.678;
        tablet2.nombre = " IPad";
        tablet2.origen = "192.160.0.10";
        tablet2.destino = "192.162.9.12";
        tablet2.longitud = 42;
        tablet2.protocolo = "ICMP";

        telefono6.id = 9;
        telefono6.tiempo = 9.125;
        telefono6.nombre = " Xiaomi -Redmi7";
        telefono6.origen = "192.155.8.5";
        telefono6.destino = "192.175.9.6";
        telefono6.longitud = 56;
        telefono6.protocolo = "UDP";

        items.add(telefono);
        items.add(telefono2);
        items.add(telefono3);
        items.add(telefono4);
        items.add(telefono5);
        items.add(tablet1);
        items.add(ordenador1);
        items.add(ordenador2);
        items.add(tablet2);
        items.add(telefono6);

        DispositivoAdapter adaptador = new DispositivoAdapter(this, items, listener);

        contenedor.setAdapter(adaptador);


    }
}
