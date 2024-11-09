/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ccu33
 */
public class Proveedores {
    private int id;
    private String proveedor,nit,direccion,telefono;
    Conexion cn;

    public Proveedores(){}
    public Proveedores(int id, String proveedor, String nit, String direccion, String telefono) {
        this.id = id;
        this.proveedor = proveedor;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
   public DefaultTableModel leer(){
 DefaultTableModel tabla = new DefaultTableModel();
 try{
     cn = new Conexion();
     cn.abrirConexion();
      String query = "SELECT id_proveedor as id,proveedor,nit,direccion,telefono FROM proveedores;";
      ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
      String encabezado[] = {"id_proveedor","proveedor","nit","direccion","telefono"};
      tabla.setColumnIdentifiers(encabezado);
      String datos[] = new String[4];
      while (consulta.next()){
          datos[0] = consulta.getString("id");
          datos[1] = consulta.getString("proveedor");
          datos[2] = consulta.getString("nit");
          datos[3] = consulta.getString("direccion");
          datos[4] = consulta.getString("telefono");
          
          tabla.addRow(datos);
      
      }
      
     cn.cerrarConexion();
 }catch(SQLException ex){
     System.out.println(ex.getMessage());
 }
 return tabla;
 }

    public int agregar(){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "insert into proveedores(proveedor,nit,direccion,telefono) values(?,?,?,?,?);";
            cn.abrirConexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            
            parametro.setString(1,getProveedor());
            parametro.setString(2,getNit());
            parametro.setString(3,getDireccion());
            parametro.setString(4,getTelefono());
            retorno = parametro.executeUpdate();
            cn.cerrarConexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
   
    public int modificar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "update proveedores set proveedor = ?,nit= ?,direccion= ?,telefono= ? where id_proveedor = ?;";
            cn.abrirConexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setString(1,getProveedor());
            parametro.setString(2,getNit());
            parametro.setString(3,getDireccion());
            parametro.setString(4,getTelefono());
            parametro.setInt(5, getId());
            retorno = parametro.executeUpdate();
            cn.cerrarConexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
    
    public int eliminar (){
        int retorno =0;
        try{
            PreparedStatement parametro;
            cn = new Conexion();
            String query = "delete from empleados  where id_empleado = ?;";
            cn.abrirConexion();
            parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query);
            parametro.setInt(1, getId());
            retorno = parametro.executeUpdate();
            cn.cerrarConexion();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    return retorno;
    }
   
}
    
