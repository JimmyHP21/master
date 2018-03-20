/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.main;

import br.com.main.classes.Teste;
import br.com.main.classes.abstracts.Pessoa;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author renanperes
 */
public class Main extends JFrame{
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;
    
     Object [][] dados = {
        {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
        {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
        {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
    };
    
    String [] colunas = {"Nome", "Telefone", "Email"}; 
    
    public void criarTabela(){
        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1,1));
        tabela = new JTable(dados,colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);
        
        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500, 120);
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa() {};
        // TODO code application logic here
        Teste tt = new Teste();
        tt.entrada();
        System.out.println("//////////////////////////////////////////////////////////////////");
        tt.imprimir();
//        Main mn = new Main();
//        mn.criarTabela();
//        Map<Long,Teste> tela = new HashMap<>();
//        tela.put(pessoa.gerarCodigo(), tt);
        
    }
    
}
