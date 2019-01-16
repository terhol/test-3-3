package se.terhol.pisemka33;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Teachers notebook.
 *
 * @author tomp
 */
public interface ITeachersNotebook {
    /**
     * Add mark to student. If student does not exist in the teachers notebook
     * then the student is added.
     *
     * @param student Student
     * @param mark    Mark
     * @throws IllegalArgumentException if student or mark are null
     */
    void addMark(Student student, Mark mark);

    /**
     * Returns marks of given student.
     *
     * @param student Student
     * @return list of student's marks, empty list if the student does not exist
     */
    List<Mark> getMarks(Student student);

    /**
     * Returns final mark of a student as a rounded average of student's marks.
     * <p/>
     * Final mark is computed as an average mark (i.e. the number in
     * the range 1.0 - 5.0) rounded to the nearest integer
     * (e.g. 2.3 is rounded down to 2 while 2.6 is rounded up to 3).
     *
     * @param student Student
     * @return -1 if student does not exist, final mark in the range 1-5 otherwise.
     */
    int getFinalMark(Student student);

    /**
     * Writes data to given file as follows:
     * 1. Data are written in text mode.
     * 2. Each student is written to a single line.
     * 3. Students are written according to their natural ordering.
     * 4. Each line has the form "student:marks", where 'student' is the output of
     * the Student.toString() method and 'marks' is a space-separated list of marks,
     * e.g. "7654 Jan Novak:1 4 3 2"
     *
     * @param file Text file to write into
     * @throws IOException on any I/O failure
     */
    void save(File file) throws IOException;

    /**
     * Reads data from given text file, instantiates objects
     * (i.e. students and their marks) and inserts them into the teachers notebook.
     *
     * @param file Text file to read from
     * @throws FileNotFoundException if given file cannot be opened for reading
     * @throws IOException           on any other I/O failure
     */
    void load(File file) throws FileNotFoundException, IOException;
}
