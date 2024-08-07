package mybatis.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.BoardsVO;
import mybatis.vo.CategoryVO;
import mybatis.vo.ProductVO;

public class CategoryDAO {
	// 카테고리 전체 조회
	public static CategoryVO[] allCategory() {
		SqlSession ss = FactoryService.getFactory().openSession();
		CategoryVO[] ar = null;
		List<CategoryVO> list = ss.selectList("category.allCategory");
		if (list != null) {
			ar = new CategoryVO[list.size()];
			list.toArray(ar);
		}
		ss.close();

		return ar;
	}

	// 카테고리별 재고대비 판매량
	public static CategoryVO[] findPdcntPerOdcntByCategory() {
		SqlSession ss = FactoryService.getFactory().openSession();
		CategoryVO[] ar = null;
		List<CategoryVO> list = ss.selectList("category.findPdcntPerOdcntByCategory");
		if (list != null) {
			ar = new CategoryVO[list.size()];
			list.toArray(ar);
		}
		ss.close();
		return ar;
	}
	
	// 카테고리 추가
	public static int addCategory(String ct_name) {
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.insert("category.addCategory", ct_name);
		if(cnt > 0) 
			ss.commit();
		else
			ss.rollback();
		
		ss.close();
		
		return cnt;
	}
	
	// 카테고리명 수정
	public static int updateCategory(HashMap<String, String> map) {
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.update("category.updateCategory", map);
		if(cnt > 0) 
			ss.commit();
		else
			ss.rollback();
		
		ss.close();
		
		return cnt;
	}
	
	// 카테고리 삭제
	public static int deleteCategory(String ct_idx) {
		SqlSession ss = FactoryService.getFactory().openSession();
		
		int cnt = ss.update("category.deleteCategory", ct_idx);
		if(cnt > 0) 
			ss.commit();
		else
			ss.rollback();
		
		ss.close();
		
		return cnt;
	}
}
