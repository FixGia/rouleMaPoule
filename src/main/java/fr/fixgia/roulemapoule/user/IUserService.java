package fr.fixgia.roulemapoule.user;

import org.springframework.stereotype.Service;


public interface IUserService {


    void createUser(UserEntity user);

    void deleteUser(String email);





}
