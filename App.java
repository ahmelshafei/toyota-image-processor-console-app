import java.util.function.Predicate;

import core.ImageObjectCounter;
import image.ImageLoader;
import processors.VerticalLineProcessor;

public class App {
    
    public static void main(String[] args) {
        
        if(args.length != 1) {
            System.out.println("Number of arguments must be 1");
            return;
        }

        try {

            // black color predicate
            Predicate<Integer> blackColorPredicate = rgb -> {
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;

                int brightness = (r + g + b) / 3;
                return brightness < 100;
            };
            
            ImageObjectCounter imageProcessor = new VerticalLineProcessor(blackColorPredicate);
            int numberOfBlackVerticalLines = imageProcessor.count(ImageLoader.load(args[0]));
            System.out.println(String.format("Number of black vertical line(s): %d", numberOfBlackVerticalLines));
        
        } catch(Exception e) {
            System.out.println(String.format("Exception: %s", e.getMessage()));
        }
    }
}
