package com.bank.controller;

import com.bank.model.Service.ProductService;
import com.bank.model.dto.LoanDTO;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.SavingsDTO;
import com.bank.view.PrintMenu;

import java.util.List;

public class ProductController {

    private final PrintMenu printMenu;
    private final ProductService productService;

    public ProductController() {
        printMenu = new PrintMenu();
        productService = new ProductService();
    }

    public void selectedProductInfo(MemberDTO member) {

        List<SavingsDTO> savingsList = productService.selectedSavingsProductInfo(member);
        List<LoanDTO> loanList = productService.selectedLoanProductInfo(member);

        if (savingsList != null && !savingsList.isEmpty() || loanList != null && !loanList.isEmpty()) {
            printMenu.printSelectedProductInfo(savingsList, loanList);
        } else {
            printMenu.errorMessage("selectedProductList");
        }


    }

    public void savingsProduct(SavingsDTO savings) {
        if(savings.getSavingsAmount() == 0){
            printMenu.errorMessage("savingsError");
            return;
        }

        if (productService.registNewSavingsProduct(savings)) {
            printMenu.successMessage("insertSavingsProduct");
        } else {
            printMenu.errorMessage("insertSavingsProduct");
        }
    }

    public void loanProduct(LoanDTO loan, MemberDTO member) {

        if (member.getAge() < 19) {
            printMenu.errorMessage("youngToGetLoan");
        } else if (productService.registNewLoanProduct(loan)) {
            printMenu.successMessage("insertLoanProduct");
        } else {
            printMenu.errorMessage("insertLoanProduct");
        }
    }
}
