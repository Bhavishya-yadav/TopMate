import java.util.ArrayList;
import java.util.List;

public class Creator extends Person{
    private List<Event> events;
    public Creator(String name, int age, String id) {
        super(name, age, id, UserType.CREATOR);
        events = new ArrayList<>();
    }
    public List<Event> getEvents() {
        return events;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public void addEvent(Event event) {
        this.events.add(event);
    }
}
