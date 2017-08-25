package DAO;

import Model.Mercadoria;
import java.sql.Array;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class MercadoriaDAO {
    
    private Connection connection;
    
    public MercadoriaDAO() throws Exception {

            this.connection =  Factory.ConectarDB();

    }
    
    public void adicionarMercadoria(Mercadoria mercadoria){
        
        String sql;
        sql = "INSERT INTO mercadoria(nome, parcela, preco) VALUES(?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, mercadoria.getNome());
            ps.setInt(2, mercadoria.getParcela());
            ps.setFloat(3, mercadoria.getPreco());
            
            ps.execute();
            ps.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    }

    public Mercadoria procurarMercadoria(int id) throws Exception{
    
        String sql;
        sql = "SELECT id, nome, parcela, preco FROM mercadoria WHERE id=?";
        PreparedStatement ps = null;
        Connection c = null;
        ResultSet rs = null;
        
        
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
            int parcela = rs.getInt(3);
            float Preco = rs.getFloat(4);
            
            
            return new Mercadoria(nome, parcela, Preco);
            
        } catch (SQLException ex) {
            throw  new Exception(ex);
        }finally{
            Factory.closeConnection(c, ps, rs);
        }  
    }
    
    public void editarMercadoria(Mercadoria mercadoria) throws Exception {
        PreparedStatement ps = null;
        Connection c = null;
            String sql="UPDATE mercadoria SET nome = ?, parcela = ?, preco = ? FROM mercadoria WHERE id=?";
                    
            try{
            c = this.connection;
            ps = connection.prepareStatement(sql);
            
            ps.setString(1, mercadoria.getNome());
            ps.setInt(2, mercadoria.getParcela());
            ps.setFloat(3, mercadoria.getPreco());
            ps.setFloat(4, mercadoria.getId());
            
            ps.executeUpdate();
        }catch(SQLException sqle){
            throw new Exception("Erro ao atualizar dados: "+sqle);
        }finally{
            Factory.closeConnection(connection, ps);
        }
    }
    
    public void excluirMercadoria(Mercadoria mercadoria) throws Exception{
        
        PreparedStatement ps = null;
        Connection c = null;
        String sql = "DELETE FROM mercadoria WHERE id=?";
        
        try{
            c = this.connection;
            ps = connection.prepareStatement(sql);
            ps.setLong(1, mercadoria.getId());
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao excluir dados:"+sqle);
        }finally{
            Factory.closeConnection(connection, ps);
        }
    }
    
    public void excluirMercadoria(String ids) throws Exception{
        
        PreparedStatement ps = null;
        Connection c = null;
        String sql = "DELETE FROM mercadoria WHERE id IN("+ids.replaceAll("'", "''")+")";
        //Array array = MyPostgresArray.create(ids);
        
        try{
            c = this.connection;    
            ps = connection.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException sqle){
            throw new Exception("Erro ao excluir dados:"+sqle);
        }finally{
            Factory.closeConnection(connection, ps);
        }
    }
    
    public Collection<Mercadoria> todasMercadorias() throws Exception{
    
        String sql;
        
        Collection<Mercadoria> mercadorias = new ArrayList<>();
        PreparedStatement ps = null;
        Connection c = null;
        ResultSet rs = null;
        sql = "SELECT id, nome, parcela, preco FROM mercadoria";
        
        try {
            c = this.connection;
            ps = connection.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.executeQuery();
            if(!rs.next()){
                throw new Exception("Não foi "
                        + "encontrado nenhum dado!");
                
            }
            
            while(rs.next()){
                
                Mercadoria mercadoria = new Mercadoria();
                int id2 = rs.getInt(1);
                String nome = rs.getString(2);
                int parcela = rs.getInt(3);
                float Preco = rs.getFloat(4);
                
                mercadoria.setId(id2);
                mercadoria.setNome(nome);
                mercadoria.setParcela(parcela);
                mercadoria.setPreco(Preco);
                
                mercadorias.add(mercadoria);
            }
            
            
            return mercadorias;
            
        } catch (SQLException ex) {
            throw  new Exception(ex);
        }finally{
            Factory.closeConnection(c, ps, rs);
        }  
    }
    
}
