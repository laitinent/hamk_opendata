
package fi.hamk.riksu.hamkopendata;


import android.os.Parcel;
import android.os.Parcelable;

public class Relation {  //implements Parcelable {

    private String id;
    private String level;
    private String treeId;
    private LearningUnit learningUnit;

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
     *     The level
     */
    public String getLevel() {
        return level;
    }

    /**
     * 
     * @param level
     *     The level
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 
     * @return
     *     The treeId
     */
    public String getTreeId() {
        return treeId;
    }

    /**
     * 
     * @param treeId
     *     The treeId
     */
    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    /**
     * 
     * @return
     *     The learningUnit
     */
    public LearningUnit getLearningUnit() {
        return learningUnit;
    }

    /**
     * 
     * @param learningUnit
     *     The learningUnit
     */
    public void setLearningUnit(LearningUnit learningUnit) {
        this.learningUnit = learningUnit;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(getLearningUnit(),i);

    }

    public final Parcelable.Creator<Relation> CREATOR = new Parcelable.Creator<Relation>() {
        @Override
        public Relation createFromParcel(Parcel source) {

            return new Relation(source);
        }

        @Override
        public Relation[] newArray(int size) {
            return new Relation[size];
        }
    };

    public Relation(Parcel data) {
        setLearningUnit(data.readParcelable());
    }*/
    }
