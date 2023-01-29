package projekuas;

import java.util.Scanner;


public class InputDataMakanan {
    public static void InputData(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("             INPUT DATA MAKANAN            ");
        System.out.println("==========================================");
        
        System.out.print("ID Makanan : ");
        String id_makanan = sc.nextLine();
        System.out.print("Nama Makanan : ");
        String nama_makanan = sc.nextLine();
        System.out.print("Harga Makanan : ");
        String harga_makanan = sc.nextLine();
        System.out.print("ID Pelanggan : ");
        String id_pelanggan = sc.nextLine();
        
        try{
            Database.DataMakanan(id_makanan, nama_makanan, harga_makanan, id_pelanggan);
        }
        catch(Exception e){
            System.out.println("Error: " +e.getMessage());
            e.printStackTrace();
        }
    }
}
