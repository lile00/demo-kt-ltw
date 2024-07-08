package com.example.demoktltw.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory

@Aspect
class CustomAnnotationAspect {
    @Around("@annotation(com.example.demoktltw.annotation.CustomAnnotation)")
    fun example(pjp: ProceedingJoinPoint): Any? {
        log.info("INSIDE BEFORE")
        var result: Any? = null
        try {
            result = pjp.proceed()
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
