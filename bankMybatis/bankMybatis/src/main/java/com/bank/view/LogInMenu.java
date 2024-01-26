package com.bank.view;

import com.bank.controller.MemberController;
import com.bank.model.dto.MemberDTO;

import java.util.Scanner;

public class LogInMenu {

    public void loginMenu(){
        Scanner sc = new Scanner(System.in);
        MemberController memberController = new MemberController();
        AdminMenu adminMenu = new AdminMenu();

        while(true){
            System.out.println("======로그인 메뉴=====");
            System.out.println("    1. 회원가입");
            System.out.println("    2. 로그인");
            System.out.println("    3. 관리자 모드");
            System.out.println("    0. 종료");
            System.out.println("===================");
            System.out.print("메뉴를 선택하세요 : ");

            int num = sc.nextInt();

            switch (num){
                case 1 :
                    memberController.signUp(inputInfo());
                    break;
                case 2 :
                    memberController.signIn(inputId());
                    break;
                case 3 :
                    adminMenu.adminMenu();
                    break;
                case 0 :
                    return;
                default :
                    System.out.println();
                    System.out.println(" ** 잘못된 입력입니다. **");
                    System.out.println();
                    break;
            }
        }
    }

    private MemberDTO inputInfo() {
        Scanner sc = new Scanner(System.in);
        MemberDTO member = new MemberDTO();

        System.out.println("===== 회원가입 =====");
        System.out.println("이름 : ");
        String name = sc.nextLine();

        System.out.println("나이 : ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("성별 : ");
        String gender = sc.nextLine();

        System.out.println("id : ");
        String id = sc.nextLine();

        System.out.println("password : ");
        String pwd = sc.nextLine();

        member.setName(name);
        member.setAge(age);
        member.setGender(gender);
        member.setId(id);
        member.setPwd(pwd);

        return member;
    }

    private MemberDTO inputId(){
        Scanner sc = new Scanner(System.in);
        System.out.println("id를 입력하세요 : ");
        String id = sc.nextLine();
        System.out.println("password를 입력하세요 : ");
        String pwd = sc.nextLine();

        MemberDTO member = new MemberDTO();
        member.setId(id);
        member.setPwd(pwd);

        return member;
    }


}
