
package fi.hamk.riksu.hamkopendata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseUnitSearch {

    private String status;
    private List<CourseUnit> courseUnits = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CourseUnit> getCourseUnits() {
        return courseUnits;
    }

    public void setCourseUnits(List<CourseUnit> courseUnits) {
        this.courseUnits = courseUnits;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
