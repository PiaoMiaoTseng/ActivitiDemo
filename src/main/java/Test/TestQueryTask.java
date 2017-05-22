package Test;

import java.util.List;  
  
import org.activiti.engine.ProcessEngine;  
import org.activiti.engine.ProcessEngines;  
import org.activiti.engine.task.Task;  
import org.junit.Test;  
  
public class TestQueryTask {  
  
    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();  
  
    /** 
     * ѧϰ��ѯ���˵����� 
     */  
    @Test  
    public void testQueryTask() {  
        String assignee = "Steven";  
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
}  