package projetohackaton;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;

public class convertImage {
    
    public void converterImagem(){
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/";
	String dbName = "imagens";
	String userName = "root";
	String password = "root";
	Connection con = null;
        
	try{
            Class.forName(driverName);
            con = DriverManager.getConnection(url+dbName,userName,password);
            try {
                PreparedStatement ss = con.prepareStatement("select * from imagensbd");
                ResultSet result = ss.executeQuery();
                 
                while(result.next()){
                    if(Integer.parseInt(result.getString("cvtd")) == 0){
                        int x = Integer.parseInt(result.getString("idImagem"));
                        InputStream img = result.getBinaryStream("img"); // reading image as InputStream
                        BufferedImage buffimg = ImageIO.read(img);
                        File outputfile = new File("imagee"+x+".jpg");
                        ImageIO.write(buffimg, "jpg", outputfile);
                        
                        PreparedStatement x2 = con.prepareStatement("UPDATE imagensbd set cvtd = 1 where idImagem = ?");
                        x2.setString(1, result.getString("idimagem"));
                        x2.executeUpdate();
                        
                        x++;
                    }
                }
            }catch(Exception ex) {
                System.out.println(ex.getMessage());
            }
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}
    }
}
