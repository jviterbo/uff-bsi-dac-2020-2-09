/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import persistence.Grupo;

/**
 *
 * @author viter
 */
public class GrupoDAO {

    private EntityManager em;

    public GrupoDAO() {
    }

    public void salva(Grupo g) {

        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(g);
        et.commit();
        em.close();
    }

    public void novo(Long id, String projeto, boolean ok1, boolean ok2, boolean ok3, double n1, double n2, double n3) {

        Grupo g = new Grupo();
        g.setId(id);
        g.setProjeto(projeto);
        g.setOk_1(ok1);
        g.setOk_2(ok1);
        g.setOk_3(ok1);
        g.setNota_1(n1);
        g.setNota_2(n2);
        g.setNota_3(n3);

        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(g);
        et.commit();
        em.close();
    }

    public Grupo atualiza(Long id, String projeto, boolean ok1, boolean ok2, boolean ok3, double n1, double n2, double n3) {

        em = JPAUtil.getEM();
        //System.out.println("[DAO] Id = " + id.toString());
        Grupo g = em.find(Grupo.class, id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        g.setProjeto(projeto);
        g.setOk_1(ok1);
        g.setOk_2(ok1);
        g.setOk_3(ok1);
        g.setNota_1(n1);
        g.setNota_2(n2);
        g.setNota_3(n3);
        et.commit();
        em.close();
        return g;
    }

    public Grupo recupera(String sid) {

        em = JPAUtil.getEM();
        Long id = new Long(sid);
        //System.out.println("[DAO] Id = " + id.toString());
        Grupo g = em.find(Grupo.class, id);
        em.close();
        return g;
    }

    public void deleta(Long id) {

        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Grupo g = em.find(Grupo.class, id);
        em.remove(g);
        et.commit();
        em.close();
    }

    public List<Grupo> buscaProjeto(String projeto) {
        String jpqlQuery = "SELECT g FROM Grupo g where g.projeto = :pj";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Grupo.class);
        query.setParameter("pj", projeto);
        List<Grupo> g = query.getResultList();
        em.close();
        return g;
    }

    public List<Grupo> buscaTudo() {
        String jpqlQuery = "SELECT g FROM Grupo g ORDER BY g.projeto";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Grupo.class);
        List<Grupo> g = query.getResultList();
        em.close();
        return g;
    }

    public Long proxId() {
        String jpqlQuery = "SELECT MAX(g.id) from Grupo g";
        Long prox = Integer.toUnsignedLong(1);
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Grupo.class);
        Long max = (Long) query.getSingleResult();
        em.close();
        if (max > 1) {
            prox = max + 1;
        }
        return prox;
    }

    public int numRegs() {
        String jpqlQuery = "SELECT MAX(g.id) from Grupo g";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Grupo.class);
        Long maxLong = (Long) query.getSingleResult();
        int max = maxLong.intValue();
        System.out.println("[DAO GRUPOS] max = " + max);
        return max;
    }
}
