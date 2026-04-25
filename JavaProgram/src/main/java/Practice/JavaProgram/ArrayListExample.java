package Practice.JavaProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.MappingIterator;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(20);
		list.add(30);
		list.add(0, 10);
		
		System.out.println(list);
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Rachana");
		map.put(2, "Shivam");
		
		System.out.println(map.size());
		
		Set sn = map.entrySet();
		Iterator it = sn.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next());
			Map.Entry mp = (Map.Entry)it.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());
		}
		
		
		
	}

}
