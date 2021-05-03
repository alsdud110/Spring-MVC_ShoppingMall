package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cart.CartController;
import cart.CartService;
import controller.MainController;
import edit.ChangePasswordService;
import edit.ChangePwdController;
import edit.EditMemberController;
import edit.EditMemberService;
import login.LoginController;
import login.LoginService;
import login.LogoutController;
import product.ProductController;
import product.ProductService;
import register.MemberRegisterService;
import register.RegisterController;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private EditMemberService editMemberService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegisterService);
		controller.setLoginService(loginService);
		return controller;
	}

	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setLoginService(loginService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
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
	public MainController mainController() { //최고 판마량 제품 보여주기위해 productService 추가
		MainController controller = new MainController();
		controller.setProductService(productService);
		return controller;
	}

	@Bean
	public ProductController productController() {
		ProductController controller = new ProductController();
		controller.setProductService(productService);
		return controller;
	}

	@Bean
	public CartController cartController() {
		CartController controller = new CartController();
		controller.setCartService(cartService);
		return controller;
	}


}
