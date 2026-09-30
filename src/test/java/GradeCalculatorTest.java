import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    private final GradeCalculator calculator = new GradeCalculator();

    @Test
    @DisplayName("90 оноо A дүн буцаана")
    void score90ShouldReturnA() {
        // Arrange
        double score = 90;

        // Act
        String result = calculator.letterGrade(score);

        // Assert
        assertEquals("A", result);
    }

    @Test
    @DisplayName("80 оноо B дүн буцаана")
    void score80ShouldReturnB() {
        // Arrange
        double score = 80;

        // Act
        String result = calculator.letterGrade(score);

        // Assert
        assertEquals("B", result);
    }

    @Test
    @DisplayName("70 оноо C дүн буцаана")
    void score70ShouldReturnC() {
        // Arrange
        double score = 70;

        // Act
        String result = calculator.letterGrade(score);

        // Assert
        assertEquals("C", result);
    }

    @Test
    @DisplayName("60 оноо D дүн буцаана")
    void score60ShouldReturnD() {
        // Arrange
        double score = 60;

        // Act
        String result = calculator.letterGrade(score);

        // Assert
        assertEquals("D", result);
    }

    @Test
    @DisplayName("59.99 оноо F дүн буцаана")
    void scoreBelow60ShouldReturnF() {
        // Arrange
        double score = 59.99;

        // Act
        String result = calculator.letterGrade(score);

        // Assert
        assertEquals("F", result);
    }

    @Test
    @DisplayName("100-аас их оноо exception үүсгэнэ")
    void scoreAbove100ShouldThrowException() {
        // Arrange
        double score = 100.01;

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(score)
        );
    }

    @Test
    @DisplayName("Сөрөг оноо exception үүсгэнэ")
    void negativeScoreShouldThrowException() {
        // Arrange
        double score = -0.01;

        // Act & Assert
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.letterGrade(score)
        );
    }

    @Test
    @DisplayName("Бүх бүрэлдэхүүний дээд онооны нийлбэр 100 байна")
    void maximumTotalScoreShouldBe100() {
        // Arrange
        double attendance = 10;
        double lab = 40;
        double quiz1 = 10;
        double quiz2 = 10;
        double exam = 30;

        // Act
        double result = calculator.totalScore(
                attendance,
                lab,
                quiz1,
                quiz2,
                exam
        );

        // Assert
        assertEquals(100.0, result);
    }

    @Test
    @DisplayName("Бүх бүрэлдэхүүн 0 үед нийт оноо 0 байна")
    void zeroTotalScoreShouldBeZero() {
        // Act
        double result = calculator.totalScore(0, 0, 0, 0, 0);

        // Assert
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("Лабораторийн оноо 40-өөс их үед exception үүсгэнэ")
    void labScoreAboveMaximumShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.totalScore(10, 40.01, 10, 10, 30)
        );
    }

    @Test
    @DisplayName("Шалгалтын оноо сөрөг үед exception үүсгэнэ")
    void negativeExamScoreShouldThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.totalScore(10, 40, 10, 10, -0.01)
        );
    }

    @ParameterizedTest(name = "{0} оноо -> {1}")
    @CsvSource({
            "100, A",
            "90, A",
            "89.99, B",
            "80, B",
            "79.99, C",
            "70, C",
            "69.99, D",
            "60, D",
            "59.99, F",
            "0, F"
    })
    @DisplayName("Онооны хилийн утгуудад зөв үсгэн дүн буцаана")
    void letterGradeBoundaryValues(double score, String expectedGrade) {
        // Act
        String actualGrade = calculator.letterGrade(score);

        // Assert
        assertEquals(expectedGrade, actualGrade);
    }

    @ParameterizedTest(
            name = "Ирц={0}, лаб={1}, сорил1={2}, сорил2={3}, шалгалт={4} -> нийт={5}"
    )
    @CsvSource({
            "10, 40, 10, 10, 30, 100",
            "5, 20, 5, 5, 15, 50",
            "0, 0, 0, 0, 0, 0",
            "8, 30, 8, 9, 25, 80"
    })
    @DisplayName("Онооны бүрэлдэхүүнүүдийн нийлбэрийг зөв тооцно")
    void totalScoreParameterizedTest(
            double attendance,
            double lab,
            double quiz1,
            double quiz2,
            double exam,
            double expectedTotal) {

        // Act
        double actualTotal = calculator.totalScore(
                attendance,
                lab,
                quiz1,
                quiz2,
                exam
        );

        // Assert
        assertEquals(expectedTotal, actualTotal);
    }
}