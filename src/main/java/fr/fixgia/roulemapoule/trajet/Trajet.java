package fr.fixgia.roulemapoule.trajet;

import fr.fixgia.roulemapoule.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column
    String ville_depart;
    @Column
    String ville_arrivee;
    @Column
    String date;
    @Column
    String description;
    @Column
    Integer Places;
    @Column
    Boolean complet;

    @JoinColumn
    @ManyToOne
    UserEntity conducteur;

    @Column
    Integer prix;

    @Column
    String heureDepart;

}
