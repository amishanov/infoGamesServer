package infoGamesServer.service;

import infoGamesServer.models.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService{

    MongoTemplate mongoTemplate;

    @Autowired
    public ThemeServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Theme> getThemes() {
        List<Theme> themes =  mongoTemplate.findAll(Theme.class);
        if (themes.isEmpty()) {
            System.out.println("Themes was not found");
            return null;
        }
        System.out.println("Themes was found");
        return themes;
    }


}
