package com.bank.model.dao;

import com.bank.model.dto.LoanDTO;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.SavingsDTO;

import java.util.List;

public interface ProductDAO {

    List<SavingsDTO> selectedSavingsProductInfo(MemberDTO member);

    List<LoanDTO> selectedLoanProductInfo(MemberDTO member);

    boolean registNewSavingsProduct(SavingsDTO savings);

    boolean registNewLoanProduct(LoanDTO loan);
}