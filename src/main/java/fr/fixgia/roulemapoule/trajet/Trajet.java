package fr.fixgia.roulemapoule.trajet;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    String metadonnee;

}
