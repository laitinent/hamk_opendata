
package fi.hamk.riksu.hamkopendata;

import java.util.List;

public class StructureView {

    private String id;
    private List<Relation> relations = null;

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
     *     The relations
     */
    public List<Relation> getRelations() {
        return relations;
    }

    /**
     * 
     * @param relations
     *     The relations
     */
    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

}
