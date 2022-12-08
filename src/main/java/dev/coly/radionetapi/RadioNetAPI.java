package dev.coly.radionetapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.coly.radionetapi.items.NowPlaying;
import dev.coly.radionetapi.items.SearchResponse;
import dev.coly.radionetapi.items.Station;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * An API wrapper for the semi-public radio.net API
 */
public class RadioNetAPI {

    static Gson gson = new Gson();

    /**
     * Get all information about a station by station id.
     * @param stationId     the internal station id.
     * @param language      Language of description texts.
     * @return              A {@link Station} with all information available.
     * @throws IOException  Thrown when the website can't be accessed.
     */
    public static Station getStation(String stationId, Locale language) throws IOException {
        String content = Jsoup.connect("https://prod.radio-api.net/stations/details?stationIds=" + stationId)
                .userAgent("RadioNetAPI/1.0").header("Accept-Language", language.getISO3Language())
                .ignoreContentType(true).execute().body();

        Type listType = new TypeToken<List<Station>>(){}.getType();
        List<Station> stations = gson.fromJson(content, listType);
        if (stations.size() == 0) {
            throw new IllegalArgumentException("No stations found with this id");
        }
        return stations.get(0);
    }

    /**
     * Search for radio stations by name.
     * @param query         Part of the station name you are search for.
     * @param count         How many results should be returned.
     * @param language      Language of description texts.
     * @return              The {@link SearchResponse} containing all results.
     * @throws IOException  Thrown when the website can't be accessed.
     */
    public static SearchResponse searchStations(String query, int count, Locale language) throws IOException {
        String content = Jsoup.connect("https://prod.radio-api.net/stations/search?query=" + query + "&count=" + count)
                .userAgent("RadioNetAPI/1.0").header("Accept-Language", language.getISO3Language())
                .ignoreContentType(true).execute().body();

        return gson.fromJson(content, SearchResponse.class);
    }

    /**
     * Get which title is now playing at a station by stationId.
     * @param stationId     The internal id of the station.
     * @param language      Language of description texts. (Most likely won't matter)
     * @return              {@link NowPlaying} containing the title of what is playing now.
     * @throws IOException  Thrown when the website can't be accessed.
     */
    public static NowPlaying getNowPlaying(String stationId, Locale language) throws IOException {
        String content = Jsoup.connect("https://prod.radio-api.net/stations/now-playing?stationIds=" + stationId)
                .userAgent("RadioNetAPI/1.0").header("Accept-Language", language.getISO3Language())
                .ignoreContentType(true).execute().body();

        content = content.replaceFirst(Pattern.quote("["), "").substring(0, content.length() - 3);

        return gson.fromJson(content, NowPlaying.class);
    }

}
