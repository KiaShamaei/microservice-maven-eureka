package ir.digixo.controller;

import ir.digixo.entity.NotificationEntity;
import ir.digixo.notification.NoticationRequest;
import ir.digixo.repository.NotificationRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/")
public class NotificationController
{
    private final NotificationRepository repo;

    public NotificationController(NotificationRepository repo) {
        this.repo = repo;
    }
    @PostMapping("add")
    public String addNotification(@RequestBody NoticationRequest model){
        var entity = NotificationEntity
                .builder().
                message(model.getMessage()).
                sender(model.getSender()).
                senderAt(model.getSenderAt()).build();
        repo.save(entity);
        return "done";
    }

}
