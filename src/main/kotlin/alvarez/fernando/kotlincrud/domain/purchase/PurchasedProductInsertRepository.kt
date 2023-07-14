package alvarez.fernando.kotlincrud.domain.purchase

import alvarez.fernando.kotlincrud.extensions.repository.ReactiveInsertRepository
import org.springframework.data.r2dbc.core.R2dbcEntityOperations
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class PurchasedProductInsertRepository(entityOperations: R2dbcEntityOperations) : ReactiveInsertRepository<PurchasedProduct, UUID>(entityOperations)