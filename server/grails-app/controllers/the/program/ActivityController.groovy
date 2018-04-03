package the.program

import grails.gorm.transactions.Transactional
import grails.rest.*
import grails.converters.*
import groovy.transform.CompileStatic

@CompileStatic
class ActivityController extends RestfulController {
	static responseFormats = ['json', 'xml']

    ActivityController() {
        super(Activity)
    }

    /**
     * Saves a resource
     */
    @Override
    @Transactional
    def save() {
        Activity instance = createResource()
        instance.validate()
        if (instance.hasErrors()) {
            instance.errors.allErrors.each {
                println it
            }
        }
        respond instance
    }
}
