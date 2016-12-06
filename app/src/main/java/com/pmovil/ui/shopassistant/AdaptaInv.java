package com.pmovil.ui.shopassistant;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

    public class AdaptaInv extends ArrayAdapter<Articulos> {
        Context myContext;
        int layaoutResourceID;
        Articulos myData[] = null;
        Articulos articulos;

        public AdaptaInv(Context context, int layaoutResourceID, Articulos[] data){
            super(context,layaoutResourceID,data);
            this.myContext=context;
            this.myData=data;
            this.layaoutResourceID=layaoutResourceID;
        }
        @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                AdaptaInv.MyViewHolder mViewHolder;
                View res=convertView;
                articulos =myData[position];
            if (convertView == null) {
                LayoutInflater inflater=((Activity)myContext).getLayoutInflater();
                res= inflater.inflate(layaoutResourceID, parent, false);
                mViewHolder = new com.pmovil.ui.shopassistant.AdaptaInv.MyViewHolder(res);
            } else {
                mViewHolder = (com.pmovil.ui.shopassistant.AdaptaInv.MyViewHolder) res.getTag();
            }
            return res;
        }

        private class MyViewHolder {
            public TextView name,clave,unidad;

            public MyViewHolder(){}

            public MyViewHolder(View item) {
                name = (TextView) item.findViewById(R.id.textView5);
                name.setText(articulos.getName());
                clave = (TextView) item.findViewById(R.id.textView6);
                clave.setText("Codigo de Producto : "+ articulos.getClave());
                unidad = (TextView) item.findViewById(R.id.textView7);
                unidad.setText(articulos.getUnidades() +" Unidades Disponibles");
            }
        }
    }
