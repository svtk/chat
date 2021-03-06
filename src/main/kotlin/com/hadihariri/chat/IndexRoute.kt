package com.hadihariri.chat

import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.wasabifx.wasabi.routing.routeHandler

val indexRoute = routeHandler {

    val html = StringBuilder()

    html.appendHTML().html {
        head {
            styleLink("/css/bootstrap.min.css")
            styleLink("/css/font-awesome.min.css")
            styleLink("/css/app.css")
        }
        body {
            div("container") {
                div("row") {
                    div("col-md-2 sidebar") {
                        h5 { +"Users" }
                        ul("nav nav-sidebar") {
                            id = "users"
                        }
                        p {}
                        h5 { +"Rooms" }
                        ul("nav nav-sidebar") {
                            id = "rooms"
                        }
                        form {
                            id = "addRoom"
                            action = "#"
                            fieldSet {
                                input {
                                    id = "newRoom"
                                    classes = setOf("form-control")
                                    type = InputType.text
                                    placeholder = "Add Room"
                                    autoComplete = false
                                }
                            }
                        }

                    }
                    div("col-md-8 offset-md-2 main") {
                        h1 {
                            id ="currentRoom"
                        }
                        ul {
                            id = "currentPosts"
                            classes = setOf("list-group")
                        }
                        form {
                            id = "addPost"
                            action = "#"
                            fieldSet {
                                input {
                                    id = "newPost"
                                    classes = setOf("form-control")
                                    type = InputType.text
                                    autoComplete = false
                                }
                            }
                        }
                    }
                }
            }

        script(type = ScriptType.textJavaScript, src = "/js/bind.js")
        script(type = ScriptType.textJavaScript, src = "/js/app.js")
        }

    }
    response.send(html.toString(), "text/html")
}
