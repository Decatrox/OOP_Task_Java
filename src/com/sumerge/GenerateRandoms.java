import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateRandoms {
    private List<Integer> list;

    public List<Integer> generate(int desired_size, int number_of_options) {
        list = new ArrayList<Integer>();
        for (int i=1; i<number_of_options; i++) list.add(i);
        Collections.shuffle(list);
        list = list.subList(0, desired_size);

        return list;
    }
}
