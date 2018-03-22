/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes;

import br.com.main.Exceptions.Erros;
import br.com.main.classes.abstracts.Juridica;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public class Fornecedor extends Juridica {

    private final SimpleDateFormat form = new SimpleDateFormat("dd/mm/YYYY");
    private String FOR_CONTATO;
    private String FOR_SITE;
    private String FOR_LIMITECOMPRA;
    private String FOR_DTCADASTRO;
    private String ano;
    private String mes;
    private String dia;
    private String conOpt;
    private String DDD;
    private boolean isTel = false;
    private boolean isCel = false;
    private final Erros erro = new Erros();

    public String getConOpt() {
        return conOpt;
    }

    public void setConOpt(String conOpt) {
        this.conOpt = leia.next();
    }

    public String getDtcadastro() {
        return FOR_DTCADASTRO;
    }

    public String getFOR_CONTATO() {
        return FOR_CONTATO;
    }

    public void setFOR_CONTATO(String FOR_CONTATO) {
        this.FOR_CONTATO = leia.next();
    }

    public String getFOR_SITE() {
        return FOR_SITE;
    }

    public void setFOR_SITE(String FOR_SITE) {
        this.FOR_SITE = leia.next();
    }

    public String getFOR_LIMITECOMPRA() {
        return FOR_LIMITECOMPRA;
    }

    public void setFOR_LIMITECOMPRA(String FOR_LIMITECOMPRA) {
        this.FOR_LIMITECOMPRA = leia.next();
    }

    public String getFOR_DTCADASTRO() {
        return FOR_DTCADASTRO;
    }

    public void setAno(String ano) {
        this.ano = leia.next();
    }

    public void setMes(String mes) {
        this.mes = leia.next();
    }

    public void setDia(String dia) {
        this.dia = leia.next();
    }

    public String getAno() {
        return ano;
    }

    public String getMes() {
        return mes;
    }

    public String getDia() {
        return dia;
    }

    public String setDdd() {
        return DDD;
    }

    public void setDdd(String ddd) {
        this.DDD = leia.next();
    }

    @Override
    public void entrada() {
        super.entrada();
        System.out.println("-----------CADASTRAR FORNECEDOR------------");
        System.out.println("Contato: ");
        System.out.println("[1] = Celular / [2] = Telefone");
        System.out.print("|Opcão ---> ");
        validarContato();
        System.out.println("Digite o site do Fornecedor: ");
        siteValido();
        System.out.println("Digite o limite da Compra: ");
        limiteCompra();
        System.out.println("Data do Cadastro: ");
        System.out.println("Mês: ");
        validarMes();
        System.out.println("Dia: ");
        validarDia();
        System.out.println("Ano: ");
        validarAno();
        formataData();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("-------------DADOS FORNECEDOR--------------");
        if (isCel == true) {
            System.out.println("Celular: " + FOR_CONTATO);
        } else if (isTel == true) {
            System.out.println("Telefone: " + FOR_CONTATO);
        }
        System.out.println("E-Mail Fornecedor: " + FOR_SITE);
        System.out.println("Limite da Compra: " + FOR_LIMITECOMPRA);
        System.out.println("Data do Cadastro: " + FOR_DTCADASTRO);
    }

    public void formataData() {
        FOR_DTCADASTRO = dia + "/" + mes + "/" + ano;
    }

//    "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"
    public void validarContato() {
        do {
            setConOpt(conOpt);
            String op = getConOpt();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(op);
            if (op.length() != 1) {
                System.out.println();
                conOpt = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                conOpt = "";
            } else if (op.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                conOpt = "";
            } else {
                conOpt = op;
                switch (op) {
                    case "1":
                        isTel = false;
                        isCel = true;
                        isCel();
                        break;
                    case "2":
                        isTel = true;
                        isCel = false;
                        isTel();
                        break;
                    default:
                        System.out.println(erro.getERRO_OPCAO());
                        conOpt = "";
                        break;
                }
            }

        } while (conOpt.isEmpty());
    }

    public void isTel() {
        validarTelefone();
    }

    public void isCel() {
        validarCelularFor();
    }

    public void validarCelularFor() {
        System.out.println("Digite o numero para Contato: ");
        do {
            setFOR_CONTATO(FOR_CONTATO);
            String cel = getFOR_CONTATO().toLowerCase();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(cel);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                FOR_CONTATO = "";
            } else if (cel.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO());
                FOR_CONTATO = "";
            } else if (cel.length() == 9) {
                System.out.println("Digite seu DDD: ");
                do {
                    setDDD(DDD);
                    String ddd = getDDD();
                    Pattern patternDDD = Pattern.compile("\\W");
                    Matcher matcherDDD = patternDDD.matcher(ddd);
                    if (ddd.length() != 2) {
                        System.out.println(erro.getERRO_DDD1());
                        DDD = "";
                    } else if (matcherDDD.find()) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else if (ddd.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else {
                        DDD = ddd;
                        FOR_CONTATO = "(" + DDD + ")" + cel.substring(0, 5) + "-" + cel.substring(5);
                    }
                } while (DDD.isEmpty());
            } else if (cel.length() == 8) {
                String numeroCorrigido = "9" + getFOR_CONTATO();
                FOR_CONTATO = numeroCorrigido;
                System.out.println("Digite seu DDD: ");
                do {
                    setDDD(DDD);
                    String ddd = getDDD();
                    Pattern patternDDD = Pattern.compile("\\W");
                    Matcher matcherDDD = patternDDD.matcher(ddd);
                    if (ddd.length() != 2) {
                        System.out.println(erro.getERRO_DDD1());
                        DDD = "";
                    } else if (matcherDDD.find()) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else if (ddd.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                        System.out.println(erro.getERRO_DDD2());
                        DDD = "";
                    } else {
                        DDD = ddd;
                        FOR_CONTATO = "(" + DDD + ")" + "9" + cel.substring(0, 4) + "-" + cel.substring(4);
                    }
                } while (DDD.isEmpty());

            } else {
                System.out.println(erro.getERRO_NUMERO1());
            }
        } while (FOR_CONTATO.isEmpty());
    }

    public void validarTelefone() {
        System.out.println("Digite um telefone para Contato: ");
        do {
            setFOR_CONTATO(FOR_CONTATO);
            String tel = getFOR_CONTATO();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(tel);
            if (tel.length() <= 0) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                FOR_CONTATO = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                FOR_CONTATO = "";
            } else if (tel.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                FOR_CONTATO = "";
            } else {
                ddd();
                FOR_CONTATO = "(" + DDD + ")" + tel;
            }

        } while (FOR_CONTATO.isEmpty());

    }

    public void siteValido() {
        do {
            setFOR_SITE(FOR_SITE);
            String site = getFOR_SITE();
            boolean com = false;
            boolean www = false;
            if (!site.contains(".com") && !site.contains("www.")) {
                www = true;
                com = true;
            } else if (!site.contains("www.")) {
                www = true;
            } else if (!site.contains(".com")) {
                com = true;
            } else {
                FOR_SITE = site;
            }
            if (www == true && com == true) {
                FOR_SITE = "www." + site.toLowerCase() + ".com";
            } else if (www = true) {
                FOR_SITE = "www." + site.toLowerCase();
            } else if (com = true) {
                FOR_SITE = site.toLowerCase() + ".com";
            }
        } while (FOR_SITE.isEmpty());
    }

    public void ddd() {
        System.out.println("Digite seu DDD: ");
        do {
            setDDD(DDD);
            String dd = getDDD();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(dd);
            if (dd.length() <= 0) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                DDD = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                DDD = "";
            } else if (dd.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                DDD = "";
            } else {
                DDD = dd;
            }
        } while (DDD.isEmpty());
    }

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

    public void limiteCompra() {
        do {
            setFOR_LIMITECOMPRA(FOR_LIMITECOMPRA);
            String compra = getFOR_LIMITECOMPRA();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(compra);
            if(compra.length() <= 0){
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                FOR_LIMITECOMPRA = "";
            }else if(matcher.find()){
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                FOR_LIMITECOMPRA = "";
            }else if(compra.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")){
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                FOR_LIMITECOMPRA = "";
            }else{
                FOR_LIMITECOMPRA = compra;
            }
        } while (FOR_LIMITECOMPRA.isEmpty());
    }

}
