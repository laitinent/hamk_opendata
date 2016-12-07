
package fi.hamk.riksu.hamkopendata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Realizations {

    private String status;
    private List<Realization> realizations = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Realizations() {
    }

    /**
     * 
     * @param realizations
     * @param status
     */
    public Realizations(String status, List<Realization> realizations) {
        super();
        this.status = status;
        this.realizations = realizations;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The realizations
     */
    public List<Realization> getRealizations() {
        return realizations;
    }

    /**
     * 
     * @param realizations
     *     The realizations
     */
    public void setRealizations(List<Realization> realizations) {
        this.realizations = realizations;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
