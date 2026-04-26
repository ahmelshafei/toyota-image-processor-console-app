package processors;

import java.util.function.Predicate;

import core.ConnectedObjectCounter;
import core.ImageObject;

public class HorizontalLineProcessor extends ConnectedObjectCounter {

    /**
     * 
     * @param colorPredicate
     */
    public HorizontalLineProcessor(Predicate<Integer> colorPredicate) {
        super(colorPredicate);
    }

    @Override
    public boolean isValidObject(ImageObject imageObject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidObject'");
    }

}