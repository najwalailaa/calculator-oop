/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkulator;

/**
 *
 * @author Najwa
 */
public class call {
    double bil1, bil2, hasil;
    
    double tambah(){
        hasil = bil1+bil2;
        return hasil;
    }
    double kurang(){
        hasil = bil1-bil2;
        return hasil;
    }
    double kali(){
        hasil = bil1*bil2;
        return hasil;
    }
    double bagi(){
        hasil = bil1/bil2;
        return hasil;
    }
    
    double modulus(){
        hasil = bil1%bil2;
        return hasil;
    }
}
