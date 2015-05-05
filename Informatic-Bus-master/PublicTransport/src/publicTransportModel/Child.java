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
public class Child extends Customers {
    
    private String nombreApoderado;
    private String apellidoPA;
    private String apellidoMA;
    private String fechaNacimiento;

    public Child(String nombre, String apellido, String celulaid, String numero, Date datocumple) {
        super(nombre, apellido, celulaid, numero, datocumple);
    }
    
    @Override
    public void registrarAP(String ap) {
        super.registrarAP(ap);
    }

    @Override
    public void registrarAM(String am) {
        super.registrarAM(am);
    }

    @Override
    public void registrarN(String n) {
        super.registrarN(n);
    }
    

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public String getAM() {
        return super.getAM();
    }
    
    @Override
    public String getAP() {
        return super.getAP();
    }
    
    public void setNA(String na)
    {
        this.nombreApoderado=na;
    }
    
    public void setPA(String pa)
    {
        this.apellidoPA=pa;
    }
    
    public void setMA(String ma)
    {
        this.apellidoMA=ma;
    }
    
    public String getNA()
    {
        return nombreApoderado;
    }
    
    public String getPA()
    {
        return apellidoPA;
    }
    
    public String getMA()
    {
        return apellidoMA;
    }
    
    public void setFN(String nf)
    {
        this.fechaNacimiento=nf;
    }
    
    public String getFN()
    {
        return fechaNacimiento;
    }

    
}
