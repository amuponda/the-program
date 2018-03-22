package the.program

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Milestone {

    String name
    Long targetValue
    Date targetDate

    static belongsTo = Goal

    static constraints = {
        name blank: false, nullable: false
        targetValue nullable: false
        targetDate nullable: false
    }
}
