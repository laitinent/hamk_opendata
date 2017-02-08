
package fi.hamk.riksu.hamkopendata;

import java.util.List;

public class Programme {

    private String id;
    private String code;
    private String currentStatus;
    private Integer duration;
    private String language;
    private List<Plan> plans = null;
    private List<Object> specialisationOptions = null;
    private List<StructureView> structureViews = null;
    private String name;
    private String description;
    private String content;
    private String development;
    private String furtherInformation;

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
     *     The currentStatus
     */
    public String getCurrentStatus() {
        return currentStatus;
    }

    /**
     * 
     * @param currentStatus
     *     The currentStatus
     */
    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The plans
     */
    public List<Plan> getPlans() {
        return plans;
    }

    /**
     * 
     * @param plans
     *     The plans
     */
    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    /**
     * 
     * @return
     *     The specialisationOptions
     */
    public List<Object> getSpecialisationOptions() {
        return specialisationOptions;
    }

    /**
     * 
     * @param specialisationOptions
     *     The specialisationOptions
     */
    public void setSpecialisationOptions(List<Object> specialisationOptions) {
        this.specialisationOptions = specialisationOptions;
    }

    /**
     * 
     * @return
     *     The structureViews
     */
    public List<StructureView> getStructureViews() {
        return structureViews;
    }

    /**
     * 
     * @param structureViews
     *     The structureViews
     */
    public void setStructureViews(List<StructureView> structureViews) {
        this.structureViews = structureViews;
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
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
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
     *     The development
     */
    public String getDevelopment() {
        return development;
    }

    /**
     * 
     * @param development
     *     The development
     */
    public void setDevelopment(String development) {
        this.development = development;
    }

    /**
     * 
     * @return
     *     The furtherInformation
     */
    public String getFurtherInformation() {
        return furtherInformation;
    }

    /**
     * 
     * @param furtherInformation
     *     The furtherInformation
     */
    public void setFurtherInformation(String furtherInformation) {
        this.furtherInformation = furtherInformation;
    }

}
