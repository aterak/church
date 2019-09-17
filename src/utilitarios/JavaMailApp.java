package utilitarios;


        
 //http://www.java2s.com/Code/Jar/j/Downloadjavamail144jar.htm
        
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class JavaMailApp
{
    
   static String meuEmailEmpresa;
   static String minhaSenhaEMPRESA;
   static String caminhoDoAnexo;
   static String assuntoEmail;

    public static String getMeuEmailEmpresa() {
        return meuEmailEmpresa;
    }

    public static void setMeuEmailEmpresa(String meuEmailEmpresa) {
        JavaMailApp.meuEmailEmpresa = meuEmailEmpresa;
    }

    public static String getMinhaSenhaEMPRESA() {
        return minhaSenhaEMPRESA;
    }

    public static void setMinhaSenhaEMPRESA(String minhaSenhaEMPRESA) {
        JavaMailApp.minhaSenhaEMPRESA = minhaSenhaEMPRESA;
    }

    public static String getCaminhoDoAnexo() {
        return caminhoDoAnexo;
    }

    public static void setCaminhoDoAnexo(String caminhoDoAnexo) {
        JavaMailApp.caminhoDoAnexo = caminhoDoAnexo;
    }

    public static String getAssuntoEmail() {
        return assuntoEmail;
    }

    public static void setAssuntoEmail(String assuntoEmail) {
        JavaMailApp.assuntoEmail = assuntoEmail;
    }
    
    
    
    
    
    
      public static void enviarEmailAniversario(String emailDestino){
          
          if(emailDestino.equals("")){
      
             emailDestino = "enviarEmailVazio@mail.com";
      
           }
          
          
          
          
          String emailDestino2 = String.valueOf(emailDestino);
          
          Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() 
                {
                return new PasswordAuthentication(meuEmailEmpresa, minhaSenhaEMPRESA);// email e senha
                }
                });

            /** Ativa Debug para sessão */
            session.setDebug(true);

            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(meuEmailEmpresa)); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(emailDestino2 );  //String com o email

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Feliz Aniversario");//Assunto
                  message.setText("É com muitas felicidades que desejamos um otimo dia a vc!");
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

                  System.out.println("Feito!!!");

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
      }
      
      
      
      
      
      public static void enviarEmailComAnexoCliente(String emailDestino) throws EmailException{
     
          if(emailDestino.equals("")){
      
           emailDestino = "enviarEmailVazio@mail.com";
      
           }
          
          
          
          
          
          String emailDestino2 = String.valueOf(emailDestino);
      
        EmailAttachment anexo1 = new EmailAttachment();  
        anexo1.setPath(caminhoDoAnexo); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)  
        anexo1.setDisposition(EmailAttachment.ATTACHMENT);  
      //  anexo1.setDescription("Exemplo de arquivo anexo");  
      //  anexo1.setName("Nosso convite");          
      
        // configura o email  
        MultiPartEmail email = new MultiPartEmail();  
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo(emailDestino2, "Cliente"); //destinatário  
        email.setFrom(meuEmailEmpresa, "Minha Empresa"); // remetente  
        email.setSubject(assuntoEmail); // assunto do e-mail  
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail  
        email.setAuthentication(meuEmailEmpresa, minhaSenhaEMPRESA);  
        email.setSmtpPort(465);  
        email.setSSL(true);  
        email.setTLS(true);  
        
        email.attach(anexo1);  
      
        email.send();  
      }
      
      public static void enviarEmailComAnexoFuncionario(String emailDestino) throws EmailException{
     
          if(emailDestino.equals("")){
      
            emailDestino = "enviarEmailVazio@mail.com";
      
           }
          
          
          
          
          
          String emailDestino2 = String.valueOf(emailDestino);
      
        EmailAttachment anexo1 = new EmailAttachment();  
        anexo1.setPath(caminhoDoAnexo); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)  
        anexo1.setDisposition(EmailAttachment.ATTACHMENT);  
      //  anexo1.setDescription("Exemplo de arquivo anexo");  
      //  anexo1.setName("propagandaempresa.txt");          
      
        // configura o email  
        MultiPartEmail email = new MultiPartEmail();  
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo(emailDestino2, "Funcionario"); //destinatário  
        email.setFrom(meuEmailEmpresa, "Minha Empresa"); // remetente  
        email.setSubject(assuntoEmail); // assunto do e-mail  
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail  
        email.setAuthentication(meuEmailEmpresa, minhaSenhaEMPRESA);  //email e senha
        email.setSmtpPort(465);  
        email.setSSL(true);  
        email.setTLS(true);  
        
        email.attach(anexo1);  
      
        email.send();  
      }
      
      
      
      public static void enviarEmailComAnexoFornecedor(String emailDestino) throws EmailException{
      
          if(emailDestino.equals("")){
      
            emailDestino = "enviarEmailVazio@mail.com";
      
           }
          
          
          String emailDestino2 = String.valueOf(emailDestino);
      
      
      
      
      
        EmailAttachment anexo1 = new EmailAttachment();  
        anexo1.setPath(caminhoDoAnexo); //caminho do arquivo (RAIZ_PROJETO/teste/teste.txt)  
        anexo1.setDisposition(EmailAttachment.ATTACHMENT);  
     //   anexo1.setDescription("Exemplo de arquivo anexo");  
     //   anexo1.setName("propagandaempresa.txt");          
      
        // configura o email  
        MultiPartEmail email = new MultiPartEmail();  
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail  
        email.addTo(emailDestino2, "Fornecedor"); //destinatário  
        email.setFrom(meuEmailEmpresa, "Minha Empresa"); // remetente  
        email.setSubject(assuntoEmail); // assunto do e-mail  
        email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail  
        email.setAuthentication(meuEmailEmpresa, minhaSenhaEMPRESA);  
        email.setSmtpPort(465);  
        email.setSSL(true);  
        email.setTLS(true);  
        
        email.attach(anexo1);  
      
        email.send();  
      }
      
}



//Leia mais em: Enviando email com JavaMail utilizando Gmail http://www.devmedia.com.br/enviando-email-com-javamail-utilizando-gmail/18034#ixzz3DDcoJsFb