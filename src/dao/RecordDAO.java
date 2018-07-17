package dao;

import java.util.List;

import domain.*;

public interface RecordDAO {
	public void insertRecord(RecordBean record);
	public RecordBean findById(RecordBean record);
	public String updateRecord(RecordBean record);
	public String deleteRecord(RecordBean record);
	public List<RecordBean> list();
	public String selectFirstRowNum();
}
