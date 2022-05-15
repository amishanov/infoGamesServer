package infoGamesServer.service;

import infoGamesServer.TestRepository;
import infoGamesServer.models.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    private MongoTemplate mongoTemplate;
    private TestRepository testRepository;

    @Autowired
    public TestServiceImpl(MongoTemplate mongoTemplate, TestRepository testRepository) {
        this.mongoTemplate = mongoTemplate;
        this.testRepository = testRepository;
    }
    @Override
    public List<Test> getTests() {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("version").ne(null));
//        List<Test> tests = mongoTemplate.findAll(Test.class);
        List<Test> tests = testRepository.findAll();
        if (tests.isEmpty()) {
            System.out.println("Tests was not found");
            return null;
        } else {
            System.out.println("Tests was FOUND");
            return tests;
        }
    }

    @Override
    public int getVersion() {
        return 0;
    }
}
