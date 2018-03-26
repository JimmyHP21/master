/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes;

import br.com.main.Exceptions.Erros;
import br.com.main.Exceptions.Mensagens;
import br.com.main.classes.abstracts.Juridica;
import br.com.main.interfaces.ICadastro;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public class Cliente extends Juridica implements ICadastro {

    private final DecimalFormat form = new DecimalFormat("#,###.00");
    private String CLI_LIMITECREDITO;
    private Double credito;
    private String opDeve;
    private String snF;
    private boolean isDevendo = false;
    private final Erros erro = new Erros();
    private final Mensagens msg = new Mensagens();
    
    public String getSnf(){
        return snF;
    }
    
    public void setSnF(String snf){
        this.snF = leia.next();
    }
    
    public String getCliLimiteCredito() {
        return CLI_LIMITECREDITO;
    }

    public void setCliLImiteCredito(String limite) {
        this.CLI_LIMITECREDITO = leia.next();
    }

    public String getOpDeve() {
        return opDeve;
    }

    public void setOpDeve(String opDeve) {
        this.opDeve = leia.next();
    }
    
    @Override
    public void excluir(){
        super.excluir();
        CLI_LIMITECREDITO = "";
    }
    
    public void alterandoCliente(){
        System.out.println("-----------ALTERANDO INFORMAÇÕES CLIENTE-------------");
        System.out.println("---------------DADOS CLIENTE CADASTRO----------------");
        System.out.println("Cliente Devendo? ");
        System.out.println("[S] - Sim/ [N] - Não");
        System.out.print("|Opcão ---> ");
        opDeve();
    }
    
    @Override
    public void entrada() {
        super.entrada();
        System.out.println("------DADOS CLIENTE CADASTRO-------");
        System.out.println("Cliente Devendo? ");
        System.out.println("[S] - Sim/ [N] - Não");
        System.out.print("|Opcão ---> ");
        opDeve();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("-----------DADOS CLIENTE------------");
        if (isDevendo == true) {
            System.out.println("Limite Devedor:" + CLI_LIMITECREDITO);
        } else {
            System.out.println("Limite de Credito: " + CLI_LIMITECREDITO);
        }
    }
    
    public void clienteExcuir() {
        System.out.println("Deseja Realmente Excluir o Cliente? ");
        System.out.println("[1] - SIM/ [2] - NÃO");
        System.out.print("| OPÇÃO -->");
        do {
            setSnF(snF);
            String opc = getSnf();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(opc);
            if (opc.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                snF = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                snF = "";
            } else if (opc.length() != 1) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                snF = "";
            } else {
                int op = Integer.parseInt(snF);
                switch (op) {
                    case 1:
                        System.out.println(msg.getSucessoExcluir());
                        excluir();
                        break;
                    case 2:
                        System.out.println(msg.getOperacaoCancelada());
                        break;
                    default:
                        System.out.println(erro.getERRO_OPCAO());
                        snF = "";
                        break;
                }
            }
        } while (snF.isEmpty());
    }
    
    public void opDeve() {
        do {
            setOpDeve(opDeve);
            String deve = getOpDeve();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(deve);
            Pattern pattern1 = Pattern.compile("\\d");
            Matcher matcher1 = pattern1.matcher(deve);
            if (deve.length() != 1) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                opDeve = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                opDeve = "";
            } else if (matcher1.find()) {
                System.out.println(erro.getERRO_STRING_PADRAO());
                opDeve = "";
            } else {
                opDeve = deve.toUpperCase();
                switch (opDeve) {
                    case "S":
                        isDevendo();
                        isDevendo = true;
                        break;
                    case "N":
                        validarLimite();
                        break;
                    default:
                        System.out.println(erro.getERRO_OPCAO());
                        opDeve = "";
                        break;
                }
            }
        } while (opDeve.isEmpty());
    }

    public void isDevendo() {
        System.out.println("Credito Devedor: ");
        do {
            setCliLImiteCredito(CLI_LIMITECREDITO);
            String limite = getCliLimiteCredito();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(limite);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                CLI_LIMITECREDITO = "";
            } else if (limite.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                CLI_LIMITECREDITO = "";
            } else {
                credito = Double.parseDouble(limite);
                if (credito == 0) {
                    CLI_LIMITECREDITO = "0.00";
                } else {
                    CLI_LIMITECREDITO = "-" + form.format(credito);
                }
            }
        } while (CLI_LIMITECREDITO.isEmpty());
    }

    public void validarLimite() {
        System.out.println("Limite de Credito: ");
        do {
            setCliLImiteCredito(CLI_LIMITECREDITO);
            String limite = getCliLimiteCredito();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(limite);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                CLI_LIMITECREDITO = "";
            } else if (limite.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                CLI_LIMITECREDITO = "";
            } else {
                credito = Double.parseDouble(limite);
                if (credito == 0) {
                    CLI_LIMITECREDITO = "0.00";
                } else {
                    CLI_LIMITECREDITO = form.format(credito);
                }
            }
        } while (CLI_LIMITECREDITO.isEmpty());

    }
}
