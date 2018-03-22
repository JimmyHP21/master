/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes.abstracts;

import br.com.main.Exceptions.Erros;
import br.com.main.interfaces.ICadastro;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public abstract class Juridica extends Pessoa implements ICadastro {

    private String PES_CNPJ;
    private String PES_INSCEST;
    private final Erros erro = new Erros();

    public String getCnpj() {
        return PES_CNPJ;
    }

    public String getInscest() {
        return PES_INSCEST;
    }

    public void setCnpj(String cnpj) {
        this.PES_CNPJ = leia.next();
    }

    public void setInscest(String inscest) {
        this.PES_INSCEST = leia.next();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("-------PESSOA JURIDICA INFORMAÇÕES ADCIONAIS-------");
        System.out.println("CNPJ: " + PES_CNPJ);
        System.out.println("INSCEST: " + PES_INSCEST);
    }

    @Override
    public void entrada() {
        super.entrada();
        System.out.println("--------INFORMAÇÕES ADCIONAIS PESSOA FISICA--------");
        System.out.println("Digite o CNPJ: ");
        validarCnpj();
        System.out.println("Digite o Inscest(Inscrição Estadual): ");
        validarInscest();
    }

//    XX.XXX.XXX/YYYY-ZZ
    public void validarCnpj() {
        do {
            setCnpj(PES_CNPJ);
            String cnpj = getCnpj();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(cnpj);
            if (cnpj.length() != 14) {
                System.out.println(erro.getERRO_CNPJ());
                PES_CNPJ = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                PES_CNPJ = "";
            } else if (cnpj.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                PES_CNPJ = "";
            } else {
                PES_CNPJ = cnpj.substring(0, 2)
                        + "." + cnpj.substring(2, 4)
                        + "." + cnpj.substring(4, 6)
                        + "/" + cnpj.substring(6, 10)
                        + "-" + cnpj.substring(10);
            }
        } while (PES_CNPJ.isEmpty());
    }

//    XXX.XXX.XXX.XXX
    public void validarInscest() {
        do {
            setInscest(PES_INSCEST);
            String ins = getInscest();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(ins);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                PES_INSCEST = "";
            } else if (ins.length() != 12) {
                System.out.println(erro.getERRO_INSCEST());
                PES_INSCEST = "";
            } else if (ins.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                PES_INSCEST = "";
            } else {
                PES_INSCEST = ins.substring(0, 3)
                        + "." + ins.substring(3, 5)
                        + "." + ins.substring(5, 7)
                        + "." + ins.substring(7);
            }
        } while (PES_INSCEST.isEmpty());
    }

}
