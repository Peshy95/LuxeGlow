package com.example.luxeglow.models

class Product {
    var name:String = ""
    var price:String = ""
    var imageUrl:String = ""
    var description:String = ""


    constructor(name: String, description:String, price: String, imageUrl: String) {
        this.name = name
        this.price = price
        this.imageUrl = imageUrl
        this.description = description

    }
}