
public abstract class Person {
    String name;
    int age;
    UserType userType;
    String id;


    public Person(String name, int age, String id, UserType userType) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.userType = userType;
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
