package the.program

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Goal {
    String name
    String categoryName
    Category category

    Long startingValue = 0l
    Long targetValue
    Unit unit
    String unitName
    Date startDate
    Date targetDate

    String importance
    String gain
    String price
    String risks
    String obstacles
    String whyNot
    String differently

    static hasMany = [milestones: Milestone, activities: Activity]

    static constraints = {
        name blank: false, nullable: false
        category nullable: false
        categoryName nullable: true, validator: { String val, Goal obj ->
            if (obj.category == Category.CUSTOM) {
                return val ? true : false
            }
            return true
        }
        targetValue nullable: false
        unit nullable: false
        unitName nullable: true, validator: { String val, Goal obj ->
            if (obj.unit == Unit.CUSTOM) {
                return val ? true : false
            }
            return true
        }
        startDate nullable: false
        targetDate nullable: false
    }
}
