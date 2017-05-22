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
     *�������̶���
     */
    @Test
    public void deploymentProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()//�����̶���Ͳ��������ص�Service
                        .createDeployment()//����һ���������
                        .name("�������")//��Ӳ�������
                        
                        .addClasspathResource("diagrams/HelloWorld.bpmn")//��classpath����Դ�м��أ�һ��ֻ�ܼ���һ���ļ�
                        .deploy();//��ɲ���
        System.out.println("����ID��"+deployment.getId());
        System.out.println("��������:"+deployment.getName());
        
    }
    
    /*
     * ��������ʵ��
     */
    @Test
    public void startProcessInstance(){
        //���̶����key
        String processDefinitionKey = "ABC";
        ProcessInstance processInstance = processEngine.getRuntimeService()//������ִ�е�����ʵ����ִ�ж�����ص�Service
                        .startProcessInstanceByKey(processDefinitionKey);//ʹ�����̶����key��������ʵ����key��ӦHelloWorld.bpmn�ļ��е�ID������ֵ,ʹ��keyֵ������Ĭ���ǰ������°汾�����̶�������
                        
        System.out.println("����ʵ��ID:"+processInstance.getId());//����ʵ��ID
        System.out.println("���̶���ID:"+processInstance.getProcessDefinitionId());//���̶���ID
        
    }
    
//    @Test  
    public void testQueryTask() {  
        String assignee = "Steven123";  
        List<Task> allTasks = processEngine.getTaskService()// ������ִ�е����������ص�Service  
                .createTaskQuery()// ���������ѯ����  
                .taskAssignee(assignee)// ָ�����������ѯ��ָ��������  
                .list();  
        if (allTasks != null) {  
            int taskNum = allTasks.size();  
            System.out.println("�û� " + assignee + " ����" + taskNum + "���ȴ����������");  
            if (taskNum > 0) {  
                for (Task task : allTasks) {  
                    System.out  
                            .println("########################################################");  
                    System.out.println("����ID:" + task.getId());  
                    System.out.println("��������:" + task.getName());  
                    System.out.println("����Ĵ���ʱ��:" + task.getCreateTime());  
                    System.out.println("����İ�����:" + task.getAssignee());  
                    System.out.println("����ʵ��ID��" + task.getProcessInstanceId());  
                    System.out.println("ִ�ж���ID:" + task.getExecutionId());  
                    System.out.println("���̶���ID:"  
                            + task.getProcessDefinitionId());  
                    System.out  
                            .println("########################################################");  
                }  
            }  
        } else {  
            System.out.println("�����û� " + assignee + " ���������");  
        }  
    }  
    
    
    /*
     * ����ҵ�����
     */
    //@Test
    public void completeMyPersonalTask(){
        //����Id
        String taskId = "22502";
        processEngine.getTaskService()//������ִ��������ص�Service
                        .complete(taskId);
        System.out.println("�����������Id��"+taskId);
        
    }
    
    /*
     * ��ѯ��ǰ�˵ĸ�������
     */
   // @Test
    public void findMyPersonalTask(){
        String assignee = "����";
        List<Task> list = processEngine.getTaskService()//������ִ��������ص�Service
                        .createTaskQuery()//���������ѯ����
                        .taskAssignee(assignee)//ָ�����������ѯ��ָ��������
                        .list();
        
        if(list!=null && list.size()>0){
            for(Task task:list){
                System.out.println("����ID��"+task.getId());
                System.out.println("�������ƣ�"+task.getName());
                System.out.println("���񴴽�ʱ�䣺"+task.getCreateTime());
                System.out.println("��������ˣ�"+task.getAssignee());
                System.out.println("����ʵ��ID��"+task.getProcessInstanceId());
                System.out.println("ִ�ж���ID��"+task.getExecutionId());
                System.out.println("���̶���ID��"+task.getProcessDefinitionId());
            }
        }
    }
}
	
	
	 