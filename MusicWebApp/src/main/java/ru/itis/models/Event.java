package ru.itis.models;

import java.util.Date;

public class Event {
    private  int event_id;
    private final String performer;
    private final  String concertDate;
    private final  int price;
    private final  String venue;

    public Event(int event_id, String performer, String concertDate, int price, String venue) {
        this.event_id = event_id;
        this.performer = performer;
        this.concertDate = concertDate;
        this.price = price;
        this.venue = venue;
    }

    public Event(String performer, String concertDate, int price, String venue) {
        this.performer = performer;
        this.concertDate = concertDate;
        this.price = price;
        this.venue = venue;
    }

    public int getEvent_id() {
        return event_id;
    }

    public String getPerformer() {
        return performer;
    }

    public String getConcertDate() {
        return concertDate;
    }

    public int getPrice() {
        return price;
    }

    public String getVenue() {
        return venue;
    }
}
