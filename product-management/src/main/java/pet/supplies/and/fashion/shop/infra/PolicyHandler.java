package pet.supplies.and.fashion.shop.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pet.supplies.and.fashion.shop.config.kafka.KafkaProcessor;
import pet.supplies.and.fashion.shop.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    ProductRepository productRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductRegistered'"
    )
    public void wheneverProductRegistered_ProductSearchPolicy(
        @Payload ProductRegistered productRegistered
    ) {
        ProductRegistered event = productRegistered;
        System.out.println(
            "\n\n##### listener ProductSearchPolicy : " +
            productRegistered +
            "\n\n"
        );
        // Sample Logic //

    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ProductRegistered'"
    )
    public void wheneverProductRegistered_ProductViewPolicy(
        @Payload ProductRegistered productRegistered
    ) {
        ProductRegistered event = productRegistered;
        System.out.println(
            "\n\n##### listener ProductViewPolicy : " +
            productRegistered +
            "\n\n"
        );
        // Sample Logic //

    }
}
//>>> Clean Arch / Inbound Adaptor
