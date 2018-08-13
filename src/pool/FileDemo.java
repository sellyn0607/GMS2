package pool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class FileDemo {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		final String PATH = "C:\\Users\\1027\\Documents\\sample.txt";
		try {
			File file = new File(PATH);
			FileWriter fw= new FileWriter(file, true);
			FileReader fr = new FileReader(file);
			BufferedWriter writer = new BufferedWriter(fw);
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				System.err.println("메뉴 1.전송 2.읽기 0.종료");
				switch(s.next()) {
				case "1":
					System.out.println("메세지 입력");
					writer.write(s.next());
					writer.newLine();
					writer.flush();
					break;
				case "2":
					String msg = "";
					while((msg = reader.readLine())
							!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				case "0":
					return;
					
				default : break;
					
				}
					
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
	class FileName{
		 // inner class 는 public 를 갖지않는다 
		// 이유는 이 클래스 내부에서만 사용하고자 함이다
		// 만약 다른 곳에서 계속 사용한다면 독립시켜야한다.
		// 1회용 사용 클래스라고 생각 하면됨 
		//inner 는 @data 랑 충돌날수있어서 사용안함 
		private String path,sep,ext,filename;
		public FileName(String path) {
			this.path=path;
			this.sep = File.separator;
			this.filename=path.substring(path.lastIndexOf("\\")+1,path.indexOf("."));;
			this.ext=path.substring(path.lastIndexOf(".")+1, path.length()); 
		}
		public String getPath() {
			return path;
		}
		public String getSep() {
			return sep;
		}
		public String getExt() {
			return ext;
		}
		public String getFilename() {
			return filename;
		} 
		
	
	}
	

