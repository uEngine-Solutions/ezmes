package ezmes.domain;

import ezmes.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "workOrders",
    path = "workOrders"
)
public interface WorkOrderRepository
    extends PagingAndSortingRepository<WorkOrder, Long> {}
