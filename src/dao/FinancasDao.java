/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexaoBanco.ConectaBancomysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Financas;
import modelo.Prevvenda;

/**
 *
 * @author EMPRESA
 */
public class FinancasDao {

    public static void salvar(Financas f) {

        try {

            Connection con = ConectaBancomysql.getConnection();

            String query = "INSERT INTO financas (nome,data, descricao,valor) Values(?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(query);

            // setar os valores
            stm.setString(1, f.getNome());
            
            java.sql.Date datab = new java.sql.Date(f.getData().getTime());
            stm.setDate(2, datab);
            stm.setString(3, f.getDescricao());
            stm.setDouble(4, f.getValor());
          
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
            // JOptionPane.showMessageDialog(null, "Selecione um Funcionario");

        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro de sql ao cadastrar DIZIMO \n" + e1.getMessage());
        }

    }

    public static void alteraFinancas(double a, String b) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            PreparedStatement stm;

            String query = "UPDATE  financas SET valor_total=? WHERE prevVendedor=?";

            stm = con.prepareStatement(query);
            stm.setDouble(1, a);
            stm.setString(2, b);

            stm.executeUpdate();
            con.close();
            stm.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o valor total na tabela prev venda" + ex.getMessage());
        }
    }

    public static void deletaFinancas(String index) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            // cria string
            String query = "DELETE  from financas WHERE prevVendedor = ?";
            // cria o comando para a conexao
            PreparedStatement stm = con.prepareStatement(query);

            stm.setString(1, index);
            stm.executeUpdate();

            stm.close();
            con.close();

        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro de sql" + e1);
        }

    }

    
    
    
    
    
    
    
    
     public static List<String> litaNomesFuncionarioVenda(){
        String nomeVendedor;
        List<String> lista = new ArrayList();
        Prevvenda c = new Prevvenda();
        try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "SELECT * from prevvenda ";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                nomeVendedor=(rs.getString("prevVendedor"));
                //nome = c.getNome();
                lista.add(nomeVendedor);
            }
            stm.close();
            con.close();
            rs.close();
            return lista;

        } catch (SQLException e) {
            System.out.println("ocorreu um erro de sql");

        }

        System.out.println(lista);
        return lista;

    }
}
