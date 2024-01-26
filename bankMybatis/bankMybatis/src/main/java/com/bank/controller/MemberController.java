package com.bank.controller;

import com.bank.model.Service.MemberService;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.TransactionDTO;
import com.bank.view.MainMenu;
import com.bank.view.PrintMenu;

import java.util.List;

public class MemberController {
    private final PrintMenu printMenu;
    private final MemberService  memberService;
    public MemberController(){
        printMenu = new PrintMenu();
        memberService = new MemberService();
    }

    public void signUp(MemberDTO member) {
        String account = memberService.createAccount();
        member.setAccount(account);
        member.setBalance(0L);
        boolean result = memberService.singUp(member);

        if(result){
            printMenu.successMessage("signUp");
        }else{
            printMenu.errorMessage("signUp");
        }
    }

    public void signIn(MemberDTO check) {
        MainMenu mainMenu = new MainMenu();
        MemberDTO member = memberService.signIn(check);

        if(member != null){
            mainMenu.mainMenu(member);
        }else{
            printMenu.errorMessage("signIn");
        }
    }

    public void updateAccount(MemberDTO member, TransactionDTO transaction) {

        boolean result = memberService.updateAccount(member, transaction);

        if(result){
            printMenu.successMessage("update");
        }else{
            printMenu.errorMessage("update");
        }
    }

    public void selectAllMember() {
        List<MemberDTO> memberList = memberService.selectAllMember();

        if(memberList != null){
            printMenu.selectAllMember(memberList);
        }else{
            printMenu.errorMessage("selectList");
        }
    }

    public void updateMemberInfo(MemberDTO memberDTO) {
        boolean result = memberService.updateMember(memberDTO);

        if(result){
            printMenu.successMessage("updateMember");
        }else{
            printMenu.errorMessage("updateMember");
        }
    }
}


