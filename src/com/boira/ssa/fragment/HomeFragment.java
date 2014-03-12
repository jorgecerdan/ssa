package com.boira.ssa.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.boira.ssa.R;

public class HomeFragment extends Fragment {
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                       Bundle savedInstanceState) {

    	View rootView = inflater.inflate(R.layout.fragment_home, container, false);
    	
    	
    	return rootView;
	}

}
