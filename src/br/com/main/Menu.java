/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main;

import br.com.main.Exceptions.Erros;
import br.com.main.Exceptions.Mensagens;
import br.com.main.classes.Cliente;
import br.com.main.classes.Fornecedor;
import br.com.main.classes.Funcionario;
import br.com.main.classes.Pagar;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public class Menu {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Funcionario> funci = new ArrayList<>();
        Fornecedor forn = new Fornecedor();
        Cliente cli = new Cliente();
        Erros erro = new Erros();
        Mensagens msg = new Mensagens();
        Scanner leia = new Scanner(System.in);
        String continu;
        int optRepete = 0;
        String opt;
        int numOpt;
        String optSub;
        int numOptSub;
        int id = 1;

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
                    System.out.println("[2] - ALTERAR PELO CODIGO");
                    System.out.println("[3] - CONSULTAR PELA POSIÇÃO NO ARRAYLIST");
                    System.out.println("[4] - CONSULTAR POR CÓDIGO");
                    System.out.println("[5] - CONSULTAR POR NOME");
                    System.out.println("[6] - EXCLUIR");
                    System.out.println("[7] - EXCLUIR TODOS OS REGISTROS");
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
                            if (optI < 1 || optI > 8) {
                                System.out.println(erro.getERRO_OPCAO());
                                optSub = "";
                            } else {
                                optSub = String.valueOf(optI);
                            }
                        }
                    } while (optSub.isEmpty());
                    numOptSub = Integer.parseInt(optSub);
                    Funcionario func = new Funcionario();
                    switch (numOptSub) {
                        //////  INCLUIR NOVO
                        case 1:
                            func.id(id);
                            func.codigo(id);
                            func.entrada();
                            id++;
                            funci.add(func);
                            break;
                        //////  ALTERAR POR CODIGO    
                        case 2:
                            System.out.println("DIGITE O CODIGO DE QUEM DESEJA ALTERAR:...........");

                            func.alterarFuncionario();
                            break;
                        //////  CONSULTAR POR POSIÇÃO    
                        case 3:
                            System.out.println("======== NUMERO DE REGISTROS " + funci.size() + "=======");
                            System.out.println("DIGITE A POSIÇÃO DO ARRAY QUE DESEJE VER (INICIANDO EM 0)");
                            String val = "";

                            do {
                                val = s.next();
                                Pattern pattern = Pattern.compile("\\W");
                                Matcher matcher = pattern.matcher(optSub);
                                if (matcher.find()) {
                                    System.out.println(erro.getERRO_CARACTER_PADRAO());
                                    val = "";
                                } else if (val.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                                    System.out.println(erro.getERRO_NUMERO_PADRAO());
                                    val = "";
                                } else {
                                    int n;
                                    n = Integer.parseInt(val);
                                    if (n > funci.size()) {
                                        System.out.println(erro.getERRO_POSICAO_INVALIDA());
                                        val = "";
                                    } else {
                                        funci.get(n).imprimir();
                                        val = String.valueOf(n);
                                    }
                                }
                            } while (val.isEmpty());

                            break;
                        //////   CONSULTAR POR CODIGO    
                        case 4:
                            System.out.println("DIGITE O CODIGO DE QUEM DESEJA CONSULTAR:........");
                            String codConculta = "";
                            int cod = 0;

                            do {
                                codConculta = s.next();
                                Pattern pattern = Pattern.compile("\\W");
                                Matcher matcher = pattern.matcher(codConculta);
                                if (matcher.find()) {
                                    System.out.println(erro.getERRO_CARACTER_PADRAO());
                                    codConculta = "";
                                } else if (codConculta.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                                    System.out.println(erro.getERRO_NUMERO_PADRAO());
                                    codConculta = "";
                                } else {
                                    cod = Integer.parseInt(codConculta); 
                                }
                            } while (codConculta.isEmpty());
                            
                            
                            for (int i = 0; i < funci.size(); i++) {
                                if (funci.get(i).getPesId() == cod) {
                                    funci.get(i).imprimir();
                                } else {
                                    System.out.println(erro.getERRO_CODIGO_NAO_ENCONTRADO());
                                }
                            }
                            break;
                        //////   CONSULTAR POR NOME 
                        case 5:
                            System.out.println("DIGITE O NOME QUE DESEJE CONSULTAR:.........");
                            String pesNome;
                            pesNome = s.next();
                            for (int i = 0; i < funci.size(); i++) {
                                if (funci.get(i).getFullName().equals(pesNome)) {
                                    funci.get(i).imprimir();
                                } else {
                                    System.out.println(erro.getERRO_PESSOA_NAO_ENCONTRADA());
                                }
                            }

                            break;
                        //////// EXCLUIR POR POSIÇÃO    
                        case 6:
                            System.out.println("======== NUMERO DE REGISTROS " + funci.size() + "=======");
                            System.out.println("DIGITE A POSIÇÃO DO ARRAY QUE DESEJA EXCLUIR(COMEÇANDO EM 0)..........");
                            String op = "";

                            do {
                                op = s.next();
                                Pattern pattern = Pattern.compile("\\W");
                                Matcher matcher = pattern.matcher(op);
                                if (matcher.find()) {
                                    System.out.println(erro.getERRO_CARACTER_PADRAO());
                                    op = "";
                                } else if (op.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                                    System.out.println(erro.getERRO_NUMERO_PADRAO());
                                    op = "";
                                } else {
                                    int position = Integer.parseInt(op);
                                    if (position > funci.size()) {
                                        System.out.println(erro.getERRO_POSICAO_INVALIDA());
                                        op = "";
                                    } else {
                                        funci.remove(position);
                                        System.out.println(msg.getSucessoExcluir());
                                        op = String.valueOf(position);
                                    }
                                }
                            } while (op.isEmpty());
                            break;
                        ///////  EXCLUIR TODOS OS REGISTROS    
                        case 7:
                            funci.clear();
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
            do {
                continu = leia.next();
                Pattern pattern = Pattern.compile("\\W");
                Matcher matcher = pattern.matcher(continu);
                if (continu.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                    System.out.println(erro.getERRO_NUMERO_PADRAO());
                    continu = "";
                } else if (matcher.find()) {
                    System.out.println(erro.getERRO_CARACTER_PADRAO());
                    continu = "";
                } else {
                    int val = 0;
                    val = Integer.parseInt(continu);
                    if (val == 1) {
                        continu = String.valueOf(val);
                        optRepete = Integer.parseInt(continu);
                    } else if (val == 2) {
                        continu = String.valueOf(val);
                        optRepete = Integer.parseInt(continu);
                    } else {
                        System.out.println(erro.getERRO_OPCAO());
                        continu = "";
                    }
                }
            } while (continu.isEmpty());
        } while (optRepete != 2);

    }

}
