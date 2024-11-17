package com.example.sangue_bom.service;

import com.example.sangue_bom.model.User;
import com.example.sangue_bom.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setLogin(updatedUser.getLogin());
            user.setPassword(updatedUser.getPassword());
            user.setCpf(updatedUser.getCpf());
            user.setRg(updatedUser.getRg());
            user.setBloodType(updatedUser.getBloodType());
            user.setGender(updatedUser.getGender());
            user.setBirthDate(updatedUser.getBirthDate());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setCity(updatedUser.getCity());
            user.setState(updatedUser.getState());
            user.setZipCode(updatedUser.getZipCode());
            user.setStreet(updatedUser.getStreet());
            user.setHouseNumber(updatedUser.getHouseNumber());
            user.setNeighborhood(updatedUser.getNeighborhood());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
