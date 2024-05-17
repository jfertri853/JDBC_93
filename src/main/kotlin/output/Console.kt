package output

import entity.Product

class Console: IConsole {
    override fun showMessage(message: String, lineBreak: Boolean) {
        if (lineBreak) {
            println(message)
        } else {
            print(message)
        }

    }


    override fun showProduct(products: List<Product>?, productID: Int) {
        if (products != null) {
            for (product in products) {
                if (productID == product.id) {
                    println(product.toString())
                }
            }
        }

    }


    override fun showAllProducts(products: List<Product>?) {
        if (products != null) {
            for (product in products) {
                println(product.toString())
            }
        }

    }


}