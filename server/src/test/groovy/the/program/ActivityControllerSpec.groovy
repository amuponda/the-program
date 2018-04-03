package the.program

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder
import spock.lang.Stepwise

import java.sql.Time
import java.time.Duration

@Stepwise
@SuppressWarnings('MethodName')
class ActivityControllerSpec extends HibernateSpec implements ControllerUnitTest<ActivityController> {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    def setup() {
        new Activity(name: "Test", metadata: "{}", repetition: Repetition.DAILY, time: new Time(System.currentTimeMillis()), duration: Duration.ofHours(1l)).save()
    }

    def cleanup() {
    }

    void "get list fo current activities"() {
        when: "A list of current activities is requested"
        controller.index()

        then: "The response is correct"
        response.json.size() == 1
        response.json[0].name == "Test"
        response.json[0].id == 1
    }

    void "get a particular activity from the list"() {
        when: "An activity is requested"
        params.id = 2l
        controller.show()

        then: "The activity is returned"
        response.status == 200
        response.json.id == 2l
    }

    void "save a new activity"() {
        setup:
        Map activity = [name: "Test", metadata: "{}", repetition: Repetition.DAILY, time: "03:48:12", duration: "03:48:12"]
        JsonBuilder builder = new JsonBuilder(activity)

        when: "I send request to add the new activity via JSON payload"
        request.method = "POST"
        request.json = builder.toString()
        controller.save()

        then: "The activity should be created"
        response.status == 201

    }
}