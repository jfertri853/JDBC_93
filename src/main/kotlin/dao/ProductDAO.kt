package dao

import entity.Product
import output.IConsole
import java.sql.SQLException
import javax.sql.DataSource

class ProductDAO(private val console: IConsole, private val dataSource: DataSource): IProductDAO {

    override fun createProduct(product: Product): Product? {
        val sql = "INSERT INTO PRODUCTS (id, name, price, description, brand, category) VALUES (?, ?, ?, ?, ?, ?)"

        return try {
            dataSource.connection.use { conn ->
                conn.prepareStatement(sql).use { stmt ->
                    stmt.setString(1, product.id.toString())
                    stmt.setString(2, product.name)
                    stmt.setString(3, product.price.toString())
                    stmt.setString(4, product.description)
                    stmt.setString(5, product.brand)
                    stmt.setString(6, product.category)

                    val rs = stmt.executeUpdate()
                    if (rs == 1) {
                        product
                    } else {
                        console.showMessage("*ERROR* insert query failed! ($rs records inserted)", true)
                        null
                    }

                }
            }

        } catch (e: SQLException) {
            console.showMessage("*ERROR* insert query failed! (${e.message})", true)
            null
        }
    }

}