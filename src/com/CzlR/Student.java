package src.com.CzlR;

public class Student {
    private String id;
    private String name;
    private String gender;
    private String major;
    private int age;

    public Student() {
    }

    public Student(String id, String name, String gender, String major, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.major = major;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id+"      "+name+"       "+age+"        "+gender+"        "+major;
    }
}
