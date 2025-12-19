package sn.edu.ept.git.dic2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Salle {
    @Id
    private Integer id;

    @ManyToMany
    private List<Classe> classes;
}
