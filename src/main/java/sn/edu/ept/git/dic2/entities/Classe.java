package sn.edu.ept.git.dic2.entities;

import jakarta.persistence.*;

@Entity
public class Classe {
    @Id
    private Integer id;

    @Column(unique=true, nullable=false)
    private String nom;

    @Enumerated(EnumType.STRING)
    private Niveau niveau;
}
