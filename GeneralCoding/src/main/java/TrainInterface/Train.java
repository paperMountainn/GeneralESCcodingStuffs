package TrainInterface;

public class Train {
    String destinationJunction;
    String currentDirection;
    String trackID;
    String gaugeType;

    Train(String destinationJunction, String currentDirection, String trackID){
        this.destinationJunction = destinationJunction;
        this.currentDirection = currentDirection;
        this.trackID = trackID;
    }
    void changeTrack(Track track){

    }
    void changeEngine(){

    }
}
