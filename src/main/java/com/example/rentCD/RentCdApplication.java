package com.example.rentCD;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentCdApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentCdApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CdRepository repository) {
		return (args) -> {

			Cd dsm = new Cd(0, "The Dark Side Of The Moon");
			Artist pf = new Artist(0, "Pink Floyd");
			Artist dg = new Artist(1, "David Gilmour");
			Track ggs = new Track (0, "The Great Gig In The Sky");
			
			dsm.getArtists().add(pf);
			pf.setCd(dsm);
			
			dsm.getArtists().add(dg);
			dg.setCd(dsm);
			
			dsm.getTracks().add(ggs);
			ggs.setCd(dsm);
			
			repository.save(dsm);	
		};
	}

}
