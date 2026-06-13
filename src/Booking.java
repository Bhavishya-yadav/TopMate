public class Booking {
    private String bookingId;
    private String eventId;
    private String customerId;
    private String creatorId;
    private Slot slot;

    public Booking(String bookingId, String eventId, String customerId, String creatorId, Slot slot) {
        this.eventId = eventId;
        this.customerId = customerId;
        this.creatorId = creatorId;
        this.slot = slot;
        this.bookingId = bookingId;
    }

    public String getEventId() { return eventId; }
    public String getCustomerId() { return customerId; }
    public String getCreatorId() { return creatorId; }
    public Slot getSlot() { return slot; }

    public String getBookingId() {
        return bookingId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", eventId='" + eventId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", creatorId='" + creatorId + '\'' +
                ", slot=" + slot +
                '}';
    }
    
}
