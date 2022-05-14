package infoGamesServer.models;

public class Token {
    private String token;

    //TODO Удалить нахер этот мусор, если не пригодится
    public Token() {}

    public Token(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
