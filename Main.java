import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Create a group
        Group group = new Group(1, "Group 1");

        // Create students
        Student student1 = new Student(1, "John", group);
        Student student2 = new Student(2, "Alice", group);

        // Add students to the group
        group.addStudent(student1);
        group.addStudent(student2);

        // Create a lesson
        Lesson lesson = new Lesson(1, group, new Date());

        // Add lesson to the group
        group.addLesson(lesson);

        // Print all groups
        System.out.println("Group: " + group.getNumber());

        // Print all students in the group
        System.out.println("Students in the group:");
        for(Student student : group.getStudents()) {
            System.out.println(student.getName());
        }

        // Print all lessons for a student
        System.out.println("Lessons for student " + student1.getName() + ":");
        for(Lesson studLesson : student1.getGroup().getLessons()) {
            System.out.println(studLesson.getId());
        }
    }
}

class Group {
    private int id;
    private String number;
    private List<Student> students = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();

    public Group(int id, String number) {
        this.id = id;
        this.number = number;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public String getNumber() {
        return number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }
}

class Student {
    private int id;
    private String name;
    private Group group;

    public Student(int id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public Group getGroup() {
        return group;
    }
}

class Lesson {
    private int id;
    private Group group;
    private Date date;

    public Lesson(int id, Group group, Date date) {
        this.id = id;
        this.group = group;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Group getGroup() {
        return group;
    }

    public Date getDate() {
        return date;
    }
}
