package ezmes.domain;

import ezmes.domain.*;
import ezmes.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ProductionStatusRegistered extends AbstractEvent {

    private Long id;

    public ProductionStatusRegistered(Production aggregate) {
        super(aggregate);
    }

    public ProductionStatusRegistered() {
        super();
    }
    // keep

}
