package com.afaqy.ptt.domain.features.usermanagement.model

class User(
    val id: Long, val name: String, val email: String, val mobile: String,
    val isRegisteredUser: Boolean
)