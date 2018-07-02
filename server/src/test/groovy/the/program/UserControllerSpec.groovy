package the.program

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Unroll

import javax.servlet.http.HttpServletResponse

class UserControllerSpec extends HibernateSpec implements ControllerUnitTest<UserController> {

    def setup() {
        new User(passwordExpired: false, username: "test@theprogram.com.au", accountLocked: false, password: "test", accountExpired: false, enabled: true).save(flush: true)
    }

    def cleanup() {
    }

    def "test getting the current user"() {
        given:
        controller.springSecurityService = Stub(SpringSecurityService) {
            getPrincipal() >> [id: 1]
        }

        when:
        controller.index()

        then:
        response.json.username == "test@theprogram.com.au"
    }

    def "test only GET method allowed"() {
        when:
        request.method = 'POST'
        controller.index()

        then:
        response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED
    }
}