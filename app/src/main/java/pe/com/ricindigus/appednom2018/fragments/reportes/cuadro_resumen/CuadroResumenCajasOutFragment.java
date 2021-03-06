package pe.com.ricindigus.appednom2018.fragments.reportes.cuadro_resumen;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pe.com.ricindigus.appednom2018.R;
import pe.com.ricindigus.appednom2018.modelo.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class CuadroResumenCajasOutFragment extends Fragment {


    Context context;
    int nroLocal;
    TextView txtAplicacion;
    TextView txtAdicionales;
    TextView txtCandado;
    TextView txtTotal;



    public CuadroResumenCajasOutFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CuadroResumenCajasOutFragment(Context context, int nroLocal) {
        this.context = context;
        this.nroLocal = nroLocal;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cuadro_resumen_cajas_out, container, false);
        txtAplicacion = (TextView) rootView.findViewById(R.id.resumen_cajas_txtAplicacion);
        txtAdicionales = (TextView) rootView.findViewById(R.id.resumen_cajas_txtAdicional);
        txtCandado = (TextView) rootView.findViewById(R.id.resumen_cajas_txtCandado);
        txtTotal = (TextView) rootView.findViewById(R.id.resumen_cajas_txtTotal);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Data data =  new Data(context);
        data.open();
        int ap = data.getNroCajasSalidaLeidasxTipo(nroLocal,1);
        int ad = data.getNroCajasSalidaLeidasxTipo(nroLocal,2);
        int cand = data.getNroCajasSalidaLeidasxTipo(nroLocal,3);
        int tAp=data.getNroCajasSalidaTotalxTipo(nroLocal,1);
        int tAd = data.getNroCajasSalidaTotalxTipo(nroLocal,2);
        int tCand = data.getNroCajasSalidaTotalxTipo(nroLocal,3);
        txtAplicacion.setText(ap+"/"+tAp);
        txtAdicionales.setText(ad+"/"+tAd);
        txtCandado.setText(cand+"/"+tCand);
        txtTotal.setText((ap+ad+cand)+"/"+(tAp+tAd+tCand));
        data.close();
    }

}
