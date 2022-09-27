package ezmes.domain;

import ezmes.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "productions",
    path = "productions"
)
public interface ProductionRepository
    extends PagingAndSortingRepository<Production, Long> {}
