package com.bank.model.Service;

import com.bank.model.dao.ProductDAO;
import com.bank.model.dto.LoanDTO;
import com.bank.model.dto.MemberDTO;
import com.bank.model.dto.SavingsDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.bank.common.Template.getSqlSession;

public class ProductService {

    ProductDAO productDAO;

    public List<SavingsDTO> selectedSavingsProductInfo(MemberDTO member) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<SavingsDTO> savingsList = productDAO.selectedSavingsProductInfo(member);

        sqlSession.close();
        return savingsList;

    }
    public List<LoanDTO> selectedLoanProductInfo(MemberDTO member) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        List<LoanDTO> loanList = productDAO.selectedLoanProductInfo(member);

        sqlSession.close();
        return loanList;
    }

    public boolean registNewSavingsProduct(SavingsDTO savings) {
        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        boolean result = productDAO.registNewSavingsProduct(savings);

        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public boolean registNewLoanProduct(LoanDTO loan) {

        SqlSession sqlSession = getSqlSession();
        productDAO = sqlSession.getMapper(ProductDAO.class);

        boolean result = productDAO.registNewLoanProduct(loan);
        if (result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }


}
