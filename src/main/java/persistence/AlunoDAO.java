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
import persistence.Aluno;

/**
 *
 * @author viter
 */
public class AlunoDAO {

    private EntityManager em;

    public AlunoDAO() {
    }

    public void salva(Aluno a) {

        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(a);
        et.commit();
        em.close();
    }

    public void novo(Long id, String nome, String mat, int grupo, double n1, double n2, double n3, double n4) {

        Aluno a = new Aluno();
        a.setId(id);
        a.setNome(nome);
        a.setMatricula(mat);
        a.setGrupo(grupo);
        a.setNota_1(n1);
        a.setNota_2(n2);
        a.setNota_3(n3);
        a.setNota_4(n4);

        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(a);
        et.commit();
        em.close();
    }

    public Aluno atualiza(Long id, String nome, String mat, int grupo, double n1, double n2, double n3, double n4) {

        em = JPAUtil.getEM();
        System.out.println("[DAO] Id = " + id.toString());
        Aluno a = em.find(Aluno.class, id);
        EntityTransaction et = em.getTransaction();
        et.begin();
        a.setNome(nome);
        a.setMatricula(mat);
        a.setGrupo(grupo);
        a.setNota_1(n1);
        a.setNota_2(n2);
        a.setNota_3(n3);
        a.setNota_4(n4);
        et.commit();
        em.close();
        return a;
    }

    public Aluno recupera(String sid) {

        em = JPAUtil.getEM();
        Long id = new Long(sid);
        System.out.println("[DAO] Id = " + id.toString());
        Aluno a = em.find(Aluno.class, id);
        em.close();
        return a;
    }

    public void deleta(Long id) {

        em = JPAUtil.getEM();
        EntityTransaction et = em.getTransaction();
        et.begin();
        Aluno a = em.find(Aluno.class, id);
        em.remove(a);
        et.commit();
        em.close();
    }

    public List<Aluno> buscaNome(String nome) {
        String jpqlQuery = "SELECT a FROM Aluno a where a.nome = :nm";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Aluno.class);
        query.setParameter("nm", nome);
        List<Aluno> a = query.getResultList();
        em.close();
        return a;
    }

    public List<Aluno> buscaTudo() {
        String jpqlQuery = "SELECT a FROM Aluno a ORDER BY a.nome";
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Aluno.class);
        List<Aluno> a = query.getResultList();
        em.close();
        return a;
    }

    public Long proxId() {
        String jpqlQuery = "SELECT MAX(a.id) from Aluno a";
        Long prox = Integer.toUnsignedLong(1);
        em = JPAUtil.getEM();
        Query query = em.createQuery(jpqlQuery, Aluno.class);
        Long max = (Long) query.getSingleResult();
        em.close();
        if (max > 1) {
            prox = max + 1;
        }
        return prox;
    }

}
