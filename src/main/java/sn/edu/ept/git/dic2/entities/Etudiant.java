package sn.edu.ept.git.dic2.entities;

import jakarta.persistence.*;
import lombok.*;
import sn.edu.ept.git.dic2.EntityLoggingListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "etudiant")
@EntityListeners(EntityLoggingListener.class)
public class Etudiant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false)
  private String nom;

  @Column(nullable = false)
  private String prenom;

  @Column(nullable = false)
  private LocalDate dateNaissance;

  private String adresse;

  private LocalDateTime dateCreation;
  private LocalDateTime dateModification;
  @Version
  private Integer version;

  @OneToOne(mappedBy = "etudiant")
  private CarteEtudiant carte;

  @ManyToOne
  @JoinColumn(name = "CLASSE")
  private Classe classe;
}