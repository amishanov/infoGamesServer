package infoGamesServer.models;

import infoGamesServer.service.ReviewService;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
public class Review {
    @Id
    private String id;
    private String type;
    private int materialId;
    private int evaluation;

    public Review()  {}
    public Review(String id, String type, int materialId, int evaluation) {
        this.id = id;
        this.type = type;
        this.materialId = materialId;
        this.evaluation = evaluation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }
}
