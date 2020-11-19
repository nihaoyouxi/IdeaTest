package WeiBiinMyBatisTest.bean;

/**
 * @author WeiBin
 * @Create 2020-11-13 18:35
 */
public class Student {
    private int id;
    private int classId;
    private String name;
    private String className;

    public Student(int studentId, int classId, String name) {
        this.id = studentId;
        this.classId = classId;
        this.name = name;
    }

    public Student(int classId, String name) {
        this.classId = classId;
        this.name = name;
    }

    public Student() {
    }

    public int getStudentId() {
        return id;
    }

    public void setStudentId(int studentId) {
        this.id = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + id +
                ", classId=" + classId +
                ", name='" + name + '\'' +
                '}';
    }
}
