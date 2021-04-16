/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author viter
 */
@Named(value = "alunoBean")
@RequestScoped
public class AlunoBean {

    private String nome;
    private String matricula;
    private int grupo;
    private double nota_1;
    private double nota_2;
    private double nota_3;
    private double nota_4;
    private boolean saved;
    private AlunoDAO dao;
    private GrupoDAO grupoDao;
    private List<String> grupos;
    private List<Integer> index;
    private Map<String, String> availableItems;

    public AlunoBean() {
        nome = "";
        matricula = "";
        grupo = 0;
        nota_1 = 0;
        nota_2 = 0;
        nota_3 = 0;
        nota_4 = 0;
        saved = false;
        dao = new AlunoDAO();
        grupoDao = new GrupoDAO();
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

    public String saveAluno() {

        Long newId = dao.proxId();
        Aluno a = new Aluno();
        a.setId(newId);
        a.setNome(nome);
        a.setMatricula(matricula);
        a.setGrupo(grupo);
        a.setNota_1(nota_1);
        a.setNota_2(nota_2);
        a.setNota_3(nota_3);
        a.setNota_4(nota_4);
        dao.salva(a);
        return ("salvou-aluno.xhtml");
    }

    public List<String> getGrupos() {
        List<Grupo> gruposObj = grupoDao.buscaTudo();
        grupos = new ArrayList();
        int i = 0;

        Iterator<Grupo> iter = gruposObj.iterator();
        while (iter.hasNext()) {
            Grupo g = iter.next();
            grupos.add(i, g.getProjeto());
            i++;
        }
        return grupos;
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

    public List<Integer> getIndex() {
        int max = grupoDao.numRegs();
        index = new ArrayList(max);
        for (int i = 0; i <= max; i++) {
            index.add(i, i);
        }
        return index;
    }

}
