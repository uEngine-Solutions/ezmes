package ezmes.common;

import ezmes.WorkOrderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { WorkOrderApplication.class })
public class CucumberSpingConfiguration {}
