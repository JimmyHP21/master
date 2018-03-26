/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes.abstracts;

import br.com.main.Exceptions.Erros;
import br.com.main.Exceptions.Mensagens;
import br.com.main.interfaces.ICadastro;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author renanperes
 */
public abstract class Financeiro implements ICadastro {

    SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
    Date data = new Date(System.currentTimeMillis());
    private final DecimalFormat form = new DecimalFormat("#,###.00");
    private final Erros erro = new Erros();
    private final Mensagens msg = new Mensagens();
    private Long FIN_CODIGO;
    private String FIN_NUMERO;
    private String mes;
    private String ano;
    private String dia;
    private String FIN_EMICAO;
    private String FIN_VENCIMENTO;
    private String FIN_PAGAMENTO;
    private String FIN_VALOR;
    private float FIN_VALOR1;
    private String qtdPar;
    private boolean isAvista = false;
    private boolean isPago = false;
    private boolean isHist = false;
    private String op;
    private float FIN_VALOR_AVISTA;
    private float FIN_VALOR_JUROS;
    private String FIN_TOTAL;
    private float FIN_VALOR_PAR;
    private float FIN_VALOR_PAR_S_JUROS;
    private float valor;
    private final double FIN_JUROS = 3;
    private final double FIN_DESCONTO = 10;
    private String FIN_HISTORICO;

    public String getAno() {
        return ano;
    }

    public String getMes() {
        return mes;
    }

