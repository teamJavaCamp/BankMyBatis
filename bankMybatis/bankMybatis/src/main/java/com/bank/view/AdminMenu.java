package com.bank.view;

import com.bank.controller.MemberController;
import com.bank.model.dto.MemberDTO;

import java.util.Scanner;

public class AdminMenu {
    public void adminMenu() {
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();

        while(true){
            System.out.println("관리자 모드");
            System.out.println("1. 회원 전체 조회");
            System.out.println("2. 회원 정보 변경");
            System.out.println("0. 뒤로");
            System.out.print("메뉴 선택 : ");

            int num = sc.nextInt();
            switch (num){
                case 1 :
                    memberController.selectAllMember();
                    break;
                case 2:
                    memberController.updateMemberInfo(updateInfo());
                    break;
                default :
                    return;
            }

        }
    }

    public MemberDTO updateInfo(){

        MemberDTO member = new MemberDTO();
        Scanner sc = new Scanner(System.in);

        System.out.println("정보를 변경할 회원의 아이디 : ");
        String id = sc.nextLine();

        System.out.println("변경할 비밀번호 : ");
        String pwd = sc.nextLine();

        System.out.println("변경할 이름 : ");
        String name = sc.nextLine();

        System.out.println("변경할 성별 : ");
        String gender = sc.nextLine();

        System.out.println("변경할 나이 : ");
        int age = sc.nextInt();
        sc.nextLine();

        member.setId(id);
        member.setPwd(pwd);
        member.setAge(age);
        member.setGender(gender);
        member.setName(name);

        return member;
    }



}
