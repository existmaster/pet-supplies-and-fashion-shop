package pet.supplies.and.fashion.shop.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import pet.supplies.and.fashion.shop.OrderManagementApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { OrderManagementApplication.class })
public class CucumberSpingConfiguration {}
