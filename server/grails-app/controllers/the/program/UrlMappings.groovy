package the.program

class UrlMappings {

    static mappings = {
        "/goals"(resources: "goal")
        "/activities"(resources: "activity")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
