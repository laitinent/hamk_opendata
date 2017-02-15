
package fi.hamk.riksu.hamkopendata;

import java.util.HashMap;
import java.util.Map;

public class CourseUnit {

    private String id;
    private String code;
    private Integer credits;
    private Integer yearOfFoundation;
    private String name;
    private String content;
    private String furtherInformation;
    private String qualifications;
    private String objective;
    private String evaluationCriteria1;
    private String evaluationCriteria2;
    private String evaluationCriteria3;
    private String evaluationCriteria4;
    private String teachingMethods;
    private String materials;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(Integer yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFurtherInformation() {
        return furtherInformation;
    }

    public void setFurtherInformation(String furtherInformation) {
        this.furtherInformation = furtherInformation;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getEvaluationCriteria1() {
        return evaluationCriteria1;
    }

    public void setEvaluationCriteria1(String evaluationCriteria1) {
        this.evaluationCriteria1 = evaluationCriteria1;
    }

    public String getEvaluationCriteria2() {
        return evaluationCriteria2;
    }

    public void setEvaluationCriteria2(String evaluationCriteria2) {
        this.evaluationCriteria2 = evaluationCriteria2;
    }

    public String getEvaluationCriteria3() {
        return evaluationCriteria3;
    }

    public void setEvaluationCriteria3(String evaluationCriteria3) {
        this.evaluationCriteria3 = evaluationCriteria3;
    }

    public String getEvaluationCriteria4() {
        return evaluationCriteria4;
    }

    public void setEvaluationCriteria4(String evaluationCriteria4) {
        this.evaluationCriteria4 = evaluationCriteria4;
    }

    public String getTeachingMethods() {
        return teachingMethods;
    }

    public void setTeachingMethods(String teachingMethods) {
        this.teachingMethods = teachingMethods;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
