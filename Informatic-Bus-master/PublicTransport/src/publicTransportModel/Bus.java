/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicTransportModel;

/**
 *
 * @author CASPED
 */
public class Bus {
    private String marca;
    private String placa;
    private String numeroid;
    private String conductor;
    
    public void Bus(String marca,String placa,String numeroid,String conductor){
        this.marca=marca;
        this.placa=placa;
        this.numeroid=numeroid;
        this .conductor=conductor;
    }

    public String getMarca(){
        return marca;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public String getNumeroID(){
        return numeroid;
    }
    
    public String getConductor(){
        return conductor;
    }
    
    public void setConductor(String conductor){
        this.conductor=conductor;
    }
    
}
