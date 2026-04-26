package core;
import java.awt.image.BufferedImage;

/**
 * An interface used to count objects in image
 */
public interface ImageObjectCounter {

    int count(BufferedImage image);

}