package sn.edu.ept.git.dic2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "carte_etudiant")
public class CarteEtudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String numero;

    @Column(nullable = false)
    private LocalDateTime dateCreation;

    @Column(nullable = false)
    private LocalDateTime dateModification;


    @Column(nullable = false)
    private LocalDate dateExpiration;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(nullable = false)
    private Etudiant etudiant;

    @PrePersist
    @PreUpdate
    public void onCreate(){
        System.out.println("enregistrement carte");
        LocalDateTime now = LocalDateTime.now();
        if(dateCreation==null){
            dateCreation = now;
        }
        this.dateModification = now;
        this.dateExpiration=LocalDate.of(now.getYear()+1, 12, 31);
    }
}