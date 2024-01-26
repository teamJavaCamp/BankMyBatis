package com.bank.view;

import com.bank.model.dto.LoanDTO;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.SavingsDTO;

import java.util.List;

public class PrintMenu {
    public void successMessage(String successCode) {
        String successMessage = "";
        switch(successCode){
            case "signUp" : successMessage = "가입 완료"; break;
            case "update" : successMessage = "성공"; break;
            case "updateMember" : successMessage = "변경 성공"; break;
            case "insertSavingsProduct" : successMessage = "적금 가입 완료"; break;
        }
        System.out.println(successMessage);
    }

    public void errorMessage(String errorCode) {
        String errorMessage = "";
        switch (errorCode){
            case "signUp" : errorMessage = "가입 실패"; break;
            case "signIn" : errorMessage = "로그인 실패"; break;
            case "selectList" : errorMessage = "조회 결과가 없습니다."; break;
            case "update" : errorMessage = "실패"; break;
            case "updateMember" : errorMessage = "변경 실패"; break;
            case "savingsError" : errorMessage = "잘못된 입력"; break;
            case "insertSavingsProduct" : errorMessage = "적금 가입 실패"; break;
        }
        System.out.println(errorMessage);
    }

    public void printAcc(MemberDTO member) {
        System.out.println("계좌번호 : " + member.getAccount());
        System.out.println("잔고 : " + member.getBalance());
    }

    public void printInfo(MemberDTO member) {
        System.out.println(member);
    }

    public void selectAllMember(List<MemberDTO> memberList) {
        for(MemberDTO member : memberList){
            System.out.println(member);
        }
    }

    public void printSelectedProductInfo(List<SavingsDTO> savingsList, List<LoanDTO> loanList) {
        for (SavingsDTO savings : savingsList) {
            System.out.println(savings);
        }

        for (LoanDTO loan : loanList) {
            System.out.println(loan);
        }
        // 2개 다 출력 원하기를

    }
}
