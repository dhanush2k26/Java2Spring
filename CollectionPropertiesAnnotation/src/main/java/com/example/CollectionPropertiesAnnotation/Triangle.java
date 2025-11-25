package com.example.CollectionPropertiesAnnotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Triangle {
	@Value("#{@trianglePoints}")
	List<Point> Points;

	public List<Point> getPoints() {
		return Points;
	}

	public void setPoints(List<Point> points) {
		Points = points;
	}

	@Override
	public String toString() {
		return "Triangle [Points=" + Points + "]";
	}
}