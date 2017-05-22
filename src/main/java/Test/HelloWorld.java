package Test;


import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class HelloWorld {
    
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
    
    /*
     *部署流程定义
     */
    @Test
    public void deploymentProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的Service
                        .createDeployment()//创建一个部署对象
                        .name("张三请假")//添加部署名称
                        
                        .addClasspathResource("diagrams/HelloWorld.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                        .deploy();//完成部署
        System.out.println("部署ID："+deployment.getId());
        System.out.println("部署名称:"+deployment.getName());
        
    }
    
    /*
     * 启动流程实例
     */
    @Test
    public void startProcessInstance(){
        //流程定义的key
        String processDefinitionKey = "ABC";
        ProcessInstance processInstance = processEngine.getRuntimeService()//与正在执行的流程实例和执行对象相关的Service
                        .startProcessInstanceByKey(processDefinitionKey);//使用流程定义的key启动流程实例，key对应HelloWorld.bpmn文件中的ID的属性值,使用key值启动，默认是按照最新版本的流程定义启动
                        
        System.out.println("流程实例ID:"+processInstance.getId());//流程实例ID
        System.out.println("流程定义ID:"+processInstance.getProcessDefinitionId());//流程定义ID
        
    }
    
//    @Test  
    public void testQueryTask() {  
        String assignee = "Steven123";  
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
    
    
    /*
     * 完成我的任务
     */
    //@Test
    public void completeMyPersonalTask(){
        //任务Id
        String taskId = "22502";
        processEngine.getTaskService()//与正在执行任务相关的Service
                        .complete(taskId);
        System.out.println("完成任务：任务Id："+taskId);
        
    }
    
    /*
     * 查询当前人的个人任务
     */
   // @Test
    public void findMyPersonalTask(){
        String assignee = "张三";
        List<Task> list = processEngine.getTaskService()//与正在执行任务相关的Service
                        .createTaskQuery()//创建任务查询对象
                        .taskAssignee(assignee)//指定个人任务查询，指定办理人
                        .list();
        
        if(list!=null && list.size()>0){
            for(Task task:list){
                System.out.println("任务ID："+task.getId());
                System.out.println("任务名称："+task.getName());
                System.out.println("任务创建时间："+task.getCreateTime());
                System.out.println("任务办理人："+task.getAssignee());
                System.out.println("流程实例ID："+task.getProcessInstanceId());
                System.out.println("执行对象ID："+task.getExecutionId());
                System.out.println("流程定义ID："+task.getProcessDefinitionId());
            }
        }
    }
}
	
	
	 