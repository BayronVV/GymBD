/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

/**
 *
 * @author estudiante
 */
import java.util.*;
import java.sql.*;
import javax.swing.*;

public class ClaseServicioDAO {
    
    public ArrayList<String> LlenarInst(String m, String n, JButton bo) throws SQLException, ClassNotFoundException{
        
        String mi = "", ni = "";
        ArrayList<String> listains = new ArrayList<>();
        String sql = "SELECT * FROM instructor";
        try(Connection conexion3 = Conexion.obtener();
            Statement declaracion = conexion3.createStatement();
            ResultSet rs = declaracion.executeQuery(sql)    ) {
              
              listains.add("seleccione instructor");
              
              while(rs.next()){
                
                  mi = rs.getString("especialidad");
                  ni = rs.getString("hora");
                  if(mi.equals(m) && n.equals(ni)){
                    listains.add(rs.getString("codigo"));
                    bo.setEnabled(true);
                  }
               }
        }
        catch (SQLException e) {
        System.err.println(e.getMessage());
    
            }
        return listains;
    }
        public void insertar(){
        
        
        }
    
}
