/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anderson
 */
public class testarConexao {
    public static void main(String[] args) throws Exception {

        System.out.println("Conexão aberta!");
        UsuarioDAO udao = new UsuarioDAO();
        System.out.println(udao.validarLogin("anderson.santos", "123"));
       
    }
    
}
