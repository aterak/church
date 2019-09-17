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
import modelo.Prevvenda;

/**
 *
 * @author EMPRESA
 */
public class PrevVendaDao {

    public static void inserirPreVenda(String a, String b, String c, double d, int e, double f) {

        try {

            Connection con = ConectaBancomysql.getConnection();

            String query = "INSERT INTO prevvenda (prevVendedor,prevCliente, prevProduto,valor_venda_Produto_prevV,quantidade,totalPrev,nota_fiscal,troco,valor_pago,valor_total) Values(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(query);

            // setar os valores
            stm.setString(1, a);
            stm.setString(2, b);
            stm.setString(3, c);
            stm.setDouble(4, d);
            stm.setInt(5, e);//quantidade
            stm.setDouble(6, f);
            //stm.setDate(7, );// aqui eu pego a data atual

            stm.setInt(7, 0);//nota fiscal
            stm.setDouble(8, 0);
            stm.setDouble(9, 0);
            stm.setDouble(10, 0);
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
            // JOptionPane.showMessageDialog(null, "Selecione um Funcionario");

        } catch (SQLException e1) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro de sql ao cadastrar na tabela prev vendas \n" + e1.getMessage());
        }

    }

    public static void alteraPrevVenda(double a, String b) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            PreparedStatement stm;

            String query = "UPDATE  prevvenda SET valor_total=? WHERE prevVendedor=?";

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

    public static void deletaPrevVendedor(String index) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            // cria string
            String query = "DELETE  from prevvenda WHERE prevVendedor = ?";
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

    public static void deletaPrevVendaProduto(String index) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            // cria string
            String query = "DELETE  from prevvenda WHERE prevProduto =(?)";
            // cria o comando para a conexao
            PreparedStatement stm = con.prepareStatement(query);

            stm.setString(1, index);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql" + e1);
        }

    }

    public static void alteraPrevVendaVendedor(double a, String b) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            PreparedStatement stm;

            String query = "UPDATE  prevvenda SET valor_total=? WHERE prevVendedor=?";

            // cria o comando para a conexao
            stm = con.prepareStatement(query);
            stm.setDouble(1, a);
            stm.setString(2, b);

            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar alterar o valor total na tabela prev venda" + ex.getMessage());
        }

    }

    
    public static void alteraNotaPrevVendedor(int ultima_nota, String nota){
    
    try {
            Connection con = ConectaBancomysql.getConnection();

            PreparedStatement stm;

            String query = "UPDATE  prevvenda SET nota_fiscal=? WHERE prevVendedor=?";

            // cria o comando para a conexao
            stm = con.prepareStatement(query);
            stm.setInt(1, ultima_nota);
          //  stm.setDouble(2, valorPago);
            // stm.setDouble (3,trocoSobra);
            stm.setString(2, nota);
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar alterar o valor total na tabela prev venda" + ex.getMessage());
        }

    
    
    }
    
    public static void deletaPrevVenda(String index){
    
        try {
            Connection con = ConectaBancomysql.getConnection();
            // cria string
            String query = "DELETE  from prevvenda WHERE prevVendedor = ?";
            // cria o comando para a conexao
            PreparedStatement stm;
            stm = con.prepareStatement(query);
            stm.setString(1, index);
            stm.executeUpdate();
            stm.close();
            con.close();
        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql" + e1);

        }
    
    
    }
    
    
    
    public static void salvaTabelaVenda(String index){
    
    try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "insert into venda select * from prevvenda WHERE prevVendedor =?";
            PreparedStatement stm = con.prepareStatement(query);

            stm.setString(1, index);
            stm.executeUpdate();
            JOptionPane.showMessageDialog(null,
                    "voce esta confirmando as atividades do Vendedor \n" + " " + index);
            con.close();
            stm.close();
        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql ao inserir a venda " + e1.getMessage());
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
