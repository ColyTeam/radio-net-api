package dev.coly.radionetapi.test;

import dev.coly.radionetapi.RadioNetAPI;
import dev.coly.radionetapi.items.NowPlaying;
import dev.coly.radionetapi.items.SearchResponse;
import dev.coly.radionetapi.items.Station;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;

public class TestRadioNetAPI {

    @Test
    public void testGetStation(){
        try {
            Station station = RadioNetAPI.getStation("schlagerparadies", Locale.GERMAN);
            Assert.assertNotNull(station);
            Assert.assertTrue("Streams empty", station.getStreams().size() > 0);
            Assert.assertTrue("Genres empty", station.getGenres().size() > 0);
            Assert.assertTrue("Languages empty", station.getLanguages().size() > 0);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testSearchStation(){
        try {
            SearchResponse searchResponse = RadioNetAPI.searchStations("Schlagerparadies", 10, Locale.GERMAN);
            Assert.assertNotNull(searchResponse);
            Assert.assertTrue("Results empty", searchResponse.getResults().size() > 0);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNowPlaying(){
        try {
            NowPlaying nowPlaying = RadioNetAPI.getNowPlaying("schlagerparadies", Locale.GERMAN);
            Assert.assertNotNull(nowPlaying);
            Assert.assertFalse("Title empty", nowPlaying.getTitle().isEmpty());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }

}
