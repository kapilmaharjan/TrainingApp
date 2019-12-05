package app.frantic.trainingapp.network

data class Flower(
    var category: String = "",
    var price: Double,
    var instructions: String,
    var photo: String,
    var name: String,
    var productId: Int
)