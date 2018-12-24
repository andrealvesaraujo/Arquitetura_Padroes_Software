/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Classe exemplo de tag customizada
 * @author Andre
 */
public class MateriaTag extends SimpleTagSupport{

    
    private String materia;
    
    /**
     * Metodo get padrão
     * @return the materia
     */
    public String getMateria() {
        return materia;
    }

    /**
     * Metodo set padrão
     * @param materia the materia to set
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }
    
    
    /**
     * Metodo que realiza uma tag cujo resultado é criar uma janela de escolha entre duas materias:matematica ou geografia. 
     * @author André
     * @throws JspException exceção sobre as JSP
     * @throws IOException exceção sobre IO
     */
    
    @Override
    public void doTag() throws JspException, IOException {
        String selectHtml = 
        "<select class='form-control' name='materia'>" +
        "    <option value=''></option>" +
        "    <option value='Matematica' " + ("Matematica".equals(materia) ? "selected": "") +  " >Matematica</option>" +
        "    <option value='Geografia' " + ("Geografia".equals(materia)  ? "selected": "") + " >Geografia</option>" +
        "</select>";
        getJspContext().getOut().print(selectHtml);
    }
}
