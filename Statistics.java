package tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Antoine
 * This class manage basic statistic computations: deviation, mean, variance, median of list of double numbers
 * You can use basic typename like int, float, double, ...
 * @warning statistics on integer data will be rounded!
 * @param <Type>
 */
public class Statistics {
	
	private List<Float> data;
	private int size;
	private String name;
	
	public Statistics() {
		size = 0;
		data = new ArrayList<>();
		name = "Statistics";
	}
	
	public Statistics(String name) {
		size = 0;
		data = new ArrayList<>();
		this.name = name;
	}
	
	public Statistics(List<Float> list) {
		size = list.size();
		data = list;
		name = "Statistics";
	}
	
	public Statistics(List<Float> list, String name) {
		size = list.size();
		data = list;
		this.name = name;
	}
	
	public void addAll(Statistics stats) {
		data.addAll(stats.getData());
		size = data.size();
	}
	
	public void addAll(List<Float> list) {
		data.addAll(list);
		size = data.size();
	}
	
	public void add(Float value) {
		data.add(value);
		size = data.size();
	}
	
	
	public Float mean() {
		if (data.isEmpty()) {
			return 0f;
		}
		Float sum = 0f;
		for (Float a: data) {
			sum += a;
		}
		return sum/size;
	}
	
	public Float variance() {
		if (data.isEmpty()) {
			return 0f;
		}
		Float mean = mean();
		Float tmp = 0f;
		
		for(Float num: data) {
			tmp += (mean - num)*(mean - num);
		}
		return tmp/size;
	}
	
	public Float StdDev() {
		if (data.isEmpty()) {
			return 0f;
		}
		return new Float (Math.sqrt(variance().doubleValue()));
	}
	
	public Float median() {
		if (data.isEmpty()) {
			return 0f;
		}
		Collections.sort(data);
		
		if (size % 2 == 0) {
	        return (data.get((size / 2) - 1) + data.get(size / 2)) / 2.0f;
	    } else {
	        return data.get(size / 2);
	    }
	}
	
	public Float min() {
		
		return (data.isEmpty())?0f:Collections.min(data);
	}
	
	public Float max() {
		return (data.isEmpty())?0f:Collections.max(data);
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Float> getData() {
		return data;
	}

	public int getSize() {
		return size;
	}

	public String getName() {
		return name;
	}
	

	
}
