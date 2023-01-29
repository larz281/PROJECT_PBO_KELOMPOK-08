package projekuas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class UpdateData {
    static final String jdbc = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/kantinkampus";
    static final String username = "root";
    static final String password = "";
    
    static Connection con;
    static ResultSet rs;
    static PreparedStatement ps;
    public static void update() throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             UPDATE DATA PELANGGAN             ");
        System.out.println("===============================================");
        
        System.out.print("Nama Pelanggan Sebelumnya : ");
        String nama_pel = sc.nextLine();
        System.out.print("Nama Pelanggan  : ");
        String nama_pelanggan = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        System.out.print("Jenis Kelamin [L/P] : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("ID Karyawan : ");
        String id_karyawan = sc.nextLine();
        
        try{
            Class.forName(jdbc);
            con = DriverManager.getConnection(url,username,password);
            String query = "update pelanggan set nama_pelanggan=?, alamat=?, jenis_kelamin=?, id_karyawan=? WHERE nama_pelanggan=?";
            
            ps = con.prepareStatement(query);
            
            ps.setString(1, nama_pelanggan);
            ps.setString(2, alamat);
            ps.setString(3, jenis_kelamin);
            ps.setString(4, id_karyawan);
            ps.setString(5, nama_pel);
            
            if (ps.executeUpdate() > 0) {
                System.out.println("Proses Update Berhasil!");
            }
            else{
                System.out.println("Proses Update Gagal");
            } 
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
