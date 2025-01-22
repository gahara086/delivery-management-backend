package com.example.delivery_management.controller

import com.example.delivery_management.entity.Delivery
import com.example.delivery_management.service.DeliveryService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/deliveries")
class DeliveryController(private val deliveryService: DeliveryService) {

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllDeliveries(): ResponseEntity<List<Delivery>> =
        ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(deliveryService.getAllDeliveries())

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getDeliveryById(@PathVariable id: Long): ResponseEntity<Delivery> =
        ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(deliveryService.getDeliveryById(id))

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createDelivery(@RequestBody delivery: Delivery): ResponseEntity<Delivery> =
        ResponseEntity.status(HttpStatus.CREATED)
            .contentType(MediaType.APPLICATION_JSON)
            .body(deliveryService.createDelivery(delivery))

    @PutMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateDelivery(
        @PathVariable id: Long,
        @RequestBody updatedDelivery: Delivery
    ): ResponseEntity<Delivery> =
        ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(deliveryService.updateDelivery(id, updatedDelivery))

    @DeleteMapping("/{id}")
    fun deleteDelivery(@PathVariable id: Long): ResponseEntity<Void> {
        deliveryService.deleteDelivery(id)
        return ResponseEntity.noContent().build()
    }
}
