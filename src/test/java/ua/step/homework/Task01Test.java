package ua.step.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.step.homework.Task01;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task01Test {
    private static class Size {
        int columns;
        int rows;

        Size(int columns, int rows) {
            this.columns = columns;
            this.rows = rows;
        }

        int getColumns() {
            return columns;
        }

        int getRows() {
            return rows;
        }
    }

    private static Stream<Arguments> sourceForCreateOne() {
        return Stream.of(
                Arguments.of(new Size(2, 2), new int[][]{{1, 0}, {0, 1}}),
                Arguments.of(new Size(3, 3), new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}})
        );
    }

    private static Stream<Arguments> sourceForCreateNull() {
        return Stream.of(
                Arguments.of(new Size(2, 2), new int[][]{{0, 0}, {0, 0}}),
                Arguments.of(new Size(3, 3), new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}})
        );
    }

    private static Stream<Arguments> sourceForSumMatrix() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 1}, {1, 1}}, new int[][]{{2, 2}, {2, 2}},
                        new int[][]{{3, 3}, {3, 3}}),
                Arguments.of(
                        new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}},
                        new int[][]{{3, 3, 3}, {3, 3, 3}, {3, 3, 3}}
                )
        );
    }

    private static Stream<Arguments> sourceForProductMatrix() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2}, {3, 4}}, new int[][]{{4, 3}, {2, 1}},
                        new int[][]{{8, 5}, {20, 13}}),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}},
                        new int[][]{{30, 24, 18}, {84, 69, 54}, {138, 114, 90}}
                )
        );
    }

    private static Stream<Arguments> sourceForProductMatrixScalar() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2}, {3, 4}}, 2,
                        new int[][]{{2, 4}, {6, 8}}),
                Arguments.of(
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 2,
                        new int[][]{{2, 4, 6}, {8, 10, 12}, {14, 16, 18}}
                )
        );
    }

    private static Stream<Arguments> sourceForDeterminant() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 2}, {3, 4}}, -2),
                Arguments.of(new int[][]{{9, 2, 3}, {4, 5, 6}, {7, 8, 9}}, -24)
        );
    }

    @ParameterizedTest
    @DisplayName("Test createOneMethod")
    @MethodSource("sourceForCreateOne")
    void testCreateOne(Size size, int[][] expected) {
        int[][] actual = Task01.createOne(size.getRows(), size.getColumns());
        assertEquals(size.rows, actual.length);
        assertEquals(size.columns, actual[0].length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Метод создания единичной матрицы реализован не верно");
        }
    }

    @ParameterizedTest
    @DisplayName("Test createOneNull")
    @MethodSource("sourceForCreateNull")
    void testCreateNull(Size size, int[][] expected) {
        int[][] actual = Task01.createNull(size.getRows(), size.getColumns());
        assertEquals(size.rows, actual.length);
        assertEquals(size.columns, actual[0].length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Метод создания нулевой матрицы реализован не верно");
        }
    }

    @ParameterizedTest
    @DisplayName("Test sumMatrix")
    @MethodSource("sourceForSumMatrix")
    void testSumMatrix(int[][] one, int[][] two, int[][] expected) {
        int[][] actual = Task01.sumMatrix(one, two);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Метод вычисления суммы дву матриц реализован не верно");
        }
    }

    @ParameterizedTest
    @DisplayName("Test productMatrix")
    @MethodSource("sourceForProductMatrix")
    void testProductMatrix(int[][] one, int[][] two, int[][] expected) {
        int[][] actual = Task01.productMatrix(one, two);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Метод вычисления произведения матрицы на матрицу реализован не верно");
        }
    }

    @ParameterizedTest
    @DisplayName("Test productMatrix scalar")
    @MethodSource("sourceForProductMatrixScalar")
    void testProductMatrixScalar(int[][] one, int num, int[][] expected) {
        int[][] actual = Task01.productMatrix(one, num);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i], "Метод вычисления произведения матрицы на скаляр реализован не верно");
        }
    }

    @ParameterizedTest
    @DisplayName("Test determinant")
    @MethodSource("sourceForDeterminant")
    void testDeterminant(int[][] matrix, int expected) {
        int actual = Task01.determinant(matrix);
        assertEquals(expected, actual, "Метод вычисления детерминанта реализован не верно");
    }
}
