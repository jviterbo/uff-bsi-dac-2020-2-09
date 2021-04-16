/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Named;
import java.util.Map;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import persistence.Aluno;

/**
 *
 * @author viter
 */
@Named(value = "editaAlunoBean")
@ViewScoped
public class EditaAlunoBean implements Serializable {

    private Aluno a;
    private String id;
    private AlunoDAO dao;
    private String nome;
    private String matricula;
    private int grupo;
    private String projeto;
    private double nota_1;
    private double nota_2;
    private double nota_3;
    private double nota_4;
    private GrupoDAO grupoDao;
    private List<String> grupos;
    private Map<String, String> availableItems;

    public EditaAlunoBean() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        id = params.get("id");
        System.out.println("Id = " + id);
        dao = new AlunoDAO();
        a = dao.recupera(id);
        grupoDao = new GrupoDAO();
        nome = a.getNome();
        matricula = a.getMatricula();
        grupo = a.getGrupo();
        nota_1 = a.getNota_1();
        nota_2 = a.getNota_2();
        nota_3 = a.getNota_3();
        nota_4 = a.getNota_4();
    }

    public Aluno getAluno() {
        return a;
    }

    public String setAluno() {
        a.setNome(nome);
        a.setMatricula(matricula);
        a.setGrupo(grupo);
        a.setNota_1(nota_1);
        a.setNota_2(nota_2);
        a.setNota_3(nota_3);
        a.setNota_4(nota_4);
        dao.atualiza(a.getId(), nome, matricula, grupo, nota_1, nota_2, nota_3, nota_4);
        return "mostra-alunos.xhtml";
    }

    public void getAluno(Aluno a) {
        this.a = a;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public double getNota_1() {
        return nota_1;
    }

    public void setNota_1(double nota_1) {
        this.nota_1 = nota_1;
    }

    public double getNota_2() {
        return nota_2;
    }

    public void setNota_2(double nota_2) {
        this.nota_2 = nota_2;
    }

    public double getNota_3() {
        return nota_3;
    }

    public void setNota_3(double nota_3) {
        this.nota_3 = nota_3;
    }

    public double getNota_4() {
        return nota_4;
    }

    public void setNota_4(double nota_4) {
        this.nota_4 = nota_4;
    }

    public String removeAluno() {
        dao.deleta(a.getId());
        return "mostra-alunos.xhtml";
    }

    public String getProjeto() {
        List<Grupo> gruposObj = grupoDao.buscaTudo();
        if(this.grupo == 0){
            return "Trabalho Individual";            
        }
        Grupo grp = gruposObj.get(this.grupo-1);
        return grp.getProjeto();
    }

    public Map<String, String> getAvailableItems() {
        List<Grupo> gruposObj = grupoDao.buscaTudo();
        availableItems = new LinkedHashMap<>();
        int max = grupoDao.numRegs();
        availableItems.put("0", "Trabalho Individual");
        for (int i = 0; i < max; i++) {
            availableItems.put(String.valueOf(i+1), gruposObj.get(i).getProjeto());          
        }
        return availableItems;
    }

}
