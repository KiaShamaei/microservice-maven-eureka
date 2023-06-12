package ir.digixo.controller;

import ir.digixo.notification.NoticationRequest;
import ir.digixo.repository.NotificationRepository;
import ir.digixo.service.NotifiacationProducer;
import ir.digixo.service.NotificationConsumer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/")
public class NotificationController
{
    private final NotificationRepository repo;
    private final NotifiacationProducer producer;
    private final NotificationConsumer consumer;

    public NotificationController(NotificationRepository repo,
                                  NotifiacationProducer producer,
                                  NotificationConsumer consumer) {
        this.repo = repo;
        this.producer = producer;
        this.consumer = consumer;
    }
    @PostMapping("add")
    public String addNotification(@RequestBody NoticationRequest model) throws InterruptedException {
        consumer.save(model);
        return "done";
    }
    // http://localhost:8080/api/v1/publish?message=hello
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");
    }

}
