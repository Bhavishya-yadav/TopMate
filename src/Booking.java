public class Booking {
    private String eventId;
    private String customerId;
    private String creatorId;
    private Slot slot;

    public Booking(String eventId, String customerId, String creatorId, Slot slot) {
        this.eventId = eventId;
        this.customerId = customerId;
        this.creatorId = creatorId;
        this.slot = slot;
    }

    public String getEventId() { return eventId; }
    public String getCustomerId() { return customerId; }
    public String getCreatorId() { return creatorId; }
    public Slot getSlot() { return slot; }
}
