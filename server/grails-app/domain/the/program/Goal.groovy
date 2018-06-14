package the.program

import grails.compiler.GrailsCompileStatic
import grails.databinding.BindingFormat

@GrailsCompileStatic
class Goal {
    String name
    String categoryName
    Category category

    Long startingValue = 0l
    Long targetValue
    Unit unit
    String unitName
    @BindingFormat('dd/MM/yyyy')
    Date startDate
    @BindingFormat('dd/MM/yyyy')
    Date targetDate

    String importance
    String gain
    String price
    String risks
    String obstacles
    String whyNot
    String differently

    static hasMany = [milestones: Milestone, activities: Activity]

    static belongsTo = User

    static mapping = {
        milestones column: "goal_id", joinTable: false
        activities joinTable: [name: "goal_activities", key: "goal_id"]
    }

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
        importance nullable: true
        gain nullable: true
        price nullable: true
        risks nullable: true
        obstacles nullable: true
        whyNot nullable: true
        differently nullable: true
    }
}
