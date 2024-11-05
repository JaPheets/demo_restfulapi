package com.restful.laptopsshop.service;

import org.springframework.stereotype.Service;

import com.restful.laptopsshop.domain.User;
import com.restful.laptopsshop.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    public List<User> handleFetchAllUser() {
        return this.userRepository.findAll();
    }

    public User handleFetchUserById(Long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public User handleUpdateUser(User putUser) {
        User currenUser = this.handleFetchUserById(putUser.getId());
        if (currenUser != null) {
            currenUser.setEmail(putUser.getEmail());
            currenUser.setName(putUser.getName());
            currenUser.setPassword(putUser.getPassword());

            currenUser = this.userRepository.save(currenUser);
        }

        return currenUser;
    }

}
