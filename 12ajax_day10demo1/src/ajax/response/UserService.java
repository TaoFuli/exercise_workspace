package ajax.response;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private List<String> names;
	public UserService() {
		names=new ArrayList<>();
		names.add("aaaa");
		names.add("bbbb");
		names.add("cccc");
		names.add("dddd");
		names.add("eeee");
		names.add("ffff");
		names.add("gggg");
	}
	public boolean checkName(String name) {
		return names.contains(name);
	}
}
