/*
 * To change this template, choose Tools | Templates
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import modelo.Fornecedor;
import modelo.Funcionario;
import org.apache.commons.mail.EmailException;
import utilitarios.JavaMailApp;

/**
 *
 * @author EMPRESA
 */
public class FornecedorDao {

    public void adiciona(Fornecedor c1) {



        try {
            Connection con = ConectaBancomysql.getConnection();

            String query;
            PreparedStatement stm;
            query = "INSERT INTO fornecedor (nome, cgc,"
                    + "cpf,tel,cel,"
                    + "email,cep,endereco,"
                    + "bairro,cidade,estado,"
                    + "produto,detalhe)"
                    + "Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            stm = con.prepareStatement(query);

            // setar os valores
            stm.setString(1, c1.getNome().toUpperCase());
            stm.setString(2, c1.getCgc());
            stm.setString(3, c1.getCpf());
            stm.setString(4, c1.getTel());
            stm.setString(5, c1.getCel());
            stm.setString(6, c1.getEmail().toLowerCase());
            stm.setString(7, c1.getCep());
            stm.setString(8, c1.getEndereco().toUpperCase());
            stm.setString(9, c1.getBairro().toUpperCase());
            stm.setString(10, c1.getCidade().toUpperCase());
            stm.setString(11, c1.getEstado());
            stm.setString(12, c1.getProduto().toUpperCase());
            stm.setString(13, c1.getDetalhe().toUpperCase());
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
            System.out.println("fornecedor passou");
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void altera(Fornecedor c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
            query = "UPDATE  fornecedor SET nome=?,"
                    + "cgc=?,cpf=?,tel=?,"
                    + "cel=?,email=?,"
                    + "cep=?,endereco=?,bairro=?,"
                    + "cidade=?,estado=?,produto=?,"
                    + "detalhe=? "
                    + "WHERE id=?";
            // cria o comando para a conexao
               stm = con.prepareStatement(query);
            stm.setString(1, c1.getNome().toUpperCase());
            stm.setString(2, c1.getCgc());
            stm.setString(3, c1.getCpf());
            stm.setString(4, c1.getTel());
            stm.setString(5, c1.getCel());
            stm.setString(6, c1.getEmail().toLowerCase());
            stm.setString(7, c1.getCep());
            stm.setString(8, c1.getEndereco().toUpperCase());
            stm.setString(9, c1.getBairro().toUpperCase());
            stm.setString(10, c1.getCidade().toUpperCase());
            stm.setString(11, c1.getEstado().toUpperCase());
            stm.setString(12, c1.getProduto().toUpperCase());
            stm.setString(13, c1.getDetalhe().toUpperCase());
            stm.setInt(14, c1.getId());
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public void remove(Fornecedor c1){
    
       try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "DELETE  from fornecedor WHERE id = ?";
            PreparedStatement stm;
            stm = con.prepareStatement(query);
            stm.setLong(1, c1.getId());
            stm.executeUpdate();

            stm.close();
            con.close();

        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql" + e1);
           JOptionPane.showMessageDialog(null,"falha tente novamente");

        }
    
     }
    
     public static void consultarFornecedorPropagandaEmail() throws EmailException{
        try {

            Connection con = ConectaBancomysql.getConnection();

            String query = "SELECT * from fornecedor ";
            PreparedStatement stm = con.prepareStatement(query);
           
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
               
                String mail = rs.getString("email");

                JavaMailApp.enviarEmailComAnexoFornecedor(mail);//aqui eu envio os esmails

                System.out.println(mail);

            }

            stm.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro de sql" + e.getMessage());

        }

    }
     
     
     public static List<String> litaNomesFornecedorProdutos(){
        String nome;
        List<String> lista = new ArrayList();
        Fornecedor f = new Fornecedor();
        try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "SELECT * from fornecedor ";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                f.setNome(rs.getString("nome"));
                nome = f.getNome();
                lista.add(nome);
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