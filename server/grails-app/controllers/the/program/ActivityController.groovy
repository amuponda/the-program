package the.program

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController
import groovy.transform.CompileStatic

@CompileStatic
@Secured(['ROLE_USER'])
class ActivityController extends RestfulController {
	static responseFormats = ['json', 'xml']

    ActivityController() {
        super(Activity)
    }
}
