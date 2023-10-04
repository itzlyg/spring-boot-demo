package com.triscit.flow.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ReviewApprove
 * @author xyb
 * @Description
 * @Date 2022/4/4 21:16
 */
public class ReviewApprove implements JavaDelegate {
    private final Logger log = LoggerFactory.getLogger(ReviewApprove.class);
    @Override
    public void execute(DelegateExecution delegateExecution) {
        //可以发送消息给某人
        log.info("通过，userId是：{}", delegateExecution.getVariable("userId"));
    }
}
