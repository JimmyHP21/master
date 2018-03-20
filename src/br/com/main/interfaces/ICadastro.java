/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.interfaces;

import java.util.Scanner;

/**
 *
 * @author renanperes
 */
public interface ICadastro{
    void imprimir();
    void entrada();
    public static final Scanner leia= new Scanner(System.in);
}
