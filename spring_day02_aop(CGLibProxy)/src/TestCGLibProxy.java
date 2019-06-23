import org.junit.Test;

import com.tfl.proxy.CGLibProxyFactory;
import com.tfl.service.CustomerService;
import com.tfl.service.CustomerServiceImpl;

public class TestCGLibProxy {
	/**
	 * 	不是用代理
	 */
	@Test
	public void testSave() {
		CustomerService service=new CustomerServiceImpl();
		service.save();
	}
	/**
	 * 	使用代理
	 */
	@Test
	public void testSave1() {
		CustomerServiceImpl target=new CustomerServiceImpl();
		CGLibProxyFactory factory=new CGLibProxyFactory(target);
		//获取代理
		CustomerService service=(CustomerService)factory.getProxyObject();
		service.save();
	}
	/**
	 * 	使用代理
	 */
	@Test
	public void testSave2() {
		CGLibProxyFactory factory=new CGLibProxyFactory(new CustomerServiceImpl());
		//获取代理对象
		CustomerService service=(CustomerService)factory.getProxyObject();
		service.find();
		service.save();
	}
}
