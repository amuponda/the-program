package the.program

enum Repetition {
    ONE_TIME("One-Time"),
    DAILY("Daily"),
    WEEKLY("Weekly"),
    MONTHLY("Monthly"),
    SPECIFIC_DAYS("Specific Days")

    String label

    Repetition(String label) {
        this.label = label
    }
}