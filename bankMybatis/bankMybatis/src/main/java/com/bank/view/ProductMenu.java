package com.bank.view;

import com.bank.controller.ProductController;
import com.bank.model.dto.LoanDTO;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.SavingsDTO;

import java.util.Scanner;

public class ProductMenu {

    public void productMenu(MemberDTO member){
        Scanner sc = new Scanner(System.in);
        ProductController productController = new ProductController();
        while(true) {
            System.out.println(" ===== 상품메뉴 =====");
            System.out.println(" 1. 내 가입 상품");
            System.out.println(" 2. 적금");
            System.out.println(" 3. 대출");
            System.out.println(" 0. 뒤로 ");
            System.out.print("메뉴 선택 : ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    productController.selectedProductInfo(member); break;
                case 2:
                    productController.savingsProduct(inputSavingsInfo(member)); break;
                case 3:
                    productController.loanProduct(inputLoanInfo(member), member); break;
                default:
                    return;
            }
        }
    }

    private static SavingsDTO inputSavingsInfo(MemberDTO member) {
        Scanner sc = new Scanner(System.in);
        SavingsDTO savings = new SavingsDTO();
        long deposit = 0;

        System.out.println("적금 가입 메뉴 **");
        System.out.print("월 납입 할 금액을 입력하세요 (한도 : 50만원), (단위 : 만원) : ");
        deposit = sc.nextLong();
        sc.nextLine();

        if ((deposit * 10000) > member.getBalance()) {
            return savings;
        } else if (deposit > 50) {
            return savings;
        } else if (deposit <= 0) {
            return savings;
        } else {
            savings.setSavingsAmount(deposit);
            System.out.println();
            System.out.println(deposit + "만원을 적금하겠습니다.");
            System.out.println();
        }

        System.out.println("***** 상품의 기간 선택 *****");
        System.out.println("1) 12개월 (금리 4%)");
        System.out.println("2) 24개월 (금리 4.5%)");
        System.out.println("3) 48개월 (금리 5%)");
        System.out.print("상품 기간을 선택해 주세요 : ");
        int yearsToDeposit = sc.nextInt();

        switch (yearsToDeposit) {
            case 1:
                savings.setPeriod(12);
                savings.setInterestRate(0.04);
                break;
            case 2:
                savings.setPeriod(24);
                savings.setInterestRate(0.045);
                break;
            case 3:
                savings.setPeriod(48);
                savings.setInterestRate(0.05);
                break;
            default:
                System.out.println();
                System.out.println(" ** 잘못된 입력입니다. **");
                System.out.println();
                break;
        }
        savings.setType(1);
        return savings;
    }

    private static LoanDTO inputLoanInfo(MemberDTO member) {
        LoanDTO loan = new LoanDTO();
        Scanner sc = new Scanner(System.in);
        int takeLoan;
        int limitAmount;

        if (member.getAge() < 19) {
            System.out.println("미성년자는 대출 못받습니다");
            return null;
        } else if (member.getAge() < 29) {
            limitAmount = 1000;
        } else if (member.getAge() < 39) {
            limitAmount = 3000;
        } else if (member.getAge() < 49) {
            limitAmount = 5000;
        } else {
            limitAmount = 3000;
        }

        System.out.println(" ====== 대출 메뉴 ======");
        System.out.println(" ** 최대 대출 가능 금액은 " + limitAmount + "만원 입니다. ** ");
        System.out.print(" 대출받을 금액을 입력하세요 (단위 : 만원): ");
        takeLoan = sc.nextInt();

        if (takeLoan <= limitAmount && takeLoan > 0) {
            loan.setLoanAmount(takeLoan);
        }
        System.out.println("===== 대출메뉴 =====");
        System.out.println(" 1) 12개월 (이자율 4.0%) ");
        System.out.println(" 2) 24개월 (이자율 4.18%) ");
        System.out.println(" 3) 36개월 (이자율 4.36%) ");
        System.out.println(" 4) 48개월 (이자율 4.5%) ");
        System.out.println(" 0) 메인메뉴로 ");

        System.out.print(" 대출 상환 기간 선택 :  ");
        int select = sc.nextInt();

        switch (select){
            case 1:
                loan.setPeriod(12);
                loan.setInterestRate(0.04);
                System.out.println("대출이 완료되었습니다.");
                break;
            case 2:
                loan.setPeriod(24);
                loan.setInterestRate(0.0418);
                System.out.println("대출이 완료되었습니다.");
                break;
            case 3:
                loan.setPeriod(36);
                loan.setInterestRate(0.0436);
                System.out.println("대출이 완료되었습니다.");
                break;
            case 4:
                loan.setPeriod(48);
                loan.setInterestRate(0.045);
                System.out.println("대출이 완료되었습니다.");
                break;
            case 0:
                break;
            default:
                System.out.println();
                System.out.println(" ** 잘못된 입력입니다. ** ");
                System.out.println();
                break;
        }
        loan.setType(2);
        return loan;
    }
}
