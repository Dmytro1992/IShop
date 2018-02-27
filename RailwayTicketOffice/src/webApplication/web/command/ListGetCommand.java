package webApplication.web.command;

import java.util.ArrayList;
import java.util.List;
//Check get inquiry 
public class ListGetCommand {
	
public boolean check(String command){
	List<String> getInquiry = new ArrayList<>();
	getInquiry.add("searchRequest");
	getInquiry.add("main_page");
	getInquiry.add("register_page");
	getInquiry.add("remove");
	getInquiry.add("login_page");
	getInquiry.add("regUser");
	if(getInquiry.contains(command)){
		return true;
	}
	return false;
}
}
