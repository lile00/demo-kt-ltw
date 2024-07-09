package com.example.demoktltw

import org.springframework.beans.factory.annotation.Configurable
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Component
class RandomService(): IService {
    override fun testing(){
        println("RandomService is performing testing")
    }
}