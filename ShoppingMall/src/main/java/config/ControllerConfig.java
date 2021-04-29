package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cart.CartController;
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
	

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegisterService);
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
	public MainController mainController() {
		return new MainController();
	}

	@Bean
	public ProductController productController() {
		ProductController controller = new ProductController();
		controller.setProductService(productService);
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
