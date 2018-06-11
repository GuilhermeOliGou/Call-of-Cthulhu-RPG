/*
package BaseDados;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ConectorBaseDados {

        // MySQL
        private static final String MYSQL_URL = "jdbc:mysql";

        protected Connection con;
        protected PreparedStatement ps;
        protected ResultSet rs;

        protected abstract String getDbHost();

        protected abstract String getDbName();

        protected abstract String getUser();

        protected abstract String getPassword();

        protected ConectorBaseDados(){
            super();
        }

        protected void abreConexao() throws Exception {
            try {
                con = DriverManager.getConnection(MYSQL_URL + "://" + getDbHost() + "/"
                        + getDbName(), getUser(), getPassword());
            } catch (SQLException e) {
                throw new Exception(
                        "Problemas no acesso ao banco de dados.");
            }
        }

        protected void fechaConexao() throws Exception {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }

                if (ps != null) {
                    ps.close();
                    ps = null;
                }

                if (con != null) {
                    con.close();
                    con = null;
                }

            } catch (SQLException e) {
                throw new Exception(
                        "Problemas no acesso ao banco de dados.");
            }

        }
        protected void geraComandoSQL(String sql) throws Exception {
            try {
                ps = con.prepareStatement(sql);
            } catch (SQLException e) {
                throw new Exception(
                        "Problemas no acesso ao banco de dados.");
            }
        }
    }

*/