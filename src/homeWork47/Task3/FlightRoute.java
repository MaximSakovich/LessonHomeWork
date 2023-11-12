package homeWork47.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Task3
//Построение маршрута.
//У вас есть карта прямых рейсов, где ключ — это название города отправления,
// а значение — город назначения. Необходимо написать функцию, которая принимает карту рейсов,
// город отправления и город назначения и возвращает список городов, через которые проходит маршрут.
// Если прямого рейса нет, функция должна пытаться найти маршрут с пересадками.
//Условия:
//Если прямого рейса нет, нужно искать возможные пересадки через другие города.
//Если маршрут невозможно составить, функция должна возвращать пустой список.
//Предполагается, что нет циклических маршрутов,
// и из города можно уехать только в один другой город (один к одному соответствие).

public class FlightRoute {
    public static List<String> findRoute(Map<String, String> directFlights, String departure, String destination) {
        List<String> route = new ArrayList<>();
        route.add(departure);

        if (directFlights.containsKey(departure) && directFlights.get(departure).equals(destination)) {
            route.add(destination);
            return route;
        }

        if (!directFlights.containsKey(departure) || !directFlights.containsValue(destination)) {
            for (Map.Entry<String, String> entry : directFlights.entrySet()) {
                if (entry.getValue().equals(destination)) {
                    List<String> via = findRoute(directFlights, departure, entry.getKey());
                    via.add(destination);
                    return via;
                }
            }
        }

        for (Map.Entry<String, String> entry : directFlights.entrySet()) {
            if (entry.getKey().equals(departure)) {
                route.addAll(findRoute(directFlights, entry.getValue(), destination));
                break;
            }
        }

        if (!route.contains(destination)) {
            route.clear();
        }

        return route;
    }

    public static void main(String[] args) {
        Map<String, String> directFlights = new HashMap<>();
        directFlights.put("New York", "Chicago");
        directFlights.put("Chicago", "Denver");
        directFlights.put("Denver", "Las Vegas");
        directFlights.put("Boston", "Miami");
        directFlights.put("Miami", "New York");
        directFlights.put("Los Angeles", "San Francisco");
        directFlights.put("San Francisco", "New York");

        List<String> route = findRoute(directFlights, "Boston", "Las Vegas");
        System.out.println(route);
    }
}