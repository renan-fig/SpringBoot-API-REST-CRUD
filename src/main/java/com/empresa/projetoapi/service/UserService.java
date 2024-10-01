package com.empresa.projetoapi.service;

import com.empresa.projetoapi.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Maria", 25, "maria@gmail.com");
        User user2 = new User(2, "Luigi", 23, "luigi_mario@gmail.com");
        User user3 = new User(3, "Joãozin", 21, "joao_camisa10@gmail.com");
        User user4 = new User(4, "Miguel", 9, "miguel@gmail.com");
        User user5 = new User(5, "Buzina", 22, "buzina@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }

    public User getUser(final Integer id) {

        for (User user : userList) {
            if (id == user.getId()) {
                return user;
            }
        }
        return null;
    }

    public List<User> getUsers() {
        return userList;
    }

    public void createUser (User user) {
        userList.add(user);
    }

    public void deleteUser (Integer id) {

        for (User user : userList) {
            if (id == user.getId()) {
                userList.remove(user);
            }
        }
    }

    public void editUser (User user) {
        for (User users : userList) {
            if (user.getId() == users.getId()) {
                userList.remove(users);
                User newUser = new User(user.getId(), user.getName(), user.getAge(), user.getEmail());
                userList.add(newUser);
            }
        }
    }
}
