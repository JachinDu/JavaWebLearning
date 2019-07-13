package com.jachin.providerdicket.service;


import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
//必须引入dubbo才有该注解（不仅要引入starter）
@Service //org.apache.dubbo.config.annotation.Service下的注解
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "《厉害了，我的国》";
    }
}
