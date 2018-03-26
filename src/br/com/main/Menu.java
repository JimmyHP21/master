/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main;

import br.com.main.Exceptions.Erros;
import br.com.main.classes.Fornecedor;
import br.com.main.classes.Pagar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public class Menu {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Erros erro = new Erros();
        String opt;
        int numOpt;
        System.out.println("Digite a Categoria que deseja entrar");
        System.out.println("[1] - Cadastro de Funcionários");
        System.out.println("[2] - Cadastro de Clientes");
        System.out.println("[3] - Cadastro de Fornecedores");
        System.out.println("[4] - Cadastro de a Receber");
        System.out.println("[5] - Cadastro de Contas a pagar");
        System.out.print("|OPÇÃO --> ");
        do {
            opt = leia.next();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(opt);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                opt = "";
            } else if (opt.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                opt = "";
            } else if (opt.length() != 1) {
                System.out.println(erro.getERRO_OPCAO());
                opt = "";
            } else {
                int optI = Integer.parseInt(opt);
                if (optI < 1 || optI > 5) {
                    System.out.println(erro.getERRO_OPCAO());
                    opt = "";
                } else {
                    opt = String.valueOf(optI);
                }
            }
        } while (opt.isEmpty());
        numOpt = Integer.parseInt(opt);
        switch (numOpt) {
            case 1:
                System.out.println("--------CADASTRO DE FUNCIONARIOS----------");
                break;
            case 2:
                System.out.println("--------CADASTRO DE CLIENTES--------------");
                break;
            case 3:
                System.out.println("--------CADASTRO DE FORNECEDORES----------");
                break;
            case 4:
                System.out.println("--------CADASTRO DE A RECEBER-------------");
                break;
            case 5:
                System.out.println("--------CADASTRO DE CONTAS A PAGAR--------");
                Pagar pg = new Pagar();
                pg.entrada();
                System.out.println("//////////////////////////////////////////////////");
                pg.imprimir();
                break;
            default:
                System.out.println(erro.getERRO_OPCAO());
                break;
        }

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
    }
}
