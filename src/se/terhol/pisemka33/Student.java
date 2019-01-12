package se.terhol.pisemka33;

/**
 *
 * @author tomp
 */
public class Student implements Comparable<Student> {

    private int uco;
    private String name;

    public Student(int uco, String name) {
        this.uco = uco;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUco() {
        return uco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return (this.uco == ((Student)obj).uco);
    }

    @Override
    public int hashCode() {
        return this.uco;
    }

    public int compareTo(Student o) {
        return this.getUco() - o.getUco();
    }

    @Override
    public String toString() {
        return uco + " " + name;
    }
}
