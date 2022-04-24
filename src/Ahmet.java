import java.util.Arrays;

public class Ahmet {

    public static void main(String[] args) {


        // Ahmet Branch has created.

        System.out.println("Hello world");

        System.out.println("Were now collaborating ");

        // first change has been made.


        String projectName = "Group 10 Project";

        System.out.println("Project = " + projectName);

        String[] projectMembers = new String[12]; // members name to be added.

        String member1 = "Ahmet"; // first member is added.

        projectMembers[0] = member1;


        collaborate(member1, projectName);


    }
        // first method has been created
    public static void collaborate(String name, String project) {
        System.out.println(name + " is collaborating, on the " + project);
    }
}
