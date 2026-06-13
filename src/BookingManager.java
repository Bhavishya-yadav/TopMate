import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BookingManager {
    private UserManager userManager;
    private CreatorManager creatorManager;
    // private Map<String, Event> eventMap;
    private Map<String, Booking> allBookingMap;
    private Map<String, List<Booking>> customerBookingsMap;

    public BookingManager() {
        userManager = UserManager.getInstance();
        creatorManager = CreatorManager.getInstance();
        // eventMap = new HashMap<>();
        allBookingMap = new HashMap<>();
        customerBookingsMap = new HashMap<>();
    }


    public boolean isEventAvailable(Event event, LocalDateTime eventStarTime) {
        List<Slot> slots = event.getSlots();
        return  slots.stream().anyMatch(slot -> slot.getStartTime().equals(eventStarTime)
                        && (slot.getSlotStatus() == SlotStatus.CREATED
                        || slot.getSlotStatus() == SlotStatus.CANCELLED));
    }

    public String bookEvent(String customerId, String creatorId, String eventId, LocalDateTime eventStartTime) throws Exception {
        // Event event = eventMap.get(eventId);
        // if (event == null) {
        //     throw new Exception("Event not found");
        // }

        Event event = creatorManager.getCreatorById(creatorId).getEvents().stream().filter(e -> e.getEventId().equals(eventId)).findFirst().orElseThrow(() -> new Exception("No available event found"));

        Slot availableSlot = event.getSlots().stream()
                .filter(slot -> slot.getStartTime().equals(eventStartTime)
                        && (slot.getSlotStatus() == SlotStatus.CREATED
                            || slot.getSlotStatus() == SlotStatus.CANCELLED))
                .findFirst()
                .orElseThrow(() -> new Exception("No available slot found"));

        availableSlot.setSlotStatus(SlotStatus.BOOKED);

        String bookingId = UUID.randomUUID().toString().substring(0, 4);

        Booking booking = new Booking(bookingId, eventId, customerId, creatorId, availableSlot);
        allBookingMap.put(bookingId, booking);
        customerBookingsMap.putIfAbsent(customerId, new ArrayList<>());
        customerBookingsMap.get(customerId).add(booking);
        return bookingId;
    }


    public void addEvent(String id, Event event) {
        creatorManager.addEvent(id, event);
    }

    public void addSlot(String creatorId, String eventId, Slot slot) throws Exception {
        creatorManager.addSlot(creatorId, eventId, slot);
    }

    public void removeSlot(String creatorId, String eventId, String slotId) throws Exception {
        creatorManager.removeSlot(creatorId, eventId, slotId);
    }

    public void getAllEeventsByCreatorId(String creatorId) {
        creatorManager.getAllEeventsByCreatorId(creatorId);
    }

    public void getAllSlotsByEventId(String creatorId, String eventId) {
        creatorManager.getAllSlotsByEventId(creatorId, eventId);
    }

    public void acceptRequest(String bookingId) throws Exception{
        Booking booking = allBookingMap.get(bookingId);
        if(booking == null) {
            System.out.println("Bhkkk");
        } else {
            booking.getSlot().setSlotStatus(SlotStatus.ACCEPTED);
            System.out.println("Request accepted!!!!");
        }
    }

    public void rejectRequest(String bookingId) throws Exception{
        Booking booking = allBookingMap.get(bookingId);
        if(booking == null) {
            System.out.println("Bhkkk");
        } else {
            booking.getSlot().setSlotStatus(SlotStatus.CREATED);
        }
    }

    public void getAllCreators() {
        creatorManager.getAllCreators();
    }

    public void getAllEvents(String creatorId) {
        creatorManager.getAllEeventsByCreatorId(creatorId);
    }

    public void getAllBookingOfUser(String userId) {
        customerBookingsMap.getOrDefault(userId, Collections.emptyList()).forEach(System.out::println);
    }
    
}
