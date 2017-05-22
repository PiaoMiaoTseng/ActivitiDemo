package Test;

import java.util.List;  
  
import org.activiti.engine.ProcessEngine;  
import org.activiti.engine.ProcessEngines;  
import org.activiti.engine.task.Task;  
import org.junit.Test;  
  
public class TestQueryTask {  
  
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();  
  
    /** 
     * 学习查询个人的任务 
     */  
    @Test  
    public void testQueryTask() {  
        String assignee = "Steven";  
        List<Task> allTasks = processEngine.getTaskService()// 与正在执行的任务管理相关的Service  
                .createTaskQuery()// 创建任务查询对象  
                .taskAssignee(assignee)// 指定个人任务查询，指定办理人  
                .list();  
        if (allTasks != null) {  
            int taskNum = allTasks.size();  
            System.out.println("用户 " + assignee + " 共有" + taskNum + "个等待处理的任务");  
            if (taskNum > 0) {  
                for (Task task : allTasks) {  
                    System.out  
                            .println("########################################################");  
                    System.out.println("任务ID:" + task.getId());  
                    System.out.println("任务名称:" + task.getName());  
                    System.out.println("任务的创建时间:" + task.getCreateTime());  
                    System.out.println("任务的办理人:" + task.getAssignee());  
                    System.out.println("流程实例ID：" + task.getProcessInstanceId());  
                    System.out.println("执行对象ID:" + task.getExecutionId());  
                    System.out.println("流程定义ID:"  
                            + task.getProcessDefinitionId());  
                    System.out  
                            .println("########################################################");  
                }  
            }  
        } else {  
            System.out.println("查找用户 " + assignee + " 的任务出错。");  
        }  
    }  
}  