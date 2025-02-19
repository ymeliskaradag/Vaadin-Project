package org.vaadin.example;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.ParentLayout;

@Route(value = "about" , layout = MainView.class)
@PageTitle("About | My App")
public class AboutView extends VerticalLayout {

    public AboutView() {
        add(new Label("This is the About page."));
    }
}