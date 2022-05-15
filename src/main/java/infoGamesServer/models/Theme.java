package infoGamesServer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "themes")
public class Theme {
    @Id
    private int id;
    private String themeName;
    private int testId;
    private String theory;

    public Theme() {}

    public Theme(int id, String themeName, int testId, String theory) {
        this.id = id;
        this.themeName = themeName;
        this.testId = testId;
        this.theory = theory;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + "\"" + id + "\"" +
                ", \"themeName\":" + themeName + "\"" +
                ", \"testId\"" + "\""+ testId + "\"" +
                ", \"theory\"" + theory + "\"" +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }
}
