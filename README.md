# RadioNetAPI
An API wrapper for the semi-public [radio.net](https://radio.net) API

## Installation
Download the jar file from the [release page](https://github.com/ColyTeam/RadioNetAPI/releases/latest).

### Maven

```xml
<repository>
    <id>coly</id>
    <url>https://m2.coly.dev/releases</url>
</repository>

<dependency>
    <groupId>dev.coly</groupId>
    <artifactId>radio-net-api</artifactId>
    <version>VERSION</version>
</dependency>
````

## Usage
This project can only be used as a libary.

### Examples

```JAVA
Station station = RadioNetAPI.searchStation("schlagerparadies", Locale.GERMAN);
System.out.println("The Station " +  station.getName() + " is located in " + city + ", " + country);
```

```JAVA
SearchResponse searchResponse = RadioNetAPI.searchStations("Schlagerparadies", 10, Locale.GERMAN);
System.out.println("The search returned " + searchResponse.getResults().size() + " results.");
```

```JAVA
NowPlaying nowPlaying = RadioNetAPI.getNowPlaying("schlagerparadies", Locale.GERMAN);
System.out.println("The station is now playing: " + nowPlaying.getTitle());
```

### Tips
- The stationId is case sensitive
- NowPlaying#getTitle can get some wierd shorted text in some examples. It will not be an title and artist for all stations.
