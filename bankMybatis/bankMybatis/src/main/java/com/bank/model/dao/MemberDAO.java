package com.bank.model.dao;

import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.TransactionDTO;

import java.util.List;

public interface MemberDAO {

    boolean signUpMember(MemberDTO member);

    List<String> getAccountList();

    MemberDTO signInMember(MemberDTO check);

    boolean updateAccount(MemberDTO member);

    boolean saveHistory(TransactionDTO transaction);

    List<MemberDTO> selectMemberList();

    boolean updateMember(MemberDTO memberDTO);
}
