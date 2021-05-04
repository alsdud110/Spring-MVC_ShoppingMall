package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cart.CartDAO;
import cart.CartService;
import delete.DeleteMemberService;
import edit.ChangePasswordService;
import edit.EditMemberService;
import login.LoginService;
import login.MemberService;
import member.MemberDao;
import order.OrderDAO;
import order.OrderService;
import product.ProductDAO;
import product.ProductService;
import register.IdCheckService;
import register.MemberRegisterService;


@Configuration
@EnableTransactionManagement
public class MemberConfig {
	
    private static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@210.217.149.135:6352:XE";
    private static final String USER="SPRING";
    private static final String PW="1234";//


	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PW);
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberDao());
	}
	
	@Bean
	public LoginService authService() {
		return new LoginService(memberDao());
	}
	

	@Bean
	public ChangePasswordService changePwdSvc() {
		return new ChangePasswordService(memberDao());
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}	
	
	@Bean
	public IdCheckService idCheckService() {
		return new IdCheckService(memberDao());
	}
	
	@Bean
	public EditMemberService editMemberService() {
		return new EditMemberService(memberDao());
	}
	
	@Bean
	
	public DeleteMemberService deleteMemberService() {
		return new DeleteMemberService(memberDao());
	}
	
	
	//ProductDAO 생성에 따른 빈 생성
	@Bean
	public ProductDAO productDAO() {
		return new ProductDAO(dataSource());
	}
	
	//ProductService 생성에 따른 빈 생성
	@Bean
	public ProductService productService() {
		return new ProductService(productDAO());
	}
	
	@Bean
	public CartDAO cartDAO() {
		return new CartDAO(dataSource());
	}
	@Bean 
	public CartService cartService() {
		return new CartService(cartDAO());
	}

	@Bean
	public OrderDAO orderDAO() {
		return new OrderDAO(dataSource());
	}
	@Bean
	public OrderService orderService() {
		return new OrderService(orderDAO());
	}
}
