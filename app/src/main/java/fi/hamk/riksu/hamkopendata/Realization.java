
package fi.hamk.riksu.hamkopendata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Realization {

    private String id;
    private String code;
    private String startDate;
    private String endDate;
    private String enrollmentStart;
    private String enrollmentEnd;
    private String teachingLanguage;
    private Double credits;
    private Integer virtualProportion;
    private String name;
    private String content;
    private String furtherInformationOfRealization;
    private String furtherInformationOfCourse;
    private String qualifications;
    private String objective;
    private String cuEvaluationCriteria1;
    private String cuEvaluationCriteria2;
    private String cuEvaluationCriteria3;
    private String cuEvaluationCriteria4;
    private String curEvaluationCriteria;
    private String examSchedule;
    private String completionAlternatives;
    private String approveRejectDescription;
    private String employerConnections;
    private String evaluationScale;
    private String studentWorkload;
    private String teachingMethods;
    private Office office;
    private Unit unit;
    private List<Object> tags = null;
    private List<DegreeProgramme> degreeProgrammes = null;
    private List<EducationalField> educationalFields = null;
    private List<StudentGroup> studentGroups = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Realization() {
    }

    /**
     * 
     * @param startDate
     * @param qualifications
     * @param cuEvaluationCriteria1
     * @param cuEvaluationCriteria2
     * @param cuEvaluationCriteria3
     * @param cuEvaluationCriteria4
     * @param credits
     * @param studentWorkload
     * @param endDate
     * @param degreeProgrammes
     * @param teachingMethods
     * @param id
     * @param studentGroups
     * @param evaluationScale
     * @param enrollmentEnd
     * @param virtualProportion
     * @param furtherInformationOfCourse
     * @param name
     * @param tags
     * @param office
     * @param objective
     * @param code
     * @param examSchedule
     * @param furtherInformationOfRealization
     * @param teachingLanguage
     * @param enrollmentStart
     * @param content
     * @param completionAlternatives
     * @param unit
     * @param employerConnections
     * @param approveRejectDescription
     * @param educationalFields
     * @param curEvaluationCriteria
     */
    public Realization(String id, String code, String startDate, String endDate, String enrollmentStart, String enrollmentEnd, String teachingLanguage, Double credits, Integer virtualProportion, String name, String content, String furtherInformationOfRealization, String furtherInformationOfCourse, String qualifications, String objective, String cuEvaluationCriteria1, String cuEvaluationCriteria2, String cuEvaluationCriteria3, String cuEvaluationCriteria4, String curEvaluationCriteria, String examSchedule, String completionAlternatives, String approveRejectDescription, String employerConnections, String evaluationScale, String studentWorkload, String teachingMethods, Office office, Unit unit, List<Object> tags, List<DegreeProgramme> degreeProgrammes, List<EducationalField> educationalFields, List<StudentGroup> studentGroups) {
        super();
        this.id = id;
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
        this.enrollmentStart = enrollmentStart;
        this.enrollmentEnd = enrollmentEnd;
        this.teachingLanguage = teachingLanguage;
        this.credits = credits;
        this.virtualProportion = virtualProportion;
        this.name = name;
        this.content = content;
        this.furtherInformationOfRealization = furtherInformationOfRealization;
        this.furtherInformationOfCourse = furtherInformationOfCourse;
        this.qualifications = qualifications;
        this.objective = objective;
        this.cuEvaluationCriteria1 = cuEvaluationCriteria1;
        this.cuEvaluationCriteria2 = cuEvaluationCriteria2;
        this.cuEvaluationCriteria3 = cuEvaluationCriteria3;
        this.cuEvaluationCriteria4 = cuEvaluationCriteria4;
        this.curEvaluationCriteria = curEvaluationCriteria;
        this.examSchedule = examSchedule;
        this.completionAlternatives = completionAlternatives;
        this.approveRejectDescription = approveRejectDescription;
        this.employerConnections = employerConnections;
        this.evaluationScale = evaluationScale;
        this.studentWorkload = studentWorkload;
        this.teachingMethods = teachingMethods;
        this.office = office;
        this.unit = unit;
        this.tags = tags;
        this.degreeProgrammes = degreeProgrammes;
        this.educationalFields = educationalFields;
        this.studentGroups = studentGroups;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return
     *     The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 
     * @param startDate
     *     The startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 
     * @return
     *     The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 
     * @param endDate
     *     The endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 
     * @return
     *     The enrollmentStart
     */
    public String getEnrollmentStart() {
        return enrollmentStart;
    }

    /**
     * 
     * @param enrollmentStart
     *     The enrollmentStart
     */
    public void setEnrollmentStart(String enrollmentStart) {
        this.enrollmentStart = enrollmentStart;
    }

    /**
     * 
     * @return
     *     The enrollmentEnd
     */
    public String getEnrollmentEnd() {
        return enrollmentEnd;
    }

    /**
     * 
     * @param enrollmentEnd
     *     The enrollmentEnd
     */
    public void setEnrollmentEnd(String enrollmentEnd) {
        this.enrollmentEnd = enrollmentEnd;
    }

    /**
     * 
     * @return
     *     The teachingLanguage
     */
    public String getTeachingLanguage() {
        return teachingLanguage;
    }

    /**
     * 
     * @param teachingLanguage
     *     The teachingLanguage
     */
    public void setTeachingLanguage(String teachingLanguage) {
        this.teachingLanguage = teachingLanguage;
    }

    /**
     * 
     * @return
     *     The credits
     */
    public Double getCredits() {
        return credits;
    }

    /**
     * 
     * @param credits
     *     The credits
     */
    public void setCredits(Double credits) {
        this.credits = credits;
    }

    /**
     * 
     * @return
     *     The virtualProportion
     */
    public Integer getVirtualProportion() {
        return virtualProportion;
    }

    /**
     * 
     * @param virtualProportion
     *     The virtualProportion
     */
    public void setVirtualProportion(Integer virtualProportion) {
        this.virtualProportion = virtualProportion;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The content
     */
    public String getContent() {
        return content;
    }

    /**
     * 
     * @param content
     *     The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * @return
     *     The furtherInformationOfRealization
     */
    public String getFurtherInformationOfRealization() {
        return furtherInformationOfRealization;
    }

    /**
     * 
     * @param furtherInformationOfRealization
     *     The furtherInformationOfRealization
     */
    public void setFurtherInformationOfRealization(String furtherInformationOfRealization) {
        this.furtherInformationOfRealization = furtherInformationOfRealization;
    }

    /**
     * 
     * @return
     *     The furtherInformationOfCourse
     */
    public String getFurtherInformationOfCourse() {
        return furtherInformationOfCourse;
    }

    /**
     * 
     * @param furtherInformationOfCourse
     *     The furtherInformationOfCourse
     */
    public void setFurtherInformationOfCourse(String furtherInformationOfCourse) {
        this.furtherInformationOfCourse = furtherInformationOfCourse;
    }

    /**
     * 
     * @return
     *     The qualifications
     */
    public String getQualifications() {
        return qualifications;
    }

    /**
     * 
     * @param qualifications
     *     The qualifications
     */
    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    /**
     * 
     * @return
     *     The objective
     */
    public String getObjective() {
        return objective;
    }

    /**
     * 
     * @param objective
     *     The objective
     */
    public void setObjective(String objective) {
        this.objective = objective;
    }

    /**
     * 
     * @return
     *     The cuEvaluationCriteria1
     */
    public String getCuEvaluationCriteria1() {
        return cuEvaluationCriteria1;
    }

    /**
     * 
     * @param cuEvaluationCriteria1
     *     The cuEvaluationCriteria1
     */
    public void setCuEvaluationCriteria1(String cuEvaluationCriteria1) {
        this.cuEvaluationCriteria1 = cuEvaluationCriteria1;
    }

    /**
     * 
     * @return
     *     The cuEvaluationCriteria2
     */
    public String getCuEvaluationCriteria2() {
        return cuEvaluationCriteria2;
    }

    /**
     * 
     * @param cuEvaluationCriteria2
     *     The cuEvaluationCriteria2
     */
    public void setCuEvaluationCriteria2(String cuEvaluationCriteria2) {
        this.cuEvaluationCriteria2 = cuEvaluationCriteria2;
    }

    /**
     * 
     * @return
     *     The cuEvaluationCriteria3
     */
    public String getCuEvaluationCriteria3() {
        return cuEvaluationCriteria3;
    }

    /**
     * 
     * @param cuEvaluationCriteria3
     *     The cuEvaluationCriteria3
     */
    public void setCuEvaluationCriteria3(String cuEvaluationCriteria3) {
        this.cuEvaluationCriteria3 = cuEvaluationCriteria3;
    }

    /**
     * 
     * @return
     *     The cuEvaluationCriteria4
     */
    public String getCuEvaluationCriteria4() {
        return cuEvaluationCriteria4;
    }

    /**
     * 
     * @param cuEvaluationCriteria4
     *     The cuEvaluationCriteria4
     */
    public void setCuEvaluationCriteria4(String cuEvaluationCriteria4) {
        this.cuEvaluationCriteria4 = cuEvaluationCriteria4;
    }

    /**
     * 
     * @return
     *     The curEvaluationCriteria
     */
    public String getCurEvaluationCriteria() {
        return curEvaluationCriteria;
    }

    /**
     * 
     * @param curEvaluationCriteria
     *     The curEvaluationCriteria
     */
    public void setCurEvaluationCriteria(String curEvaluationCriteria) {
        this.curEvaluationCriteria = curEvaluationCriteria;
    }

    /**
     * 
     * @return
     *     The examSchedule
     */
    public String getExamSchedule() {
        return examSchedule;
    }

    /**
     * 
     * @param examSchedule
     *     The examSchedule
     */
    public void setExamSchedule(String examSchedule) {
        this.examSchedule = examSchedule;
    }

    /**
     * 
     * @return
     *     The completionAlternatives
     */
    public String getCompletionAlternatives() {
        return completionAlternatives;
    }

    /**
     * 
     * @param completionAlternatives
     *     The completionAlternatives
     */
    public void setCompletionAlternatives(String completionAlternatives) {
        this.completionAlternatives = completionAlternatives;
    }

    /**
     * 
     * @return
     *     The approveRejectDescription
     */
    public String getApproveRejectDescription() {
        return approveRejectDescription;
    }

    /**
     * 
     * @param approveRejectDescription
     *     The approveRejectDescription
     */
    public void setApproveRejectDescription(String approveRejectDescription) {
        this.approveRejectDescription = approveRejectDescription;
    }

    /**
     * 
     * @return
     *     The employerConnections
     */
    public String getEmployerConnections() {
        return employerConnections;
    }

    /**
     * 
     * @param employerConnections
     *     The employerConnections
     */
    public void setEmployerConnections(String employerConnections) {
        this.employerConnections = employerConnections;
    }

    /**
     * 
     * @return
     *     The evaluationScale
     */
    public String getEvaluationScale() {
        return evaluationScale;
    }

    /**
     * 
     * @param evaluationScale
     *     The evaluationScale
     */
    public void setEvaluationScale(String evaluationScale) {
        this.evaluationScale = evaluationScale;
    }

    /**
     * 
     * @return
     *     The studentWorkload
     */
    public String getStudentWorkload() {
        return studentWorkload;
    }

    /**
     * 
     * @param studentWorkload
     *     The studentWorkload
     */
    public void setStudentWorkload(String studentWorkload) {
        this.studentWorkload = studentWorkload;
    }

    /**
     * 
     * @return
     *     The teachingMethods
     */
    public String getTeachingMethods() {
        return teachingMethods;
    }

    /**
     * 
     * @param teachingMethods
     *     The teachingMethods
     */
    public void setTeachingMethods(String teachingMethods) {
        this.teachingMethods = teachingMethods;
    }

    /**
     * 
     * @return
     *     The office
     */
    public Office getOffice() {
        return office;
    }

    /**
     * 
     * @param office
     *     The office
     */
    public void setOffice(Office office) {
        this.office = office;
    }

    /**
     * 
     * @return
     *     The unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * 
     * @param unit
     *     The unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Object> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The degreeProgrammes
     */
    public List<DegreeProgramme> getDegreeProgrammes() {
        return degreeProgrammes;
    }

    /**
     * 
     * @param degreeProgrammes
     *     The degreeProgrammes
     */
    public void setDegreeProgrammes(List<DegreeProgramme> degreeProgrammes) {
        this.degreeProgrammes = degreeProgrammes;
    }

    /**
     * 
     * @return
     *     The educationalFields
     */
    public List<EducationalField> getEducationalFields() {
        return educationalFields;
    }

    /**
     * 
     * @param educationalFields
     *     The educationalFields
     */
    public void setEducationalFields(List<EducationalField> educationalFields) {
        this.educationalFields = educationalFields;
    }

    /**
     * 
     * @return
     *     The studentGroups
     */
    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    /**
     * 
     * @param studentGroups
     *     The studentGroups
     */
    public void setStudentGroups(List<StudentGroup> studentGroups) {
        this.studentGroups = studentGroups;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
