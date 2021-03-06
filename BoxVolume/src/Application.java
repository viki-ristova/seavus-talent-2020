import java.util.Scanner;

/**
 * Exercise: BoxVolume
 * An application class that reads the dimensions for height, width and depth of a box
 * and as an output gives the calculated volume of the box with the given dimensions from the user.
 * Sample test input: Input value for the box's height:
 *  2
 * Input value for the box's width:
 *  2
 * Input value for the box's depth:
 *  3
 * Sample test output: The volume for the given parameters for the box is: 12
 */
public class Application {
    public static void main(String[] args) {
        System.out.println("Input value for the box's height:");
        int height = new Scanner(System.in).nextInt();
        System.out.println("Input value for the box's width:");
        int width = new Scanner(System.in).nextInt();
        System.out.println("Input value for the box's depth:");
        int depth = new Scanner(System.in).nextInt();
        Box box = new Box(height,width,depth);
        Integer volume;
        volume = box.getVolume();

        System.out.printf("The volume for the given parameters for the box is: %d", volume);

    }
}
