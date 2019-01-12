package se.terhol.pisemka33;

/**
 *
 * @author tomp
 */
public class Mark {

    private int value;
    
    public Mark(int value) {
        if (value < 1 || value > 5) {
            throw new IllegalArgumentException("value");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }    
}
