
package fi.hamk.riksu.hamkopendata;

import java.util.HashMap;
import java.util.Map;

public class LocalizedName {

    private String valueFi;
    private String valueEn;
    private String valueSv;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LocalizedName() {
    }

    /**
     * 
     * @param valueEn
     * @param valueFi
     * @param valueSv
     */
    public LocalizedName(String valueFi, String valueEn, String valueSv) {
        super();
        this.valueFi = valueFi;
        this.valueEn = valueEn;
        this.valueSv = valueSv;
    }

    /**
     * 
     * @return
     *     The valueFi
     */
    public String getValueFi() {
        return valueFi;
    }

    /**
     * 
     * @param valueFi
     *     The valueFi
     */
    public void setValueFi(String valueFi) {
        this.valueFi = valueFi;
    }

    /**
     * 
     * @return
     *     The valueEn
     */
    public String getValueEn() {
        return valueEn;
    }

    /**
     * 
     * @param valueEn
     *     The valueEn
     */
    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    /**
     * 
     * @return
     *     The valueSv
     */
    public String getValueSv() {
        return valueSv;
    }

    /**
     * 
     * @param valueSv
     *     The valueSv
     */
    public void setValueSv(String valueSv) {
        this.valueSv = valueSv;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
