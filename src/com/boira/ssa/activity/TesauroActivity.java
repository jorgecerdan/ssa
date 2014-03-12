package com.boira.ssa.activity;

import com.boira.ssa.R;
import com.boira.ssa.db.TestAdapter;
import com.boira.ssa.model.editable;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TesauroActivity extends Activity {

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tesauro_view);

        Bundle bundle = this.getIntent().getExtras();
        
        TestAdapter mDbHelper = new TestAdapter(this);        
		mDbHelper.open();
		editable edi = mDbHelper.getEditable(bundle.getInt("editable_id"));
		
		TextView txtNombre = (TextView)findViewById(R.id.txtNombre);
		txtNombre.setText(edi.getNombre());
        TextView txtContenido = (TextView)findViewById(R.id.txtContenido);
        txtContenido.setText(edi.getContenido());
        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/SANFW__.TTF");
        txtNombre.setTypeface(face);
        txtContenido.setTypeface(face);
        
        mDbHelper.close();
        
	}
	
	
	
	@Override
	public void onBackPressed(){
	    android.app.FragmentManager fm = getFragmentManager();
	    if (fm.getBackStackEntryCount() > 0) {
	        Log.i("MainActivity", "popping backstack");
	        fm.popBackStack();
	    } else {
	        Log.i("MainActivity", "nothing on backstack, calling super");
	        super.onBackPressed();  
	    }
	}
}
