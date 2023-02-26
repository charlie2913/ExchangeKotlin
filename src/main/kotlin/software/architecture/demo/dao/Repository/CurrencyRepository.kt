package software.architecture.demo.dao.Repository

import org.springframework.data.repository.CrudRepository
import software.architecture.demo.dao.CurrencyDao

interface CurrencyRepository: CrudRepository<CurrencyDao, Long>