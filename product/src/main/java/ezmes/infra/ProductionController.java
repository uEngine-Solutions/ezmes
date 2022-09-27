package ezmes.infra;

import ezmes.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/productions")
@Transactional
public class ProductionController {

    @Autowired
    ProductionRepository productionRepository;

    @RequestMapping(
        value = "productions/{id}/complete",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Production complete(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /production/complete  called #####");
        Optional<Production> optionalProduction = productionRepository.findById(
            id
        );

        optionalProduction.orElseThrow(() -> new Exception("No Entity Found"));
        Production production = optionalProduction.get();
        production.complete();

        productionRepository.save(production);
        return production;
    }
    // keep
}