    public String getDia() {
        return dia;
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

    public String getFinTotal() {
        return FIN_TOTAL;
    }

    public float getFimValor1() {
        return FIN_VALOR1;
    }

    public void setQtdPar(String qtdPar) {
        this.qtdPar = leia.next();
    }

    public String getQtdPar() {
        return qtdPar;
    }

    public float getValor() {
        return valor;
    }

    public float getFinValorAvista() {
        return FIN_VALOR_AVISTA;
    }

    public Long getFIN_CODIGO() {
        return FIN_CODIGO;
    }

    public void setFIN_CODIGO(Long FIN_CODIGO) {
        this.FIN_CODIGO = FIN_CODIGO;
    }

    public String getFIN_NUMERO() {
        return FIN_NUMERO;
    }

    public String getFIN_EMICAO() {
        return FIN_EMICAO;
    }

    public void setFIN_EMICAO(String FIN_EMICAO) {
        this.FIN_EMICAO = leia.next();
    }

    public String getFIN_VENCIMENTO() {
        return FIN_VENCIMENTO;
    }

    public void setFIN_VENCIMENTO(String FIN_VENCIMENTO) {
        this.FIN_VENCIMENTO = leia.next();
    }

    public String getFIN_PAGAMENTO() {
        return FIN_PAGAMENTO;
    }

    public void setFIN_PAGAMENTO(String FIN_PAGAMENTO) {
        this.FIN_PAGAMENTO = leia.next();
    }

    public String getFIN_VALOR() {
        return FIN_VALOR;
    }

    public void setFIN_VALOR(String FIN_VALOR) {
        this.FIN_VALOR = leia.next();
    }

    public void setOp(String op) {
        this.op = leia.next();
    }

    public String getOp() {
        return op;
    }

    public String getFIN_HISTORICO() {
        return FIN_HISTORICO;
    }

    public void setFIN_HISTORICO(String FIN_HISTORICO) {
        this.FIN_HISTORICO = leia.next();
    }

    public String getFinValor() {
        return FIN_VALOR;
    }

    public void setFinValor(String FIN_VALOR) {
        this.FIN_VALOR = leia.next();
    }

    public void tabelaFinHist() {
        System.out.println("----------------Historico Financeiro---------------");
        getFIN_HISTORICO();
        System.out.println("---------------------------------------------------");
    }

    @Override
    public void imprimir() {
        System.out.println("---------------------FINANCEIRO---------------------");
        System.out.println("Numero Boleto........: " + FIN_NUMERO);
        if (isAvista == true) {
            System.out.println("Pagamento aVista, Total de.......: $" + FIN_VALOR_AVISTA);
        } else if (qtdPar.equals("02") || qtdPar.equals("03")) {
            System.out.println("Valor da Compra.........:" + FIN_VALOR);
            System.out.println(qtdPar + " X $" + FIN_VALOR_PAR_S_JUROS);
        } else {
            System.out.println("Valor Total Com Juros..........: $" + FIN_TOTAL);
            System.out.print("Pagamento Parcelado........: ");
            System.out.println(qtdPar + " X $" + FIN_VALOR_PAR);
        }
        System.out.println("Data Emissão Boleto...........: " + forma.format(data));
        System.out.println("Data Vencimento Boleto..........: " + dataVencimento());
        if (isPago == true) {
            System.out.println("Situação.........: " + msg.getPagamentoFeito());
        } else {
            System.out.println("Situação.........: " + msg.getPagamentoDebito());
        }
        if (isHist == true) {
            tabelaFinHist();
        } else {
            System.out.println("Sem Observações!");
        }
        
    }

    @Override
    public void entrada() {
        System.out.println("--------CADASTRO DE INFORMAÇÕES FINANCEIRO----------");
        numeroBoleto();
        System.out.println("Valor á Pagar:");
        valorCompra();
        parcelaAvista();
        System.out.println("Pagamento já foi Realizado?  ");
        validarPagamento();
        validarHist();
    }

//    "^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$"
    public void numeroBoleto() {
        System.out.println("Gerando Numero Boleto........");
        Random rd = new Random();
        String numeroBoleto;
        int n = rd.nextInt(999999999);
        numeroBoleto = String.valueOf(n);
        int m = rd.nextInt(999999999);
        numeroBoleto = numeroBoleto + m;
        int o = rd.nextInt(999999999);
        numeroBoleto = numeroBoleto + o;
        int p = rd.nextInt(999999999);
        numeroBoleto = numeroBoleto + p;
        int q = rd.nextInt(999999999);
        numeroBoleto = numeroBoleto + q;
        int r = rd.nextInt(999);
        numeroBoleto = numeroBoleto + r;
        FIN_NUMERO = numeroBoleto.substring(0, 5)
                + "." + numeroBoleto.substring(5, 10)
                + " " + numeroBoleto.substring(10, 15)
                + "." + numeroBoleto.substring(15, 20)
                + " " + numeroBoleto.substring(20, 25)
                + "." + numeroBoleto.substring(25, 30)
                + " " + numeroBoleto.substring(30, 31)
                + " " + numeroBoleto.substring(31);
        System.out.println("Boleto gerado com Sucesso!!");
    }

    public void validarHist() {
        System.out.println("Alguma observação sobre esse boleto?  ");
        System.out.println("[1] - SIM/ [2] - NÃO");
        System.out.print("| OPÇÃO -->");
        do {
            setOp(op);
            String opt = getOp();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(opt);
            if (opt.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                op = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                op = "";
            } else if (opt.length() != 1) {
                System.out.println(erro.getERRO_TAMANHO_PADRAO());
                op = "";
            } else {
                int po = Integer.parseInt(opt);
                switch (po) {
                    case 1:
                        isHist = true;
                        historico();
                        break;
                    case 2:
                        FIN_HISTORICO = "";
                        break;
                    default:
                        System.out.println(erro.getERRO_OPCAO());
                        break;
                }
            }
        } while (op.isEmpty());
    }

    public void valorCompra() {
        do {
            setFIN_VALOR(FIN_VALOR);
            String val = getFIN_VALOR().toLowerCase();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(val);
            if (val.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                FIN_VALOR = "";
            } else if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                FIN_VALOR = "";
            } else {
                valor = Float.parseFloat(val);
                FIN_VALOR1 = valor;
                FIN_VALOR = form.format(valor);
            }
        } while (FIN_VALOR.isEmpty());
    }

    public void historico() {
        setFIN_HISTORICO(FIN_HISTORICO);
    }

