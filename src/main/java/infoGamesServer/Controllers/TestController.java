package infoGamesServer.Controllers;

import infoGamesServer.models.Test;
import infoGamesServer.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "v1/tests")
    public ResponseEntity<List<Test>> getTests() {
        final List<Test> tests = testService.getTests();
        if (tests != null)
            return new ResponseEntity<>(tests, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "v1/tests/version")
    public ResponseEntity<Integer> getVersion() {
        return new ResponseEntity<>(0, HttpStatus.OK);
    }
}
