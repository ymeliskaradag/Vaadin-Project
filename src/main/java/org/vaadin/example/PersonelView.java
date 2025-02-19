package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.component.dependency.CssImport;
import java.util.List;

@Route(value = "personel", layout = MainView.class)
@PageTitle("Personel | My App")
@CssImport("./themes/my-theme/styles.css")
public class PersonelView extends VerticalLayout {

    private final PersonelService personelService;
    private Grid<Personel> grid = new Grid<>(Personel.class);
    private ListDataProvider<Personel>dataProvider;
    private TextField searchField = new TextField("İsim ile ara");

    public PersonelView(PersonelService personelService) {
        this.personelService = personelService;
        addClassName("content");


        grid.removeAllColumns();
        grid.addColumn(Personel::getTc).setHeader("TC Kimlik No").setSortable(true);
        grid.addColumn(Personel::getAd).setHeader("Ad").setSortable(true);
        grid.addColumn(Personel::getSoyad).setHeader("Soyad").setSortable(true);


        List<Personel> personelList = personelService.getPersonelList();
        dataProvider = new ListDataProvider<>(personelList);
        grid.setItems(dataProvider);

        searchField.setPlaceholder("İsim giriniz...");
        searchField.setClearButtonVisible(true);

        searchField.setValueChangeMode(ValueChangeMode.EAGER); // Anlık değişiklikleri takip etmek için
        searchField.addValueChangeListener(event -> filterGrid(event.getValue()));

        add(searchField, grid);
    }

    private void filterGrid(String searchText) {
        if (searchText == null || searchText.trim().isEmpty()) {
            dataProvider.clearFilters();
        } else {
            dataProvider.setFilter(Personel::getAd,
                    ad -> ad.toLowerCase().startsWith(searchText.toLowerCase()));
        }
    }
}
