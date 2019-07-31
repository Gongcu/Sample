package sample.data;

import javafx.beans.property.*;

public class ScoreDataSub {
    private final FloatProperty avg;
    private final IntegerProperty rank;

    public ScoreDataSub(){
        avg=new SimpleFloatProperty();
        rank=new SimpleIntegerProperty();
    }

    public float getAvg() {
        return avg.get();
    }

    public FloatProperty avgProperty() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg.set(avg);
    }

    public int getRank() {
        return rank.get();
    }

    public IntegerProperty rankProperty() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank.set(rank);
    }

}
