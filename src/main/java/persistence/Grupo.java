/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author viter
 */
@Entity
public class Grupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String projeto;
    private boolean ok_1;
    private boolean ok_2;
    private boolean ok_3;
    private double nota_1;  
    private double nota_2;  
    private double nota_3;  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Grupo[ id=" + id + " ]";
    }
    
}
