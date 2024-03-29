package infoGamesServer.services;

import infoGamesServer.models.Theme;

import java.util.List;

public interface ThemeService {
    List<Theme> getThemes();
    boolean updateThemes(List<Theme> themes, String token);
}
