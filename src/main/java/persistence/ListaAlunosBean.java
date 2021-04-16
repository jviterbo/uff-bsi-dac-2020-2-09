/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author viter
 */
@Named(value = "listaAlunosBean")
@RequestScoped
public class ListaAlunosBean {
    
    List<Aluno> alunos;
    private AlunoDAO dao;
    private Aluno current;

    /**
     * Creates a new instance of ListaAlunosBean
     */
    public ListaAlunosBean() {
        
        dao = new AlunoDAO();
    }
    
    public List<Aluno> getAlunos() {
        alunos = dao.buscaTudo();
        return alunos;
    }

    public String editaAluno(){
                
        return "edita-aluno.xhtml";
    }    
    
}
