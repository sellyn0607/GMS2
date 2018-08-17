package enums;

public enum ImgQuery {
	INSERT,CALLIMG;
	@Override
	public String toString() {
		String query = "";
		switch(this) {
		case INSERT:
			query = "insert into image(img_seq,img_name,extension,userid) values(img_seq.nextval,?,?,?)";
			break;
		case CALLIMG:
			query = "select img_name,extension from image where userid like ? ";
			break;
		default:
			break;
		}
		return query;
	
	}
	
}
