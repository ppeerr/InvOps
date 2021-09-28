package com.ebtd.config

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureHealthCheck() {
    routing {
        get("/health") {
            call.respondText("App is running", ContentType.Text.Plain)
        }
    }
}