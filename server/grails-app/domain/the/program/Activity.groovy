package the.program

import java.sql.Time
import java.time.Duration

class Activity {
    String name
    String metadata
    Duration duration
    Time time
    Repetition repetition
    Boolean highPriority = false

    static constraints = {
        name blank: false, nullable: false
        metadata blank: false, nullable: false
        duration nullable: false
        time nullable: false
        repetition nullable: false
    }
}
