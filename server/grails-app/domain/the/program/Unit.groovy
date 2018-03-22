package the.program

enum Unit {
    KG("kg"),
    KM("km"),
    CM("cm"),
    YEARS("years"),
    MONTHS("months"),
    DAYS("days"),
    HOURS("hours"),
    MIN("min"),
    DOLLAR("\$"),
    STEPS("steps"),
    REPETITIONS("Repetitions"),
    LAPS("Laps"),
    CUSTOM("Custom")

    String label

    Unit(String label) {
        this.label = label
    }
}