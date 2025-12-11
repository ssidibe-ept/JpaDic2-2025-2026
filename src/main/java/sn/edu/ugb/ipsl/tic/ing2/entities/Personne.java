package sn.edu.ugb.ipsl.tic.ing2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Personne {
    @Id
    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    @Version
    private Integer version;

}

