package infoGamesServer.service;

import infoGamesServer.models.Token;
import infoGamesServer.models.User;

public interface UserService {

    Token create(User user);

    User read(String token);

    User readByLogin(String login, String password);

    boolean update(String token, int score, Boolean[] access, Integer[] testsBests, Integer[] gamesBests);


    boolean delete(User user, String login);
}
