package ezmes.infra;

import ezmes.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class MaterialsHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Materials>> {

    @Override
    public EntityModel<Materials> process(EntityModel<Materials> model) {
        return model;
    }
}
