package com.pmovil.ui.shopassistant;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
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
    ListView listaRes;
    AdaptaRes adapter;
    ArrayList <Respuestas> listArres=new ArrayList<Respuestas>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listArres.add(new Respuestas("Cordial saludo, en Medellin se hacen domicilios por $5000, lo recibe el mismo dia y puede pagar al momento de recibir","domicilio","contraentrega","entrega"));
        listArres.add(new Respuestas("Cordial saludo, estoy ubicado en la carrera 52#25-370, queda sobre la avenida guayabal mas adelante de la cruz roja","ubicado","recoger","pasar"));
        Respuestas[] arrayres= new Respuestas[listArres.size()];
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
        final Respuestas[] finalArrayres = arrayres;
        //FUNCION LLAMADA AL COPIAR AL PORTAPAPELES
        mClipboardManager.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {

            @Override
            public void onPrimaryClipChanged() {
                j=0;
                longArr= finalArrayres.length;
                String newClip = mClipboardManager.getText().toString();
                Toast.makeText(getApplicationContext(), newClip,  Toast.LENGTH_SHORT).show();
                if (!listen) {
                    while (j<longArr) {
                        compara(finalArrayres[j]);
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
                listArres.add(new Respuestas(reper.getText().toString(),claper.getText().toString(),"",""));
                Respuestas[] arrayres= new Respuestas[listArres.size()];
                arrayres=listArres.toArray(arrayres);
                adapter = new AdaptaRes(this,R.layout.layout_respuestas,arrayres);
                listaRes.setAdapter(adapter);
                break;
            case R.id.btnInventario:
                startActivity(new Intent(this,InventarioActivity.class));
                break;
        }
    }
    private void compara(Respuestas res) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        entrada = String.valueOf(clipboard.getText());
        ocu=-1;
        i=1;
        while (ocu==-1 && i<=3){
            ocu = entrada.indexOf(res.claves[i]);
            i++;
        }
        if (ocu !=-1) {
            salida.setText(res.claves[i-1]);
            ClipData clip = ClipData.newPlainText("text", res.claves[0]);
            clipboard = (ClipboardManager) this.getSystemService(CLIPBOARD_SERVICE);
            clipboard.setPrimaryClip(clip);
            listen=true;
        }
        else
            salida.setText("No Encontrado");
    }
}