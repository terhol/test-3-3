package se.terhol.pisemka33;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Tereza Holm
 */
public class TeachersNotebook implements ITeachersNotebook {
    private SortedMap<Student, List<Mark>> listOfStudents = new TreeMap<>();

    @Override
    public void addMark(Student student, Mark mark) {
        if (student == null || mark == null) {
            throw new IllegalArgumentException();
        }
        if (listOfStudents.containsKey(student)) {
            listOfStudents.get(student).add(mark);
        } else {
            List<Mark> marks = new ArrayList<>();
            marks.add(mark);
            listOfStudents.put(student, marks);
        }
    }

    @Override
    public List<Mark> getMarks(Student student) {
        return listOfStudents.get(student);
    }

    @Override
    public int getFinalMark(Student student) {
        float sum = 0;
        float numberOfMarks = 0;
        float finalMark = 0;
        if (!listOfStudents.containsKey(student)) {
            return -1;
        }
        for (Mark mark : listOfStudents.get(student)) {
            sum = sum + mark.getValue();
            numberOfMarks++;
        }
        if (numberOfMarks != 0) {
            finalMark = sum / numberOfMarks;
        }
        return Math.round(finalMark);
    }

    @Override
    public void save(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (Student student : listOfStudents.keySet()) {
            writer.write(String.format("%1$s:%2$s", student.toString(), this.allMarks(student)));
            writer.newLine();
            writer.flush();
        }
    }

    @Override
    public void load(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            this.addDataFromString(line);
            line = reader.readLine();
        }
    }

    private String allMarks(Student student) {
        String allMarks = "";
        for (Mark mark : this.getMarks(student))
            if ("".equals(allMarks)) {
                allMarks = mark.toString();
            } else {
                allMarks = String.format("%1$s %2$s", allMarks, mark.toString());
            }
        return allMarks;
    }

    private void addDataFromString(String line) {
        int firstSpace = line.indexOf(' ');
        int firstColon = line.indexOf(':');
        int uco = Integer.parseInt(line.substring(0, firstSpace));
        String name = line.substring(firstSpace + 1, firstColon);
        Student student = new Student(uco, name);
        listOfStudents.put(student, new ArrayList<>());
        for (int i = firstColon + 1; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                int markValue = Character.getNumericValue(line.charAt(i));
                listOfStudents.get(student).add(new Mark(markValue));
            }
        }
    }
}
