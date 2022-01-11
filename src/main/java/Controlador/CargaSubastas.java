/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luis
 */
public class CargaSubastas {
    public ResultSet rs;
    
    public CargaSubastas() throws SQLException{
        Conexion con = new Conexion();
        rs = con.getConexion().executeQuery("SELECT * FROM subastar");
    }
    
    public ArrayList<Subasta> cargarSubastas() throws SQLException{
        ArrayList<Subasta> a = new ArrayList<>();
        while(rs.next()){
            a.add(new Subasta(rs.getInt("id_usuario"),rs.getInt("id_articulo"),rs.getString("fecha_inicio"),rs.getString("fecha_fin"),rs.getString("estado"),rs.getInt("precio_salida")));
        }
        return a;
    }
}
