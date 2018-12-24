/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 * Classe Aluno que armazena o seu nome,primeira prova,nota do trabalho em grupo,nota do projeto individual em sala,a frequencia do aluno,nota da prova final
 * 
 * @author Andre
 * 
 * @version 1
 * @since 26/03/2018
 * 
 */
public class Aluno {
    
    private String nome;
    private double p1;
    private double tr;
    private double pj;
    private double fr;
    private double pf;
    private String situacao;

    public String getNome() {
        return nome;
    }

    public String getSituacao() {
        return situacao;
    }
    /**
     * 
     * Metodo que serve para preencher a String situação do aluno com uma das seguintes opções:
     * aprovado direto ou reprovado direto,aprovado pela prova final,reprovado pela prova final,reprovado por frequencia
     * 
     * @author Andre
     * @version 1
     * @since 26/03/2018
     * 
     *  
     */
    public void situacao(){
        double m1 = 0.7*((this.p1+this.tr)/2)+this.pj* 0.3;
       
        if(this.fr >= 0.75){
           if(m1>= 7) 
               this.situacao= "Aprovado direto";
           else if (m1 < 3) 
               this.situacao="Reprovado direto";
           else{
               //Prova final
               if( ((this.pf + m1) / 2) >= 5)
                   this.situacao="Aprovado final";
               else
                   this.situacao= "Reprovado final";
               
           }
       }else{
          this.situacao= "Reprovado por falta";
        }
    }    
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getP1() {
        return p1;
    }

    public void setP1(double p1) {
        this.p1 = p1;
    }

    public double getTr() {
        return tr;
    }

    public void setTr(double tr) {
        this.tr = tr;
    }

    public double getPj() {
        return pj;
    }

    public void setPj(double pj) {
        this.pj = pj;
    }

    public double getFr() {
        return fr;
    }

    public void setFr(double fr) {
        this.fr = fr;
    }

    public double getPf() {
        return pf;
    }

    public void setPf(double pf) {
        this.pf = pf;
    }
    
    /**
     * Metodo que mostra pelo terminal as informações do aluno
     * 
     * @author Andre
     * @version 1
     * @since 26/03/2018
     * 
     */
    
    public void mostra(){
        System.out.println("Nome do aluno: "+this.nome);
        System.out.println("Prova 1: "+this.p1);
        System.out.println("Trabalho: "+this.tr);
        System.out.println("Projeto: "+this.pj);
        System.out.println("Frequencia: "+this.fr);
        System.out.println("Prova final: "+this.pf);
        System.out.println("Situação:"+this.situacao);
        
        
        
    }
}
