package infoGamesServer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "users")
public class User {
    @Id
    private  int _id;
    @Indexed(unique = true)
    private String email;
     @Indexed(unique = true)
    private String login;
    private String password;
    private String accessToken;
    private int score;
    private Boolean[] access;
    private Integer[] testsBests;
    private Integer[] gamesBests;


    public User(int _id, String email, String login,
                String password, String accessToken, int score, Boolean[] access,
                Integer[] testsBests, Integer[] gamesBests) {
        this._id = _id;
        this.email = email;
        this.login = login;
        this.password = password;
        this.accessToken = accessToken;
        this.score = score;
        this.access = access;
        this.testsBests = testsBests;
        this.gamesBests = gamesBests;
    }

    public User() {}

    public User(String email, String login,
                String password, String accessToken, int score,
                Boolean[] access, Integer[] testsBests, Integer[] gamesBests) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.accessToken = accessToken;
        this.score = score;
        this.access = access;
        this.testsBests = testsBests;
        this.gamesBests = gamesBests;
    }

    @Override
    public String toString() {
        return "{" + "\"_id\":" +  _id +
                ", \"email\":\"" + email + '\"' +
                ", \"login\":\"" + login + '\"' +
                ", \"password\":\"" + password + '\"' +
                ", \"accessToken\":\"" + accessToken + '\"' +
                ", \"score\":" + score +
                ", \"access\":" + Arrays.toString(access) +
                ", \"testsBests\":" + Arrays.toString(testsBests) +
                ", \"gamesBests\":" + Arrays.toString(gamesBests) +
                '}';
    }

    public int get_id() {
        return _id;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public int getScore() {
        return score;
    }

    public Boolean[] getAccess() {
        return access;
    }

    public Integer[] getTestsBests() {
        return testsBests;
    }

    public Integer[] getGamesBests() {
        return gamesBests;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAccess(Boolean[] access) {
        this.access = access;
    }

    public void setTestsBests(Integer[] testsBests) {
        this.testsBests = testsBests;
    }

    public void setGamesBests(Integer[] gamesBests) {
        this.gamesBests = gamesBests;
    }

}
