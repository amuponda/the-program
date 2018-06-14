package the.program

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*
import groovy.transform.CompileStatic

@CompileStatic
@Secured(['ROLE_USER'])
class GoalController extends RestfulController {
	static responseFormats = ['json', 'xml']

    GoalController() {
        super(Goal)
    }

    protected Goal saveResource(Goal resource) {
        resource.save flush: true
    }
}
