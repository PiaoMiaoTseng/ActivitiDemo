package Test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.junit.Test;

public class TestActiviti {
	/**
	 * ʹ�ô��봴����������Ҫ��23�ű�
	 */
	
	public void createTable() {
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration
				.createStandaloneProcessEngineConfiguration();
		// �������ݿ�����
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration
				.setJdbcUrl("jdbc:mysql://localhost:3306/activiti?useUnicode=true&characterEncoding=utf8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("123456");

		/**
		 * public static final String DB_SCHEMA_UPDATE_FALSE =
		 * "false";//�����Զ���������Ҫ����� public static final String
		 * DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";//��ɾ�����ٴ����� public static
		 * final String DB_SCHEMA_UPDATE_TRUE = "true";//��������ڣ��Զ�������
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		// �������ĺ��Ķ���ProcessEngine����
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println("processEngine:" + processEngine);
	}

	/*
	 * ʹ�������ļ���������������Ҫ��23�ű�
	 */
	@Test
	public void createTable2() {
		// ProcessEngineConfiguration processEngineConfiguration =
		// ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		// //�������ĺ��Ķ���ProcessEngine����
		// ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();

		ProcessEngine processEngine = ProcessEngineConfiguration
				.createProcessEngineConfigurationFromResource("activiti.cfg.xml").buildProcessEngine();
		System.out.println("processEngine:" + processEngine);
	}
}