
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author CASPED
 */
public class Interface extends JFrame implements ActionListener {
    public boolean termino; 
    
    public JMenuBar barraMenu=new JMenuBar();
    
    public JMenu pestania1=new JMenu("Archivo");
    public JMenuItem addCustomer=new JMenuItem("Nuevo Cliente");
    public JMenuItem deleteCustomer=new JMenuItem("Eliminar Cliente");
    public JMenuItem modifyCustomer=new JMenuItem("Modificar Cliente");
    public JMenuItem Exit=new JMenuItem("Exit");
    
    public JMenu pestania2=new JMenu("Tarjetero");
    public JMenuItem designingCards=new JMenuItem("Nueva Tarjeta");
    public JMenuItem designingQR=new JMenuItem("QR Tarjeta Reverso");
    
    private javax.swing.JLabel jLabel1;
    JFrame panelillo=new JFrame();
    
    public Interface(){  
        initComponents();
        panelillo.setTitle("Public Transport");
        panelillo.setBounds(600, 220, 718, 590);
        
        addCustomer.addActionListener(this);
        deleteCustomer.addActionListener(this);
        modifyCustomer.addActionListener(this);
        Exit.addActionListener(this);
        
        designingCards.addActionListener(this);
        designingQR.addActionListener(this);
        
        pestania1.add(addCustomer);
        pestania1.add(deleteCustomer);
        pestania1.add(modifyCustomer);
        pestania1.add(Exit);
        
        pestania2.add(designingCards);
        pestania2.add(designingQR);
        
        barraMenu.add(pestania1);
        barraMenu.add(pestania2);
        panelillo.setJMenuBar(barraMenu);
        
        panelillo.setVisible(true);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    
    private void initComponents() {
 
        jLabel1 = new javax.swing.JLabel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/publictransport/imagenes/fondo.png"))); 
        panelillo.getContentPane().add(jLabel1);
        
        //pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent eventos){
        
        if(eventos.getSource()==addCustomer){
            addCustomer();
        }
        if(eventos.getSource()==deleteCustomer){
           deleteCustomer(); 
        }
        if(eventos.getSource()==modifyCustomer){
           modifyCustomer(); 
        }
        if(eventos.getSource()==Exit){
            panelillo.dispose();
            System.out.println("Se está pulsando EXIT");
        }
        
        if(eventos.getSource()==designingCards){
            designerCards();
        } 
        
        if(eventos.getSource()==designingQR){
            designerQR();
        }
    }
    
    public void addCustomer(){
        //ListaPersona metodo = new ListaPersona();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCliente().setVisible(true);
            }
        });
        System.out.println("Se está pulsando aderir cliente");
    }
    
    public void deleteCustomer(){
        //ListaPersona metodo = new ListaPersona();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteCliente().setVisible(true);
            }
        });
        System.out.println("Se está pulsando eliminar cliente");
    }
    
    public void modifyCustomer(){
        //ListaPersona metodo = new ListaPersona();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyClient().setVisible(true);
            }
        });
        System.out.println("Se está pulsando modificar cliente");
    }
    
    public void designerCards(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesigningCards().setVisible(true);
            }
        });
        System.out.println("Se está pulsando tarjetero");
    }
    
    public void designerQR(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesigningQR().setVisible(true);
            }
        });
        System.out.println("Se está pulsando generar");
    }
    
}
