package sixth;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
public class TestListComparationByAverage {
    static ListComparison listComparison;

    @BeforeAll
    static void setUp() {
        listComparison = new ListComparison();
    }

    @ParameterizedTest
    @ArgumentsSource(AverageArgumentsProvider.class)
    public void testAverageValue(List<Integer> list, double result) {
        AverageOfList averageOfList = new AverageOfList();
        double average = averageOfList.getAverageOfList(list);

        assertThat(average).isEqualTo(result);
    }

    static class AverageArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(List.of(10, 20, 30), 20),
                    Arguments.of(List.of(2, 3), 2.5),
                    Arguments.of(List.of(), 0),
                    Arguments.of(List.of(-10, -20, 30), 0)
            );
        }
    }


    @ParameterizedTest
    @ArgumentsSource(CompareArgumentsProvider.class)
    public void testAverageList1Bigger(List<Integer> list1, List<Integer> list2) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        listComparison.compareLists(list1, list2);

        assertThat(out.toString()).isEqualTo("Первый список имеет большее среднее значение");

        System.setOut(null);
    }
    @ParameterizedTest
    @ArgumentsSource(CompareArgumentsProvider.class)
    public void testAverageList2Bigger(List<Integer> list1, List<Integer> list2) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        listComparison.compareLists(list2, list1);

        assertThat(out.toString()).isEqualTo("Второй список имеет большее среднее значение");

        System.setOut(null);
    }

    static class CompareArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of(List.of(10, 20, 31), List.of(10, 20, 30)),
                    Arguments.of(List.of(2, 3), List.of()),
                    Arguments.of(List.of(-2, -2 ), List.of(-2, -3))
            );
        }
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    public void testEqualAverageLists(List<Integer> list1, List<Integer> list2) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        listComparison.compareLists(list1, list2);

        assertThat(out.toString()).isEqualTo("Средние значения равны");

        System.setOut(null);
    }
    static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(List.of(10, 20, 31), List.of(10, 20, 31)),
                Arguments.of(List.of(10, 21, 30), List.of(10, 20, 31)),
                Arguments.of(List.of(), List.of()),
                Arguments.of(List.of(-2, -2 ), List.of(-2, -2))
        );
    }

}
