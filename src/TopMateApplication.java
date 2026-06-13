import java.time.LocalDateTime;

public class TopMateApplication {
    public static void main(String[] args) throws Exception {
        
        CreatorManager creatorManager = CreatorManager.getInstance();
        Creator creator1 = new Creator("Amit", 26, "1");
        Creator creator2 = new Creator("Bhavishya", 2, "2");
        Creator creator3 = new Creator("Pintu", 25, "3");
        creatorManager.addCreator(creator1);
        creatorManager.addCreator(creator2);
        creatorManager.addCreator(creator3);

        UserManager userManager = UserManager.getInstance();
        User user1 = new User("JK Chhabra", 52, "1");
        userManager.addUser(user1);

        
        BookingManager bookingManager = new BookingManager();
        Event event1 = new Event("Data Structure and Algo", 10000, "123");
        bookingManager.addEvent("1", event1);
        LocalDateTime startTime = LocalDateTime.now();
        bookingManager.addSlot("1", "123", new Slot(startTime, startTime.plusHours(1), "2345"));

        bookingManager.getAllCreators();
        bookingManager.getAllEvents("1");

        String bookingId = bookingManager.bookEvent("1", "1", "123", startTime);

        bookingManager.acceptRequest(bookingId);

        bookingManager.getAllEeventsByCreatorId("1");
        bookingManager.getAllBookingOfUser("1");

        bookingManager.getAllSlotsByEventId("1", "123");
    }
}
