package org.vaadin.example;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

@Route("")
@PageTitle("Home | My App")
@CssImport("./themes/my-theme/styles.css")
public class MainView extends AppLayout {

    private final GreetService greetService;

    public MainView(GreetService greetService) {
        this.greetService = greetService;
        createDrawer();
        createMainContent();
    }

    private void createDrawer() {
        H1 appTitle = new H1("My App");
        appTitle.addClassName("drawer-title");

        RouterLink helloWorldLink = new RouterLink("Hello World", HelloWorldView.class);
        helloWorldLink.addClassName("menu-item");
        helloWorldLink.addComponentAsFirst(VaadinIcon.GLOBE.create());

        RouterLink personelLink = new RouterLink("Personel", PersonelView.class);
        personelLink.addClassName("menu-item");
        personelLink.addComponentAsFirst(VaadinIcon.USERS.create());

        RouterLink aboutLink = new RouterLink("About", AboutView.class);
        aboutLink.addClassName("menu-item");
        aboutLink.addComponentAsFirst(VaadinIcon.INFO_CIRCLE.create());

        VerticalLayout drawerLayout = new VerticalLayout(appTitle, helloWorldLink,  personelLink, aboutLink);
        drawerLayout.addClassName("drawer-menu");

        addToDrawer(drawerLayout);
    }

    private void createMainContent() {
        VerticalLayout content = new VerticalLayout();
        content.addClassName("content");

        TextField nameField = new TextField("Your name");
        nameField.addClassName("input-field");

        Label messageLabel = new Label("");
        messageLabel.addClassName("message-label");

        Button greetButton = new Button("Greet Me", event -> {
            String message = greetService.greet(nameField.getValue());
            messageLabel.setText(message);
        });
        greetButton.addClassName("primary-button");

        VerticalLayout inputContainer = new VerticalLayout(nameField, greetButton, messageLabel);
        inputContainer.addClassName("centered-form");
        inputContainer.setSizeFull();

        content.add(inputContainer);
        setContent(content);
    }
}