
package fi.hamk.riksu.hamkopendata;

import java.util.HashMap;
import java.util.Map;

public class Office {

    private String id;
    private LocalizedName localizedName;
    private String code;
    private String facetName;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Office() {
    }

    /**
     * 
     * @param id
     * @param localizedName
     * @param facetName
     * @param code
     */
    public Office(String id, LocalizedName localizedName, String code, String facetName) {
        super();
        this.id = id;
        this.localizedName = localizedName;
        this.code = code;
        this.facetName = facetName;
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
     *     The localizedName
     */
    public LocalizedName getLocalizedName() {
        return localizedName;
    }

    /**
     * 
     * @param localizedName
     *     The localizedName
     */
    public void setLocalizedName(LocalizedName localizedName) {
        this.localizedName = localizedName;
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
     *     The facetName
     */
    public String getFacetName() {
        return facetName;
    }

    /**
     * 
     * @param facetName
     *     The facetName
     */
    public void setFacetName(String facetName) {
        this.facetName = facetName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
