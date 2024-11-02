package modelo;

import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class Marcas {
    private int id_marca;
    private String marca;
    private Conexion cn;

    public Marcas() {
    }

    public Marcas(String marca) {
        this.marca = marca;
    }
    
    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
        public DefaultTableModel leer(){
        DefaultTableModel tabla = new DefaultTableModel();
        try {
            cn = new Conexion();
            cn.abrirConexion();
            String query = "Select id_marca as id,marca from  marcas";
            ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
            String encabezado[] = {"id","marcas"};
            tabla.setColumnIdentifiers(encabezado);
            String datos[] = new String[2];
            while (consulta.next()) {
                //System.out.println("Id: " + consulta.getString("id"));
                datos[0] = consulta.getString("id");
                datos[1] = consulta.getString("marca");
                tabla.addRow(datos);
            }
            cn.cerrarConexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return tabla;
    }
        
        public int agregar(){
            int retorno = 0;
            try{
                cn = new Conexion();
                PreparedStatement parametro;
                String query = query = "INSERT INTO marcas(marca) VALUES(?);";
                cn.abrirConexion();
                parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
                parametro.setString(1, getMarca());
                
                retorno = parametro.executeUpdate();
                
                cn.cerrarConexion();
                
            }catch(SQLException ex){
                System.out.println("Error"+ex.getMessage());
                retorno = 0;
            }
            return retorno;
        }
        
        public int modificar(){
            int retorno = 0;
            try {
                cn = new Conexion();
                PreparedStatement parametro;
                String query = "update marcas set marca=? where id_marca=?;";
                cn.abrirConexion();
                parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
                parametro.setString(1, getMarca());
                parametro.setInt(2, getId_marca());
                
                retorno = parametro.executeUpdate();
                
                cn.cerrarConexion();
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
            return retorno;
        }
        
        public int eliminar(){
            int retorno = 0;
            try{
                cn = new Conexion();
                PreparedStatement parametro;
                String query = "delete from marcas where id_marca=?";
                parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
                parametro.setInt(1, getId_marca());
                
                retorno = parametro.executeUpdate();
                
                cn.cerrarConexion();
            }catch(SQLException ex){
            System.out.println(ex.getMessage());
            retorno = 0;
        }
            return retorno;
        }
        
}
