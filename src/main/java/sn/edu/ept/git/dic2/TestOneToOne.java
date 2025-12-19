package sn.edu.ept.git.dic2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import sn.edu.ept.git.dic2.entities.CarteEtudiant;
import sn.edu.ept.git.dic2.entities.Etudiant;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestOneToOne {

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence
                .createEntityManagerFactory("dicPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Etudiant e1=Etudiant.builder()
                .nom("diop")
                .prenom("Abdou")
                .dateNaissance(LocalDate.of(2004,8,24))
                .build();

        CarteEtudiant c1= CarteEtudiant.builder()
                .dateCreation(LocalDateTime.now())
                .dateExpiration(LocalDate.of(2027,12,31))
                .numero("2024A8")
                .etudiant(e1)
                .build();
        em.persist(e1);
        em.persist(c1);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
