import java.util.function.Predicate;

import core.ConnectedObjectCounter;
import core.ImageObject;

public class VerticalLineProcessor extends ConnectedObjectCounter {

    /**
     * 
     * @param colorPredicate
     */
    public VerticalLineProcessor(Predicate<Integer> colorPredicate) {
        super(colorPredicate);
    }

    @Override
    public boolean isValidObject(ImageObject imageObject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidObject'");
    }

}