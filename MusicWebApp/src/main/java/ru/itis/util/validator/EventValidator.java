package ru.itis.util.validator;

import ru.itis.models.Event;

import java.sql.Date;

public class EventValidator {

    public boolean eventVerification(Event event) {
        String performer = event.getPerformer();
        String venue = event.getVenue();
        Date concertDate = event.getConcertDate();

        return performer.trim().length() != 0 && concertDate != null && venue.trim().length() != 0;
    }
}
