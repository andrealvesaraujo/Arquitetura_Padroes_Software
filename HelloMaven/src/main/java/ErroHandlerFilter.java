/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.lang.IllegalStateException;

import org.apache.log4j.Logger;
/**
 * Classe que ao encontrar um erro( fora os que foram tratados por ValidarFormulario.java) transfere para uma pagina que informa um erro padrão ao usuario.Caso nenhum erro seja encontrado segue o fluxo normal dos programas .jsp e servlets
 * @author Andre
 * @since 09/04/2018
 */
@WebFilter("/*")
public class ErroHandlerFilter implements Filter{
    
    /**
    * Classe que ao encontrar um erro( fora os que foram tratados por ValidarFormulario.java) transfere para uma pagina que informa um erro padrão ao usuario.Caso nenhum erro seja encontrado segue o fluxo normal dos programas .jsp e servlets
    * @author Andre
    * @since 07/04/2018
    * 
    * @param request ServletRequest
    * @param response ServletResponse
    * @param chain FilterChain
    * @throws IOException exceção de entrada
    * @throws ServletException exceção do servlet
    */
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException ,IllegalStateException {
        
        try{
            chain.doFilter(request, response);
        }catch(Exception e){
            //O ServletRequest n tem o metodo send redirect
            Logger lg = Logger.getLogger(ErroHandlerFilter.class);
            lg.error("Erro encontrado pelo meu log: ",e);
            if(response instanceof HttpServletResponse){
               ((HttpServletResponse) response).sendRedirect("ErroPadrao.html");
            
            }
            
            
        }
    }
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    
    public void destroy() {
        
    }
}
