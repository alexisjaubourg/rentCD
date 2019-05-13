package com.example.rentCD;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentCdApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RentCdApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentCdApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CdRepository repository) {
		return (args) -> {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse("2018-10-09");
			log.info(date.toString());
			
			Cd sftd = new Cd(0, "SongForTheDead");
			Artist qotsa = new Artist(0, "QueensOfTheStoneAge");
			sftd.getArtists().add(qotsa);
			qotsa.setCd(sftd);
			
			Artist dg = new Artist(1, "DaveGrohl");
			sftd.getArtists().add(dg);
			dg.setCd(sftd);
			
			repository.save(sftd);	
		};
	}

}
