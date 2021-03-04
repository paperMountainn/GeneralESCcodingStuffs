package TrainInterface;

import java.util.ArrayList;

public class Track {
    boolean containsTrain;
    String trainDirection;
    ArrayList<String> junctionPointsConnected = new ArrayList<>();
    String gaugeType;

    Track(boolean containsTrain, String trainDirection, ArrayList<String> junctionPointsConnected, String gaugeType){
        this.containsTrain = containsTrain;
        this.trainDirection = trainDirection;
        this.junctionPointsConnected = junctionPointsConnected;
        this.gaugeType = gaugeType;
    }

    public boolean isContainsTrain() {
        return containsTrain;
    }
}
