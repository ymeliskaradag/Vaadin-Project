package org.vaadin.example;

import com.vaadin.flow.spring.annotation.SpringComponent;
import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class PersonelService {

    public List<Personel> getPersonelList() {
        List<Personel> personeller = new ArrayList<>();
        personeller.add(new Personel("12345678901", "Ahmet", "Yılmaz"));
        personeller.add(new Personel("23456789012", "Mehmet", "Demir"));
        personeller.add(new Personel("34567890123", "Ayşe", "Kaya"));
        personeller.add(new Personel("45678901234", "Fatma", "Çelik"));
        personeller.add(new Personel("56789012345", "Ali", "Öztürk"));
        personeller.add(new Personel("67890123456", "Zeynep", "Koç"));
        personeller.add(new Personel("78901234567", "Mustafa", "Şahin"));
        personeller.add(new Personel("89012345678", "Elif", "Arslan"));
        personeller.add(new Personel("90123456789", "Burak", "Eren"));
        personeller.add(new Personel("01234567890", "Hülya", "Güneş"));
        return personeller;
    }
}
