package the.program

class UrlMappings {

    static mappings = {
        "/api/goals"(resources: "goal")
        "/api/activities"(resources: "activity")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
