package com.hmlr.api

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.concurrent.thread


/**
 * Our Spring Boot application.
 */
@SpringBootApplication
open class Server

/**
 * Starts our Spring Boot application.
 */
fun main(args: Array<String>) {
    //Check required env vars exist
    require(System.getenv("CONFIG_RPC_HOST") != null) { "CONFIG_RPC_HOST env var was not set." }
    require(System.getenv("CONFIG_RPC_PORT") != null) { "CONFIG_RPC_PORT env var was not set." }
    require(System.getenv("CONFIG_RPC_USERNAME") != null) { "CONFIG_RPC_USERNAME env var was not set." }
    require(System.getenv("CONFIG_RPC_PASSWORD") != null) { "CONFIG_RPC_PASSWORD env var was not set." }
    require(System.getenv("CASE_MANAGEMENT_API_URL") != null) { "CASE_MANAGEMENT_API_URL env var was not set." }
    require(System.getenv("HMLR_PARTY_ORGANISATION") != null) { "HMLR_PARTY_ORGANISATION env var was not set." }
    require(System.getenv("HMLR_PARTY_LOCALITY") != null) { "HMLR_PARTY_LOCALITY env var was not set." }
    require(System.getenv("HMLR_PARTY_COUNTRY") != null) { "HMLR_PARTY_COUNTRY env var was not set." }

    //Run main api
    thread(start=true, name="API") {
        SpringApplication.run(Server::class.java, *args)
    }
}