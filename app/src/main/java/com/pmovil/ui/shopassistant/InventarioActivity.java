package com.pmovil.ui.shopassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import static com.pmovil.ui.shopassistant.MainActivity.listArinve;

public class InventarioActivity extends AppCompatActivity {
    ListView listaInv;
    AdaptaInv adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        Articulos[] arrinv= new Articulos[listArinve.size()];
        arrinv=listArinve.toArray(arrinv);
        adapter = new AdaptaInv(this,R.layout.layout_inventario,arrinv);
        listaInv=(ListView)findViewById(R.id.listView2);
        View header= getLayoutInflater().inflate(R.layout.header_list2,null);
        listaInv.addHeaderView(header);
        listaInv.setAdapter(adapter);
    }
}
