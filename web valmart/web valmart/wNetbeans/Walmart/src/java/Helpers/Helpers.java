package Helpers;

import java.text.NumberFormat;

public class Helpers {

    public static String fmReal(double valor){
    
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String valorFormatado = nf.format(valor);
        
        valorFormatado = valorFormatado.substring(3, valorFormatado.length()-3);
       
        return valorFormatado;
    
    } 
    
    public static String fmCents(double valor){
    
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String valorFormatado = nf.format(valor);
        
        valorFormatado = valorFormatado.substring(valorFormatado.length()-3, valorFormatado.length());
       
        return valorFormatado;
    
    }
    
    public static String selectInId(String[] array){
       
        String retorno = "";
        
        for(String s: array)
            retorno+= s+", ";
        
        return retorno.substring(0, retorno.length()-2);
    
    }
    
}
