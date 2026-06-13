import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Creator {
    String name;
    int age;
    List<CreatorEvent> history;
    Deque<CreatorEvent> futureSessions;
    UserType userType;
    String id;

    public Creator(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.history = new ArrayList<>();
        this.futureSessions = new ArrayDeque<>();
        this.userType = UserType.CREATOR;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CreatorEvent> getHistory() {
        return history;
    }

    public void setHistory(List<CreatorEvent> history) {
        this.history = history;
    }

    public Deque<CreatorEvent> getFutureSessions() {
        return futureSessions;
    }

    public void setFutureSessions(Deque<CreatorEvent> futureSessions) {
        this.futureSessions = futureSessions;
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
