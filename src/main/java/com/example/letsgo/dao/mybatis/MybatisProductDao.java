package com.example.letsgo.dao.mybatis;

import com.example.letsgo.dao.ProductDao;
import com.example.letsgo.dao.mybatis.mapper.ProductMapper;
import com.example.letsgo.domain.market.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MybatisProductDao {
//	@Autowired
//	private ProductMapper productMapper;
//
//	public List<Product> searchProductByProductType(int categoryId)
//			throws DataAccessException {
//	    return productMapper.searchProductByProductType(categoryId);
//	}
//
//	public List<Product> getAllProducts() throws DataAccessException {
//	    return productMapper.getAllProducts();
//	}
//
//	public List<Product> searchProductByName(String keywords)
//			throws DataAccessException {
//	    return productMapper.searchProductByName(
//	    	"%" + keywords.toLowerCase() + "%");
//	}
//
//	//* Inner Classes *//
//	public static class ProductSearch {
//		private List<String> keywordList = new ArrayList<String>();
//
//		public ProductSearch(String keywords) {
//			StringTokenizer splitter = new StringTokenizer(keywords," ",false);
//			while (splitter.hasMoreTokens()) {
//				this.keywordList.add("%" + splitter.nextToken() + "%");
//			}
//		}
//		public List<String> getKeywordList() {
//			return keywordList;
//		}
//	}
}
