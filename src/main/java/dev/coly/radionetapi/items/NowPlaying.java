package dev.coly.radionetapi.items;

public class NowPlaying {

    private String title;
    private String stationId;

    /**
     * The title will contain the title of the track and the artist.
     * @return  The title and artist of the track.
     */
    public String getTitle() {
        return title;
    }

    public String getStationId() {
        return stationId;
    }

    @Override
    public String toString() {
        return "NowPlaying{" +
                "title='" + title + '\'' +
                ", stationId='" + stationId + '\'' +
                '}';
    }
}
