Zadanie - aplikacja messaging do bazy danych:
- poprawiłem sql generujacy tabelkę - była literówka w timestamp
- poprawiłęm literówki w menu w messages
- przeniosłem nasze propertisy z tłumaczeniami do poprawnej scieżki
 
Zadanie: aplikacja pantry_app:
- błąd jest w PantryService - musi implementować serializable:
  public class PantryService implements Serializable

Zadanie: emergency_system nie było w klasie Ambulans w return wpisane Ambulans:
  public String getUnitType() {
        return "Ambulans";
    }

Wszystko poprawiłem:)
