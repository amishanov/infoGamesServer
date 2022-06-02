package infoGamesServer.Controllers;

import infoGamesServer.models.ErrorReport;
import infoGamesServer.models.Review;
import infoGamesServer.services.ErrorReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ErrorReportController {
    private ErrorReportService errorReportService;

    @Autowired
    public ErrorReportController(ErrorReportService errorReportService) {
        this.errorReportService = errorReportService;
    }

    @PostMapping("/v1/errors")
    public ResponseEntity<?> createErrorReport(@RequestBody ErrorReport errorReport) {
        boolean res = errorReportService.createErrorReport(errorReport);
        if (res)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/v1/errors")
    public ResponseEntity<List<ErrorReport>> getErrorReports(@RequestHeader("Authorization") String token) {
        List<ErrorReport> errorReports = errorReportService.getErrorReports(token);
        System.out.println(errorReports.size());
        if (errorReports == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(errorReports, HttpStatus.OK);
    }
}
