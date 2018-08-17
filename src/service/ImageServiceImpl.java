package service;

import java.util.Map;

import dao.ImageDAOImpl;
import domain.ImageBean;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}
	@Override
	public void insert(Map<?,?>param) {
		ImageDAOImpl.getInstance().insert(param);
		
	}

	@Override
	public ImageBean call(String img) {
	
		return ImageDAOImpl.getInstance().call(img);
	}

}
