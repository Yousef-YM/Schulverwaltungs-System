/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.ss.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javase.ss.db.DbConnection;
import oracle.net.nt.ConnOption;

/**
 *
 * @author CC-Student
 */
public class BenutzerHandler {

    public static boolean checkLogin(String benutzerName, String passwort) {
        int cntUsers = 0;
        boolean userFaund = false;
        try {
        Connection conn = DbConnection.openConnection();
        String sql = "SELECT COUNT(*) AS CNT_USERS"
                + "    FROM BENUTZER "
                + "    WHERE NAME = ?"
                + "    AND PASSWORT = ?";
        
        
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, benutzerName);
            pstmt.setString(2, passwort);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {                
                cntUsers = rs.getInt("CNT_USERS");
                
            }
            
            if(cntUsers > 0){
                userFaund = true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BenutzerHandler.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return userFaund;

    }

}
