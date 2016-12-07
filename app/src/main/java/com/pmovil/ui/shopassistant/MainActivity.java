package com.pmovil.ui.shopassistant;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ClipboardManager mClipboardManager;
    private TextView salida;
    public String entrada;
    public EditText reper,claper;
    int i=0,j=0,ocu=-1,longArr=0;
    boolean listen=false;
    Respuestas[] arrayres;
    ListView listaRes;
    AdaptaRes adapter;
    ArrayList <Respuestas> listArres=new ArrayList<Respuestas>();
    public static ArrayList <Articulos>  listArinve=new ArrayList<Articulos>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelperRes helper = new HelperRes(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        listArinve.add(new Articulos("Mascara Antipolucion","28","1"));
        listArinve.add(new Articulos("Drone Eachine H8c","5","2"));
        listArinve.add(new Articulos("Eachine H8c","55","3"));
        listArres.add(new Respuestas("Esta es tu respuesta predeterminada", new String[]{"prueba", "respuesta","ensayo"}));
        listArres.add(new Respuestas("Hay -- unidades disponibles de ---", new String[]{"1", "2","3"}));
        //listArres.add(new Respuestas("Cordial saludo, estoy ubicado en la carrera 52#25-370, queda sobre la avenida guayabal mas adelante de la cruz roja","ubicado","recoger","pasar"));
        arrayres= new Respuestas[listArres.size()];
        arrayres=listArres.toArray(arrayres);
        adapter = new AdaptaRes(this,R.layout.layout_respuestas,arrayres);
        listaRes=(ListView)findViewById(R.id.listView);
        View header= getLayoutInflater().inflate(R.layout.header_list,null);
        listaRes.addHeaderView(header);
        listaRes.setAdapter(adapter);
        reper=(EditText) findViewById(R.id.reper);
        claper=(EditText) findViewById(R.id.claper);
        salida = (TextView) findViewById(R.id.muestra);
        findViewById(R.id.btnAdicionar).setOnClickListener(this);
        findViewById(R.id.btnInventario).setOnClickListener(this);
        mClipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        //FUNCION LLAMADA AL COPIAR AL PORTAPAPELES
        mClipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                j=0;
                longArr= listArres.size();
                String newClip = mClipboardManager.getText().toString();
                Toast.makeText(getApplicationContext(), newClip,  Toast.LENGTH_SHORT).show();
                if (!listen) {
                    while (j<longArr) {
                        compara(listArres.get(j),listArres.get(j).claves.length);
                        j++;
                    }
                }
                else listen=false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdicionar:
                String cadena = claper.getText().toString();
                String delimitadores= " ";
                String[] palabrasSeparadas = cadena.split(delimitadores);
                listArres.add(new Respuestas(reper.getText().toString(),palabrasSeparadas));
                Respuestas[] arrayres= new Respuestas[listArres.size()];
                arrayres=listArres.toArray(arrayres);
                adapter = new AdaptaRes(this,R.layout.layout_respuestas,arrayres);
                listaRes.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "Respuesta adicionada",  Toast.LENGTH_SHORT).show();
                reper.setText("");
                claper.setText("");
                break;
            case R.id.btnInventario:
                startActivity(new Intent(this,InventarioActivity.class));
                break;
        }
    }
    private void compara(Respuestas res,int longclave) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        entrada = String.valueOf(clipboard.getText());
        ocu=-1;
        i=0;
        while (ocu==-1 && i<=longclave-1){
            ocu = entrada.indexOf(res.claves[i]);
            i++;
        }
        if (ocu !=-1) {
            salida.setText(res.claves[i-1]);
            if (isNumeric(res.claves[i-1])) {
                ClipData clip = ClipData.newPlainText("text", (" Hay "+listArinve.get(i-1).unidades+" unidades disponibles de "+listArinve.get(i-1).name));
                clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
                clipboard.setPrimaryClip(clip);
                listen = true;
            }
            else {
                ClipData clip = ClipData.newPlainText("text", res.respuesta);
                clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
                clipboard.setPrimaryClip(clip);
                listen = true;
            }
        }
        else
            salida.setText("No Encontrado");
    }
    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
