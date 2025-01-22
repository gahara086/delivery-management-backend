package com.example.delivery_management.service

import com.example.delivery_management.entity.Delivery
import com.example.delivery_management.repository.DeliveryRepository
import org.springframework.stereotype.Service

@Service
class DeliveryService(private val deliveryRepository: DeliveryRepository) {

    fun getAllDeliveries(): List<Delivery> = deliveryRepository.findAll()

    fun getDeliveryById(id: Long): Delivery =
        deliveryRepository.findById(id).orElseThrow { IllegalArgumentException("Delivery not found") }

    fun createDelivery(delivery: Delivery): Delivery = deliveryRepository.save(delivery)

    fun updateDelivery(id: Long, updatedDelivery: Delivery): Delivery {
        val existingDelivery = getDeliveryById(id)
        val newDelivery = existingDelivery.copy(
            recipientName = updatedDelivery.recipientName,
            address = updatedDelivery.address,
            status = updatedDelivery.status
        )
        return deliveryRepository.save(newDelivery)
    }

    fun deleteDelivery(id: Long) = deliveryRepository.deleteById(id)
}
