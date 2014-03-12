package com.boira.ssa.model;

public class editable {
	
	int id;
    String nombre;
    String contenido;
    int categoria;
    int baja;
    String creado;
    
    public editable(){
    }
    
    public editable(String nombre, String contenido, int categoria, int baja){
    	this.nombre = nombre;
    	this.contenido = contenido;
    	this.categoria = categoria;
    	this.baja = baja;
    }
    
    public void setId(int id){
    	this.id = id;
    }
    public void setNombre(String nombre){
    	this.nombre = nombre;
    }
    public void setContenido(String contenido){
    	this.contenido = contenido;
    }
    public void setCategoria(int categoria){
    	this.categoria = categoria;
    }
    public void setBaja(int baja){
    	this.baja = baja;
    }
    public void setCreado(String creado){
    	this.creado = creado;
    }
    

    public int getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getContenido() {
        return this.contenido;
    }
    public int getCategoria(){
    	return this.categoria;
    }
    public int getBaja(){
    	return this.baja;
    }
    public String getCreado(){
    	return this.creado;
    }

}
