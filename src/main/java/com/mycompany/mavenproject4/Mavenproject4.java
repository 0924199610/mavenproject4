package com.mycompany.mavenproject4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mavenproject4 {
   public static void main(String[] args) {
        String usuario="root";
         String password="";
         String url="jdbc:mysql://localhost:3306/pañalera pipe";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
       try {
           conexion = DriverManager.getConnection(url, usuario, password);
           statement = conexion.createStatement();
           rs = statement.executeQuery("SELECT * FROM usuarios");
           while(rs.next()){
               System.out.println(rs.getString("nombre"));
           }
           
           // insercion de datos
           statement.execute("INSERT INTO `usuarios` (`id`, `nombre`) VALUES (NULL, 'jstefany');");
           System.out.println("");
           rs = statement.executeQuery("SELECT * FROM usuarios");
           while(rs.next()){
               System.out.println(rs.getString("nombre"));
           }
           
           // actualizacion de datos 
           statement.execute("UPDATE `usuarios` SET `nombre` = 'jperea' WHERE `usuarios`.`nombre` = 'stefany' ;");
           System.out.println("");
           rs = statement.executeQuery("SELECT * FROM usuarios");
           while(rs.next()){
               System.out.println(rs.getString("nombre"));
           }
           
           // borrado o eliminacion  de datos 
           statement.execute("DELETE FROM usuarios WHERE `usuarios`.`id` = 2");
           System.out.println("");
           rs = statement.executeQuery("SELECT * FROM usuarios");
           while(rs.next()){
               System.out.println(rs.getString("nombre"));
           }
       } catch (SQLException ex) {
           Logger.getLogger(Mavenproject4.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
