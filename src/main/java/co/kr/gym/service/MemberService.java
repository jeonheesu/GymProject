package co.kr.gym.service;

import java.util.List;

import co.kr.gym.model.MemberDTO;

public interface MemberService {

    void registInsert(MemberDTO dto);

    int check_id(String g_id);

    int check_nick(String g_nick);

	int login(MemberDTO dto);

    MemberDTO memberRead(String g_id);

	List<MemberDTO> memberList();

	void memberUpdate(MemberDTO dto);



   

   
  
    

    
}
