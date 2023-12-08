package com.example.myapplication;

import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] saldo;
    private String[] cantidades;

    public MyAdapter(String[] saldo, String[] cantidades) {
        this.saldo = saldo;
        this. cantidades = cantidades; 
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.saldoTextView.setText(saldo[position]);
        holder.cantidadTextView.setText(cantidades[position]);
    }

    @Override
    public int getItemCount() {
        return saldo.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView saldoTextView;
        public TextView cantidadTextView;

        public ViewHolder(@NonNull View itemView) {
           /* super(itemView);
            saldoTextView = itemView.findViewById(R.id.textSaldo);
            cantidadTextView = itemView.findViewById(R.id.textCantidad);*/

            super(itemView);
            saldoTextView = itemView.findViewById(R.id.textSaldo);
            saldoTextView.setOnClickListener(view -> {
                if (cantidadTextView.getVisibility()==View.VISIBLE) {
                    cantidadTextView.setVisibility(View.INVISIBLE);
                } else {
                    cantidadTextView.setVisibility(View.VISIBLE);
                }
            });
            cantidadTextView = itemView.findViewById(R.id.textCantidad);
            // Oculta la cantidad
            cantidadTextView.setVisibility(View.INVISIBLE);
        }
    }
}
