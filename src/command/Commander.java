package command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.*;

public class Commander {

	public static Command order(HttpServletRequest request,HttpServletResponse response) {
		Command cmd = null;
		
		switch(Action.valueOf(request.getParameter("action").toUpperCase())){
		case MOVE:
		cmd = new MoveCommand(request);
		break;
		case JOIN:
			cmd = new CreateCommand(request);
		break;
		case UPDATE:
			cmd = new UpdateCommand(request,response);
			break;
		case DELETE:
			cmd = new DeleteCommand(request);
			break;
		case FINDID:
			cmd = new FindIdCommand(request);
			break;
		case FINDTEAMID:
			cmd = new FindTeamIdCommand(request);
			break;
		case LIST:
			cmd = new ListCommand(request);
			break;
		case LOGIN:
			cmd = new LoginCommand(request);
			break;
		case COUNT:
			cmd= new CountCommand(request);
			break;
		default:
			break;
			
		}
		return cmd; // 리턴되면 이 cmd(레퍼런스) 가 센트리 cmd로 유언을 남기고 사라짐 
		
		
	}
	
	
}
