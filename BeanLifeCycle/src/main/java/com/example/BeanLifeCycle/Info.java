package com.example.BeanLifeCycle;




import org.springframework.stereotype.Component;

@Component("info")
public class Info {
     
	private Data data;

	public Info(Data data) {
		this.data = data;
	}
	
	
	
}