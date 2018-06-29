package the.program

import groovy.json.JsonBuilder
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.springframework.context.MessageSource
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.AuthenticationFailureHandler

import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Slf4j
@CompileStatic
class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    /**
     * Configurable status code, by default: conf.rest.login.failureStatusCode?:HttpServletResponse.SC_FORBIDDEN
     */
    Integer statusCode
    MessageSource messageSource
    JsonBuilder builder
    /**
     * Called when an authentication attempt fails.
     * @param request the request during which the authentication attempt occurred.
     * @param response the response.
     * @param exception the exception which was thrown to reject the authentication request.
     */
    void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.debug "Setting status code to ${statusCode}"

        response.addHeader('WWW-Authenticate', 'Bearer')
        response.setContentType('application/json')
        if (exception instanceof BadCredentialsException) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN)
            PrintWriter out = response.getWriter()
            String msg = messageSource.getMessage("springSecurity.errors.login.badCredentials", null, request.locale)
            builder.call([message: msg])
            out.print(builder.toString())
            out.flush()
        } else {
            response.setStatus(statusCode)
        }
    }
}
