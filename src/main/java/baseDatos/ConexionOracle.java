/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Jorge Alfaro
 */
public class ConexionOracle {
    
    private Connection conn=null;
    private String url, user, pass;

    public ConexionOracle() {
        conectar();
    }
    
    public void conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            url="jdbc:oracle:thin:@localhost:1521:XE";
            user="proyectoLBD";
            pass="admin";
            conn= DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado");
                   
        
        }catch(Exception e){
            System.out.println("Error, no se pudo conectar");
                   
        }
    }
    
    public void desconectar(){
        try{
            conn.close();
            System.out.println("Desconectado");
        }catch(Exception e){
            System.out.println("Error, no se pudo desconectar");
                   
        }
    
    }
    
    
    
    
}
