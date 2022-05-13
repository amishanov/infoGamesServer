package infoGamesServer.service;

import infoGamesServer.models.User;

public interface UserService {

    void create(User user);

    User read(String token);

    boolean update(String token, int score, Boolean[] access, Integer[] testsBests, Integer[] gamesBests);

    boolean delete(User user, String login);
}
