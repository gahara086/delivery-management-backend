package com.example.delivery_management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example.delivery_management"])
class DeliveryManagementApplication

fun main(args: Array<String>) {
    runApplication<DeliveryManagementApplication>(*args)
}