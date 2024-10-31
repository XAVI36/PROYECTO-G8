/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal;
import dao.conexionBD;
import java.sql.ResultSet;
import ui.Login;

/**
 *
 * @author Teban
 */
public class Proyecto_integrador {
    
    
    public static void main(String[] args) {
        System.out.println("Iniciando la conexion a la base de datos");
        conexionBD c = new conexionBD();
        ResultSet rs = c.consultarBD("select * proyecto");
        // Iniciar la ventana de Login
        Login login = new Login();
        login.setVisible(true);
    }
    
}

