/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main;

import br.com.main.classes.Cliente;
import br.com.main.classes.Fornecedor;
import br.com.main.classes.Funcionario;

/**
 *
 * @author renanperes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Funcionario func = new Funcionario();
//        func.entrada();
//        System.out.println("////////////////////////////////////////////////////");
//        func.imprimir();

//        Cliente cli = new Cliente();
//        cli.entrada();
//        System.out.println("////////////////////////////////////////////////////");
//        cli.imprimir();

          Fornecedor forn = new Fornecedor();
          forn.entrada();
          System.out.println("////////////////////////////////////////////////////");
          forn.imprimir();
    }

}
