package projekuas;

import java.util.Scanner;


public class InputDataPelanggan {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             INPUT DATA PELANGGAN             ");
        System.out.println("==============================================");
        
        System.out.print("ID Pelanggan : ");
        String id_pelanggan = sc.nextLine();
        System.out.print("Nama Pelanggan : ");
        String nama_pelanggan = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        System.out.print("Jenis Kelamin (L/P) : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("ID karyawan : ");
        String id_pegawai = sc.nextLine();
        
        try{
            Database.DataPelanggan(id_pelanggan, nama_pelanggan, alamat, jenis_kelamin, id_pegawai);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
