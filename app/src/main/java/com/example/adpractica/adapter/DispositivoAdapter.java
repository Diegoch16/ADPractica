package com.example.adpractica.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adpractica.R;
import com.example.adpractica.listener.DispositivoAdapterListener;
import com.example.adpractica.models.Dispositivo;

import java.util.ArrayList;
import java.util.List;

public class DispositivoAdapter extends RecyclerView.Adapter<DispositivoAdapter.PlatoHolder> {

    private static final int layout = R.layout.adaptador_dispositivo_item;
    private final DispositivoAdapterListener listener;
    private final Activity act;
    private List<Dispositivo> items = new ArrayList<Dispositivo>();

    public DispositivoAdapter(Activity act, List<Dispositivo> items, DispositivoAdapterListener listener) {
        this.act = act;
        this.items = items;
        this.listener = listener;
        Log.d("ADAPTER","Items Size: "+items.size());
    }

    @NonNull
    @Override
    public PlatoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(layout, parent, false);

        Log.d("ADAPTER","Inflate");

        return new PlatoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatoHolder holder, int position) {
        final Dispositivo item = items.get(position);

        Log.d("ADAPTER","Item: "+position+" - Nombre:"+item.nombre);

        holder.txt.setText(item.id + item.nombre);

        holder.linRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (listener != null) {
                    listener.click(item);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        Log.d("ADAPTER","Items Size2: "+items.size());
        return items.size();
    }

    public class PlatoHolder extends RecyclerView.ViewHolder {
        public TextView txt;

        public LinearLayout linRoot;

        void initView(View v){
            txt = v.findViewById(R.id.dispositivo_item_nombre);
            linRoot = v.findViewById(R.id.dispositivo_item_root_lin);
        }

        public PlatoHolder(View v) {
            super(v);
            initView(v);
        }
    }
}