package the.program

enum Category {

    WORK_CAREER("Work & Career"),
    HEALTH_WELLNESS("Health & Wellness"),
    LOVE_RELATIONSHIPS("Love & Relationships"),
    MONEY_FINANCE("Money & Finance"),
    FAMILY_FRIENDS("Family & Friends"),
    SPIRITUALITY_FAITH("Spirituality & Faith"),
    RECREATION_LIFESTYLE("Recreation & Lifestyle"),
    PERSONAL_GROWTH("Personal Growth"),
    CUSTOM("Custom")

    String label

    Category(String label) {
        this.label = label
    }
}