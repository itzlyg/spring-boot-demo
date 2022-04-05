package com.triscit.flow.delegate;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ReviewNoApprove
 * @author xyb
 * @Description
 * @Date 2022/4/4 21:16
 */
public class ReviewNoApprove implements JavaDelegate {
    private Logger log = LoggerFactory.getLogger(ReviewNoApprove.class);

    @Override
    public void execute(DelegateExecution delegateExecution) {
        //可以发送消息给某人
        log.info("拒绝，userId是：{}",delegateExecution.getVariable("userId"));
    }
}
