import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Customer {
    String name;
    int age;
    Deque<CreatorEvent> futureEvents;
    List<CreatorEvent> history;
    UserType userType;
    String id;


    public Customer(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.futureEvents = new ArrayDeque<>();
        this.history = new ArrayList<>();
        this.userType = UserType.CUSTOMER;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Deque<CreatorEvent> getFutureEvents() {
        return futureEvents;
    }

    public void setFutureEvents(Deque<CreatorEvent> futureEvents) {
        this.futureEvents = futureEvents;
    }

    public List<CreatorEvent> getHistory() {
        return history;
    }

    public void setHistory(List<CreatorEvent> history) {
        this.history = history;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
