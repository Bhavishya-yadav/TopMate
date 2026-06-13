import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

public class CreatorManager {
    private Map<String, Creator> creatorMap; // id -> creator
    private static CreatorManager instance = new CreatorManager();

    private CreatorManager() {
        this.creatorMap = new HashMap<>();
    }

    public static CreatorManager getInstance() {
        return instance;
    }

    public void addCreator(Creator creator) {
        creatorMap.put(creator.getId(), creator);
    }

    public void removeCreator(String id) {
        if(creatorMap.containsKey(id)) {
            creatorMap.remove(id);
        }
    }

    public Creator getCreatorById(String id) {
        return creatorMap.getOrDefault(id, null);
    }

    public void addEvent(String id, Event event) {
        getCreatorById(id).addEvent(event);
    }

    public void addSlot(String creatorId, String eventId, Slot slot) throws Exception {
        List<Event> events = getCreatorById(creatorId).getEvents();

        Event event = events.stream().filter(e -> e.getEventId().equals(eventId)).findFirst()
                .orElseThrow(() -> new Exception("No available event found"));
        event.addSlot(slot);
    }

    public void removeSlot(String creatorId, String eventId, String slotId) throws Exception {
        List<Event> events = getCreatorById(creatorId).getEvents();

        Event event = events.stream().filter(e -> e.getEventId().equals(eventId)).findFirst()
                .orElseThrow(() -> new Exception("No available event found"));
        event.removeSlot(slotId);
    }

    public void getAllEeventsByCreatorId(String creatorId) {
        List<Event> events = getCreatorById(creatorId).getEvents();
        events.forEach(event ->
            System.out.printf(
                "Event Id: %s, Title: %s, Cost: %d%n",
                event.getEventId(),
                event.getTitle(),
                event.getCostOfEvent()
            )
        );
    }

    public void getAllSlotsByEventId(String creatorId, String eventId) {
        Event event = getCreatorById(creatorId).getEvents().stream().filter(e -> e.getEventId().equals(eventId)).findFirst().orElse(null);
        event.getSlots().forEach(slot ->
            System.out.printf(
                "Slot Id: %s, Status: %s, StartTime: %s, EndTime: %s%n",
                slot.getSlotId(),
                slot.getSlotStatus().name(),
                slot.getStartTime().toString(),
                slot.getEndTime().toString()
            )
        );
    }

    public void acceptRequest(String creatorId, String eventId, String slotId) throws Exception{
        List<Event> events = getCreatorById(creatorId).getEvents();

        Event event = events.stream().filter(e -> e.getEventId().equals(eventId)).findFirst()
                .orElseThrow(() -> new Exception("No available event found"));
        Slot slot = event.findSlotById(slotId);
        slot.setSlotStatus(SlotStatus.ACCEPTED);
    }

    public void rejectRequest(String creatorId, String eventId, String slotId) throws Exception{
        List<Event> events = getCreatorById(creatorId).getEvents();

        Event event = events.stream().filter(e -> e.getEventId().equals(eventId)).findFirst()
                .orElseThrow(() -> new Exception("No available event found"));
        Slot slot = event.findSlotById(slotId);
        slot.setSlotStatus(SlotStatus.CREATED);
    }

    public void getAllCreators() {
        creatorMap.values()
          .stream()
          .forEach(creator -> {
              System.out.println("================================");
              System.out.printf(
                  "Id: %s, Name: %s, Age: %d, Type: %s%n",
                  creator.getId(),
                  creator.getName(),
                  creator.getAge(),
                  creator.getUserType()
              );
            });
    }

    public void getAllEvents(String creatorId) {
    Creator creator = creatorMap.get(creatorId);
    creator.getEvents()
       .stream()
       .forEach(event -> {
           System.out.println("================================");
           System.out.println("Event Id    : " + event.getEventId());
           System.out.println("Title       : " + event.getTitle());
           System.out.println("Cost        : " + event.getCostOfEvent());

           System.out.println("Slots:");
           event.getSlots()
                .stream()
                .forEach(slot ->
                    System.out.printf(
                        "  Start: %s | End: %s | Status: %s%n",
                        slot.getStartTime(),
                        slot.getEndTime(),
                        slot.getSlotStatus()
                    )
                );
       });
    }
}
