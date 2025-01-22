package com.example.delivery_management.entity

import jakarta.persistence.*

@Entity
@Table(name = "deliveries")
data class Delivery(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "recipient_name")
    val recipientName: String,
    val address: String,
    val status: String
)

