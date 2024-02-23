package com.example.kotlindemo.JetPackComposed.RentHouse.Retrofit.Model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponce(
    @Json(name = "uid")
    val uid: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    @Json(name = "username")
    val username: String,
    @Json(name = "email")
    val email: String,
    @Json(name = "avatar")
    val avatar: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "phone_number")
    val phoneNumber: String,
    @Json(name = "social_insurance_number")
    val socialInsuranceNumber: String,
    @Json(name = "date_of_birth")
    val dateOfBirth: String,
    val employment: Employment,
    val address: Address
)

data class Employment(
    @Json(name = "title")
    val title: String,
    @Json(name = "key_skill")
    val keySkill: String
)

data class Address(
    @Json(name = "city")
    val city: String,
    @Json(name = "street_name")
    val streetName: String,
    @Json(name = "street_address")
    val streetAddress: String,
    @Json(name = "zip_code")
    val zipCode: String,
    @Json(name = "state")
    val state: String,
    @Json(name = "country")
    val country: String
)
