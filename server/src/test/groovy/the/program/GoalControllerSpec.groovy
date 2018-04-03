package the.program

import grails.plugin.json.view.mvc.JsonViewResolver
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import groovy.json.JsonBuilder
import spock.lang.Specification

class GoalControllerSpec extends HibernateSpec implements ControllerUnitTest<GoalController> {

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    def setup() {
        Milestone milestone = new Milestone(name: "Test", targetValue: 150, targetDate: new Date() + 7)
        Goal goal = new Goal()
        goal.with {
            name = "Test"
            category = Category.MONEY_FINANCE
            targetValue = 300
            unit = Unit.DOLLAR
            startDate = new Date()
            targetDate = startDate + 14
        }
        goal.addToMilestones(milestone)
        goal.save()
    }

    def cleanup() {
    }

    void "get list of current goals"() {
        when: "A list of current goals is requested"
        controller.index()

        then: "The current goals are returned"
        response.json.size() == 1
        response.json[0].name == "Test"
        response.json[0].id == 1
        response.json[0].milestones.size() == 1
    }

    void "get a particular goal from the list"() {
        when: "A goal is requested"
        params.id = 2l
        controller.show()

        then: "The activity is returned"
        response.status == 200
        response.json.id == 2l
    }

    void "save a new goal"() {
        setup:
        Map milestone = [name: "Test", targetValue: 150, targetDate: new Date() + 7]
        Map goal = [name: "Test", category: Category.MONEY_FINANCE, targetValue: 300, unit: Unit.DOLLAR, startDate: new Date().format("dd/MM/yyyy"), targetDate: (new Date() + 14).format("dd/MM/yyyy")]
        //goal.milestones = [milestone]
        JsonBuilder builder = new JsonBuilder(goal)

        when: "I send request to add the new goal via JSON payload"
        request.method = "POST"
        request.json = builder.toString()
        controller.save()

        then:
        response.status == 201

    }
}