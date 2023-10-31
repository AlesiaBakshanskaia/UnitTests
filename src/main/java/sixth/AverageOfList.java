package sixth;

import java.util.List;

public class AverageOfList {
    public double getAverageOfList(List<Integer> list) {
        double sum = 0;
        if (list.size() == 0) return 0;
        else for (int i : list) {
            sum += i;
        }
        return sum / list.size();
    }
}
