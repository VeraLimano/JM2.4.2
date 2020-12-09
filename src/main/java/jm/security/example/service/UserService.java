package jm.security.example.service;

import jm.security.example.model.Role;
import jm.security.example.model.User;

import java.util.List;

public interface UserService {

    User getUserByName(String name);

    public Role getRole(String role);

    public List<User> index();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updateUser);

    public void delete(int id);
}
