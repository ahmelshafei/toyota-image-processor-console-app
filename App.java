import java.util.function.Predicate;

import core.ImageObjectCounter;
import image.ImageLoader;

public class App {
    
    public static void main(String[] args) {
        
        if(args.length != 1) {
            throw new IllegalArgumentException("Number of arguments must be 1");
        }

        try {

            // black color predicate
            Predicate<Integer> blackColorPredicate  = rgb -> {
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;

                int brightness = (r + g + b) / 3;
                return brightness < 100;
            };
            
            ImageObjectCounter imageProcessor = new VerticalLineProcessor(blackColorPredicate);
            int numberOfBlackVerticalLines = imageProcessor.count(ImageLoader.load(args[0]));
            String output = String.format("Number of black vertical line(s): %s", numberOfBlackVerticalLines);
            System.out.println(output);
        
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
