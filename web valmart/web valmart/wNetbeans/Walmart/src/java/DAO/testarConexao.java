/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Mercadoria;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author anderson
 */
public class testarConexao {
    public static void main(String[] args) throws Exception {

        double valor = 1234567.89;
   
   
        
        System.out.println("Conexão aberta!");
        MercadoriaDAO mercadoriaDAO = new MercadoriaDAO();
        ArrayList<Mercadoria> mercadorias = (ArrayList<Mercadoria>) mercadoriaDAO.pesquisarMercadorias("Sma");
        
        for(Mercadoria m : mercadorias){
        
            System.out.println(m);
            
        }
    }
   
    public boolean insertFile( File f ) throws SQLException, ClassNotFoundException{
    Connection c = Factory.ConectarDB();//busca uma conexao com o banco
    try {
        PreparedStatement ps = c.prepareStatement("INSERT INTO mercadoria(arquivo) VALUES ( ? )");
 
        //converte o objeto file em array de bytes
        InputStream is = new FileInputStream( f );
        byte[] bytes = new byte[(int)f.length() ];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        ps.setBytes( 1, bytes );
        ps.execute();
        ps.close();
        c.close();
        return true;
 
    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return false;
}
    
}
