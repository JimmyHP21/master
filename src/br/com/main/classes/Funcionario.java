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
    private String FUN_DTADMISSAO;
    private String FUN_DTDEMISSAO;
    private String dia;
    private String mes;
    private String ano;
    private boolean isDemitido = false;
    private String optD;
    private final Erros erro = new Erros();

    public String getOptD() {
        return optD;
    }

    public void setOptD(String optD) {
        this.optD = leia.next();
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAno() {
        return ano;
    }

    public void setDia(String dia) {
        this.dia = leia.next();
    }

    public void setMes(String mes) {
        this.mes = leia.next();
    }

    public void setAno(String ano) {
        this.ano = leia.next();
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
        if (isDemitido == false) {
            System.out.println("Funcionario Trabalha na Empressa");
        } else {
            System.out.println("Data Demissão: " + FUN_DTDEMISSAO);
        }

        System.out.println("----------------------------------------------");
    }

    @Override
    public void entrada() {
        super.entrada();
        System.out.println("---------------DADOS FUNCIONARIO--------------");
        System.out.println("-------Data de Admissão do Funcionario--------");
        System.out.print("Mês: ");
        validarMes();
        System.out.print("Dia: ");
        validarDia();
        System.out.print("Ano: ");
        validarAno();
        dtadmissao();
        System.out.println("Funionario Foi Demitido: ");
        System.out.println("[S] = SIM / [N] = NÃO");
        System.out.print("|Opcão ---> ");
        isDemitido();
        if (isDemitido == true) {
            System.out.println("-------Data de Demissão do Funcionario--------");
            System.out.print("Mês: ");
            validarMes();
            System.out.print("Dia: ");
            validarDia();
            System.out.println("Ano: ");
            validarAno();
            dtdmissao();
        }

        System.out.println("----------------------------------------------");
    }

    public void dtadmissao() {
        FUN_DTADMISSAO = dia + "/" + mes + "/" + ano;
    }

    public void dtdmissao() {
        FUN_DTDEMISSAO = dia + "/" + mes + "/" + ano;
    }

//    "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"
    public void validarMes() {
        do {
            setMes(mes);
            String m = getMes();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(m);
            int n = Integer.parseInt(m);
            if (n < 12 && n > 1) {
                if (m.length() == 1) {
                    mes = "0" + m;
                } else if (matcher.find()) {
                    System.out.println(erro.getERRO_CARACTER_PADRAO());
                    mes = "";
                } else if (m.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                    System.out.println(erro.getERRO_NUMERO_PADRAO());
                    mes = "";
                } else {
                    mes = m;
                }
            } else if (n > 12 || n <= 0) {
                System.out.println(erro.getERRO_MES_INVALIDO());
                mes = "";
            }
        } while (mes.isEmpty());
    }

    public void validarDia() {

        switch (mes) {
            case "01":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_JANEIRO());
                        dia = "";
                    }

                } while (dia.isEmpty());
                break;
            case "02":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 28 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_FEVEREIRO());
                        dia = "";
                    }

                } while (dia.isEmpty());
                break;
            case "03":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_MARCO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "04":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 30 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_ABRIL());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "05":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);

                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_MAIO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "06":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 30 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_JUNHO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "07":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_JULHO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "08":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_AGOSTO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "09":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);

                    if (Integer.parseInt(d) < 30 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_SETEMBRO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "10":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_OUTUBRO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "11":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 30 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_NOVEMBRO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            case "12":
                do {
                    setDia(dia);
                    String d = getDia();
                    Pattern pattern = Pattern.compile("\\W");
                    Matcher matcher = pattern.matcher(d);
                    if (Integer.parseInt(d) < 31 && Integer.parseInt(d) > 1) {
                        if (d.length() == 1) {
                            dia = "0" + d;
                        } else if (matcher.find()) {
                            System.out.println(erro.getERRO_CARACTER_PADRAO());
                            dia = "";
                        } else if (d.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                            System.out.println(erro.getERRO_NUMERO_PADRAO());
                            dia = "";
                        } else {
                            dia = d;
                        }
                    } else {
                        System.out.println(erro.getERRO_DIA_DEZEMBRO());
                        dia = "";
                    }
                } while (dia.isEmpty());
                break;
            default:
                System.out.println("ERRO DE INCONSISTENCIA!!");
                break;

        }

    }

//    "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"
    public void validarAno() {
        do {
            setAno(ano);
            String an = getAno();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(an);
            if (an.length() != 4) {
                System.out.println(erro.getERRO_ANO_INVALIDO2());
                ano = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                ano = "";
            } else if (an.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                ano = "";
            } else if (Integer.parseInt(an) > 2018) {
                System.out.println(erro.getERRO_ANO_INVALIDO1());
                ano = "";
            } else {
                ano = an;
            }
        } while (ano.isEmpty());
    }

    public void isDemitido() {
        do {
            setOptD(optD);
            String op = getOptD().toUpperCase();
            Pattern pattern = Pattern.compile("\\W");
            Pattern pattern1 = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(op);
            Matcher matcher1 = pattern1.matcher(op);
            if (op.length() != 1) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                optD = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                optD = "";
            } else if (matcher1.find()) {
                System.out.println(erro.getERRO_STRING_PADRAO());
                optD = "";
            } else {
                optD = op;
                switch (optD) {
                    case "S":
                        isDemitido = true;
                        break;
                    case "N":
                        isDemitido = false;
                        break;
                    default:
                        System.out.println();
                        optD = "";
                        break;
                }
            }
        } while (optD.isEmpty());
    }
}
