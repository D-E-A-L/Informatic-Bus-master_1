package publictransport.DB;
import publicTransportModel.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class insertTable {

    public insertTable(){}
    
    private double costoPasaje(String Tusuario)
    {
        double resp = 2;
        switch(Tusuario)
        {
            case "nino": resp = 1;
            break;
            case "Colegio": resp = 1.5;
            break;   
            case "Universitario": resp = 1.8;
            break;
            case "Tercera Edad": resp = 1.5;
            break;
        }
        return resp;
    }
    
   /* public ArrayList<ListaPersona> buscarPersona (String ci1) throws SQLException
    {
        ArrayList<ListaPersona> miPersona = new ArrayList<ListaPersona>();
        DBConector conex = new DBConector;
        
        try
        {
            PreparedStatement consulta = conex.GetConnection.PreparedStatement("select * from Cliente where ci = ?");
            consulta.setString(1, ci1);
            ResultSet res = consulta.executeQuery();
            
            if(res.next())
            {
                ListaPersona persona = new ListaPersona();
                persona
            }
        }
    }*/
    
    public void insertPersona(String ci, String nombre, String apellidos, 
            String celular, String fecNac, String TUsuario, double saldo) throws SQLException
    {
        double costo = costoPasaje(TUsuario);
        Connection conexion= DBConector.GetConnection() ;
	String query = " insert into Cliente (ci, nombre, apellido, celular, "
                + "fechaNacimiento, tipoUsuario, costoPasaje, saldoDisponible)"
        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
       
      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conexion.prepareStatement(query);
      preparedStmt.setString (1, ci);
      preparedStmt.setString (2, nombre);
      preparedStmt.setString (3, apellidos);
      preparedStmt.setString (4, celular);
      preparedStmt.setString (5, fecNac);
      preparedStmt.setString (6, TUsuario);
      preparedStmt.setDouble (7, costo);
      preparedStmt.setDouble (8, saldo);

      // execute the preparedstatement
      preparedStmt.execute();
    }
    
    public void createTable()
    {
       Connection conn = null;
       Statement stmt = null;
       try{
       conn = DBConector.GetConnection();
      
      //STEP 4: Execute a query
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE Cliente " +
                   "(ci VARCHAR(25) not NULL, " +
                   " nombre VARCHAR(25), " + 
                   " apellido VARCHAR(25), " + 
                   " celular VARCHAR(10), " +
                   " fechaNacimiento VARCHAR(10), " +
                   " tipoUsuario VARCHAR(15), " +
                   " costoPasaje DOUBLE, " +
                   " saldoDisponible DOUBLE, " +
                   //" imagen LONGBLOB, " +
                   " PRIMARY KEY ( ci ))"; 

      stmt.executeUpdate(sql);
      System.out.println("tabla creada...");
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      
   }
}
    
    public static void main(String[] args) {
        
        insertTable seed = new insertTable();
        seed.createTable();
         System.out.println("Goodbye!");
    }//end main
}//end JDBCExample
