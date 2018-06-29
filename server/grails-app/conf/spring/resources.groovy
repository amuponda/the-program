import groovy.json.JsonBuilder
import the.program.RestAuthenticationFailureHandler
import the.program.UserPasswordEncoderListener

import javax.servlet.http.HttpServletResponse

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    restAuthenticationFailureHandler(RestAuthenticationFailureHandler) {
        statusCode = HttpServletResponse.SC_UNAUTHORIZED
        builder = new JsonBuilder()
        messageSource = ref('messageSource')
    }
}
