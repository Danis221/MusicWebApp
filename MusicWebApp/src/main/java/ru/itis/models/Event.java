package ru.itis.models;

import java.sql.Date;

public class Event {
    private  int event_id;
    private final String performer;
    private final Date concertDate;
    private final  int price;
    private final  String venue;

    public Event(int event_id, String performer, Date concertDate, int price, String venue) {
        this.event_id = event_id;
        this.performer = performer;
        this.concertDate = concertDate;
        this.price = price;
        this.venue = venue;
    }

    public Event(String performer, Date concertDate, int price, String venue) {
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

    public Date getConcertDate() {
        return concertDate;
    }

    public int getPrice() {
        return price;
    }

    public String getVenue() {
        return venue;
    }

    @Override
    public String toString() {
        return "Event{" +
                "event_id=" + event_id +
                ", performer='" + performer + '\'' +
                ", concertDate=" + concertDate +
                ", price=" + price +
                ", venue='" + venue + '\'' +
                '}';
    }
}
