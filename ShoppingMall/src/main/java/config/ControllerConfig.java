package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

<<<<<<< HEAD

=======
import cart.CartController;
import controller.ChangePasswordService;
>>>>>>> 황민영
import controller.ChangePwdController;
import controller.MainController;
import edit.EditMemberController;
import edit.EditMemberService;
import login.AuthService;
import login.LoginController;
import login.LogoutController;
import member.MemberService;
<<<<<<< HEAD
import register.MemberRegisterService;
=======
>>>>>>> 황민영
import product.ProductController;
import product.ProductService;
<<<<<<< HEAD
=======
import register.MemberRegisterService;
>>>>>>> 황민영
import register.RegisterController;

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
<<<<<<< HEAD
	private MemberService memberService;
=======
	private MemberService memberServiceImpl;
>>>>>>> 황민영

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
<<<<<<< HEAD
		controller.setMemberService(memberService);
=======
		controller.setMemberService(memberServiceImpl);
>>>>>>> 황민영
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


//	@Bean
//	public ModifyController changePwdController() {
//		ModifyController controller = new ModifyController();
//		controller.setChangePasswordService(changePasswordService);
//		return controller;
//	}
}
