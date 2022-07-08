package co.kr.gym.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.kr.gym.model.MemberDTO;
import co.kr.gym.service.MemberService;

@Controller
public class MemberController {
	
   @Autowired
	private MemberService memberService;
   
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

   
	
   @GetMapping("/login")
   public String login(){
	    return "login";
   }	

   @PostMapping("/login")
  	public String login(MemberDTO dto, HttpServletRequest request, RedirectAttributes rttr) {

  		System.out.println("로그인 할떄 불러오는 dto = "+dto);
  		int result = memberService.login(dto);
                         		             
  		
  		if(result == 1) {
  			HttpSession session = request.getSession();
  			dto = memberService.memberRead(dto.getG_id());
  			session.setAttribute("g_bmi", dto.getG_bmi());
			  session.setAttribute("g_name", dto.getG_name());
			  session.setAttribute("g_height", dto.getG_height());
			  session.setAttribute("g_weight", dto.getG_weight());
  			session.setAttribute("g_id", dto.getG_id());
  			return "redirect:/";
  		};

  		 if(result == 0){
  			rttr.addFlashAttribute("msgID", false);
  			return "redirect:/login";
  		}; 

  		if(result == -1) {
  			rttr.addFlashAttribute("msgPW", false);
  			return "redirect:/login";
  		} else {
  			return "redirect:/login";
  		}
     }
   
   @GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
   
   @GetMapping("/regist")
   public String regist(){



	    return "regist";
   }	

   @PostMapping("/regist")
   public String registInsert(MemberDTO dto ){


	   dto.setG_password(bCryptPasswordEncoder.encode(dto.getG_password()));
		dto.setG_Rpassword(bCryptPasswordEncoder.encode(dto.getG_Rpassword()));
        memberService.registInsert(dto);
      
      return "redirect:/";
   }

   @GetMapping("/list")
public String memberlist(Model model){
	   List<MemberDTO> list = memberService.memberList();
	   model.addAttribute("list", list);
	    
	return "list";
}    
   

@PostMapping("/memberUpdate")
public String memberUpdate(MemberDTO dto,HttpServletRequest request, RedirectAttributes rttr){
	dto.setG_password(bCryptPasswordEncoder.encode(dto.getG_password()));
	dto.setG_Rpassword(bCryptPasswordEncoder.encode(dto.getG_Rpassword()));
	memberService.memberUpdate(dto);
	dto = memberService.memberRead(dto.getG_id());
  		HttpSession session = request.getSession();
  			session.setAttribute("g_bmi", dto.getG_bmi());
			  session.setAttribute("g_height", dto.getG_height());
			  session.setAttribute("g_weight", dto.getG_weight());
  			session.setAttribute("g_id", dto.getG_id());
			  return "redirect:/";

}

   @PostMapping("/check_id")
	@ResponseBody
	public int check_id(@RequestParam("g_id") String g_id) {
		System.out.print("checkid called");
		int checkCount = memberService.check_id(g_id);
		return checkCount;
	}
  
   
   
    
   @GetMapping("/myPage")
   public String memberRead(@RequestParam(value = "g_id", required = false) String g_id, Model model){
	   System.out.println(g_id);
	 MemberDTO dto = memberService.memberRead(g_id);
	model.addAttribute("dto", dto);
	 return "myPage";
		}
   }
