package dev.coly.radionetapi.items;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Locale;

/**
 * The response for search by station name. The station results will not list all information about a station. To
 * retrieve all information use {@link dev.coly.radionetapi.RadioNetAPI#getStation(String, Locale)}
 */
public class SearchResponse {

    private int totalCount;
    @SerializedName("playables")
    private List<Station> results;

    public int getTotalCount() {
        return totalCount;
    }

    public List<Station> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "totalCount=" + totalCount +
                ", results=" + results +
                '}';
    }

}
