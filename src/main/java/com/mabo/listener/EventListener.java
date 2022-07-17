package com.mabo.listener;

import com.mabo.event.Event;
import com.mabo.utils.AddEventListener;
import com.mabo.utils.EventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventListener {
    private  static Logger log = LoggerFactory.getLogger(EventListener.class);

    @AddEventListener(value = "eventId",position = EventType.AFTEREVENT)
    public void test1(String s) {
        log.info("test1执行成功，参数:"+s);
    }

    @AddEventListener(value = "reduce")
    public void test2(String s) {
        log.info("test2执行成功，参数:"+s);
    }
}
