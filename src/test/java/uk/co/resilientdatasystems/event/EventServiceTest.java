package uk.co.resilientdatasystems.event;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.joda.time.DateTimeUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import uk.co.resilientdatasystems.event.Event.EventType;

public class EventServiceTest {

	private EventService eventService;
	private EventDAO eventDAO;

	@Before
	public void setUp() {
		eventDAO = mock(EventDAO.class);
		eventService = new EventService(eventDAO);
		DateTimeUtils.setCurrentMillisFixed(0);
	}

	@After
	public void after() {
		DateTimeUtils.setCurrentMillisSystem();
	}

	@Test
	public void storeUserEventTest() {

		//run multiple times to see failures when using new Date() instead of DateTime.now().toDate()
		for (int i = 0; i < 3000; i++) {
			String message = "User did something..." + i;

			Event expectedEvent = createExpectedEvent(EventType.USER, message);
			eventService.recordUserEvent(message);
			verify(eventDAO).storeEvent(expectedEvent);

			// just checking you are not cheating ;-)
			assertThat(
					"createdOn must be set on Event to demonstrate the example",
					expectedEvent.getCreatedOn(), is(notNullValue()));
		}
	}

	private Event createExpectedEvent(EventType eventType, String message) {
		return new Event(eventType, message);
	}
}