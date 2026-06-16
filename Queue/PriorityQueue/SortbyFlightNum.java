package Queue.PriorityQueue;

import java.util.Comparator;

public class SortbyFlightNum implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        return o1.getFlightNumber().compareTo(o2.getFlightNumber());
    }
    
}
