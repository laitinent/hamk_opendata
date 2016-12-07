package fi.hamk.riksu.hamkopendata;

import java.util.List;

public class Realizations {

    private String status;
    private String message;
    private List<Realization> realizations = null;

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
     * The realizations
     */
    public List<Realization> getRealizations() {
        return realizations;
    }

    /**
     *
     * @param realizations
     * The realizations
     */
    public void setRealizations(List<Realization> realizations) {
        this.realizations = realizations;
    }

}