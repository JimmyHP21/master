/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main;

import br.com.main.Exceptions.Erros;
import br.com.main.classes.Cliente;
import br.com.main.classes.Fornecedor;
import br.com.main.classes.Funcionario;
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
        Funcionario func = new Funcionario();
        Fornecedor forn = new Fornecedor();
        Cliente cli = new Cliente();
        Erros erro = new Erros();
        Scanner leia = new Scanner(System.in);
        int continu = 0;
        String opt;
        int numOpt;
        String optSub;
        int numOptSub;

        do {
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
                    System.out.println("[1] - INCLUIR");
                    System.out.println("[2] - ALTERAR");
                    System.out.println("[3] - CONSULTAR");
                    System.out.println("[4] - EXCLUIR");
                    System.out.print("|OPÇÃO --> ");
                    do {
                        optSub = leia.next();
                        Pattern pattern = Pattern.compile("\\W");
                        Matcher matcher = pattern.matcher(optSub);
                        if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            optSub = "";
                        } else if (optSub.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            optSub = "";
                        } else if (optSub.length() != 1) {
                            System.out.println(erro.getERRO_OPCAO());
                            optSub = "";
                        } else {
                            int optI = Integer.parseInt(optSub);
                            if (optI < 1 || optI > 5) {
                                System.out.println(erro.getERRO_OPCAO());
                                optSub = "";
                            } else {
                                optSub = String.valueOf(optI);
                            }
                        }
                    } while (optSub.isEmpty());
                    numOptSub = Integer.parseInt(optSub);
                    switch (numOptSub) {
                        case 1:
                            func.entrada();
                            break;
                        case 2:
                            func.alterarFuncionario();
                            break;
                        case 3:
                            func.imprimir();
                            break;
                        case 4:
                            func.funcionarioExcuir();
                            break;
                        default:
                            System.out.println(erro.getERRO_OPCAO());
                            break;

                    }
                    break;
                case 2:
                    System.out.println("--------CADASTRO DE CLIENTES--------------");
                    System.out.println("[1] - INCLUIR");
                    System.out.println("[2] - ALTERAR");
                    System.out.println("[3] - CONSULTAR");
                    System.out.println("[4] - EXCLUIR");
                    System.out.print("|OPÇÃO --> ");
                    do {
                        optSub = leia.next();
                        Pattern pattern = Pattern.compile("\\W");
                        Matcher matcher = pattern.matcher(optSub);
                        if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            optSub = "";
                        } else if (optSub.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            optSub = "";
                        } else if (optSub.length() != 1) {
                            System.out.println(erro.getERRO_OPCAO());
                            optSub = "";
                        } else {
                            int optI = Integer.parseInt(optSub);
                            if (optI < 1 || optI > 5) {
                                System.out.println(erro.getERRO_OPCAO());
                                optSub = "";
                            } else {
                                optSub = String.valueOf(optI);
                            }
                        }
                    } while (optSub.isEmpty());
                    numOptSub = Integer.parseInt(optSub);
                    switch (numOptSub) {
                        case 1:
                            cli.entrada();
                            break;
                        case 2:
                            cli.alterandoCliente();
                            break;
                        case 3:
                            cli.imprimir();
                            break;
                        case 4:
                            cli.clienteExcuir();
                            break;
                        default:
                            System.out.println(erro.getERRO_OPCAO());
                            break;

                    }
                    break;
                case 3:
                    System.out.println("--------CADASTRO DE FORNECEDORES----------");
                    System.out.println("[1] - INCLUIR");
                    System.out.println("[2] - ALTERAR");
                    System.out.println("[3] - CONSULTAR");
                    System.out.println("[4] - EXCLUIR");
                    System.out.print("|OPÇÃO --> ");
                    do {
                        optSub = leia.next();
                        Pattern pattern = Pattern.compile("\\W");
                        Matcher matcher = pattern.matcher(optSub);
                        if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            optSub = "";
                        } else if (optSub.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            optSub = "";
                        } else if (optSub.length() != 1) {
                            System.out.println(erro.getERRO_OPCAO());
                            optSub = "";
                        } else {
                            int optI = Integer.parseInt(optSub);
                            if (optI < 1 || optI > 5) {
                                System.out.println(erro.getERRO_OPCAO());
                                optSub = "";
                            } else {
                                optSub = String.valueOf(optI);
                            }
                        }
                    } while (optSub.isEmpty());
                    numOptSub = Integer.parseInt(optSub);
                    switch (numOptSub) {
                        case 1:
                            forn.entrada();
                            break;
                        case 2:
                            forn.alterandoFornecedor();
                            break;
                        case 3:
                            forn.imprimir();
                            break;
                        case 4:
                            forn.fornecedorExcuir();
                            break;
                        default:
                            System.out.println(erro.getERRO_OPCAO());
                            break;

                    }
                    break;
                case 4:
                    System.out.println("-------CADASTRO DE CONTAS A RECEBER-------");
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

            System.out.println("Deseja realizar mais alguma opção? ");
            System.out.println("[1] - SIM / [2] - NÃO");
            System.out.print("| OPÇÃO -->");
            try {
                continu = leia.nextInt();
            } catch (Exception e) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                continu = 2;
            }

        } while (continu != 2);

    }
}
