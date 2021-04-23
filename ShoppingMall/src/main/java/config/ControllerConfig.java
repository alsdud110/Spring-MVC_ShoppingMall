package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import controller.LoginController;
import controller.LogoutController;
import controller.RegisterController;
import spring.AuthService;
import spring.ChangePasswordService;

@Configuration
public class ControllerConfig {
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		return controller;
	}

	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
//	@Bean
//	public ModifyController changePwdController() {
//		ModifyController controller = new ModifyController();
//		controller.setChangePasswordService(changePasswordService);
//		return controller;
//	}
}
