package com.ebtd

import com.ebtd.config.configureHealthCheck
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*
import io.ktor.serialization.*
import io.ktor.features.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.ebtd.plugins.*

class ApplicationTest {

    @Test
    fun testRoot() {
        withTestApplication(
            {
                configureHealthCheck()
            }
        ) {
            handleRequest(HttpMethod.Get, "/health").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("App is running", response.content)
            }
        }
    }
}