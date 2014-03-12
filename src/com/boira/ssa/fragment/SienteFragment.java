package com.boira.ssa.fragment;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.TextView;

import com.boira.ssa.R;
import com.boira.ssa.db.TestAdapter;
import com.boira.ssa.model.editable;

public class SienteFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                       Bundle savedInstanceState) {

    	View rootView = inflater.inflate(R.layout.fragment_siente, container, false);
    	
    	
		WebView web = (WebView)rootView.findViewById(R.id.webViewIGram);
		//web.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		web.loadUrl("http://www.gmaza.lacotorra.org/boira/igram/example/test2.php?tagname=alca–iz");
		/*
		WebView web2 = (WebView)rootView.findViewById(R.id.webViewTwitter);
		web2.setBuiltInZoomControls(true);
		web2.loadUrl("http://www.gmaza.lacotorra.org/boira/twitter/index.php?tagname=alca–iz");
		*/
    	return rootView;
	}

}