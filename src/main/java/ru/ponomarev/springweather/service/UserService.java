package ru.ponomarev.springweather.service;

import org.springframework.stereotype.Service;
import ru.ponomarev.springweather.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public User getUserById(final long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<User> addUser(final User user) {
        users.add(user);
        return users;
    }

    public List<User> deleteUser(final long id) {
        users.remove(users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new));
        return users;
    }

    public List<User> updateUser(final User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                u.setName(user.getName());
                u.setAge(user.getAge());
            }
        };
        return users;
    }
}
