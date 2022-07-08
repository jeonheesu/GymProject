package co.kr.gym.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.gym.model.MemberDTO;

@Mapper
public interface MemberMapper {

	  void registInsert(MemberDTO dto);

	int check_id(String g_id);

    int check_nick(String g_nick);


	List<MemberDTO> login(MemberDTO dto);

	public String getRealPassword(String user_id);

	MemberDTO memberRead(String g_id);

	List<MemberDTO> memberList();

	void memberUpdate(MemberDTO dto);
	

	
		
		
	

}
