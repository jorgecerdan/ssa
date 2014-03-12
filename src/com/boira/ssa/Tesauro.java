package com.boira.ssa;

import android.widget.TextView;

public class Tesauro {
	private String titulo;
    private String subtitulo;
 
    public Tesauro(String tit, String sub){
        titulo = tit;
        subtitulo = sub;
    }
 
    public String getTitulo(){ return titulo; }
    public String getSubtitulo(){ return subtitulo; }
}


