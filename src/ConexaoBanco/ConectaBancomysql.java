/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author EMPRESA
 */
public class ConectaBancomysql {

    public static Connection getConnection() throws SQLException {

        try {
            // procura por uma classe no projeto
     Class.forName("com.mysql.jdbc.Driver");
     return DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinase",
                    "root", "");
        } catch (ClassNotFoundException ex) {

            throw new SQLException(ex.getMessage());
        }
    }
}