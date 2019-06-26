package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import xml.Book;

public class JSONTest {

	public static void main(String[] args) throws IOException 
	{
	
//		testWrite();

		testRead();
	}

	private static void testRead() throws IOException {
		
		Reader r = new FileReader("bookstore.json");
		int len = 0;
		char[] buf = new char[1024];
		String str = "";
		while((len=r.read(buf))!=-1)
		{
			str += new String(buf,0,len);
		}
		r.close();
		
		
//		JSONObject j1 = JSONObject.fromObject(str);
//		System.out.println(j1);
//		
//		JSONArray j2 = JSONArray.fromObject(str);
////		System.out.println(j2);
//		for(int i=0;i<j2.size();i++)
//		{
//			JSONObject j3 = j2.getJSONObject(i);
//			System.out.println(j3);
//		}
		
		// get()
		// getInt()
		// ...
		// getJSONObject()
		// getJSONArray()
		
		
		JSONObject bookstore = JSONObject.fromObject(str);
		System.out.println(bookstore.get("name"));
		System.out.println(bookstore.get("address"));
		
		JSONObject boss = bookstore.getJSONObject("boss");
		System.out.println(""+boss.get("name")+boss.get("sex")+boss.getInt("age"));
		JSONArray books = bookstore.getJSONArray("books");
		for(int i=0;i<books.size();i++)
		{
			JSONObject book = books.getJSONObject(i);
			System.out.println(book);
		}
	}

	private static void testWrite() throws IOException 
	{
	
		// 1. 创建一个JSON对象
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("id", "ISBN-234234");
//		jsonObject.put("name", "高等数学");
//		jsonObject.put("author", "华罗庚");
//		jsonObject.put("year", "2017");
//		System.out.println(jsonObject);
//		Writer w = new FileWriter("book.json");
//		w.write(jsonObject.toString());
//		w.close();
		
		// 2. 有Map创建JSON对象
//		Map<String,Object> map = new HashMap<>();
//		map.put("id", "ISBN-234234");
//		map.put("name", "高等数学");
//		map.put("author", "华罗庚");
//		map.put("year", "2017");
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		Writer w = new FileWriter("book2.json");
//		w.write(jsonObject.toString());
//		w.close();
		
		// 3. JavaBean创建JSON对象
		Book book = new Book(5,"高等数学","胡罗庚",2017);
		JSONObject jsonObject = JSONObject.fromObject(book);
		Writer w = new FileWriter("book3.json");
		w.write(jsonObject.toString());
		w.close();
		

		
		// 3.  集合容器转换为 JSONArray
//		List<Book> list = new ArrayList<>();
//		list.add(new Book(1,"相对论","爱因斯坦",2017));
//		list.add(new Book(2,"离散数学","爱因斯坦",2017));
//		list.add(new Book(3,"相对论2","爱因斯坦",2017));
//		JSONArray jsonArray = JSONArray.fromObject(list);
//		
//		Writer w = new FileWriter("books.json");
//		w.write(jsonArray.toString());
//		w.close();
		
	}

}
