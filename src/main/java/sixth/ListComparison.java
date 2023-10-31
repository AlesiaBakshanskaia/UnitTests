package sixth;

import java.util.List;

public class ListComparison {
    AverageOfList averageOfList = new AverageOfList();

    public void compareLists(List<Integer> list1, List<Integer> list2) {
        if (averageOfList.getAverageOfList(list1) > averageOfList.getAverageOfList(list2)) {
            System.out.print("Первый список имеет большее среднее значение");
        }
        else if (averageOfList.getAverageOfList(list1) < averageOfList.getAverageOfList(list2)) {
            System.out.print("Второй список имеет большее среднее значение");
        }
        else System.out.print("Средние значения равны");
    }

}
