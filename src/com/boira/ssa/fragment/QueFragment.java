package com.boira.ssa.fragment;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.boira.ssa.R;
import com.boira.ssa.adapter.TesauroAdapter;
import com.boira.ssa.db.TestAdapter;
import com.boira.ssa.model.editable;

public class QueFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                       Bundle savedInstanceState) {

    	View rootView = inflater.inflate(R.layout.fragment_que, container, false);
    	
    	TestAdapter mDbHelper = new TestAdapter(rootView.getContext());        
		 
		mDbHelper.open();
		editable edit = mDbHelper.getEditable(1);
		
		TextView txtSaludo = (TextView)rootView.findViewById(R.id.txtNombre);
        txtSaludo.setText(edit.getNombre());
        
		TextView txtContenido = (TextView)rootView.findViewById(R.id.txtContenido);
		txtContenido.setText(edit.getContenido());

        Typeface face = Typeface.createFromAsset(rootView.getContext().getAssets(),"fonts/SANFW__.TTF");
        txtSaludo.setTypeface(face);
        txtContenido.setTypeface(face);
		
		mDbHelper.close();
		
    	return rootView;
	}

}