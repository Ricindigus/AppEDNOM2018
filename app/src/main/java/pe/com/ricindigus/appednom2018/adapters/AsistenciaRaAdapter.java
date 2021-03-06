package pe.com.ricindigus.appednom2018.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.com.ricindigus.appednom2018.R;
import pe.com.ricindigus.appednom2018.modelo.AsistenciaRaReg;
import pe.com.ricindigus.appednom2018.modelo.AsistenciaReg;

public class AsistenciaRaAdapter extends RecyclerView.Adapter<AsistenciaRaAdapter.ViewHolder>{
    ArrayList<AsistenciaRaReg> asistenciaLocals;
    Context context;

    public AsistenciaRaAdapter(ArrayList<AsistenciaRaReg> asistenciaLocals, Context context) {
        this.asistenciaLocals = asistenciaLocals;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asistencia,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        AsistenciaRaReg asistenciaRaReg = asistenciaLocals.get(position);
        holder.txtDni.setText(asistenciaRaReg.getDni());
        holder.txtNombres.setText(asistenciaRaReg.getNombres_completos());
        holder.txtFecha.setText(checkDigito(asistenciaRaReg.getDia()) + "-"
                + checkDigito(asistenciaRaReg.getMes()) + "-" + checkDigito(asistenciaRaReg.getAnio()) + " "
                + checkDigito(asistenciaRaReg.getHora()) + ":" + checkDigito(asistenciaRaReg.getMin())+ ":" + checkDigito(asistenciaRaReg.getSeg()));
        if(asistenciaRaReg.getEstado() == 2) holder.cv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.greenPrimaryLight));
        else if(asistenciaRaReg.getEstado() == 1) holder.cv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.amberPrimaryLight));
        else holder.cv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.redPrimaryLight));
    }

    public String checkDigito (int number) {
        return number <= 9 ? "0" + number : String.valueOf(number);
    }

    @Override
    public int getItemCount() {
        return asistenciaLocals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtDni;
        TextView txtNombres;
        TextView txtFecha;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.item_asistencia_cv);
            txtDni = itemView.findViewById(R.id.item_asistencia_txtDni);
            txtNombres = itemView.findViewById(R.id.item_asistencia_txtNombres);
            txtFecha = itemView.findViewById(R.id.item_asistencia_txtFecha);
        }
    }
}
