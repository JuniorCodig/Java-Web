package nathan.ads.gerenciadorDeVeiculos.filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author Nathan
 */
public class ConexaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private Connection abrirConexao() throws SQLException {
        Properties config = new Properties();
        config.setProperty("user", "root");
        config.setProperty("password", "Acdc32112409");
        config.setProperty("serverTimezone", "America/Sao_Paulo");
        
        String url = "jdbc:mysql://localhost:3306/gerenciadorveiculos";
        
        return DriverManager.getConnection(url, config);
    }
    
    private void fecharConexao(Connection conn) {
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
        Connection conexao = null;
        try {
            conexao = abrirConexao();
            request.setAttribute("conexao", conexao);
            
            chain.doFilter(request, response);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            fecharConexao(conexao);
        }
        
    }

    @Override
    public void destroy() {
    
    }

}
