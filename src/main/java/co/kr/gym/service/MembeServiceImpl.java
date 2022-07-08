package co.kr.gym.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.kr.gym.mapper.MemberMapper;
import co.kr.gym.model.MemberDTO;

@Service
public class MembeServiceImpl implements MemberService {
    

    @Autowired
    private MemberMapper mapper;
    
    @Autowired
	private BCryptPasswordEncoder pwEncoder;

	@Override
	public void registInsert(MemberDTO dto) {

	    mapper.registInsert(dto);
	}

	@Override
	public int check_id(String g_id) {
		return  mapper.check_id(g_id);
		
	}

	@Override
	public int check_nick(String g_nick) {
		
		return mapper.check_nick(g_nick);
	}

	@Override
	public int login(MemberDTO dto) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		list = mapper.login(dto);

		String resultPW = mapper.getRealPassword(dto.getG_id());
		System.out.println("resultPW 값 : " + resultPW);

		if (list.size() == 0) {
			return 0;
		}
		if (pwEncoder.matches(dto.getG_password(), resultPW)) {
			return 1;
		} else {
			return -1;
		}

}

	@Override
	public MemberDTO memberRead(String g_id) {
		
		return mapper.memberRead(g_id);
	}

	@Override
	public List<MemberDTO> memberList() {
		
		return mapper.memberList();
	}

	@Override
	public void memberUpdate(MemberDTO dto) {
	
		
		mapper.memberUpdate(dto);
		
	}
}




	

