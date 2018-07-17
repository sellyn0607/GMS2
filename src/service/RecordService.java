package service;

import java.util.List;

import domain.*;

public interface RecordService {
	public void createRecord(RecordBean record);
	public RecordBean findById(RecordBean record);
	public String update(RecordBean record);
	public String delete(RecordBean record);
	public List<RecordBean> list();
}
