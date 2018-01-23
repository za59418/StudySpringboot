package com.zxl.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
	private static final Logger logger = LoggerFactory.getLogger(SchedulerTask.class);
	private int count=0;

	/**
	 * @Scheduled 注解用于标注这个方法是一个定时任务的方法，
	 * 有多种配置可选。cron支持cron表达式，指定任务在特定时间执行；
	 * fixedRate以特定频率执行任务；fixedRateString以string的形式配置执行频率。
	 */
    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
        
        // 间隔2分钟,执行任务     
        Thread current = Thread.currentThread();  
        System.out.println("定时任务1:"+current.getId());
        logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }
}
