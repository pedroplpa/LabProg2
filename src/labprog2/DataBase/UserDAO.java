/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprog2.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class UserDAO {
    private final Connection con;
    
    public UserDAO(){
        this.con = new FabricaConexoes().getConnection();
    }
    
    /**
     *
     * @param u
     * @return se foi capaz de inserir
     */
    public boolean insere(User u){
        if(duplicate(u))
            return false;
        else{
            String cmd = "insert into user" +
                    " (id,nome,eMail,login,senha)" +
                    " values(?,?,?,?,?)";

            try (PreparedStatement stmt = con.prepareStatement(cmd)) {
                stmt.setInt(1, u.getId());
                stmt.setString(2, u.getNome());
                stmt.setString(3, u.getEMail());
                stmt.setString(4, u.getLogin());
                stmt.setString(5, u.getPassword());

                stmt.execute();
                
                return true;
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
            }
        }
    }
    
    /**
     *
     * @param u
     * @return se há duplicata
     */
    public boolean duplicate(User u){
        String cmd = "select * from user" +
                " where login = ?" +
                " or eMail = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(cmd)) {
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getEMail());
            
            ResultSet rs = stmt.executeQuery();
            
            return rs.isBeforeFirst();
                
        } catch (SQLException ex) {
        throw new RuntimeException(ex);
        }
    }

    /**
     *
     * @param u
     */
    public void atualiza(User u){
        String cmd = "update user set " +
                "nome=?,eMail=?,login=?,senha=? where id = ?";
        
        try(PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEMail());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getPassword());
            stmt.setInt(5, u.getId());
            
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
    }
    
    public boolean validate(User u){
        String cmd = "select * from user " +
                "where login = ?";
        
        try(PreparedStatement stmt = con.prepareStatement(cmd)){
            
            stmt.setString(1, u.getLogin());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                String pass = rs.getString("senha");
                return pass.equals(u.getPassword());
            }
                
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        
        return false;
    }
}
