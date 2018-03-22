/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes;

import br.com.main.Exceptions.Erros;
import br.com.main.classes.abstracts.Fisica;
import br.com.main.interfaces.ICadastro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public class Funcionario extends Fisica implements ICadastro {

    //Carteira de Trabalho e Previdência Social
    private String FUN_CTPS;
    private float FUN_SALARIO;
    private String dta;
    private String FUN_DTADMISSAO;
    private String dtd;
    private String FUN_DTDEMISSAO;
    private String dia;
    private String mes;
    private String ano;
    private final Erros erro = new Erros();
    
    public String getDtd(){
        return dtd;
    }
    
    public void setDtd(String dtd){
        this.dtd = leia.next();
    }
    
    public String getDta() {
        return dta;
    }

    public void setDta(String dta) {
        this.dta = leia.next();
    }

    public String getFUN_CTPS() {
        return FUN_CTPS;
    }

    public void setFUN_CTPS(String FUN_CTPS) {
        this.FUN_CTPS = leia.next();
    }

    public float getFUN_SALARIO() {
        return FUN_SALARIO;
    }

    public void setFUN_SALARIO(float FUN_SALARIO) {
        this.FUN_SALARIO = leia.nextFloat();
    }

    public String getFUN_DTADMISSAO() {
        return FUN_DTADMISSAO;
    }

    public String getFUN_DTDEMISSAO() {
        return FUN_DTDEMISSAO;
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("---------------DADOS FUNCIONARIO--------------");
        System.out.println("Data Admissão: " + FUN_DTADMISSAO);
        System.out.println("Data Demissão: " + FUN_DTDEMISSAO);
        System.out.println("----------------------------------------------");
    }

    @Override
    public void entrada() {
        super.entrada();
        System.out.println("---------------DADOS FUNCIONARIO--------------");
        System.out.println("Digite a Data de Admissão do Funcionario: ");
        validaDta();
        System.out.println("Digite a Data de Demissão do Funcionario: ");
        validaDtd();
        System.out.println("----------------------------------------------");
    }
    
    public void validarDia(){
        
    }
    
//    "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"
    public void validaDta(){
        do {
            setDta(dta);
            String dtaN = getDta();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(dtaN);
            if (dtaN.length() != 8) {
                System.out.println(erro.getERRO_TAMANHO_DATA());
                dta = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_DATA_PADRAO());
                dta = "";
            } else if (dtaN.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                dta = "";
            } else {
                FUN_DTADMISSAO = dtaN.substring(0, 2) 
                        + "/" + dtaN.substring(2, 4) 
                        + "/" + dtaN.substring(4);
            }
        } while (dta.isEmpty());
    }
    
    public void validaDtd(){
        do {
            setDtd(dtd);
            String dtdN = getDtd();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(dtdN);
            if (dtdN.length() != 8) {
                System.out.println(erro.getERRO_TAMANHO_DATA());
                dtd = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_DATA_PADRAO());
                dtd = "";
            } else if (dtdN.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                dtd = "";
            } else {
                FUN_DTDEMISSAO = dtdN.substring(0, 2) 
                        + "/" + dtdN.substring(2, 4) 
                        + "/" + dtdN.substring(4);
            }
        } while (dtd.isEmpty());
    }
}
