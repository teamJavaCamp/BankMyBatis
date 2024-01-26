package com.bank.view;

import com.bank.controller.MemberController;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.TransactionDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    public void mainMenu(MemberDTO member){
        Scanner sc = new Scanner(System.in);
        PrintMenu printMenu = new PrintMenu();
        MemberController memberController = new MemberController();
        ProductMenu productMenu = new ProductMenu();

        while(true){
            System.out.println(" ===== 메인메뉴 =====");
            System.out.println("1. 계좌 조회");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 계좌이체");
            System.out.println("5. 마이페이지");
            System.out.println("6. 상품페이지");
            System.out.println("0. 로그아웃");
            System.out.print("메뉴를 선택하세요 : ");

            int num = sc.nextInt();

            switch(num){
                case 1:
                    printMenu.printAcc(member);
                    break;
                case 2 :
                    memberController.updateAccount(member, deposit(member));
                    break;
                case 3 :
                    memberController.updateAccount(member, withdraw(member));
                    break;
                case 4 :
                    memberController.updateAccount(member, transfer(member));
                    break;
                case 5 :
                    printMenu.printInfo(member);
                    break;
                case 6 :
                    productMenu.productMenu(member);
                    break;
                case 0 :
                    return;
                default :
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }
    }

    private TransactionDTO deposit(MemberDTO member) {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금할 금액 :");
        long deposit = sc.nextLong();

        member.setBalance(member.getBalance() + deposit);

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dates = date.format(new Date());

        return new TransactionDTO(dates, member.getId(), "입금" ,deposit); //내역 저장
    }

    private TransactionDTO withdraw(MemberDTO member){
        Scanner sc = new Scanner(System.in);
        System.out.println("출금할 금액 : ");
        long withdraw = sc.nextLong();

        member.setBalance(member.getBalance() - withdraw);

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dates = date.format(new Date());

        return new TransactionDTO(dates, member.getId(), "출금" ,withdraw * -1);
    }
    private TransactionDTO transfer(MemberDTO member){
        Scanner sc = new Scanner(System.in);
        System.out.println("이체할 계좌 번호 : ");
        String account = sc.nextLine();
        System.out.println("이체할 금액 : ");
        long transfer = sc.nextLong();

        member.setBalance(member.getBalance() - transfer);

        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dates = date.format(new Date());

        return new TransactionDTO(dates, member.getId(), "계좌이체" ,transfer * -1);
    }

}
