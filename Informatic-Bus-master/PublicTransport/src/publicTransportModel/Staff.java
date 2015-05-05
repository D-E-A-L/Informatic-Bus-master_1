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
public abstract class Staff extends Person {
    
    private String idtrabajador;
    private String cargo;
   
    public Staff(String nombre, String apellido, String celulaid, String numero, Date datocumple) {
        super(nombre, apellido, celulaid, numero, datocumple);
    }
    
    public void setIDTrabajador(String idtrabajador){
        this.idtrabajador=idtrabajador;
    }
    
    public String getIDTrabajador(){
        return idtrabajador;
    } 
    
    public void setCargo(String cargo){
        this.cargo=cargo;
    }
    
    public String getCargo(){
        return cargo;
    } 
    
}
