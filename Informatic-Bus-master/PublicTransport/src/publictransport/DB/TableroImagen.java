/*Clase para controlar la insercin/modificacion/eliminacion de una imagen, parecida a la de cliente
 */
package publictransport.DB;

import publicTransportModel.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class TableroImagen 
{
    public String codImagen;
    public String nombreImagen;
    public String urlImagen;
    
    DBConector conecImagen;
    
    public TableroImagen() 
    {
        conecImagen = new DBConector();
    }
    
    public void insertImagen(String codImagen, String nombre, String url) throws SQLException      
    {   
    
        String query = " insert into Imagen(codImagen, nombre, url)"
                    + " values (?, ?, ?)";
       
        // create the mysql insert preparedstatement
        PreparedStatement psmt = conecImagen.GetConnection().prepareStatement(query);
        psmt.setString (1, codImagen);
        psmt.setString (2, nombre);
        psmt.setString (3, url);

        // execute the preparedstatement(psmt)
        psmt.execute();
    }
    
    public void updateImagen(String codi, String nombre, String urli) throws SQLException
    {
        try {            
            String query = "update Imagen(nombre = ? , url = ?)"
                    + " where cedula = ? ";
            PreparedStatement pstm = conecImagen.GetConnection().prepareStatement(query);
            //preparedStmt.setString (1, cedula);
            pstm.setString (2, nombre);
            pstm.setString (3, urli);
            pstm.setString(4, String.valueOf(codi));
            pstm.execute();
            pstm.close();            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void createTableImage()//metodo que crea la tabla de la Imagen para poner la url
    {
        Statement stmt = null;
       try{
      
      //STEP 4: Execute a query
        stmt=conecImagen.GetConnection().createStatement();
      
        String sql = "CREATE TABLE Imagen " +
                   "(codImagen VARCHAR(25) not NULL, " +
                   " nombre VARCHAR(25), " + 
                   " url VARCHAR(250), " + 
                   " PRIMARY KEY (codImagen))"; 

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
            conecImagen.GetConnection().close();
      }catch(SQLException se){}// do nothing
   }
 }    
    /*obtenemos todos los datos de la tabla*/
    public Object [][] getDatosTabla() throws SQLException{
        int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{         
           PreparedStatement preparedStmt = conecImagen.GetConnection().prepareStatement("SELECT count(1) as total FROM Imagen ");
           ResultSet resultado = preparedStmt.executeQuery();
           resultado.next();
           registros = resultado.getInt("total");
           resultado.close();
        }catch(SQLException e){
           System.out.println(e);
        }
        
        Object[][] datos = new String[registros][3];
        //realizamos la consulta sql y llenamos los datos en "Object"  
        try{ 
            PreparedStatement preparedStmt = conecImagen.GetConnection().prepareStatement("SELECT codIamgen, nombreImagen, url"
                        + " FROM Imagen"
                        + " ORDER BY codImagen ");
            ResultSet resultado = preparedStmt.executeQuery();
            int i=0;
            while(resultado.next()){
                this.codImagen = resultado.getString("codImagen");
                this.nombreImagen = resultado.getString("nombreImagen");
                this.urlImagen = resultado.getString("url");
                datos[i][0] = codImagen;            
                datos[i][1] = nombreImagen;            
                datos[i][2] = urlImagen;         
                i++;
            }
            resultado.close();
        }catch(SQLException e){
            System.out.println(e);
        }
        return datos;
    }   
    
    /*obtenermos un dato de toda la tabla*/
    public void getDatos(String buscarcedula) throws SQLException{

        try{   
            Statement Stmt = conecImagen.GetConnection().createStatement();
            ResultSet registro=Stmt.executeQuery("SELECT * FROM Imagen where cedula = 'buscarImagen'");
            Stmt.getConnection();
                       
            while(registro.next()){ 
                this.codImagen = registro.getString("codImagen");
                this.nombreImagen = registro.getString("nombreImagen");
                this.urlImagen = registro.getString("url");
            }
            System.out.println(this.nombreImagen);
            
            registro.close();
        }catch(SQLException e){
            System.out.println(e);
    } 
}    
    
    public String getNombreImagen(String buscarImagen){
        try {         
            PreparedStatement pstm = conecImagen.GetConnection().prepareStatement("SELECT nombreImagen FROM Imagen where codImagen = ?");          
            pstm.setString(1, buscarImagen); 
            ResultSet registro=pstm.executeQuery();
            if(registro.next()){
                InputStream stm = registro.getBinaryStream(1);
                this.nombreImagen = registro.getString("nombreImagen");
                System.out.println(this.nombreImagen);
            }
            pstm.execute();
            pstm.close();            
        }catch(SQLException e){
            System.out.println(e);
        }
        return this.nombreImagen;
    }
    
    public String getUrlImagen(String buscarImagen){
        try {         
            PreparedStatement pstm = conecImagen.GetConnection().prepareStatement("SELECT url FROM Imagen where codImagen = ?");          
            pstm.setString(1, buscarImagen); 
            ResultSet registro=pstm.executeQuery();
            if(registro.next()){
                InputStream stream = registro.getBinaryStream(1);
                this.urlImagen = registro.getString("url");
                System.out.println(this.urlImagen);
            }
            pstm.execute();
            pstm.close();            
        }catch(SQLException e){
            System.out.println(e);
        }
        return urlImagen;
    }
    
    public void deleteImagen(String co){  
        try {         
            PreparedStatement preparedStmt = conecImagen.GetConnection().prepareStatement("DELETE FROM Imagen where codImagen = ?");          
            preparedStmt.setString(1, co);                   
            preparedStmt.execute();
            preparedStmt.close();            
        }catch(SQLException e){
            System.out.println(e);
        }            
   }
    
    public static void main(String[] args) 
    {
        TableroImagen ti = new TableroImagen();
        ti.createTableImage();
        System.out.println("Goodbye!");
    }
}
