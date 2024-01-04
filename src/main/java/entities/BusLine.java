package entities;

import java.util.List;

public class BusLine {

    private int id;
    private String name;
    private String terminal;
    private int dailyUsers;
    private List<BusStop> itinerary;

    public BusLine() {

    }

    public BusLine(int id, String name, String terminal, List<BusStop> itinerary, int dailyUsers) {
        this.id = id;
        this.name = name;
        this.terminal = terminal;
        this.itinerary = itinerary;
        this.dailyUsers = dailyUsers;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTerminal() {
        return terminal;
    }

    public int getDailyUsers() {
        return dailyUsers;
    }

    public List<BusStop> getItinerary() {
        return itinerary;
    }

    @Override
    public String toString() {
        return String.format("BusLine [id=%s, name=%s, terminal=%s, itinerary=%s]", id, name, terminal, itinerary);
    }

    public boolean serves(String region) {
        for(BusStop stop : this.getItinerary())
            if(stop.region().compareToIgnoreCase(region) == 0)
                return true;
        return false;
    }

}
