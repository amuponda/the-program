package the.program

import java.sql.Time
import java.time.Duration

class BootStrap {

    def init = { servletContext ->
        Role admin = new Role(authority: "ROLE_USER").save()
        User user = new User(username: "user", password: "pass").save()
        UserRole.create(user, admin, true)
        new Activity(name: "Test", metadata: "{}", repetition: Repetition.DAILY, time: new Time(System.currentTimeMillis()), duration: new Time(System.currentTimeMillis())).save()
    }

    def destroy = {
    }
}
