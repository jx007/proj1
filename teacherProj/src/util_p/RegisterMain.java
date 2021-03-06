package util_p;

import java.util.regex.Pattern;

/*1. 아이디 : 영문대문자소문자 숫자 특수기호 조합
2. 사진 첨부-->영문,숫자.이미지 확장자
이미지(jpg, jpeg, bmp, png, gif)  --  대소문자 구분없음
3. 우편번호 검색 - 구단위 (초성검색)*/
public class RegisterMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			String [] pp = {".*[a-z].*",".*[A-Z].*",".*[0-9].*",".*[_.].*"};
			String tot = "[a-zA-Z0-9_.]*";
			
			String id = "abA_cd123";
			
			boolean idChk = false;
			if(!Pattern.matches(tot, id))
			{
				idChk = true;
			}else{
				for(String ppp: pp)
				{
					if(!Pattern.matches(ppp, id))
						idChk = true;
				}
			}
			
			if(idChk) throw new Exception("id 에러");
			
			String ff = "fefef.jpg";
			
			if(!Pattern.matches(".*\\.(jpg|png|gif|bmp)", ff.toLowerCase()))
				throw new Exception("파일 에러");
			
			
			
			String [][] zipStr = {
					{"ㄱ","가-깋"},
					{"ㄴ","나-닣"},
					{"ㄷ","다-딯"},
					{"ㄹ","라-맇"},
					{"ㅁ","마-밓"},
					{"ㅂ","바-빟"},
					{"ㅅ","사-싷"},
					{"ㅇ","아-잏"},
					{"ㅈ","자-짛"},
					{"ㅊ","차-칳"},
					{"ㅋ","카-킿"},
					{"ㅌ","타-팋"},
					{"ㅍ","파-핗"},
					{"ㅎ","하-힣"},
					{"ㅃ","빠-삫"},
					{"ㅉ","짜-찧"},
					{"ㄸ","따-띻"},
					{"ㄲ","까-낗"},
					{"ㅆ","싸-앃"},
			};
			
			String [] qq = {
					"강남구","분당구","노원구","마포부",
					"구노구","바다구","노인구"
					
			};
			
			String gu = "ㄱㄴ";
			
			String guReg =".*";
			
			for (int i = 0; i < gu.length(); i++) {
				
				for(String [] zip: zipStr)
				{
					if((gu.charAt(i)+"").equals(zip[0]))
						guReg+="["+zip[1]+"]";
				}
			}
			guReg+=".*";
			
			for(String qqq : qq)
			{
				if(Pattern.matches(guReg, qqq))
					System.out.println(qqq);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
