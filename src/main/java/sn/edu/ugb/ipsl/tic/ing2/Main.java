package sn.edu.ugb.ipsl.tic.ing2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ugb.ipsl.tic.ing2.entities.Personne;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("dicPU");
        EntityManager em = emf.createEntityManager();

        Personne p1 =new Personne();
        p1.setId(1);
        p1.setNom("John");
        p1.setPrenom("Doe");
        p1.setDateNaissance(LocalDate.of(2000,3,29));


        Personne p2 =Personne.builder()
                .id(2)
                .nom("Fall")
                .prenom("Salif")
                .dateNaissance(LocalDate.of(2000,3,29))
                .build();

        em.getTransaction().begin();
        //creer
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();

        p1.setPrenom("Abdou");
        p1.setNom("Fall");
        em.getTransaction().begin();
        //modfif
        em.merge(p1);
        em.getTransaction().commit();

        em.getTransaction().begin();
        em.remove(p2);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}