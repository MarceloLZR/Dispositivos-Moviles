package com.example.mycontactos20232;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdaptador extends BaseAdapter {
    Context context;
    MyAdaptador(Context c){
        context = c;
    }
    @Override
    public int getCount(){return MainActivity.miscontactos.size();}
    @Override
    public Object getItem(int position){
        return MainActivity.miscontactos.get(position);
    }
    @Override
    public long getItemId(int position){return 0;}
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View fila = null;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            fila = inflater.inflate(R.layout.misfilas,null);
        }else{
            fila = convertView;
        }
        TextView txtminombre = fila.findViewById(R.id.txtminombre);
        TextView txtmialias = fila.findViewById(R.id.txtmialias);
        ImageView imgImagen = fila.findViewById(R.id.imgimagen);
        String nombre = MainActivity.miscontactos.get(position).getNombre();
        String alias = MainActivity.miscontactos.get(position).getAlias();
        txtminombre.setText(nombre);
        txtmialias.setText(alias);
        int spntipo = MainActivity.miscontactos.get(position).getTipo();
        Button btn_editar = fila.findViewById((R.id.btn_editar));
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditarContacto.class);
                intent.putExtra("positionX",position);
                intent.putExtra("nombreX",nombre);
                intent.putExtra("aliasX",alias);
                intent.putExtra("tipoX",spntipo);
                context.startActivity(intent);
            }
        });
        Button btn_eliminar = fila.findViewById((R.id.btn_eliminar));
        btn_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity.class);
                MainActivity.con.eliminarContacto(MainActivity.miscontactos.get(position).getIdcontacto());
                context.startActivity(intent);
            }
        });
        return  fila;
    }
}
