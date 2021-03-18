package dev.coly.radionetapi.items;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * A radio station with all its information. Some values can be null depending on where this object was created.
 */
public class Station {

    private String id;
    private String name;
    private Long lastModified;
    @SerializedName("logo44x44")
    private String logo44;
    @SerializedName("logo100x100")
    private String logo100;
    @SerializedName("logo175x175")
    private String logo175;
    @SerializedName("logo300x300")
    private String logo300;
    @SerializedName("logo630x630")
    private String logo630;
    @SerializedName("logo1200x1200")
    private String logo1200;
    private boolean playable;
    private List<Stream> streams;
    private String city;
    private String region;
    private String country;
    private String continent;
    private List<String> genres;
    private Type type;
    private String description;
    private String homepageUrl;
    private List<String> languages;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getLastModified() {
        return lastModified;
    }

    public String getLogo44() {
        return logo44;
    }

    public String getLogo100() {
        return logo100;
    }

    public String getLogo175() {
        return logo175;
    }

    public String getLogo300() {
        return logo300;
    }

    public String getLogo630() {
        return logo630;
    }

    public String getLogo1200() {
        return logo1200;
    }

    public boolean isPlayable() {
        return playable;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getHomepageUrl() {
        return homepageUrl;
    }

    public List<String> getLanguages() {
        return languages;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastModified=" + lastModified +
                ", logo44='" + logo44 + '\'' +
                ", logo100='" + logo100 + '\'' +
                ", logo175='" + logo175 + '\'' +
                ", logo300='" + logo300 + '\'' +
                ", logo630='" + logo630 + '\'' +
                ", logo1200='" + logo1200 + '\'' +
                ", playable=" + playable +
                ", streams=" + streams +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                ", genres=" + genres +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", homepageUrl='" + homepageUrl + '\'' +
                ", languages=" + languages +
                '}';
    }

    public static class Stream {

        private String url;
        private String contentFormat;

        public String getUrl() {
            return url;
        }

        public String getContentFormat() {
            return contentFormat;
        }

        @Override
        public String toString() {
            return "Stream{" +
                    "url='" + url + '\'' +
                    ", contentFormat='" + contentFormat + '\'' +
                    '}';
        }
    }

    public enum Type {
        STATION
    }

}
