package projekuas;

import java.util.Scanner;


public class DaftarKaryawan {
    public static void DaftarKaryawan(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             DAFTAR AKUN KARYAWAN             ");
        System.out.println("=============================================");
        
        System.out.print("Username : ");
        String id_karyawan = sc.nextLine();
        System.out.print("Password : ");
        String passwordd = sc.nextLine();
        System.out.print("Nama Karyawan : ");
        String nama_karyawan = sc.nextLine();
        System.out.print("Jenis Kelamin (Laki-Laki/Perempuan) : ");
        String jenis_kelamin = sc.nextLine();
        System.out.print("Alamat : ");
        String alamat = sc.nextLine();
        
        try{
            Database.insertAkun(id_karyawan, nama_karyawan, jenis_kelamin, alamat, passwordd);
            System.out.println("Tolong ingat username anda");
            System.out.println("Username anda " + id_karyawan);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
