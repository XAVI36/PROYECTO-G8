/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
import java.util.logging.*;


/**
 *
 * @author SAlA-9
 */
public class conexionBD {
    
    //Definir unas variables de la conexion a la base de datos
   private String url="";
   public Connection con =null;
   private Statement stmt =null;
   private ResultSet rs = null;
   private String user = "proyecto369";
   private String password  ="proyecto369";
   public conexionBD(){

       //Base de datos con oracle
       url="jdbc:oracle:thin:proyecto369/proyecto369@localhost:1521:orc";
       
       try {
           con=DriverManager.getConnection(url,user,password);
           if(con!=null){
               DatabaseMetaData meta = con.getMetaData();
               System.out.println("Base de datos conectada " + meta.getDriverName());
           }
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }
   }
   
   public Connection getConnection(){
       return con;
   }
   
   public void closeConnection(Connection con){
       if(con != null){
           try {
               con.close();
           } catch (SQLException ex) {
               System.out.println("Error" + ex.getMessage());
               Logger.getLogger(conexionBD.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   
   }
   
   public ResultSet consultarBD(String sentencia){
   
       try {
           stmt = con.createStatement();
           rs=stmt.executeQuery(sentencia);
           
       } catch (SQLException sqlex){
           System.out.println("Error al hacer el commit" + sqlex.getMessage());
       }
       catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       } 
       
       return rs;
   }
   public static void main(String[] args) {
        // Crear una instancia de la clase ConexionBD
        conexionBD conexionBD = new conexionBD();

        // Verificar si la conexión se ha establecido
        if (conexionBD.getConnection() != null) {
            System.out.println("La conexión a la base de datos se estableció con éxito.");
        } else {
            System.out.println("No se pudo establecer la conexión a la base de datos.");
        }

        

    }
   
  
    
    
}