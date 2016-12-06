package com.pmovil.ui.shopassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class InventarioActivity extends AppCompatActivity {
    ListView listaInv;
    AdaptaInv adapter;
    ArrayList<Articulos> listArinv=new ArrayList<Articulos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        listArinv.add(new Articulos("Mascara Antipolucion","28","1"));
        listArinv.add(new Articulos("Drone Eachine H8c","5","2"));
        Articulos[] arrinv= new Articulos[listArinv.size()];
        arrinv=listArinv.toArray(arrinv);
        adapter = new AdaptaInv(this,R.layout.layout_inventario,arrinv);
        listaInv=(ListView)findViewById(R.id.listView2);
        View header= getLayoutInflater().inflate(R.layout.header_list2,null);
        listaInv.addHeaderView(header);
        listaInv.setAdapter(adapter);
    }
}
