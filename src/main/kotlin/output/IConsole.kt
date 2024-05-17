package output

import entity.Product

interface IConsole {
    fun showMessage(message: String, lineBreak: Boolean)
    fun showProduct(products: List<Product>?, productID: Int)
    fun showAllProducts(products: List<Product>?)
}