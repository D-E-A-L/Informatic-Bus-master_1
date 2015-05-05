package Impresora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.*;

/**
 *
 * @author CASPED
 */

public class Imprimir_JPanel extends JFrame implements Printable{
    JPanel componentes; //=new javax.swing.JPanel();
    public Imprimir_JPanel(JPanel imprimir){
	super("Imprimir Tarjeta"); 
        this.componentes=imprimir;
        getContentPane().add(imprimir);    
        setBounds(700, 300, 370, 290);
        this.setLocationRelativeTo(null);
        imprimir.setVisible(true);
	 	
        try{
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(this);
            job.printDialog();
            job.print();
        }catch (PrinterException ex){}  
    }
    
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D)graphics;
            
        g2d.translate( pageFormat.getImageableX()+100, 
                       pageFormat.getImageableY()+50);
        g2d.scale(0.50,0.50);
        componentes.printAll(graphics);
        return PAGE_EXISTS;                
    }
    
    public static void main (String[] args){
   	//new Imprimir_JPanel();
    }
	
}
