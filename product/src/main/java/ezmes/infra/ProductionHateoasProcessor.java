package ezmes.infra;

import ezmes.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProductionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Production>> {

    @Override
    public EntityModel<Production> process(EntityModel<Production> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/complete")
                .withRel("complete")
        );

        return model;
    }
}
