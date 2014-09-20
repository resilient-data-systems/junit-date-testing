package uk.co.resilientdatasystems.event;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

public class Event {
    enum EventType {
        SYSTEM, USER
    }

    private EventType eventType;
    private Date createdOn;
    private String message;

    public Event(EventType eventType, String message) {
        this.eventType = eventType;
        this.message = message;

        // to see test failure, use new Date() instead of DateTime
//         this.createdOn = new Date();
        this.createdOn = DateTime.now().toDate();

    }

    public EventType getEventType() {
        return eventType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getMessage() {
        return message;
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, true);
    }

    public String toString() {
        // appended createdOn.getTime() so that when unit test fails, you can
        // see millisecond of difference
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE) + "; createdOn " + createdOn.getTime();
    }
}