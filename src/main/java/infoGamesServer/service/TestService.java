package infoGamesServer.service;

import infoGamesServer.models.Test;

import java.util.List;

public interface TestService {
    List<Test> getTests();

    int getVersion();
}
