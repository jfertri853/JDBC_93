package dao

import entity.Product

interface IProductDAO {
    fun createProduct(product: Product): Product?
}