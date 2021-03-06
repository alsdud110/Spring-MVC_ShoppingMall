package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cart.CartController;
import cart.CartService;
import controller.MainController;
import delete.DeleteMemberController;
import delete.DeleteMemberService;
import edit.ChangePasswordService;
import edit.ChangePwdController;
import edit.EditMemberController;
import edit.EditMemberService;
import login.LoginController;
import login.LoginService;
import login.LogoutController;
import order.OrderController;
import order.OrderService;
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
	
	@Autowired
	private DeleteMemberService deleteMemberService;

	@Autowired
	private OrderService orderService;

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
	public DeleteMemberController deleteMemberController() {
		DeleteMemberController controller = new DeleteMemberController();
		controller.setDeleteService(deleteMemberService);
		return controller;
	}
	@Bean
	public MainController mainController() { //?????? ????????? ?????? ?????????????????? productService ??????
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

	@Bean
	public OrderController orderController() {
		OrderController controller = new OrderController();
		controller.setOrderService(orderService,cartService);
		return controller;
	}

}
