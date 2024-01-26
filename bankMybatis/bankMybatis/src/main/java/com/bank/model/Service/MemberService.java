package com.bank.model.Service;

import com.bank.model.dao.MemberDAO;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.TransactionDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.bank.common.Template.getSqlSession;

public class MemberService {

    private MemberDAO memberDAO;

    public boolean singUp(MemberDTO member){
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        boolean result = memberDAO.signUpMember(member);

        if(result){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public String createAccount() {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        List<String> accountList = memberDAO.getAccountList();

        int[] accNum = new int [7];
        String account = "";

        for(int i = 0; i < accountList.size() + 1; i++) {
            account = "";

            for (int j = 0; j < accNum.length; j++) {
                accNum[j] = (int) (Math.random() * 9);
                account += accNum[j] + "";
            }

            for (int k = 0; k < i; k++) {
                if (accountList.get(k).equals(account)) {
                    i--;
                    break;
                }
            }
        }
        return account;
    }

    public MemberDTO signIn(MemberDTO check) {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        MemberDTO member = memberDAO.signInMember(check);

        return member;
    }

    public boolean updateAccount(MemberDTO member, TransactionDTO transaction) {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        boolean result = false;

        boolean result1 = memberDAO.updateAccount(member);
        boolean result2 = memberDAO.saveHistory(transaction);

        if(result1 && result2){
            result = true;
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return result;
    }

    public List<MemberDTO> selectAllMember() {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        List<MemberDTO> memberList = memberDAO.selectMemberList();

        return memberList;
    }

    public boolean updateMember(MemberDTO memberDTO) {
        SqlSession sqlSession = getSqlSession();
        memberDAO = sqlSession.getMapper(MemberDAO.class);

        boolean result = memberDAO.updateMember(memberDTO);

        if(result){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }

        return result;
    }
}
