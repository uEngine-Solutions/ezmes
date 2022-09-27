package ezmes.domain;

import ezmes.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "materials", path = "materials")
public interface MaterialsRepository
    extends PagingAndSortingRepository<Materials, Long> {}
