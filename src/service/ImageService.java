package service;

import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void insert(Map<?,?>param);
	public ImageBean call(String img);
}
