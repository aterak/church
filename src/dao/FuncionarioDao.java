
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ConexaoBanco.ConectaBancomysql;
import Principal.Principal;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import modelo.Funcionario;
import org.apache.commons.mail.EmailException;
import utilitarios.JavaMailApp;

/**
 *
 * @author EMPRESA
 */
public class FuncionarioDao {

    Principal p = new Principal();

    public void adiciona(Funcionario c1, FileInputStream fin, int len) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            String query = "INSERT INTO funcionario ("
                    + "nome, cpf,"
                    + "sexo,estadocivil,"
                    + "ident,dataNasc,"
                    + "tel,cel,"
                    + "email,cep,endereco,bairro,"
                    + "cidade, estado,senha,status,foto)"
                    + " Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stm = con.prepareStatement(query);

            // setar os valores
            stm.setString(1, c1.getNome().toUpperCase());
            stm.setString(2, c1.getCpf());
            stm.setString(3, c1.getSexo());
            stm.setString(4, c1.getEstadocivil().toUpperCase());
            stm.setString(5, c1.getIdent());

            java.sql.Date datab = new java.sql.Date(c1.getDataNasc().getTime());
            stm.setDate(6, datab);

            stm.setString(7, c1.getTel());
            stm.setString(8, c1.getCel());
            stm.setString(9, c1.getEmail().toLowerCase());
            stm.setString(10, c1.getCep());
            stm.setString(11, c1.getEndereco().toUpperCase());
            stm.setString(12, c1.getBairro().toUpperCase());
            stm.setString(13, c1.getCidade().toUpperCase());
            stm.setString(14, c1.getEstado().toUpperCase());
            stm.setString(15, c1.getSenha());
            stm.setString(16, c1.getStatus());
            stm.setBinaryStream(17, fin, len);
            stm.executeUpdate();

            con.close();
            stm.close();
            //   JOptionPane.showMessageDialog(null, "cadastro ok");
            System.out.println("contato passou");
        } catch (SQLException ex) {
            System.out.println("nada passou" + ex.getMessage());
        }

    }

    public void altera(Funcionario c1, FileInputStream fin, int len) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            String query = "UPDATE  funcionario SET "
                    + "nome=?,cpf=?,"
                    + "sexo=?,estadocivil=?,ident=?,"
                    + "dataNasc=?,"
                    + "tel=?,cel=?,"
                    + "email=?,cep=?,"
                    + "endereco=?,bairro=?,cidade=?,"
                    + "estado=? ,foto=?"
                    + "WHERE id=?";
            // cria o comando para a conexao

            PreparedStatement stm = con.prepareStatement(query);

            stm.setString(1, c1.getNome().toUpperCase());
            stm.setString(2, c1.getCpf());
            stm.setString(3, c1.getSexo().toUpperCase());
            stm.setString(4, c1.getEstadocivil().toUpperCase());
            stm.setString(5, c1.getIdent());

            java.sql.Date datab = new java.sql.Date(c1.getDataNasc().getTime());
            stm.setDate(6, datab);

            stm.setString(7, c1.getTel());
            stm.setString(8, c1.getCel());
            stm.setString(9, c1.getEmail().toLowerCase());
            stm.setString(10, c1.getCep());
            stm.setString(11, c1.getEndereco().toUpperCase());
            stm.setString(12, c1.getBairro().toUpperCase());
            stm.setString(13, c1.getCidade().toUpperCase());
            stm.setString(14, c1.getEstado().toUpperCase());
            stm.setBinaryStream(15, fin, len);
            stm.setInt(16, c1.getId());

            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(Funcionario c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "DELETE  from funcionario WHERE id = ?";

            PreparedStatement stm = con.prepareStatement(query);
            stm.setLong(1, c1.getId());
            stm.executeUpdate();

            stm.close();
            con.close();

        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql" + e1);
            JOptionPane.showMessageDialog(null, "falha tente novamente");

        }

    }

    public static void consultarFuncionarioAniversario(Integer nome) {

        try {

            Connection con = ConectaBancomysql.getConnection();

            String query = "SELECT * from funcionario WHERE month(dataNasc)='" + nome + "' ";
            PreparedStatement stm = con.prepareStatement(query);
            // stm.setString(1, nome);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String nome1 = rs.getString("nome");
                String mail = rs.getString("email");

                // abaixo eu envio email com anexo
                try {
                    JavaMailApp.enviarEmailComAnexoFuncionario(mail);
                } catch (EmailException ex) {
                    Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
                }

                System.out.println(nome1);

            }

            stm.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro de sql" + e.getMessage());

        }

    }

    public static void consultarFuncionarioPropagandaEmail() throws EmailException {
        try {

            Connection con = ConectaBancomysql.getConnection();

            String query = "SELECT * from funcionario ";
            PreparedStatement stm = con.prepareStatement(query);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                String mail = rs.getString("email");

                JavaMailApp.enviarEmailComAnexoCliente(mail);//aqui eu envio os esmails

                System.out.println(mail);

            }

            stm.close();
            con.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ocorreu um erro de sql" + e.getMessage());

        }

    }

    public static void alteraSenha(Funcionario c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();

            String query = "UPDATE  funcionario SET senha=?, status=? WHERE nome=?";
            // cria o comando para a conexao

            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, c1.getSenha());
            stm.setString(2, c1.getStatus().toUpperCase());
            stm.setString(3, c1.getNome().toUpperCase());

            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     //public static void alteraFoto(FileInputStream fin,int len) {
//        try {
//            Connection con = ConectaBancomysql.getConnection();
//
//            String query = "UPDATE  funcionario SET foto=? WHERE nome=?";
//            // cria o comando para a conexao
//
//            PreparedStatement stm = con.prepareStatement(query);
//             stm.setBinaryStream(1, fin,len);
//            
//             stm.setString(2, c1.getNome().toUpperCase());
//           
//             
//
//          
//
//            stm.executeUpdate();
//            // JOptionPane.showMessageDialog(null, "cadastro ok");
//            con.close();
//            stm.close();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//      
//     
}
