/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author edelweiss
 */
public class Database {
    static Properties mypanel;
    static String driver,database,user,pass;
    static Connection conn;
    
    public static Connection KoneksiDB(){
        if (conn==null){
            try{
//                mypanel=new Properties();
//                mypanel.load(new FileInputStream("lib/database.ini"));
//                
//                driver = mypanel.getProperty("DBDriver");   
//                Database = mypanel.getProperty("DBDatabase");
//                user = mypanel.getProperty("DBUsername");
//                pass = mypanel.getProperty("DBPassword");
                driver = "com.mysql.cj.jdbc.Driver";
                database="jdbc:mysql://localhost/UAS_JWP";
                user="Edelweiss";
                pass="P4nd4_Expre55";
                
                Class.forName(driver);
                conn = DriverManager.getConnection(database,user,pass);
//                JOptionPane.showMessageDialog(null, "Koneksi berhasil", "Pesan", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Connected");
            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "Koneksi tidak berhasil","Pesan", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Error failed\t: "+e.getMessage());
            }
        }
        return conn;
    }
}
