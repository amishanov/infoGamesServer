package infoGamesServer.services;

import infoGamesServer.AdminRepository;
import infoGamesServer.TestRepository;
import infoGamesServer.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    private MongoTemplate mongoTemplate;
    private TestRepository testRepository;
    AdminRepository adminRepository;

    @Autowired
    public TestServiceImpl(MongoTemplate mongoTemplate, TestRepository testRepository, AdminRepository adminRepository) {
        this.mongoTemplate = mongoTemplate;
        this.testRepository = testRepository;
        this.adminRepository = adminRepository;
    }
    @Override
    public List<Test> getTests() {
        Query query = new Query();
        query.with(Sort.by("_id"));
//        query.addCriteria(Criteria.where("version").ne(null));
        List<Test> tests = mongoTemplate.find(query, Test.class);
//        List<Test> tests = testRepository.findAll();
        if (tests.isEmpty()) {
            System.out.println("Tests was not found");
            return null;
        } else {
            System.out.println("Tests was FOUND");
            return tests;
        }
    }

    @Override
    public boolean updateTests(List<Test> tests, String token) {
        if (adminRepository.findAdminByToken(token) != null) {
            for (Test test: tests) {
                mongoTemplate.save(test);
            }
            return true;
        }
        return false;
    }

    @Override
    public int getVersion() {
        return 0;
    }
}
