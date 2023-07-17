package alvarez.fernando.kotlincrud.domain.purchase

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@Document
class Purchase (
        //Named "Purchase" and not "Order" to not conflict with DB keywords

        @Id
        var id: UUID = UUID.randomUUID(),
        var totalValue: BigDecimal = BigDecimal.ZERO,
        var totalProducts: Int = 0,
        var purchasedAt: LocalDateTime = LocalDateTime.now(),

        var purchasedProducts: Collection<PurchasedProduct> = ArrayList()

) {

    fun calculateTotals() {
        this.totalProducts = this.purchasedProducts.size
        this.totalValue = BigDecimal.ZERO

        for (purchasedProduct in this.purchasedProducts) {
            this.totalValue = this.totalValue.add(purchasedProduct.paidPrice)
        }
    }

}