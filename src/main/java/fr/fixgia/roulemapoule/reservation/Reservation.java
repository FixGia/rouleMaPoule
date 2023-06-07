package fr.fixgia.roulemapoule.reservation;

import fr.fixgia.roulemapoule.trajet.Trajet;
import fr.fixgia.roulemapoule.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column
    @OneToOne
    private Trajet trajet;

    @Column
    String dateReservation;
    @Column
    @OneToMany
    private List<UserEntity> passager;




}
