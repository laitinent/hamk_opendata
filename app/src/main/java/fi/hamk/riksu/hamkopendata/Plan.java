
package fi.hamk.riksu.hamkopendata;


public class Plan {

    private String id;
    private Integer startSemester;
    private Integer startYear;
    private String name;

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
     *     The startSemester
     */
    public Integer getStartSemester() {
        return startSemester;
    }

    /**
     * 
     * @param startSemester
     *     The startSemester
     */
    public void setStartSemester(Integer startSemester) {
        this.startSemester = startSemester;
    }

    /**
     * 
     * @return
     *     The startYear
     */
    public Integer getStartYear() {
        return startYear;
    }

    /**
     * 
     * @param startYear
     *     The startYear
     */
    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
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

}
