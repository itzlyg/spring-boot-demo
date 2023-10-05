package com.triscit.flow.controller;

import com.triscit.data.vo.BaseResponse;
import com.triscit.flow.service.FlowDataService;
import com.triscit.flow.service.ImageService;
import com.triscit.flow.vo.request.FlowExamineRequest;
import com.triscit.flow.vo.request.FlowStartRequest;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.List;


/**
 * @author xyb
 * @Description
 * @Date 2022/4/4 23:16
 */
@RestController
@RequestMapping("/api/flowable")
public class FlowableController {

    @Resource
    private TaskService taskService;

    @Resource
    private ImageService imageService;

    @Resource
    private FlowDataService flowDataService;

    private final Logger log = LoggerFactory.getLogger(FlowableController.class);


    @PostMapping("/start_flow")
    public BaseResponse<String> start(@RequestBody @Valid FlowStartRequest request){
        String result = flowDataService.start(request);
        return BaseResponse.ok(result);
    }

    /**
     * .获取用户的任务
     *
     * @param userId 用户id
     */
    @PostMapping("/user_tasks/{userId}")
    public BaseResponse<String> getTasks(@PathVariable String userId) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee(userId).orderByTaskCreateTime().desc().list();
        return BaseResponse.ok(tasks.toString());
    }

    @PostMapping("/examine_flow")
    public BaseResponse<String> examine(@RequestBody @Valid FlowExamineRequest request){
        String result = flowDataService.examine(request);
        return BaseResponse.ok(result);
    }

    @PostMapping(value = "/flow_img/{processId}")
    public void genProcessDiagram(HttpServletResponse response, @PathVariable String processId) throws Exception {
        byte[] bs = imageService.generateImageByProcInstId(processId);
        MediaType type = MediaType.IMAGE_PNG;
        response.setContentType(type.toString());
        try (OutputStream out = response.getOutputStream()) {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bs));
            ImageIO.write(image, type.getSubtype(), out);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
