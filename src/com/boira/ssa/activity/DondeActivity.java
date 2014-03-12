package com.boira.ssa.activity;

import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.boira.ssa.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class DondeActivity extends Activity {
	// Google Map
    private GoogleMap googleMap;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donde);
 
        // show The Image
        //new DownloadImageTask((ImageView)findViewById(R.id.ImgFoto)).execute("https://maps.googleapis.com/maps/api/staticmap?center=51.477222,0&zoom=14&size=400x400&sensor=false");
        
        try {
            // Loading map
            initilizeMap();
            
            LatLng madrid = new LatLng(41.050985, -0.133362);
            CameraPosition camPos = new CameraPosition.Builder()
            .target(madrid)   //Centramos el mapa en Madrid
            .zoom(19)         //Establecemos el zoom en 19
            .bearing(45)      //Establecemos la orientaci—n con el noreste arriba
            .tilt(70)         //Bajamos el punto de vista de la c‡mara 70 grados
            .build();
     
            CameraUpdate camUpd3 = CameraUpdateFactory.newCameraPosition(camPos);
     
    		googleMap.animateCamera(camUpd3);
    
            //CameraUpdate camUpd1 = CameraUpdateFactory.newLatLng(new LatLng(41.050985, -0.133362));
            //googleMap.moveCamera(camUpd1);
 
        } catch (Exception e) {
            e.printStackTrace();
        }
 
    }
 
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
    
    /**
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }
            
            
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }

}
