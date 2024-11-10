package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Compra_Detalle {
    private int id;
    private int cantidad;
    private int precio_costo_unitario;
    private int id_producto;
    private int id_compra;
    private Conexion cn;

    public Compra_Detalle() {
    }

    public Compra_Detalle(int id, int cantidad, int precio_costo_unitario, int id_producto, int id_compra) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_costo_unitario = precio_costo_unitario;
        this.id_producto = id_producto;
        this.id_compra = id_compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_costo_unitario() {
        return precio_costo_unitario;
    }

    public void setPrecio_costo_unitario(int precio_costo_unitario) {
        this.precio_costo_unitario = precio_costo_unitario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
    
    public boolean agregar(){
    try {
        cn = new Conexion();
        cn.abrirConexion();
        PreparedStatement parametro;
        String query = "INSERT INTO compras_detalle (cantidad,precio_costo_unitario,id_producto,id_compra) VALUES (?,?,?,?);";
        parametro = (PreparedStatement)cn.conexionBD.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
        parametro.setInt(1, getCantidad());
        parametro.setInt(2, getPrecio_costo_unitario());
        parametro.setInt(3, getId_producto());
        parametro.setInt(4, getId_compra());

        int rowsAffected = parametro.executeUpdate();

        if (rowsAffected > 0) {
            // Recupera el ID generado de la venta
            try (ResultSet generatedKeys = parametro.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    setId(generatedKeys.getInt(1));  // Establece el ID de la venta
                }
            }
            boolean productoActualizado = actualizarProducto();
            cn.cerrarConexion();
            return productoActualizado;
        }
    } catch (SQLException ex) {
        System.out.println("Error al agregar el detalle: " + ex.getMessage());
    }
    return false;  // Retorna false si algo sale mal
}
    
private boolean actualizarProducto() {
    try {
        String query = "UPDATE productos SET existencia = existencia + ?, precio_costo = ?, precio_venta = ? WHERE id_producto = ?";
        PreparedStatement parametro = cn.conexionBD.prepareStatement(query);
        
        parametro.setInt(1, this.cantidad);
        parametro.setInt(2, this.precio_costo_unitario);

        double precioVenta = this.precio_costo_unitario * 1.25;
        parametro.setDouble(3, precioVenta);

        parametro.setInt(4, this.id_producto);

        int rowsAffected = parametro.executeUpdate();
        
        return rowsAffected > 0; // Si se actualiza al menos un registro, retornamos true
    } catch (SQLException ex) {
        System.out.println("Error al actualizar el producto: " + ex.getMessage());
        return false;
    }
}


}
