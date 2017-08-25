package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    
    private Connection connection;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        
        connection = Factory.ConectarDB();
    
    }
    
    
    
    public void adicionarUsuario(Usuario usuario){
        
        String sql;
        sql = "INSERT INTO usuario(nome, email, CPF, telefone, senha, receberemail) VALUES(?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getCpf());
            ps.setString(4, usuario.getTelefone());
            ps.setString(5, usuario.getSenha());
            ps.setBoolean(6, usuario.isReceberEmail());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }

    public Usuario procurarUsuario(int id) throws Exception{
    
        String sql;
        sql = "SELECT id, nome, email, CPF, telefone, senha, receberemail FROM usuario WHERE id=?";
        PreparedStatement ps = null;
        Connection c = null;
        ResultSet rs = null;
//        conectarDB();
        try {
            c = this.connection;
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeQuery();
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Não foi "
                        + "encontrado nenhum dado com o ID: "+id);
                
            }
            
            int id2 = rs.getInt(1);
            String nome = rs.getString(2);
            String email = rs.getString(3);
            String CPF = rs.getString(4);
            String telefone = rs.getString(5);
            String senha = rs.getString(6);
            boolean receberEmail = rs.getBoolean(7);

            
            
            return new Usuario(nome, email, CPF, telefone, senha, receberEmail);
            
        } catch (SQLException ex) {
            throw  new Exception(ex);
        }finally{
            Factory.closeConnection(c, ps, rs);
        }  
    }
    
    public void editarUsuario(Usuario usuario) throws Exception {
        PreparedStatement ps = null;
        Connection c = null;
            String sql="UPDATE usuario SET nome = ?, email = ?, CPF = ?, telefone = ?, senha = ?, receberemail = ? FROM usuario WHERE id=?";
                    
            try{
            c = this.connection;
            ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getCpf());
            ps.setString(4, usuario.getTelefone());
            ps.setString(5, usuario.getSenha());
            ps.setBoolean(6, usuario.isReceberEmail());
            ps.setInt(7, usuario.getId());
            
            ps.executeUpdate();
        }catch(SQLException sqle){
            throw new Exception("Erro ao atualizar dados: "+sqle);
        }finally{
            Factory.closeConnection(connection, ps);
        }
    }
    
    public void excluirUsuario(Usuario usuario) throws Exception{
        
        PreparedStatement ps = null;
        Connection c = null;
        String sql = "DELETE FROM usuario WHERE id=?";
        
        try{
            c = this.connection;
            ps = connection.prepareStatement(sql);
            ps.setLong(1, usuario.getId());
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao excluir dados:"+sqle);
        }finally{
            Factory.closeConnection(connection, ps);
        }
    }
    
    public int validarLogin(String email, String senha) throws SQLException, ClassNotFoundException{
        
        int retorno = 0;
        String sql;
        sql = "SELECT id FROM usuario WHERE email=? AND senha = ?";
        PreparedStatement ps = null;
        Connection c = null;
        ResultSet rs = null;
        //conectarDB();
            c = this.connection;
        try {
            
            ps = (PreparedStatement) connection.prepareStatement("SELECT id FROM usuario WHERE email=? AND senha = ?");
            ps.setString(1, email);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            
            if(!rs.next()){
                retorno = 0;
            }
            
            retorno = rs.getInt(1);
        
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return retorno;
        
    }
    
    
    /*public void conectarDB() throws ClassNotFoundException, SQLException{   
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WalmartDB","postgres","mysql");
    }*/
}
