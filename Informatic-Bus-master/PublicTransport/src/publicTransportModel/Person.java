/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicTransportModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author CASPED
 */
public abstract class Person {
    
    private final String nombre;
    private final String apellido;
    private final String celulaid;
    private String celular;
    private final Date datocumple;
    //private String tipo;
    
    public Person(String nombre,String apellido,String celulaid,String numero,Date datocumple){
        this.nombre=nombre;
        this.apellido=apellido;       
        this.celulaid=celulaid; 
        this.celular=numero;
        this.datocumple=datocumple;         
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public String getCelulaId(){
        return celulaid;
    }
    
    public String getCelular(){
        return celular;
    }
    
    public void setCelular(String numero){
        celular=numero;
    }
    
    public Date getDatoCumple(){
        return datocumple;
    }
    
    public int getEdad(){
        Calendar fechadato=Calendar.getInstance(); 
        Calendar datodia=new GregorianCalendar();
        datodia.setTime(datocumple);
        
        int edad=fechadato.get(Calendar.YEAR)-datodia.get( Calendar.YEAR );

        if(fechadato.get(Calendar.MONTH)<datodia.get(Calendar.MONTH) )
            edad=edad-1;
        else if (fechadato.get(Calendar.MONTH)==datodia.get(Calendar.MONTH) &&
                 fechadato.get(Calendar.DATE)<datodia.get(Calendar.DATE)){
            edad= edad-1;
        }
        return edad;
    }
    
    public boolean checkCelulaID(String buscarCelula){
        boolean verificar;
        verificar=celulaid.equals(buscarCelula);
        return verificar;
    }
}
