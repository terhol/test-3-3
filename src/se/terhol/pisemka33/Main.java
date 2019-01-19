package se.terhol.pisemka33;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author tomp
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ITeachersNotebook notebook = new TeachersNotebook();

        Student pepa = new Student(1, "Josef Vomacka");
        Student jirka = new Student(3, "Jirka Jelinek");
        Student franta = new Student(2, "Franta Vopicka");

        notebook.addMark(pepa, new Mark(2));
        notebook.addMark(pepa, new Mark(1));
        notebook.addMark(pepa, new Mark(1));
        notebook.addMark(jirka, new Mark(5));
        notebook.addMark(jirka, new Mark(4));
        notebook.addMark(franta, new Mark(3));

        notebook.save(new File("notebook.txt"));

        System.out.println("Pepa's marks " + notebook.getMarks(pepa));

        System.out.println("Re-loading notebook from file");
        notebook = new TeachersNotebook();
        notebook.load(new File("notebook.txt"));

        System.out.println("Pepa's marks: " + notebook.getMarks(pepa) + " => " + notebook.getFinalMark(pepa));
        System.out.println("Franta's marks: " + notebook.getMarks(franta) + " => " + notebook.getFinalMark(franta));
        System.out.println("Jirka's marks: " + notebook.getMarks(jirka) + " => " + notebook.getFinalMark(jirka));
    }
}
