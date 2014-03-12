package com.boira.ssa.fragment;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.boira.ssa.R;
import com.boira.ssa.Tesauro;
import com.boira.ssa.R.id;
import com.boira.ssa.R.layout;
import com.boira.ssa.activity.TesauroActivity;
import com.boira.ssa.adapter.TesauroAdapter;
import com.boira.ssa.db.DataBaseHelper;
import com.boira.ssa.db.TestAdapter;
import com.boira.ssa.model.editable;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TesauroFragment extends Fragment {

	List<editable> datos = new ArrayList<editable>();
	        
	public TesauroFragment() {}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

			View rootView = inflater.inflate(R.layout.activity_tesauro, container, false);
			
			TextView lblIntro = (TextView)rootView.findViewById(R.id.LblEtiqueta);
			Typeface face = Typeface.createFromAsset(this.getActivity().getAssets(),"fonts/SANFW__.TTF");
			lblIntro.setTypeface(face);
			
			TestAdapter mDbHelper = new TestAdapter(rootView.getContext());        
			mDbHelper.createDatabase(); 
			
			mDbHelper.open();
			datos = mDbHelper.getAllToDosByTag(3);
			
			ListView lstOpciones = (ListView)rootView.findViewById(R.id.LstOpciones);
			TesauroAdapter adapterTesauro = new TesauroAdapter(this.getActivity(), datos);
			lstOpciones.setAdapter(adapterTesauro);
			
			mDbHelper.close();
			
			lstOpciones.setOnItemClickListener(new OnItemClickListener() {
			    @Override
			    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
			    	int opcionSeleccionada = ((editable)a.getAdapter().getItem(position)).getId();
			    	Intent intent = new Intent(getActivity().getBaseContext(), TesauroActivity.class);
			        Bundle b = new Bundle();
			        b.putInt("editable_id", opcionSeleccionada);
			        intent.putExtras(b);
			        startActivity(intent);					
			    }
			});
			
			// get action bar   
	        ActionBar actionBar = this.getActivity().getActionBar();
	 
	        // Enabling Up / Back navigation
	        actionBar.setDisplayHomeAsUpEnabled(true);
			
			
			
			return rootView;
	}
}
