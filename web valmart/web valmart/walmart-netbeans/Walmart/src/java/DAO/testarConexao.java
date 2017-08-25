/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Model.Mercadoria;
import java.util.ArrayList;

/**
 *
 * @author anderson
 */
public class testarConexao {
    public static void main(String[] args) throws Exception {

        double valor = 1234567.89;
   
        /*    System.out.println(Helpers.Helpers.fmInteiro(valor));*/   

        
        System.out.println("Conexão aberta!");
        MercadoriaDAO mercadoriaDAO = new MercadoriaDAO();
        ArrayList<Mercadoria> mercadorias = (ArrayList<Mercadoria>) mercadoriaDAO.todasMercadorias();
        
        for(Mercadoria m : mercadorias){
        
            System.out.println(m);
            
        }
    }
    
}
