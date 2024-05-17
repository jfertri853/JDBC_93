import dao.ProductDAO
import db_connection.DataSourceFactory
import entity.Product
import output.Console


fun main() {
    val dataSource = DataSourceFactory.getDS(DataSourceFactory.DataSourceType.HIKARI)
    val console = Console()
    val product = Product(
        15,
        "Smartphone",
        999.99f,
        "The latest smartphone model",
        "Apple",
        "Electronics"
    )

    val productID = ProductDAO(console, dataSource).createProduct(product)

    console.showMessage("Product ID: $productID", true)

}