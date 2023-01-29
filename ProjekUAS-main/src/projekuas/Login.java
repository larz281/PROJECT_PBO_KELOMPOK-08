package projekuas;

import java.util.Scanner;

public class Login {
    public static void Login(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Username : ");
        String id_karyawan = sc.nextLine();
        
        System.out.print("Password : ");
        String passwordd = sc.nextLine();
        System.out.println();
        
        try{
            if(passwordd.equals(Database.getPassword(id_karyawan))){
                Menu2.menuForm();
            }
            else{
                System.out.println("Username Atau Password Salah");
                System.out.println("");
                Login();
            }
        }
        catch(Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}