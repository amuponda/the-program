package the.program

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*

import javax.servlet.http.HttpServletResponse

@Integration
@Rollback
class UserControllerIntSpec extends Specification {

    @Shared RestBuilder rest = new RestBuilder()

    def setup() {
    }

    def cleanup() {
    }

    def "test /api/user is secured"() {
        when:
        def resp = rest.get("http://localhost:${serverPort}/api/user") {
            accept("application/json")
            contentType("application/json")
        }

        then:
        resp.status == HttpServletResponse.SC_UNAUTHORIZED
        resp.json.status == HttpServletResponse.SC_UNAUTHORIZED
        resp.json.error == "Unauthorized"
        resp.json.message == "No message available"
        resp.json.path == "/api/user"
    }
}
