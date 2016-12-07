package com.pmovil.ui.shopassistant;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptaRes extends ArrayAdapter<Respuestas> {
    Context myContext;
    int layaoutResourceID;
    Respuestas myData[] = null;
    Respuestas respuestas;

    public AdaptaRes(Context context, int layaoutResourceID, Respuestas[] data){
        super(context,layaoutResourceID,data);
        this.myContext=context;
        this.myData=data;
        this.layaoutResourceID=layaoutResourceID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder mViewHolder;
        View res=convertView;
        respuestas=myData[position];
        if (convertView == null) {
            LayoutInflater inflater=((Activity)myContext).getLayoutInflater();
            res= inflater.inflate(layaoutResourceID, parent, false);
            mViewHolder = new MyViewHolder(res);
        } else {
            mViewHolder = (MyViewHolder) res.getTag();
        }
        return res;
    }

    private class MyViewHolder {
        public TextView respue;
        public Spinner cla;

        public MyViewHolder(){}

        public MyViewHolder(View item) {
            cla=(Spinner) item.findViewById(R.id.spinner);
            respue = (TextView) item.findViewById(R.id.textView);
            respue.setText(respuestas.getRespuesta().toString());
            String[] items=respuestas.getComparacion();
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,items);
            cla.setAdapter(adapter);
        }
    }
}
