package com.example

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import groovy.transform.CompileStatic
import io.micronaut.spring.boot.starter.EnableMicronaut
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling

@CompileStatic
@EnableScheduling
@EnableMicronaut
@ComponentScan(basePackages = "com.example")
class Application extends GrailsAutoConfiguration {
    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }
}
