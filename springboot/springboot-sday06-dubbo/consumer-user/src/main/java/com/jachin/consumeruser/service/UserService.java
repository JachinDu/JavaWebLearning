package com.jachin.consumeruser.service;


import com.jachin.providerdicket.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service  //这是Spring的service
public class UserService {

    @Reference
    TicketService ticketService;

    public void hello() {
        String ticket = ticketService.getTicket();
        System.out.println("买到票了！"+ticket);
    }

}
