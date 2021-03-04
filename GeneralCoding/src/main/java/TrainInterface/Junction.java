package TrainInterface;


import java.util.ArrayList;

public class Junction {
    ArrayList<String> tracksConnected = new ArrayList<>();
    ArrayList<String> bgTracks = new ArrayList<>();
    ArrayList<String> ngTracks = new ArrayList<>();
    ArrayList<String> mgTracks = new ArrayList<>();

    boolean hasTrain;
    Junction(ArrayList<String> tracksConnected, ArrayList<String> bgTracks, ArrayList<String> ngTracks, ArrayList<String> mgTracks){
        this.tracksConnected = tracksConnected;
        this.bgTracks = bgTracks;
        this.mgTracks = mgTracks;
        this.ngTracks = ngTracks;
    }
    public boolean isHasTrain() {
        return hasTrain;
    }

    public ArrayList<String> getBgTracks() {
        return bgTracks;
    }

    public ArrayList<String> getNgTracks() {
        return ngTracks;
    }

    public ArrayList<String> getMgTracks() {
        return mgTracks;
    }
}
