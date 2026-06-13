import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CreatorEvent {
    private String eventId;
    private Creator creator;

    private List<Slot> slots;

    private int costOfEvent;
    private String title;

    public CreatorEvent(String title, Creator creator, Customer customer, int costOfEvent, List<Slot> slots) {
        this.eventId = UUID.randomUUID().toString();
        this.creator = creator;
        this.costOfEvent = costOfEvent;
        this.slots = slots;
        this.title = title;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public int getCostOfEvent() {
        return costOfEvent;
    }

    public void setCostOfEvent(int costOfEvent) {
        this.costOfEvent = costOfEvent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    
    
}
