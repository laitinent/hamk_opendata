
package fi.hamk.riksu.hamkopendata;

import java.util.List;

public class Curriculums {

    private String status;
    private List<Programme> programmes = null;

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
     *     The programmes
     */
    public List<Programme> getProgrammes() {
        return programmes;
    }

    /**
     * 
     * @param programmes
     *     The programmes
     */
    public void setProgrammes(List<Programme> programmes) {
        this.programmes = programmes;
    }

}
