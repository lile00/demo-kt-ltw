package com.example.demoktltw.controller

import com.example.demoktltw.annotation.CustomAnnotation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {
    @GetMapping("/test")
    fun test(): String {
        ShouldWork()
        return "test"
    }

    private fun Example() {
        println("inisde")
    }

    companion object {
        @CustomAnnotation
        @JvmStatic
        private fun ShouldWork() {
            println("STATIC PRINT")
        }
    }
}

