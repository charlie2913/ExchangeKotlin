package software.architecture.demo.dao.Repository
import org.springframework.data.repository.PagingAndSortingRepository
import software.architecture.demo.dao.CurrencyDao

interface CurrenciesRepository : PagingAndSortingRepository<CurrencyDao, Long> {}