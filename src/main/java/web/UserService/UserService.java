package web.UserService;


import web.config.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUserById(Long id);
    public void deleteUser(Long id);
}