    public void parcelaAvista() {
        System.out.println("[1] = Parcelar / [2] = Avista");
        do {
            System.out.print("|Opcão ---> ");
            setOp(op);
            String opt = String.valueOf(getOp());
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(opt);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                op = "";
            } else if (opt.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                op = "";
            } else {
                switch (opt) {
                    case "1":
                        parcelado();
                        break;
                    case "2":
                        isAvista = true;
                        aVista();
                        break;
                    default:
                        System.out.println(erro.getERRO_OPCAO());
                        op = "";
                        break;
                }
            }
        } while (op.isEmpty());
    }

    public void parcelado() {
        valor = getValor();
        System.out.println("Parcela em até 10x ou 3x Sem Juros: ");
        System.out.println("$" + FIN_VALOR);
        do {
            System.out.print("|Opcão ---> ");
            setQtdPar(qtdPar);
            String par = getQtdPar();
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(par);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                qtdPar = "";
            } else if (par.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                qtdPar = "";
            } else {
                int pac = Integer.parseInt(par);
                if (pac > 11 || pac <= 0) {
                    System.out.println(erro.getERRO_PARCELAS());
                    qtdPar = "";
                } else {
                    if (qtdPar.length() == 1) {
                        qtdPar = "0" + qtdPar;
                    }
                    float parcela = (float) (FIN_VALOR1 * (FIN_JUROS / 100) * Integer.parseInt(qtdPar));
                    float parcelaSemJuro = (float) (FIN_VALOR1 / Integer.parseInt(qtdPar));
                    float subTotal = FIN_VALOR1 + parcela;
                    FIN_VALOR_PAR = parcela;
                    FIN_VALOR_JUROS = subTotal;
                    String formato = form.format(subTotal);
                    FIN_TOTAL = formato;
                    FIN_VALOR_PAR_S_JUROS = parcelaSemJuro;
                    //----X= x/100
                    //----Y = x * desc
                    //----Z =  x - y

                    float x = FIN_VALOR1 / 100;
                    float y = (float) (x * FIN_DESCONTO);
                    float parcelaAvista = FIN_VALOR1 - y;
                    switch (qtdPar) {
                        case "04":
                            FIN_VALOR_JUROS = parcela * 4;
                            break;
                        case "05":
                            FIN_VALOR_JUROS = parcela * 5;
                            break;
                        case "06":
                            FIN_VALOR_JUROS = parcela * 6;
                            break;
                        case "07":
                            FIN_VALOR_JUROS = parcela * 7;
                            break;
                        case "08":
                            FIN_VALOR_JUROS = parcela * 8;
                            break;
                        case "09":
                            FIN_VALOR_JUROS = parcela * 9;
                            break;
                        case "10":
                            FIN_VALOR_JUROS = parcela * 10;
                            break;
                    }
                }
            }
        } while (qtdPar.isEmpty());
    }

    public void aVista() {
        float x = FIN_VALOR1 / 100;
        float y = (float) (x * FIN_DESCONTO);
        float valorAvista = FIN_VALOR1 - y;
        FIN_VALOR_AVISTA = valorAvista;
    }

    public String dataVencimento() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 30);
        return forma.format(cal.getTime());
    }

    public void validarPagamento() {
        System.out.println("[1] = Já Pago / [2] = Debito");
        do {
            System.out.print("|Opcão ---> ");
            setOp(op);
            String opt = String.valueOf(getOp());
            Pattern pattern = Pattern.compile("\\W");
            Matcher matcher = pattern.matcher(opt);
            if (matcher.find()) {
                System.out.println(erro.getERRO_CARACTER_PADRAO());
                op = "";
            } else if (op.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$")) {
                System.out.println(erro.getERRO_NUMERO_PADRAO());
                op = "";
            } else {
                switch (op) {
                    case "1":
                        isPago = true;
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println(erro.getERRO_OPCAO());
                        op = "";
                        break;
                }
            }
        } while (op.isEmpty());
    }
}
