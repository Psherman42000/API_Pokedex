
package api_pokedex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

public class ConexaoBanco {
        private String url = ""; //coloque a url do seu banco de dados aqui 
	private String usuario = ""; //coloque o usuario do seu banco de dados aqui
	private String senha = ""; //colooque a senha do seu banco de dados aqui
	private Connection conn;
        private String sql;
        private String pokemon;
        
        public ConexaoBanco(){//conecta com o banco
            try{
			Class.forName("org.postgresql.Driver");
            } 
            catch (ClassNotFoundException e1){
        	e1.printStackTrace();
            }		
            Properties prop = new Properties();
            prop.setProperty("password", this.senha);
            prop.setProperty("user", this.usuario);
            try{
		this.conn = DriverManager.getConnection(this.url, prop);                    
            } 
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null,e.getMessage());
                
            }
	}
	public Connection getConnection() 
	{
		return this.conn;
	}
        
        public void addPokemon(String pokemon){
        try {       
            
            sql="INSERT INTO pokedex (pokemon) VALUES ('?');";
            
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, pokemon);
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}

    public String GetPokemon(String num) {
        PreparedStatement ps;
            try {
                ps = this.conn.prepareStatement("SELECT pokemon FROM pokedex WHERE idpessoa = '?' ;");
                ps.setString(1,num);
                ResultSet rs = ps.executeQuery();
                rs.next();
                pokemon = rs.getString(1);
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return pokemon;
    }
}
