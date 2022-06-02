package infoGamesServer.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "errors")
public class ErrorReport {
    @Id
    String id;
    int materialType;
    int materialId;
    int errorType;
    Integer questionNum;

    public ErrorReport() {};

    public ErrorReport(String id, int materialType, int materialId, int errorType, int questionNum) {
        this.id = id;
        this.materialType = materialType;
        this.materialId = materialId;
        this.errorType = errorType;
        this.questionNum = questionNum;
    }

    public ErrorReport(String id, int materialType, int materialId, int errorType) {
        this.id = id;
        this.materialType = materialType;
        this.materialId = materialId;
        this.errorType = errorType;
        questionNum = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMaterialType() {
        return materialType;
    }

    public void setMaterialType(int materialType) {
        this.materialType = materialType;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }
}
