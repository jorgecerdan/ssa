package com.boira.ssa.fragment;

import java.util.ArrayList;
import java.util.List;

import com.boira.ssa.R;
import com.boira.ssa.Tesauro;
import com.boira.ssa.activity.DondeActivity;
import com.boira.ssa.activity.TesauroActivity;
import com.boira.ssa.adapter.TesauroAdapter;
import com.boira.ssa.db.TestAdapter;
import com.boira.ssa.model.editable;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class DondeFragment extends Fragment {
	
	List<editable> datos = new ArrayList<editable>();
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                       Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_donde, container, false);

		TestAdapter mDbHelper = new TestAdapter(rootView.getContext());        
		mDbHelper.createDatabase(); 
		
		mDbHelper.open();
		datos = mDbHelper.getAllToDosByTag(2);
		
		ListView lstOpciones = (ListView)rootView.findViewById(R.id.LstDonde);
		TesauroAdapter adapterTesauro = new TesauroAdapter(this.getActivity(), datos);
		lstOpciones.setAdapter(adapterTesauro);
		
		mDbHelper.close();
		
		lstOpciones.setOnItemClickListener(new OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
		    	
		    	String opcionSeleccionada = ((editable)a.getAdapter().getItem(position)).getNombre();
		    	
		    	Intent intent = new Intent(getActivity().getBaseContext(), DondeActivity.class);
		        Bundle b = new Bundle();
		        b.putString("NOMBRE", "Opci—n seleccionada: " + opcionSeleccionada);
		        //A–adimos la informaci—n al intent
		        intent.putExtras(b);
		        //intent.putExtra("name",name);
		        startActivity(intent);
		    	/*
		    	Fragment tFragment = new tesauroFragment();
		    	FragmentManager fragmentManager = getActivity().getFragmentManager();
		    	
				fragmentManager.beginTransaction().replace(R.id.frame_container, tFragment).commit();*/
				
		    }
		});
		
		return rootView;
    }
}
