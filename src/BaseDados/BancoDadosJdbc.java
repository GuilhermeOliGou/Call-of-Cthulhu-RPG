package BaseDados;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BancoDadosJdbc{
    private final String MYSQL_URL = "jdbc:mysql";

    protected Connection con;
    protected PreparedStatement ps;
    protected ResultSet rs;

    protected Properties prop = new Properties();
    protected String properties = "config.properties";
    protected InputStream inputStream = getClass().getResourceAsStream(properties);

    private String PASSWORD;
    private String USER;
    private String HOST;
    private String DB_NAME;

    public BancoDadosJdbc() throws IOException{
        if(inputStream != null){
            prop.load(inputStream);
        }
        else{
            throw new FileNotFoundException("Arquivo " + properties + " não foi encontrado.");
        }
        USER = prop.getProperty("user");
        PASSWORD = prop.getProperty("password");
        HOST = prop.getProperty("host");
        DB_NAME = prop.getProperty("db_name");
    }

    protected void abreConexao() throws BaseDadosException {
        try {
            con = DriverManager.getConnection(MYSQL_URL + "://" + HOST + "/"
                    + DB_NAME, USER, PASSWORD);
        } catch (SQLException e) {
            throw new BaseDadosException(
                    "Problemas no acesso ao banco de dados.");
        }
    }

    protected void fechaConexao() throws BaseDadosException {
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
            throw new BaseDadosException(
                    "Problemas no acesso ao banco de dados.");
        }

    }

    protected void preparaComandoSQL(String sql) throws BaseDadosException {
        try {
            ps = con.prepareStatement(sql);
        } catch (SQLException e) {
            throw new BaseDadosException(
                    "Problemas no acesso ao banco de dados.");
        }
    }

}