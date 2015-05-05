/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicTransportModel;

import java.util.Date;

/**
 *
 * @author CASPED
 */
public class Customers extends Person {
    
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    
    public Customers(String nombre, String apellido, String celulaid, String numero, Date datocumple) {
        super(nombre, apellido, celulaid, numero, datocumple);
    }
    
    public void registrarN(String n)
    {
        this.nombre=n;
    }
    
    public void registrarAP(String ap)
    {
        this.apellidoPaterno=ap;
    }
    
    public void registrarAM(String am)
    {
        this.apellidoMaterno=am;
    }
    
    public String getNom()
    {
        return nombre;
    }
    
    public String getAP()
    {
        return apellidoPaterno;
    }
     public String getAM()
     {
         return apellidoMaterno;
     }
}
