package query;

import BBDD.*;
import entidades.Productos;
import entidades.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class querybbdd {
    
   
    public ArrayList masVendidos(Conexion con) throws SQLException {

        /* Hacemos la query para que se vea una lista de
         * mas vendidos los productos*/

        ArrayList<Productos> masVendidos = new ArrayList();

        Statement st = null;
        ResultSet rs = null;

        try {
            String query = "select p.id_producto, p.nombre, p.precio, p.unidades, p.numero_ventas "
                    + " from Productos p, Categoria c  "
                    + " where p.id_categoria =  c.id_categoria "
                    + " order by (p.numero_ventas) desc "
                    + " limit 4;";

            st = con.getConnection().createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                Productos pr = new Productos();//Creamos el objeto 

                //Añadimos los datos a los objetos
                pr.setIdProducto(rs.getString("id_producto"));
                pr.setNombre(rs.getString("nombre"));
                pr.setNumeroVentas(Integer.parseInt(rs.getString("numero_ventas")));
                pr.setPrecio(Double.parseDouble(rs.getString("precio")));
                pr.setUnidades(Integer.parseInt(rs.getString("unidades")));

                masVendidos.add(pr);//Añadimos los objetos a 
            }


        } catch (SQLException e) {
            System.out.println("FALLAAAAAAAAAN MAS VENDIDOS");
        }
        return masVendidos;
    }

   
    
    public void login(Conexion con, Usuario s) throws SQLException {
        Statement st;
        try {
            st = con.getConnection().createStatement();

            //El logueo se hace con el nombre de usuario y la contraseña... se puede ver lo del alias    
            String query = "select * from web.usuario where nombre ='" + s.getNombre() + "' and pass='" + s.getPass()+ "'";
            st.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("error en el login");
        }
    }

    public HashMap listaCategorias(Conexion con){
        Statement st = null;
        ResultSet rs = null;
        HashMap lista=new HashMap();
        try{
            String query="select * from categoria;";
            st = con.getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                lista.put(rs.getString(2), rs.getString(2));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }

}


