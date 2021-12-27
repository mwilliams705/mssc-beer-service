package dev.mwdesigns.msscbeerservice.bootstrap;

import dev.mwdesigns.msscbeerservice.domain.Beer;
import dev.mwdesigns.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count()==0){
            beerRepository.save(Beer.builder()
                            .beerName("Mango Bobs")
                            .beerStyle("IPA")
                            .upc(330944000001L)
                            .price(new BigDecimal("12.95"))
                            .minOnHand(12)
                            .quantityToBrew(200)
                            .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("Pale Ale")
                    .upc(330944000021L)
                    .price(new BigDecimal("11.95"))
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .build());
        }
        System.out.println("Loaded Beers: "+ beerRepository.count());
    }
}
