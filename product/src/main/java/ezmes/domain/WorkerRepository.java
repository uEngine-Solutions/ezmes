package ezmes.domain;

import ezmes.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "workers", path = "workers")
public interface WorkerRepository
    extends PagingAndSortingRepository<Worker, Long> {}
