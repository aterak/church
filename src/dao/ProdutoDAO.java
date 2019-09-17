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
import javax.swing.JOptionPane;
import modelo.Produto;
import static utilitarios.Teste.alteracao;

/**
 *
 * @author EMPRESA
 */
public class ProdutoDAO {

    public void adiciona(Produto c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
            query = "INSERT INTO produto (nome,codigoInter,"
                    + "valor, quant,"
                    + "pcusto,fornecedor)"
                    + " Values(?,?,?,?,?,?)";


            stm = con.prepareStatement(query);

            // setar os valores
            stm.setString(1, c1.getNome().toUpperCase());
            stm.setString(2, c1.getCodigoInter());
            stm.setDouble(3, c1.getValor());
            stm.setInt(4, c1.getQuant());
           // stm.setInt(5, c1.getEstoqueMinimo());
            stm.setDouble(5, c1.getPcusto());
            stm.setString(6, c1.getFornecedor().toUpperCase());
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
            System.out.println("produto  passou");
        } catch (SQLException ex) {
            System.out.println("nada passou");
        }

    }

    public void altera(Produto c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
            query = "UPDATE  produto SET nome=?,codigoInter=?,"
                    + "valor=?,quant=?,estoqueMinimo=?,"
                    + "pcusto=?,fornecedor=? "
                    + "WHERE id=?";

            // cria o comando para a conexao
            stm = con.prepareStatement(query);
            stm.setString(1, c1.getNome().toUpperCase());
            stm.setString(2, c1.getCodigoInter());
            stm.setDouble(3, c1.getValor());
            stm.setInt(4, c1.getQuant());
            stm.setInt(5, c1.getEstoqueMinimo());
            stm.setDouble(6, c1.getPcusto());
             stm.setString(7, c1.getFornecedor().toUpperCase());
            stm.setInt(8, c1.getId());

            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("nem aqui passou");
        }
    }

    public void remove(Produto c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "DELETE  from produto WHERE id = ?";
            PreparedStatement stm;
            stm = con.prepareStatement(query);
            stm.setLong(1, c1.getId());
            stm.executeUpdate();

            stm.close();
            con.close();

        } catch (SQLException e1) {
            System.out.println("ocorreu um erro de sql" + e1);
        }


    }

    public List<Produto > getLista() {
                //   Produto c2 = new Produto();
        try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "SELECT * from produto";
            PreparedStatement stm;
            stm = con.prepareStatement(query);
          
            
         //   stm.setString(1, c2.getNomeProduto() + "%");
            ResultSet rs;
            rs = stm.executeQuery();
            List<Produto> minhaLista = new ArrayList<Produto>();
            
             while (rs.next()) {
             Produto c1 = new Produto();
                c1.setId(rs.getInt("id"));
                c1.setCodigoInter(rs.getString("codigoInter"));
                c1.setNome(rs.getString("nome"));
                c1.setValor((rs.getDouble("valor")));
             
                
                
                
                c1.setQuant(rs.getInt("quant"));
               
                
                c1.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
                c1.setPcusto((rs.getDouble("pcusto")));
                c1.setFornecedor(rs.getString("fornecedor"));
                minhaLista.add(c1);
            }
             System.out.println(minhaLista);
            rs.close();
            stm.close();
            return minhaLista;
           
        } catch (Exception e) {
            System.out.println("nada passou");
            JOptionPane.showMessageDialog(null, "falha tente novamente");
        }
        return null;

    }

    
    public static void alteraProdutoADM(Produto c1) {

        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
            query = "UPDATE  produto SET estoqueMinimo=? WHERE nome=?";

            // cria o comando para a conexao
              stm = con.prepareStatement(query);
              stm.setInt(1, c1.getEstoqueMinimo());
              stm.setString(2, c1.getNome().toUpperCase());
          
           

            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("nem aqui passou a alteração");
        }
    }

    
    
    
     public static void alteraProdutoVendaMenos(int quantidade,String nome) {
    
     int estoqueNovo;
      
       try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "SELECT * from produto WHERE nome=?";
            PreparedStatement stm;
            stm = con.prepareStatement(query);
          
            
            stm.setString(1, nome);
            ResultSet rs;
            rs = stm.executeQuery();
            List<Produto> minhaLista = new ArrayList<Produto>();
            
             while (rs.next()) {
             Produto c1 = new Produto();
                c1.setId(rs.getInt("id"));
              
                c1.setNome(rs.getString("nome"));
              
                c1.setQuant(rs.getInt("quant"));
               
                minhaLista.add(c1);
                
                 estoqueNovo=  c1.getQuant()- quantidade;
            
                    alteracaoDQuantidade(estoqueNovo, c1.getNome());
                
                
                
            }
             System.out.println(minhaLista);
            rs.close();
            stm.close();
          
           
        } catch (Exception e) {
            System.out.println("nada passou");
            JOptionPane.showMessageDialog(null, "falha tente novamente");
        }
       
     }
         
         
          public static void alteraProdutoVendaMais(int quantidade,String nome) {
    
     int estoqueNovo;
      
       try {
            Connection con = ConectaBancomysql.getConnection();
            String query = "SELECT * from produto WHERE nome=?";
            PreparedStatement stm;
            stm = con.prepareStatement(query);
          
            
            stm.setString(1, nome);
            ResultSet rs;
            rs = stm.executeQuery();
            List<Produto> minhaLista = new ArrayList<Produto>();
            
             while (rs.next()) {
             Produto c1 = new Produto();
                c1.setId(rs.getInt("id"));
              
                c1.setNome(rs.getString("nome"));
              
                c1.setQuant(rs.getInt("quant"));
               
                minhaLista.add(c1);
                
                 estoqueNovo=  c1.getQuant()+ quantidade;
            
                    alteracaoDQuantidade(estoqueNovo, c1.getNome());
                
                
                
            }
             System.out.println(minhaLista);
            rs.close();
            stm.close();
          
           
        } catch (Exception e) {
            System.out.println("nada passou");
            JOptionPane.showMessageDialog(null, "falha tente novamente");
        }
       
     }
         
         
         //estoqueNovo= Integer.parseInt(novoestoque) - (qunatidade);
         
        public static void  alteracaoDQuantidade(int quant, String nome){ 
         
            
         
         
        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
       
            query = "UPDATE  produto SET quant=? WHERE nome=?";
            stm = con.prepareStatement(query);   
            stm.setInt(1, quant);
            stm.setString(2, nome);
            stm.executeUpdate();
            // JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("nem aqui passou");
        }
    }
}
    
