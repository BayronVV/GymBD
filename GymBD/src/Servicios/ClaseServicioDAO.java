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
import Modelo.Clase;

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
        public void insertar(Connection conexion2, Clase clase){
        
        try{
            PreparedStatement cons;
            cons = conexion2.prepareCall("INSERT INTO clase(codigo, clase, horario, cod_instructor)"+"VALUES(?,?,?,?)");
            cons.setInt(1, clase.getCodigo());
            cons.setString(2, clase.getClase());
            cons.setString(3, clase.getHorario());
            cons.setInt(4, clase.getCod_Instructor());
            cons.executeUpdate();
            JOptionPane.showMessageDialog(null, "se guardo la clase");
        }
       catch (SQLException e) {
        System.err.println(e.getMessage());
    
         }
        
        }
        
        public boolean Buscar(Integer codigo) throws SQLException, ClassNotFoundException{
        
         boolean esta = false;
         Integer cod2 = 0;
         String sql = "SELECT codigo FROM clase WHERE codigo = ' " + codigo +" ' ";
         try(Connection conexion3 = Conexion.obtener();
             Statement declaracion = conexion3.createStatement();
             ResultSet rs = declaracion.executeQuery(sql)){
             
             while (rs.next()){
               cod2=rs.getInt("codigo");
             }
             esta = Objects.equals(cod2, codigo);
            }
            catch (SQLException e) {
        System.err.println(e.getMessage());
    
         }
         return esta;
        }
       
        public void Llenar(Integer codigo, JComboBox clase, JComboBox hora,  JComboBox instructor) throws SQLException, ClassNotFoundException{
         String sql = "SELECT * FROM clase WHERE codigo = ' " + codigo +" ' ";
         
         try(Connection conexion3 = Conexion.obtener();
             Statement declaracion = conexion3.createStatement();
             ResultSet rs = declaracion.executeQuery(sql)){
            while (rs.next()){
             clase.setSelectedItem(rs.getString("clase"));
             hora.setSelectedItem(rs.getString("horario"));
             instructor.setSelectedItem(rs.getString("cod_instructor"));
            }  
         }
         catch (SQLException e) {
        System.err.println(e.getMessage());
    
         }
        }
       
        public void actualizarIns(Clase cs, Integer codigo) throws SQLException, ClassNotFoundException{
        
            String sql = "UPDATE clase SET codigo='"+cs.getCodigo()+"', clase='"+cs.getClase()+"', horario='"+cs.getHorario()+"', cod_instructor='"+cs.getCod_Instructor()+"' WHERE codigo = '"+codigo+"'";
            try(Connection conexion2 = Conexion.obtener();
                PreparedStatement pst = conexion2.prepareStatement(sql)){
                JOptionPane.showMessageDialog(null, "se actualizo la clase");
                pst.executeUpdate();
            }
            catch (SQLException e) {
            System.err.println(e.getMessage());
    
           }
        }
        
        public void eliminarIns(Integer codigo, Clase cs) throws SQLException, ClassNotFoundException{
        
            try(Connection conexion3 = Conexion.obtener();
             Statement declaracion = conexion3.createStatement()){
            
                String sql = "DELETE clase FROM WHERE codigo = '"+codigo+"'";
                declaracion.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "se eliminó la clase");
            }
            catch (SQLException e) {
            System.err.println(e.getMessage());
    
           }
        }
    
}
