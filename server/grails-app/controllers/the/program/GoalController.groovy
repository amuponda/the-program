package the.program


import grails.rest.*
import grails.converters.*
import groovy.transform.CompileStatic

@CompileStatic
class GoalController extends RestfulController {
	static responseFormats = ['json', 'xml']

    GoalController() {
        super(Goal)
    }
}
