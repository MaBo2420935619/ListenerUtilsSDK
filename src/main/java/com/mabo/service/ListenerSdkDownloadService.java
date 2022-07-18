package com.mabo.service;

import com.mabo.dao.HistoryDao;
import com.mabo.entity.History;
import com.mabo.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Service
public class ListenerSdkDownloadService {
    private  static Logger log = LoggerFactory.getLogger(ListenerSdkDownloadService.class);
    @Resource
    private HistoryDao historyDao;
    @Resource
    private RedisTemplate redisTemplate;

    public  boolean setListenerSdkDownload (String ip,String sdkName,int max){
        boolean success=false;
        History history = new History();
        history.setIp(ip);
        history.setSdkname(sdkName);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String nowString = sdf.format(now);
        try {
            now=sdf.parse(nowString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int num=0;
        String key="download-"+ip+"-"+sdkName+"-"+sdf.format(now);
        Object o = redisTemplate.opsForValue().get(key);
        if (o!=null){
            num=(int)o;
        }else {
            Date endData = DateUtils.addDay(now, 1);
            Map map = historyDao.queryById(ip,sdkName,now,endData);
            Date date=null;
            if (map!=null){
                num= (int)map.get("num");
                date = (Date) map.get("time");
                String format = sdf.format(date);
                try {
                    date=sdf.parse(format);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (now.getTime()==date.getTime()){
                    if (num>=max){
                        log.info(ip+"下载次数已达上限sdk"+sdkName);
                        return false;
                    }
                }
            }
        }
        if (num>=max){
            log.info(ip+"下载次数已达上限sdk"+sdkName);
            return false;
        }
        num++;
        history.setNumber(num);
        history.setTime(new Date());
        int insert = historyDao.insert(history);
        redisTemplate.opsForValue().set(key,num);
        success=true;
        log.info(ip+"下载sdk"+sdkName);
        return success;
    }
}
