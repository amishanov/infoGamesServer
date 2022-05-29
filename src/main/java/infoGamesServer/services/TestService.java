package infoGamesServer.services;

import infoGamesServer.models.Test;

import java.util.List;

public interface TestService {
    List<Test> getTests();
    boolean updateTests(List<Test> tests, String token);
    int getVersion();
}
