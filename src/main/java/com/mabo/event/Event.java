package com.mabo.event;

import com.mabo.utils.AddEvent;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Data
public class Event {
    private  static Logger log = LoggerFactory.getLogger(Event.class);

    /**
     * @Description : 如果该方法被调用了，则AddEventListener修饰的方法也执行
     */
    @AddEvent("eventId")
    public String event(String s){
        log.info("addEvent执行,参数:"+s);
        return s;
    }
    @AddEvent("reduce")
    public void reduce(String s){
        log.info("reduce执行成功,参数:"+s);
    }

}
