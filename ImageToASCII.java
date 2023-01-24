import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// A basic java program that take path to an image as argument and prints it as ASCII art
public class ImageToASCII {
	public static void main(String[] args) {
		BufferedImage image = null;
		StringBuilder sb = new StringBuilder();

		// Accessing the image file
		try {
			image = ImageIO.read(new File(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Definition of grayscale, from darker to brighter
		String[] asciiChars = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'.  ".split("");

		// Converting every pixel of an image would result in a giant ASCII art with rather taller printout.
		// Instead, convert pixels with some space between them.
		// Height needs to be divided by the aspect ratio of the font. Dividing by 0.51 is enough for simple cases.
		int size = Integer.parseInt(args[1]);
		for (int y = 0; y < image.getHeight(); y += size/0.51) {
			for (int x = 0; x < image.getWidth(); x += size) {

			// Converting pixel to grayscale
			Color mycolor = new Color(image.getRGB(x, y));
			int gray = (int)(0.2126 * mycolor.getRed() + 0.7152 * mycolor.getGreen() + 0.0722 * mycolor.getBlue());
			int index = gray * (asciiChars.length - 1) / 255;
			sb.append(asciiChars[index]);
		}
		sb.append("\n");
	}
	System.out.println(sb);
    }
}
