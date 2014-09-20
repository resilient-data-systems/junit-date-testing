package uk.co.resilientdatasystems.event;

import static uk.co.resilientdatasystems.event.Event.EventType.SYSTEM;
import static uk.co.resilientdatasystems.event.Event.EventType.USER;


public class EventService {
	
	private final EventDAO eventDAO; 
	
	public EventService(EventDAO eventDAO){
		this.eventDAO = eventDAO;
	}

	public void recordUserEvent(String message){
		eventDAO.storeEvent(new Event(USER, message));
	}
	
	public void recordSystemEvent(String systemUUID, String eventCode){
		String message = systemUUID + ": " + eventCode;
		eventDAO.storeEvent(new Event(SYSTEM, message));
	}
}