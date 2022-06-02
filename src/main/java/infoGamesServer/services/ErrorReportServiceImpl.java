package infoGamesServer.services;

import infoGamesServer.AdminRepository;
import infoGamesServer.models.ErrorReport;
import infoGamesServer.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorReportServiceImpl implements ErrorReportService{

    MongoTemplate mongoTemplate;
    AdminRepository adminRepository;

    @Autowired
    public ErrorReportServiceImpl(MongoTemplate mongoTemplate, AdminRepository adminRepository) {
        this.mongoTemplate = mongoTemplate;
        this.adminRepository = adminRepository;
    }

    @Override
    public boolean createErrorReport(ErrorReport report) {
        mongoTemplate.save(report);
        System.out.println("Create error report");
        return true;
    }

    @Override
    public List<ErrorReport> getErrorReports(String token) {
        if (adminRepository.findAdminByToken(token) != null) {
            System.out.println("return reports");
            return mongoTemplate.findAll(ErrorReport.class);
        }
        return null;
    }
}
