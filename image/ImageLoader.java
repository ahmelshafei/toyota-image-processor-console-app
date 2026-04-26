package image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * A class used to load images from absolute or relative path
 */
public class ImageLoader {
    
    public static BufferedImage load(String path) throws IOException {
        return ImageIO.read(new File(path));
    }
}
