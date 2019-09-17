/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import ConexaoBanco.ConectaBancomysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Inventario;

/**
 *
 * @author EMPRESA
 */
public class InventarioDao {
    
    
    
    public void adiciona(Inventario EI) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
            query = "INSERT INTO inventario (nome,fornecedor,"
                    + "valor, quant)"
                    + " Values(?,?,?,?)";


            stm = con.prepareStatement(query);

            // setar os valores
            stm.setString(1, EI.getNome().toUpperCase());
            stm.setString(2, EI.getFornecedor().toUpperCase());
            stm.setDouble(3, EI.getValor());
            stm.setInt(4, EI.getQuant());
           // stm.setDouble(5, EI.getValorTotal());
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
            System.out.println("contato passou");
        } catch (SQLException ex) {
            System.out.println("nada passou");
        }

    }

    
     public void altera(Inventario EI) {

        try {
            Connection con = ConectaBancomysql.getConnection();
           
            PreparedStatement stm;
            String query= "UPDATE  INVENTARIO SET nome=?,fornecedor=?,"
                    + "valor=?,quant=?"
                    + " WHERE id=?";

            // cria o comando para a conexao
            stm = con.prepareStatement(query);
            stm.setString(1, EI.getNome().toUpperCase());
            stm.setString(2, EI.getFornecedor().toUpperCase());
            stm.setDouble(3, EI.getValor());
            stm.setInt(4, EI.getQuant());
           // stm.setDouble(5, EI.getValorTotal());
            stm.setInt(5, EI.getId());
            

            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("nem aqui passou\n"+ex.getMessage());
        }
    }

    
     
      public void remove(Inventario EI) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "DELETE  from inventario WHERE id =?";
            PreparedStatement stm;
            stm = con.prepareStatement(query);
            stm.setInt(1, EI.getId());
            stm.executeUpdate();

            stm.close();
            con.close();

        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql" + e1);
        }


    }
    
    
}
