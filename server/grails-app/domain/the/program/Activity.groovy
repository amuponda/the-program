package the.program

import grails.compiler.GrailsCompileStatic

import java.sql.Time

@GrailsCompileStatic
class Activity {
    String name
    String metadata //used to reconstruct the repetition data
    Time duration
    Time time
    Repetition repetition
    boolean isHighPriority

    static mapping = {
        isHighPriority defaultValue: false
    }

    static constraints = {
        name blank: false, nullable: false
        metadata blank: false, nullable: false
        duration nullable: false
        time nullable: false
        repetition nullable: false
        isHighPriority nullable: false
    }
}
