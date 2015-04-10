package loginform;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * Basic custom javascript button, it simply does nothing.
 * @author seb
 * @since Apr 10, 2015
 */
@JavaScript({"jquery.min.js", "custom_button_connector.js"})
public class CustomButton extends AbstractJavaScriptComponent {

	@Override
	protected CustomButtonState getState() {
		return (CustomButtonState) super.getState();
	}
}
