package projekuas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/kantinkampus";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    static Statement state;
    
    public static String getPassword(String id_karyawan) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "SELECT passwordd FROM karyawan WHERE id_karyawan = (?)";
        ps = con.prepareStatement(query);
        ps.setString(1, id_karyawan);
        rs = ps.executeQuery();
        
        if(!rs.next()){
            return null;
        }
        else{
            return rs.getString(1).toString();
        }
    }
    
    public static void insertAkun(String id_karyawan, String nama_karyawan, String jenis_kelamin, String alamat, String passwordd) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO karyawan VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_karyawan);
        ps.setString(2, nama_karyawan);
        ps.setString(3, jenis_kelamin);
        ps.setString(4, alamat);
        ps.setString(5, passwordd);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Akun berhasil didaftarkan");
        }
        else{
            System.out.println("Akun gagal didaftarkan");
        }
    }
    
    public static void DataPelanggan(String id_pelanggan, String nama_pelanggan, String alamat, String jenis_kelamin, String id_karyawan) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO pelanggan VALUES (?,?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_pelanggan);
        ps.setString(2, nama_pelanggan);
        ps.setString(3, alamat);
        ps.setString(4, jenis_kelamin);
        ps.setString(5, id_karyawan);
        
        if(ps.executeUpdate() > 0){
            InputDataMakanan.InputData();
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void DataMakanan(String id_makanan, String nama_makanan, String harga_makanan, String id_pelanggan) throws Exception{
        Class.forName(jdbc);
        con = DriverManager.getConnection(url, username, password);
        
        String query = "INSERT INTO makanan VALUES (?,?,?,?)";
        ps = con.prepareStatement(query);
        
        ps.setString(1, id_makanan);
        ps.setString(2, nama_makanan);
        ps.setString(3, harga_makanan);
        ps.setString(4, id_pelanggan);
        
        if(ps.executeUpdate() > 0){
            System.out.println();
            System.out.println("Data Berhasil Diinput");
        }
        else{
            System.out.println("Data Gagal Diinput");
        }
    }
    
    public static void ShowDataPelanggan() throws Exception{
        int no = 0;
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url, username, password);
            state = con.createStatement();
            String query = "SELECT pelanggan.*, makanan.* FROM pelanggan INNER JOIN makanan ON pelanggan.id_pelanggan=makanan.id_pelanggan";
            rs = state.executeQuery(query);
            
            while(rs.next()){
                no++;
                System.out.println("No."+ no);
                System.out.println("ID Pelanggan       : " + rs.getString("id_pelanggan"));
                System.out.println("Nama Pelanggan     : " + rs.getString("nama_pelanggan"));
                System.out.println("Alamat             : " + rs.getString("alamat"));
                System.out.println("Jenis Kelamin      : " + rs.getString("jenis_kelamin"));
                System.out.println("ID karyawan         : " + rs.getString("id_karyawan"));
                System.out.println("ID Makanan           : " + rs.getString("id_makanan"));
                System.out.println("Nama Makanan         : " + rs.getString("nama_makanan"));
                System.out.println("Harga Makanan        : " + rs.getString("harga_makanan"));
                System.out.println("-------------------------------------------------------");
            } 
        }
        catch(Exception ex){
            ex.printStackTrace();
        } 
    }
}
