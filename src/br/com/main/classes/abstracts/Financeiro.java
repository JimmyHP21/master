/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main.classes.abstracts;

import br.com.main.interfaces.ICadastro;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author renanperes
 */
public abstract class Financeiro implements ICadastro{
    private final SimpleDateFormat datFormat = new SimpleDateFormat("dd/mm/YYYY");
    private Long FIN_CODIGO;
    private Long FIN_NUMERO;
    private Date FIN_EMICAO;
    private Date FIN_VENCIMENTO;
    private float FIN_PAGAMENTO;
    private float FIN_VALOR;
    private float FIN_JUROS;
    private float FIN_DESCONTO;
    private String FIN_HISTORICO;
    
    
    public void tabelaFinHist(){
        System.out.println("----------Historico Financeiro----------");
        System.out.println("");
        
    }
    @Override
    public void imprimir() {
        
    }

    @Override
    public void entrada() {
        
    }
}
