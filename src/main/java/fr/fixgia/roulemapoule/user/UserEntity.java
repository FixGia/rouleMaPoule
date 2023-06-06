package fr.fixgia.roulemapoule.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.UUID;

@Entity(name="user")
@Data
public class UserEntity {

    @Id
    private UUID id;
    @Column
    private String lastname;
    @Column
    private String firstname;
    @Column
    private String email;
}
