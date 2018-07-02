package the.program

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*

@Secured(['ROLE_USER'])
@Transactional(readOnly = true)
class UserController {
	static responseFormats = ['json', 'xml']

    static allowedMethods = [index: 'GET']

    def springSecurityService

    def index() {
        def user = User.get(springSecurityService.getPrincipal().id)
        respond(user)
    }
}
