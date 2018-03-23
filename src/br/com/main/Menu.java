/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main;

import br.com.main.classes.Fornecedor;
import br.com.main.classes.Pagar;

/**
 *
 * @author renanperes
 */
public class Menu {
    public static void main(String[] args){
        //        Funcionario func = new Funcionario();
//        func.entrada();
//        System.out.println("////////////////////////////////////////////////////");
//        func.imprimir();

//        Cliente cli = new Cliente();
//        cli.entrada();
//        System.out.println("////////////////////////////////////////////////////");
//        cli.imprimir();

//          Fornecedor forn = new Fornecedor();
//          forn.entrada();
//          System.out.println("//////////////////////////////////////////////////");
//          forn.imprimir();

            Pagar pg = new Pagar();
            pg.entrada();
            System.out.println("//////////////////////////////////////////////////");
            pg.imprimir();
    }
}
