package product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class ProductDAO {

	// JdbcTemplate 객체 생성
	private JdbcTemplate jdbcTemplate;

	public ProductDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<ProductVO> proRowMapper = new RowMapper<ProductVO>() {
		@Override
		public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			System.out.println("------------mapRow 실행");
			ProductVO productVO = new ProductVO();
			productVO.setP_CODE(rs.getString("P_CODE"));
			productVO.setP_NAME(rs.getString("P_NAME"));
			productVO.setP_KIND(rs.getString("P_KIND"));
			productVO.setP_IMAGE(rs.getString("P_IMAGE"));
			productVO.setP_PRICE(rs.getInt("P_PRICE"));
			// if(rs.getInt("QTY") != 0 ) { productVO.setQty(rs.getInt("QTY"));}
			System.out.println((rs.toString()));
			return productVO;
		}

	};

	// 종류별 상품 목록 가져오기
	public List<ProductVO> selectByKind(String kind) {
		String sql = "select * from product where P_KIND like ? ";
		String rekind = "%" + kind + "%";
		System.out.println("kind=" + kind + " " + "rekind=" + rekind);
		List<ProductVO> results = jdbcTemplate.query(sql,
				// proRowMapper,kind);
				proRowMapper, rekind);

		return results;
		/*
		 * List<ProductVO> results = jdbcTemplate.query(
		 * "select * from PRODUCT where P_KIND LIKE ?", proRowMapper,kind);
		 * 
		 * return results;
		 */
	}

	// 코드로 상품 목록 가져오기
	public ProductVO productselectByCode(String code) {
		List<ProductVO> results = jdbcTemplate.query("select * from PRODUCT where P_CODE=?", proRowMapper, code);
		return results.isEmpty() ? null : results.get(0); // ProductVO는 한 객체만 필요. 그래서 results.get(0);
	}

	// 코드로 상품 규격 목록 가져오기
	public List<ProductStdVO> productstdselectByCode(String code) {
		List<ProductStdVO> results = jdbcTemplate.query("select * from PRODUCT_STD", new RowMapper<ProductStdVO>() {

			@Override
			public ProductStdVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				ProductStdVO vo = new ProductStdVO();
				vo.setP_size(rs.getString("P_SIZE"));
				vo.setP_color(rs.getString("P_COLOR"));
				vo.setP_code(rs.getString("P_CODE"));
				vo.setStock(rs.getInt("STOCK"));
				return vo;
			}
		});

		System.out.println(results.size());
		return results;
	}

	// 모든 상품 목록 가져오기
	public List<ProductVO> selectAll() {
		List<ProductVO> results = jdbcTemplate.query("select * from PRODUCT", proRowMapper);

		return results;
	}

	// 탑3 뽑아오기
	/*
	 * public List<ProductVO> top3(){ List<ProductVO> results = jdbcTemplate.
	 * query("select p.P_CODE,p.P_NAME,p.P_IMAGE,p.P_PRICE,sum(op.QTY) as QTY from product as p LEFT JOIN ordered_product as op on p.P_CODE=op.P_CODE group by P_CODE order by QTY DESC LIMIT 3"
	 * , new RowMapper<ProductVO>() {
	 * 
	 * @Override public ProductVO mapRow(ResultSet rs, int rowNum) throws
	 * SQLException { ProductVO productVO = new ProductVO();
	 * productVO.setP_CODE(rs.getString("P_CODE"));
	 * productVO.setP_NAME(rs.getString("P_NAME"));
	 * productVO.setP_IMAGE(rs.getString("P_IMAGE"));
	 * productVO.setP_PRICE(rs.getInt("P_PRICE"));
	 * productVO.setQty(rs.getInt("QTY")); return productVO; } }); return results; }
	 */
}

/*
 * 현재 판매량 탑 3 WITH SUM_QTY AS( SELECT SUM(QTY) AS A_QTY, P_CODE FROM
 * ORDER_PRODUCT GROUP BY P_CODE ), QTY_R AS( SELECT P_CODE, ROWNUM R FROM(
 * SELECT * FROM SUM_QTY ORDER BY A_QTY DESC ) ), QTY_TOP_3 AS( SELECT P_CODE
 * FROM QTY_R WHERE R < 3 )
 * 
 * SELECT P.* FROM PRODUCT P, PRODUCT_STD P_STD, QTY_TOP_3 WHERE 1 =1 AND
 * P.P_CODE = QTY_TOP_3.P_CODE AND P.P_CODE = P_STD.P_CODE(+);
 */
