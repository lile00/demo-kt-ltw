package com.example.demoktltw.aspect

import com.example.demoktltw.IService
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Configurable
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.aspectj.EnableSpringConfigured

@Configuration
@EnableSpringConfigured
class CustomAnnotationAspectConfiguration

@Aspect
@Configurable
class CustomAnnotationAspect {
   @Autowired
   lateinit var randomService: IService

   @Autowired
   @Value("\${lpm.bpmn.resource-location}") private val resourceLocation: String = ""

    @Around("@annotation(com.example.demoktltw.annotation.CustomAnnotation)")
    fun example(pjp: ProceedingJoinPoint): Any? {
        log.info("INSIDE BEFORE")
        var result: Any? = null
        try {
            result = pjp.proceed()
            randomService.testing()
        } catch (e: Throwable) {
            log.error(e.message)
        }
        log.info("INSIDE AFTER")
        return result
    }

    companion object {
        private val log = LoggerFactory.getLogger(CustomAnnotationAspect::class.java)
    }
}
