/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import ConexaoBanco.ConectaBancomysql;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;

import modelo.Cliente;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author EMPRESA
 */
public class ChamaRelatorio {

    public static void relatorioGeralCliente() {

        try {
            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioGeralCliente.jrxml");
            // JasperReport reporter = JasperCompileManager.compileReport("usuarios.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, null, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void relatorioGeralFuncionario() {

        try {
            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioGeralFuncionario.jrxml");
            // JasperReport reporter = JasperCompileManager.compileReport("usuarios.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, null, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void relatorioGeralInventario() {

        try {
            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioGeralInventario.jrxml");
            // JasperReport reporter = JasperCompileManager.compileReport("usuarios.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, null, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void relatorioGeralProduto() {

        try {
            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioGeralProduto.jrxml");
            // JasperReport reporter = JasperCompileManager.compileReport("usuarios.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, null, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void relatorioGeralFornecedor() {

        try {
            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioGeralFornecedor.jrxml");
            // JasperReport reporter = JasperCompileManager.compileReport("usuarios.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, null, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void relatorioGeralVendas() {

        try {
            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioGeralNotaFiscal.jrxml");
            // JasperReport reporter = JasperCompileManager.compileReport("usuarios.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, null, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void relatorioClientePorId() {

        Cliente clien = new Cliente();
        try {
            HashMap filtro = new HashMap();
            filtro.put("solicitaNotaFiscal", clien.getId());

            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioNotaFiscal.jrxml");
            //  JasperReport reporter = JasperCompileManager.compileReport("\\src\\relatorios\\report1.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, filtro, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println("erro");

        }

    }
    
    
  
    
    
    
    public static void relatorioNotafiscalVenda(int confirmaNota){
    
     try {
            HashMap filtro = new HashMap();
            filtro.put("solicitaNotaFiscal", confirmaNota);// caso fosse para digitar deveria ser vend.getcodigo

            Connection con = ConectaBancomysql.getConnection();
            JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioNotaFiscal.jrxml");
            //  JasperReport reporter = JasperCompileManager.compileReport("\\src\\relatorios\\report1.jrxml");
            JasperPrint imprime = JasperFillManager.fillReport(reporter, filtro, con);
            JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
        } catch (Exception e) {
            System.out.println("erro ao gerar relatorio"+e.getMessage());

        }
    
    }
    
    public static void vendaData(String dataInicio , String dataFim ){
    try {
                HashMap filtro = new HashMap(); 
                filtro.put("inicioData", dataInicio);//inicioData esse solicitacodogo vem la do jasper
                filtro.put("fimData", dataFim);//fimData  esse solicitacodogo vem la do jasper 

                Connection con = ConectaBancomysql.getConnection();
                JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\NotasData.jrxml");
                 JasperPrint imprime = JasperFillManager.fillReport(reporter, filtro, con);
                JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
            } catch (Exception e) {
                System.out.println("erro de gerar relatorio " + e.getMessage());

            }

    
    }
    
    public static void aniversarioFuncionarioData(String dataInicio , String dataFim ){
   
  try {
                HashMap filtro = new HashMap();
                filtro.put("niverinicio", dataInicio);// niverinicio  esse solicitacodogo vem la do jasper
                filtro.put("niverfim", dataFim);// niverfim esse solicitacodogo vem la do jasper 

                Connection con = ConectaBancomysql.getConnection();
                JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioAniversarioFuncionario.jrxml");

                JasperPrint imprime = JasperFillManager.fillReport(reporter, filtro, con);
                JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
            } catch (Exception e) {
                System.out.println("erro de gerar relatorio " + e.getMessage());

            }
    
    }
    
    
      public static void aniversarioFuncionarioData2(String data){
    
    try {
                HashMap filtro = new HashMap();
                filtro.put("datafunci", data);// niverinicio  esse solicitacodogo vem la do jasper
                

                Connection con = ConectaBancomysql.getConnection();
                JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioAniversarioFuncionario.jrxml");

                JasperPrint imprime = JasperFillManager.fillReport(reporter, filtro, con);
                JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
            } catch (Exception e) {
                System.out.println("erro de gerar relatorio " + e.getMessage());

            }
    
    
    
    }
    
     public static void aniversarioClienteAniversario(String data){
    
    try {
                HashMap filtro = new HashMap();
                filtro.put("dataCliente", data);// niverinicio  esse solicitacodogo vem la do jasper
                

                Connection con = ConectaBancomysql.getConnection();
                JasperReport reporter = JasperCompileManager.compileReport("\\C:\\RelatoriosEmpresa\\RelatorioAniversarioCliente.jrxml");

                JasperPrint imprime = JasperFillManager.fillReport(reporter, filtro, con);
                JasperViewer.viewReport(imprime, false);//o false serve para fechar apenas o relatorio
            } catch (Exception e) {
                System.out.println("erro de gerar relatorio " + e.getMessage());

            }
    
    
    
    }
}
