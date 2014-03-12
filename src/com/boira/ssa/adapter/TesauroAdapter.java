package com.boira.ssa.adapter;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.boira.ssa.R;
import com.boira.ssa.Tesauro;
import com.boira.ssa.model.editable;

public class TesauroAdapter extends ArrayAdapter<editable> {

	private Activity context;

    public TesauroAdapter(Activity context, List<editable> items) {
        super(context, R.layout.tesauro_listitem, items);
        this.context = context;
    }

    @Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View item = convertView;
		ViewHolderTesauro holder;
		// reutilizamos los Layout como UITableViewCell
		if (item == null) {
			// es nuevo => inchamos el layout
			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.tesauro_listitem, null);
			// y creamos el ViewHolder
			holder = new ViewHolderTesauro();
			holder.titulo = (TextView)item.findViewById(R.id.LblTitulo);
			//holder.subtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
			
			Typeface face = Typeface.createFromAsset(item.getContext().getAssets(),"fonts/SANFW__.TTF");
			holder.titulo.setTypeface(face);
			//holder.subtitulo.setTypeface(face);
			
			item.setTag(holder);
		}else{
			holder = (ViewHolderTesauro)item.getTag();
		}
		
		editable itemTesauro = getItem(position);
		
		holder.titulo.setText(itemTesauro.getNombre());
		//holder.subtitulo.setText(itemTesauro.getCreado());
		
		return(item);
	}
    
    static class ViewHolderTesauro {
        TextView titulo;
        TextView subtitulo;
    }
    
}
