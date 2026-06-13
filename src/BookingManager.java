import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingManager {
    private Map<String, CreatorEvent> eventMap = new HashMap<>();
    private Map<String, List<Booking>> customerBookingMap = new HashMap<>();
    private Map<String, List<Booking>> creatorBookingMap = new HashMap<>();


    public boolean isEventAvailable(CreatorEvent event, LocalDateTime eventStarTime) {
        List<Slot> slots = event.getSlots();
        return  slots.stream().anyMatch(slot -> slot.getStartTime().equals(eventStarTime)
                        && (slot.getSlotStatus() == SlotStatus.AVAILABLE
                        || slot.getSlotStatus() == SlotStatus.CANCELLED));
    }

    public void bookEvent(String customerId, String creatorId, String eventId, LocalDateTime eventStartTime, Customer customer) throws Exception {
        CreatorEvent event = eventMap.get(eventId);
        if (event == null) {
            throw new Exception("Event not found");
        }

        Slot availableSlot = event.getSlots().stream()
                .filter(slot -> slot.getStartTime().equals(eventStartTime)
                        && (slot.getSlotStatus() == SlotStatus.AVAILABLE
                            || slot.getSlotStatus() == SlotStatus.CANCELLED))
                .findFirst()
                .orElseThrow(() -> new Exception("No available slot found"));

        availableSlot.setSlotStatus(SlotStatus.BOOKED);
        availableSlot.setCustomer(customer);

        Booking booking = new Booking(eventId, customerId, creatorId, availableSlot);
        customerBookingMap.computeIfAbsent(customerId, k -> new ArrayList<>()).add(booking);
        creatorBookingMap.computeIfAbsent(creatorId, k -> new ArrayList<>()).add(booking);
    }


    
}
