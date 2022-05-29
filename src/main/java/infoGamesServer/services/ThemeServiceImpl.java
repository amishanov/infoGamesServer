package infoGamesServer.services;

import infoGamesServer.AdminRepository;
import infoGamesServer.models.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService{

    MongoTemplate mongoTemplate;
    AdminRepository adminRepository;

    @Autowired
    public ThemeServiceImpl(MongoTemplate mongoTemplate, AdminRepository adminRepository) {
        this.mongoTemplate = mongoTemplate;
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Theme> getThemes() {
        Query query = new Query();
        query.with(Sort.by("_id"));
        List<Theme> themes =  mongoTemplate.find(query, Theme.class);
        if (themes.isEmpty()) {
            System.out.println("Themes was not found");
            return null;
        }
//        System.out.println("Themes was found");
        return themes;
    }

    @Override
    public boolean updateThemes(List<Theme> themes, String token) {
        System.out.println("Update themes: start");
        if (adminRepository.findAdminByToken(token) != null) {
            System.out.println("update Themes: token accepted");
            for (Theme theme: themes) {
//                System.out.println(theme.toString());
                mongoTemplate.save(theme);
            }
            return true;
        }
        System.out.println("Update themes: Failed");
        return false;
    }


}
