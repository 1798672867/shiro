

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestApp {
	
	public static void main(String[] args) {
		
		String username = "zhangsan";
		String password = "123456";
		
		//1.����SecurityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.�ӹ����õ�SecurityManager
		SecurityManager securitymanager=factory.getInstance();
		//3.��securitymanager�󶨵���ǰ�߳�
		SecurityUtils.setSecurityManager(securitymanager);
		//4.ȡ����ǰ subject
		Subject subject = SecurityUtils.getSubject();
		//5.��װ�û���������
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//6.���е�¼��֤
		try {
			subject.login(token);
			
			System.out.println("�Ƿ���֤�ɹ�:"+subject.isAuthenticated());
		} catch (AuthenticationException e) {
			System.out.println("�û������������!");
		}
	
//		a();
//		b();
//		
		
	}
	static void a() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println( subject);
	}
	static void b() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println( subject);
	}

}
