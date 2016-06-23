package by.htp3.hotel.command.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class QueryUtil {
		
	private QueryUtil(){}
	
	public static String createHttpQueryString(HttpServletRequest request){
		Enumeration<String> params = request.getParameterNames();
		String query = "";
		String key;
		String value;
		
		while(params.hasMoreElements()){
			key = params.nextElement();
			value = request.getParameter(key);
			query = query + "&" + key + "=" + value;
		}
		
		query = request.getRequestURL()  + "?" + query;
		//System.out.println(request.getRequestURL());
		System.out.println(query + "    QUERY FROM QUERY_UTIL");
		return query;
		
	}

}
