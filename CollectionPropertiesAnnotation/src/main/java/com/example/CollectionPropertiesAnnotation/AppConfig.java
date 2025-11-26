package com.example.CollectionPropertiesAnnotation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example")
public class AppConfig {

	@Bean
	
	public List<Point> trianglePoints() {
		List<Point> points = new ArrayList<>();
		points.add(new Point(0, 0));
		points.add(new Point(10, 0));
		points.add(new Point(5, 10));
		return points;
	}
}