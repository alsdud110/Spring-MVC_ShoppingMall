package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cart.CartController;
import controller.ChangePwdController;
import controller.EditMemberController;
import controller.LoginController;
import controller.LogoutController;
import controller.MainController;
import controller.RegisterController;
import product.ProductController;
import product.ProductDAO;
import product.ProductService;
import spring.AuthService;
import spring.ChangePasswordService;
import spring.EditMemberService;
import spring.MemberRegisterService;
import spring.MemberServiceImpl;

@Configuration
public class ControllerConfig {
	@Autowired
	private AuthService authService;
	@Autowired
	private EditMemberService editMemberService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberRegisterService memberRegisterService;
	@Autowired
	private ProductService productServicec;
	@Autowired
	private MemberServiceImpl memberServiceImpl;

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegisterService);
		return controller;
	}

	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		controller.setMemberServiceImpl(memberServiceImpl);
		return controller;
	}
	
	@Bean
	public EditMemberController editMemberController() {
		return new EditMemberController(editMemberService);
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public MainController mainController() {
		return new MainController();
	}
	
	@Bean
	public ProductController productController() {
		ProductController controller = new ProductController();
		controller.setProductService(productServicec);
		return controller;
	}

	@Bean
	public CartController cartController() {
		return new CartController();
	}
	
//	@Bean
//	public ModifyController changePwdController() {
//		ModifyController controller = new ModifyController();
//		controller.setChangePasswordService(changePasswordService);
//		return controller;
//	}
}
