package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import enums.*;
import service.ImageService;
import service.ImageServiceImpl;
import command.*;
import domain.MemberBean;

@WebServlet("/member.do")
/*@WebServlet({"/member/joinFrom.do","/member/joinResult.do","/member/userLoginFrom.do","/member/listFrom.do",
	"/member/findByIdFrom.do","/member/findByTeamIdFrom.do","/member/updateFrom.do","/member/deleteFrom.do"})*/
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Receiver.init(request,response);
		switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {//명령을 보냄 
		case MOVE :
				Carrier.forword(request, response);//캐리어로 보냄 ?
		break;
		
		case ADD:
			Carrier.redirect(request, response,"");
			break;
		
		case MODIFY:
			Carrier.forword(request, response);
		break;
		case REMOVE:
			Carrier.redirect(request, response,"");
			break;
		case RETRIEVE:
			/*Carrier.redirect(request, response,"/member.do?action=fileupload&page="+request.getParameter("page"));*/
			Carrier.forword(request, response);
		break;
		case SEARCH:
			
			Carrier.forword(request, response);
			break;
		case COUNT:
			//System.err.println(request.getAttribute("count"));
			break;
		case FILEUPLOAD:
			System.out.println("파일업로드 들어옴 ? ");
			if(!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드파일이 없습니다.");
				return;
			}
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 *3); // 3mb
			upload.setSizeMax(1024 * 1024 *50);//50mb
			List<FileItem> items = null;
			try {
				File file = null;
				items=upload.parseRequest(new ServletRequestContext(request));
				Iterator<FileItem>iter = items.iterator();
					while(iter.hasNext()) {
							FileItem item = (FileItem)iter.next();
							if(!item.isFormField()) {
								HashMap<String,Object> map = new HashMap<>();
								String fileName = item.getName();
								file = new File(Term.UPLOAD_PATH+fileName);
								item.write(file);
								map.put("userid",((MemberBean) request.getSession().getAttribute("user")).getUserid());
								map.put("imgname", fileName.substring(0,fileName.indexOf(".")));
								map.put("ext",fileName.substring(fileName.indexOf(".")+1,fileName.length()));
								map.put("table", "img");
								ImageServiceImpl.getInstance().insert(map);
								// image table 에 id , image name , ext 저장 
							}else {
								System.out.println("파일업로드실패");
							}
						}
						
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.err.println("캐리어로 들어가기전 ");
			Carrier.forword(request, response);
			break;
		case LOGIN:
			if(request.getSession().getAttribute("match").equals("TRUE")){
				Carrier.forword(request, response);
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=login");
			}
			break;
		case LOGOUT:
			Carrier.redirect(request, response,"");
			break;
		default:
			break;
		  	}
		
		}
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
