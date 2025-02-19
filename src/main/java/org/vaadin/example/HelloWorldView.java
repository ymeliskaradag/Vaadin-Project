package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dependency.CssImport;

@Route(value = "hello", layout = MainView.class)
@PageTitle("Hello World | My App")
@CssImport("./themes/my-theme/styles.css")
public class HelloWorldView extends VerticalLayout {

    public HelloWorldView() {
        addClassName("hello-world-layout");

        // Menü ikonu ve başlık
        Button menuButton = new Button(VaadinIcon.MENU.create());
        menuButton.addClassName("menu-icon");

        H1 pageTitle = new H1("Hello World");
        pageTitle.addClassName("page-title");

        HorizontalLayout header = new HorizontalLayout(menuButton, pageTitle);
        header.addClassName("page-header");

        TextField nameField = new TextField("Your name");
        nameField.addClassName("helloWName-field");

        Label messageLabel = new Label(""); // Burada mesaj gösterilecek
        messageLabel.addClassName("message-label");

        Button sayHelloButton = new Button("Say hello");
        sayHelloButton.addClassName("say-hello-button");

        HorizontalLayout formContainer = new HorizontalLayout(nameField, sayHelloButton);
        formContainer.addClassName("form-container");

        VerticalLayout messageContainer = new VerticalLayout(messageLabel);
        messageContainer.addClassName("message-container");

        VerticalLayout formLayout = new VerticalLayout(formContainer, messageContainer);
        formLayout.setAlignItems(FlexComponent.Alignment.START);

        VerticalLayout layout = new VerticalLayout(header, formLayout);
        layout.setAlignItems(FlexComponent.Alignment.START);
        layout.setWidthFull();

        add(layout);


    }
}