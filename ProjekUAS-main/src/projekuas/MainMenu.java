package projekuas;

import java.util.Scanner;


public class MainMenu {
    public static void main(String[] args) {
        try{
            menuForm();
        }
        catch(Exception e){
            System.out.println("Ada Sebuah Kesalahan");
            System.out.println("Error Message : " +e.getMessage());
            e.printStackTrace();
        }
    }
    
    static void menuForm(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             MENU UTAMA             ");
        System.out.println("=====================================");
        System.out.println("1. Login");
        System.out.println("2. Daftar");
        System.out.println("3. Keluar");
        System.out.println();
            
        System.out.print("Pilihan [1/2/3] = ");
        int pilih = sc.nextInt();
            
        if(pilih == 1){
            Login.Login();
        }
        else if(pilih == 2){
            DaftarKaryawan.DaftarKaryawan();
        }
        else if(pilih == 3){
            System.exit(0);
        }
        else{
            System.out.println("Silahkan masukkan input yang benar");
            System.out.println();
            menuForm();
        }
    }
}