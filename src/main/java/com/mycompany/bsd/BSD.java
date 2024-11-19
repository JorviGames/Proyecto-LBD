/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bsd;
import Jframes.Menu;
import Jframes.Sucursales;
import baseDatos.ConexionOracle;

/**
 *
 * @author yorvi
 */
public class BSD {

    public static void main(String[] args) {
        
        //importar la base de datos
       /* ConexionOracle conn = new ConexionOracle();
        conn.conectar();
        conn.desconectar(); */
       
       Menu menu = new Menu();
       
       menu.setVisible(true);
       
    }
}
