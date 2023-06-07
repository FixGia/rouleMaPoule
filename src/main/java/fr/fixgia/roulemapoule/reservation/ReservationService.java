package fr.fixgia.roulemapoule.reservation;

import fr.fixgia.roulemapoule.trajet.Trajet;
import fr.fixgia.roulemapoule.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService implements IReservationService{
    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    private void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void reserver(Reservation reservation) {
       Reservation reservationExist = reservationRepository.findReservationById(reservation.getId());
       if(reservationExist == null) {
           createReservation(reservation);
       }
    }

    private Integer changerNbDePlaceDuTrajet(Trajet trajet, Integer nbDeUser) {
        Integer nbDePlace = trajet.getPlaces();
        if (nbDePlace > 1) {
            return nbDePlace - 1;
    }
        throw new RuntimeException("plus de place ");
    }

    @Override
    public void supprimerReservation(UUID uuid) {
        Optional<Reservation> reservation = reservationRepository.findById(uuid);
        reservation.ifPresent(reservationRepository::delete);
    }
}
