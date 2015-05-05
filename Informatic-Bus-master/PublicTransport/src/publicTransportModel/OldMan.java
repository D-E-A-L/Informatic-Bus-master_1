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
public class OldMan extends Customers {
    
    private String fechaNacimiento;

    public OldMan(String nombre, String apellido, String celulaid, String numero, Date datocumple) {
        super(nombre, apellido, celulaid, numero, datocumple);
    }
    
    @Override
    public void registrarAM(String am) {
        super.registrarAM(am);
    }

    @Override
    public void registrarAP(String ap) {
        super.registrarAP(ap);
    }

    @Override
    public void registrarN(String n) {
        super.registrarN(n);
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
