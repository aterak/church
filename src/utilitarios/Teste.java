/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitarios;

import ConexaoBanco.ConectaBancomysql;
import dao.ClienteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 *
 * @author EMPRESA
 */
public class Teste {
 
    
    
    public static void main(String[] args) {
          //aqui eu salvo na tabela vendas e imprimo a nota fiscal
//       List<Cliente> lista = new ArrayList();
//         Cliente c = new  Cliente();
//        
//         String mes ="11"; 
//         try {
//              Connection con = ConectaBancomysql.getConnection();
//            // cria string
//            String query = "SELECT  * from cliente where month(dataNascCliente)= "+mes +" ";
//            // cria o comando para a conexao
//            PreparedStatement stm = con.prepareStatement(query);
//          
//
//            ResultSet rs = stm.executeQuery();
//
//       
//          
//            while (rs.next()) {
//
//             
//               
//                c.setDataNascCliente(rs.getDate("dataNascCliente"));
//               
//           lista.add(c);
//             System.out.println(c.getDataNascCliente());
//            }
//             
//         //  System.out.println(c.getDataNascCliente());
//            stm.close();
//            con.close();
//            rs.close();
//            
//        } catch (SQLException e) {
//            System.out.println("ocorreu um erro de sql");
//        }
//
//      // System.out.println(lista.);
//    
//    
//    
    //Object[] options = { "Sim...", "Não..." };  
//
//   Object[] options = { "Sim, sim, claro...", "Não, explica de novo." };  
//int n = JOptionPane.showOptionDialog(null,  
//                "Você entendeu este exemplo ? ",  
//                "Exemplo", JOptionPane.YES_NO_OPTION,  
//                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);  

    
    
    
    int qunatidade=1;String nome="PRODUTO2";
     String novoestoque  ;
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
                c1.setCodigoInter(rs.getString("codigoInter"));
                c1.setNome(rs.getString("nome"));
                c1.setValor((rs.getDouble("valor")));
             
                
                
                
                c1.setQuant(rs.getInt("quant"));
               
                
                c1.setEstoqueMinimo(rs.getInt("estoqueMinimo"));
                c1.setPcusto((rs.getDouble("pcusto")));
                c1.setFornecedor(rs.getString("fornecedor"));
                minhaLista.add(c1);
                
                 estoqueNovo=  qunatidade- c1.getQuant();
            
                    alteracao(estoqueNovo, c1.getNome());
                
                
                
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
         
        public static void  alteracao(int quant, String nome){ 
         
            
         
         
        try {
            Connection con = ConectaBancomysql.getConnection();
            String query;
            PreparedStatement stm;
       
            query = "UPDATE  produto SET quant=? WHERE nome=?";
            stm = con.prepareStatement(query);   
            stm.setInt(1, quant);
            stm.setString(2, nome);
            stm.executeUpdate();
             JOptionPane.showMessageDialog(null, "cadastro ok");
            con.close();
            stm.close();
        } catch (SQLException ex) {
            System.out.println("nem aqui passou");
        }
    }
    
    
    
    
    
}
