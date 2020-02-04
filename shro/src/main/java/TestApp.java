

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
		
		//1.创建SecurityManager
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		//2.从工厂得到SecurityManager
		SecurityManager securitymanager=factory.getInstance();
		//3.把securitymanager绑定到当前线程
		SecurityUtils.setSecurityManager(securitymanager);
		//4.取出当前 subject
		Subject subject = SecurityUtils.getSubject();
		//5.封装用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		//6.进行登录认证
		try {
			subject.login(token);
			
			System.out.println("是否认证成功:"+subject.isAuthenticated());
		} catch (AuthenticationException e) {
			System.out.println("用户名或密码错误!");
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
