package fi.hamk.riksu.hamkopendata;

/**
 * Created by tlaitinen on 2.12.2016.
 */

import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;

import java.util.List;



public class Buildings {

    private String status;
    private String message;
    private Building building;
    private List<Resource> resources = new ArrayList<Resource>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Buildings() {
    }

    /**
     *
     * @param message
     * @param resources
     * @param building
     * @param status
     */
    public Buildings(String status, String message, Building building, List<Resource> resources) {
        this.status = status;
        this.message = message;
        this.building = building;
        this.resources = resources;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message
     * The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     * The building
     */
    public Building getBuilding() {
        return building;
    }

    /**
     *
     * @param building
     * The building
     */
    public void setBuilding(Building building) {
        this.building = building;
    }

    /**
     *
     * @return
     * The resources
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     *
     * @param resources
     * The resources
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Buildings";
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
