import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Event {
    private String eventId;

    private List<Slot> slots;

    private int costOfEvent;
    private String title;

    public Event(String title, int costOfEvent, String id) {
        this.eventId = id;
        this.costOfEvent = costOfEvent;
        this.slots = new ArrayList<>();
        this.title = title;
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

    public void removeSlot(String slotId) {
        slots.removeIf(slot -> slot.getSlotId().equals(slotId));
    }

    public Slot findSlotById(String slotId) {
        return slots.stream().filter(s -> s.getSlotId().equals(slotId)).findFirst().orElse(null);
    }
}

