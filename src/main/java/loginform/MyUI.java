package loginform;

import javax.servlet.annotation.WebServlet;

import com.ejt.vaadin.loginform.LoginForm;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("loginform.MyAppWidgetset")
public class MyUI extends UI {

	public class MyLoginForm extends LoginForm {

		@Override
		protected Component createContent(TextField userNameField, PasswordField passwordField, Button loginButton) {
			VerticalLayout layout = new VerticalLayout();
			layout.setSpacing(true);
			layout.addComponent(userNameField);
			layout.addComponent(passwordField);
			layout.addComponent(loginButton);
			
			/*
			 * Custom Button #1, triggers login event
			 */
			layout.addComponent(new CustomButton());

			return layout;
		}

		@Override
		protected void login(String userName, String password) {
			Notification.show("Login event " + userName + ":" + password, Type.WARNING_MESSAGE);
		}

	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		
		MyLoginForm myLoginForm = new MyLoginForm();
		layout.addComponent(myLoginForm);
		
		/*
		 * Custom Button #2
		 */
		layout.addComponent(new CustomButton());

	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
