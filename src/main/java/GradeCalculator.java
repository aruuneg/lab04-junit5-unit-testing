public class GradeCalculator {

    /**
     * Нийлбэр онооноос үсгэн дүн тооцно.
     *
     * 90-100  -> A
     * 80-89.99 -> B
     * 70-79.99 -> C
     * 60-69.99 -> D
     * 0-59.99  -> F
     *
     * @param score нийлбэр оноо
     * @return үсгэн дүн
     * @throws IllegalArgumentException score 0-100 хязгаараас гарвал
     */
    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                    "Score must be between 0 and 100"
            );
        }

        if (score >= 90) {
            return "A";
        }

        if (score >= 80) {
            return "B";
        }

        if (score >= 70) {
            return "C";
        }

        if (score >= 60) {
            return "D";
        }

        return "F";
    }

    /**
     * Хичээлийн нийт оноог тооцно.
     *
     * Ирц:          0-10
     * Лаб+бие даалт: 0-40
     * Сорил 1:      0-10
     * Сорил 2:      0-10
     * Шалгалт:      0-30
     *
     * @return нийт оноо
     * @throws IllegalArgumentException аль нэг оноо
     *         зөвшөөрөгдсөн хязгаараас гарвал
     */
    public double totalScore(
            double att,
            double lab,
            double quiz1,
            double quiz2,
            double exam) {

        validateScore(att, 10, "Attendance");
        validateScore(lab, 40, "Lab");
        validateScore(quiz1, 10, "Quiz 1");
        validateScore(quiz2, 10, "Quiz 2");
        validateScore(exam, 30, "Exam");

        return att + lab + quiz1 + quiz2 + exam;
    }

    private void validateScore(
            double value,
            double max,
            String name) {

        if (value < 0 || value > max) {
            throw new IllegalArgumentException(
                    name + " score must be between 0 and " + max
            );
        }
    }
}