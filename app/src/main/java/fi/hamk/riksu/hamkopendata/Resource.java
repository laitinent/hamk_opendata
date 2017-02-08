package fi.hamk.riksu.hamkopendata;

/**
 * Created by tlaitinen on 2.12.2016.
 */

import java.util.HashMap;
import java.util.Map;




public class Resource {

    private String id;
    private String type;
    private String code;
    private String name;
    private String resourceType;
    private String description;
    private Integer places;
    private String parent;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Resource() {
    }

    /**
     *
     * @param id
     * @param description
     * @param name
     * @param parent
     * @param places
     * @param code
     * @param type
     * @param resourceType
     */
    public Resource(String id, String type, String code, String name, String resourceType, String description, Integer places, String parent) {
        this.id = id;
        this.type = type;
        this.code = code;
        this.name = name;
        this.resourceType = resourceType;
        this.description = description;
        this.places = places;
        this.parent = parent;
    }

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The resourceType
     */
    public String getResourceType() {
        return resourceType;
    }

    /**
     *
     * @param resourceType
     * The resourceType
     */
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The places
     */
    public Integer getPlaces() {
        return places;
    }

    /**
     *
     * @param places
     * The places
     */
    public void setPlaces(Integer places) {
        this.places = places;
    }

    /**
     *
     * @return
     * The parent
     */
    public String getParent() {
        return parent;
    }

    /**
     *
     * @param parent
     * The parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Resource";
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
