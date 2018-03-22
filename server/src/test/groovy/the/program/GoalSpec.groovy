package the.program

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class GoalSpec extends Specification implements DomainUnitTest<Goal> {

    def setup() {
    }

    def cleanup() {
    }

    void "test domain instance"() {
        expect:
            domain != null
    }

    void "test custom category name"() {
        when:
        domain.category = Category.CUSTOM
        domain.categoryName = "Custom name"

        then:
        domain.validate(['categoryName'])

        when:
        domain.categoryName = null

        then:
        !domain.validate(['categoryName'])

        when:
        domain.categoryName = ""

        then:
        !domain.validate(['categoryName'])
    }

    void "test custom unit name"() {
        when:
        domain.unit = Unit.CUSTOM
        domain.unitName = "customs"

        then:
        domain.validate(['unitName'])

        when:
        domain.unitName = null

        then:
        !domain.validate(['unitName'])

        when:
        domain.unitName = ''

        then:
        !domain.validate(['unitName'])

    }
}
