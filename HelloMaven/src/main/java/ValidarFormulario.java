/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * É o servlet responsavel por validar um formulario e enviar os dados para uma tabela
 * @author Andre
 * @version 1
 * @since 26/03/2018
 */
@WebServlet("/ValidarFormulario")
public class ValidarFormulario extends HttpServlet {

    
	private static final long serialVersionUID = 1L;
	/**
     * Metodo que faz a validação dos dados de um formulario sobre um aluno da classe AlunoPSW.java  atraves da interação com a pagina de formulario. Se os dados do aluno forem validos vão para uma tabela.
     * @author Andre
     * @version 1
     * @since 26/03/2018
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
           
            
            String nome=null;
            Double p1=0.0;
            Double tr=0.0 ;
            Double pj=0.0 ;
            Double fr=0.0;
            Double pf=0.0;
            
            boolean valido=true;
            boolean validoGeral=true;
            boolean ehNumero=true;
            //Na verdade é a materia
            
           /*String materia = request.getParameter("materia");
            
            if(materia == null || materia.equals("")){
                request.setAttribute("msgErroMateria", "A materia deve ser preenchida");
                valido = false;
            }*/
            System.out.println("Entrou");
            //Validação
            if(!request.getParameter("nome").equals("")){//Erro no campo nome quando estiver vazio
                try{
                    Double.parseDouble(request.getParameter("nome"));
                    
                }catch(NumberFormatException e){
                    ehNumero = false;//Erro no campo nome quando recebe um numero
                    
                } 
                if(!ehNumero){
                    nome = request.getParameter("nome");

                    request.setAttribute("nome", nome);    
                    if((nome.length() <=10) || (null == nome)) {//Erro no campo nome quando tem menos de 10 letras

                        request.setAttribute("ErroNome", "O nome completo tem que ter mais de 10 letras");
                        valido = false;
                    }
                }else{
                    valido=false;
                    request.setAttribute("ErroFormatoNome", "Nome não pode ter numeros.Ele apenas aceita letras.");
                }    
                   
            }else{
                validoGeral=false;
                valido = false;
            }    
            if(!request.getParameter("prova1").equals("")){//Erro no nome prova1
                
                try{
                    p1 = Double.parseDouble(request.getParameter("prova1"));
                
                    request.setAttribute("p1", p1);
                    if((p1 == null) || (p1 < 0) || (p1>10)){

                        request.setAttribute("ErroP1", "P1 tem que ser maior que zero e menor que 10");
                        valido = false;
                    }
                }catch(NumberFormatException e){
                    valido=false;
                    request.setAttribute("ErroFormatoP1", "P1 não pode ter letras.Ele apenas aceita numeros.");
                }
            }else{
                validoGeral=false;
                valido = false;
            } 
            if(!request.getParameter("trabalho").equals("")){
                
                try{
                    tr = Double.parseDouble(request.getParameter("trabalho"));
                    request.setAttribute("tr", tr);


                    if((tr == null) || (tr < 0) || (tr>10)  || (request.getParameter("trabalho").equals(""))  ){

                        request.setAttribute("ErroTR", "Trabalho tem que ser maior que zero e menor que 10");
                        valido = false;
                    }
                }catch(NumberFormatException e){
                    valido=false;
                    request.setAttribute("ErroFormatoTR", "Trabalho não pode ter letras.Ele apenas aceita numeros.");
                }   
            }else{
                validoGeral=false;
                valido = false;
            }
            if(!request.getParameter("projetoaula").equals("")){
                try{
                    pj = Double.parseDouble(request.getParameter("projetoaula"));
                    request.setAttribute("pj", pj);

                    if((pj == null) || (pj < 0) || (pj > 10)  || (request.getParameter("projetoaula").equals(""))  ){

                        request.setAttribute("ErroPJ", "Projeto Aula tem que ser maior que zero e menor que 10");
                        valido = false;
                    }
                }catch(NumberFormatException e){
                    valido=false;
                    request.setAttribute("ErroFormatoPJ", "Projeto Aula não pode ter letras.Ela apenas aceita numeros.");
                }    
            }else{
                validoGeral=false;
                valido = false;
            }  
            if(!request.getParameter("freq").equals("")){
                try{
                    fr = Double.parseDouble(request.getParameter("freq"));
                    request.setAttribute("fr", fr);

                    if((fr == null) || (fr < 0) || (fr >1) || (request.getParameter("freq").equals(""))   ){

                        request.setAttribute("ErroFR", "Frequencia tem que ser maior que zero e menor que 1");
                        valido = false;
                    }
                }catch(NumberFormatException e){
                    valido=false;
                    request.setAttribute("ErroFormatoFR", "Frequencia não pode ter letras.Ela apenas aceita numeros.");
                }    
                  
            }else{
                validoGeral=false;
                valido = false;
            }
            if(!request.getParameter("pf").equals("")){
                try{
                    pf = Double.parseDouble(request.getParameter("pf"));
                    request.setAttribute("pf", pf);
                    if((pf == null) || (pf < 0) || (pf> 10)){

                        request.setAttribute("ErroPF", "Prova Final tem que ser maior que zero e menor que 10");
                        valido = false;
                    }
                }catch(NumberFormatException e){
                    valido=false;
                    request.setAttribute("ErroFormatoPF", "Prova Final não pode ter letras.Ela apenas aceita numeros.");
                }    
            }else{
                validoGeral=false;
                valido = false;
            }    
            
            
            if(!validoGeral){
                request.setAttribute("ErroGeral","Todos os campos devem ser preenchidos");
            }
            if(valido){
                ServletContext sc = request.getServletContext(); 
                PreencherServletContext(nome,p1,tr,pj,fr,pf,sc);
                request.getRequestDispatcher("TabelaBootstrap.jsp").forward(request, response);//Mudar para a tabela
            }else{
              request.getRequestDispatcher("index.jsp").forward(request, response);  
            }
            
        
        
    }
    /**
     * 
     * Metodo que armazena todos as informações de um formulario do AlunoPsw.java e preenche num Servlet Context
     * 
     * @author Andre
     * @version 1
     * @since 26/03/2018
     * @param nome String do nome completo
     * @param p1 valor da P1
     * @param tr Valor do trabalho
     * @param pj valor do projeto aula
     * @param fr Valor da frequencia
     * @param pf Valor da prova finaç
     * @param sc É Servlet Context recebido do doPost
     */
    @SuppressWarnings("unchecked")
	private void PreencherServletContext(String nome,Double p1,Double tr,Double pj,Double fr,Double pf,ServletContext sc){
               
        Aluno A = new Aluno();
        A.setNome(nome);
        A.setP1(p1);
        A.setTr(tr);
        A.setPj(pj);
        A.setFr(fr);
        A.setPf(pf);
        A.situacao();
        

        if(sc.getAttribute("ListaAlunos")==null)
        {
            ArrayList<Aluno> tabelaAlunos = new ArrayList<Aluno>();
            tabelaAlunos.add(A);
            sc.setAttribute("ListaAlunos", tabelaAlunos);
        }else{
            ArrayList<Aluno> tabelaAlunos = (ArrayList<Aluno>) sc.getAttribute("ListaAlunos");
            tabelaAlunos.add(A);
            sc.setAttribute("ListaAlunos", tabelaAlunos);
        }
    }

    
}
