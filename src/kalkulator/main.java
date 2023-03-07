/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkulator;
import java.util.Scanner;
/**
 *
 * @author Najwa
 */
public class main {
   public static void main(String[] args) {
        inputan hitung1 = new inputan();
        Scanner sc = new Scanner(System.in);
        System.out.println("Masukkan data yang akan dihitung (guanakn spasi)  : ");
        String  pilih = sc.nextLine();
        
            hitung1.Input(pilih);
}}
