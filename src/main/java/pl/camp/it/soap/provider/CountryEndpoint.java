package pl.camp.it.soap.provider;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.camp.it.countries.Country;
import pl.camp.it.countries.Currency;
import pl.camp.it.countries.GetCountryRequest;
import pl.camp.it.countries.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://it.camp.pl/countries/";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryResponse(@RequestPayload GetCountryRequest getCountryRequest) {
        System.out.println("Działa !!");
        System.out.println(getCountryRequest.getName());

        GetCountryResponse getCountryResponse = new GetCountryResponse();
        Country country = getCountry(getCountryRequest.getName());
        getCountryResponse.setCountry(country);

        return getCountryResponse;
    }

    public Country getCountry(String name) {
        if(name.equals("Polska")) {
            Country country = new Country();
            country.setName("Polska");
            country.setPopulation(40000000);
            country.setCapital("Warszawa");
            country.setCurrency(Currency.PLN);
            return country;
        }

        if(name.equals("Hiszpania")) {
            Country country = new Country();
            country.setName("Hiszpania");
            country.setPopulation(47000000);
            country.setCapital("Madryt");
            country.setCurrency(Currency.EUR);
            return country;
        }

        if(name.equals("Wielka Brytania")) {
            Country country = new Country();
            country.setName("Wielka Brytania");
            country.setPopulation(67000000);
            country.setCapital("Londyn");
            country.setCurrency(Currency.GBP);
            return country;
        }

        return null;
    }
}
