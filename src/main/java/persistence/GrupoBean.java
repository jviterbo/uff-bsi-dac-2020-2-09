/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author viter
 */
@Named(value = "grupoBean")
@RequestScoped
public class GrupoBean  {

    private String projeto;
    private boolean ok_1;
    private boolean ok_2;
    private boolean ok_3;
    private double nota_1;  
    private double nota_2;  
    private double nota_3;  
    private GrupoDAO dao;

    public GrupoBean() {
        projeto = "";
        ok_1 = true;
        ok_2 = true;
        ok_3 = false;
        nota_1 = 0;
        nota_2 = 0;
        nota_3 = 0;
        dao = new GrupoDAO();
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public boolean isOk_1() {
        return ok_1;
    }

    public void setOk_1(boolean ok_1) {
        this.ok_1 = ok_1;
    }

    public boolean isOk_2() {
        return ok_2;
    }

    public void setOk_2(boolean ok_2) {
        this.ok_2 = ok_2;
    }

    public boolean isOk_3() {
        return ok_3;
    }

    public void setOk_3(boolean ok_3) {
        this.ok_3 = ok_3;
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
    
    public String saveGrupo(){
        
        Long newId = dao.proxId();
        Grupo g = new Grupo();
        g.setId(newId);
        g.setProjeto(projeto);
        g.setOk_1(ok_1);
        g.setOk_2(ok_1);
        g.setOk_3(ok_1);
        g.setNota_1(nota_1);
        g.setNota_2(nota_2);
        g.setNota_3(nota_3);
        dao.salva(g);
        return("salvou-grupo.xhtml");
    }
    
}
