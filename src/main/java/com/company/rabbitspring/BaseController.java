package com.company.rabbitspring;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.logging.Logger;

@Controller
public class BaseController {


    Logger logger = Logger.getLogger("BaseController.class");

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/base")
    @ResponseBody String queueOne(@PathParam(value = "msg") String msg){
        logger.info(msg);
        amqpTemplate.convertAndSend("queueOne", msg);
        Message message = (Message) amqpTemplate.receiveAndConvert();
        return "Message sended " + message.toString();
    }

}
