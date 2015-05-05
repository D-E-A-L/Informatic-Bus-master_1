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
public class Drivers extends Staff {
    
    public Bus busdesignado;

    public Drivers(String nombre, String apellido, String celulaid, String numero, Date datocumple) {
        super(nombre, apellido, celulaid, numero, datocumple);
    }  
    
    public Bus getBusDesignado(){
        return busdesignado;
    }
    
    public void setBusDesignado(Bus busdesignado){
        this.busdesignado=busdesignado;
    }
    
    public void desasignarbus(){
        busdesignado=null;
    }
    
}
