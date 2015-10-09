/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprog2.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class FabricaConexoes {
    public Connection getConnection()
    {
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/labprog", "root", "");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
