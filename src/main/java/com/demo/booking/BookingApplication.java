package com.demo.booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.demo.booking.dto.BookingDto;
import com.demo.booking.dto.Person;
import com.demo.booking.dto.RoomMasterDto;
import com.demo.booking.tasks.RoomWorker;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class BookingApplication {

	private final static Logger log = LoggerFactory.getLogger(BookingApplication.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BookingApplication.class, args);
		System.exit(0);
	}
//	PersonRepository personRepository,
//	RoomMasterRepository roomMasterRepository,
//	BookingRepository bookingRepository
	@Bean
	CommandLineRunner demo(RoomWorker roomWorker) {
		return args -> {
			//room
			//booking
			BookingDto bk1 = new BookingDto("test bookingaa","1","type1","1");
			BookingDto bk2 = new BookingDto("test bookingaa","1","type2","1");
			roomWorker.booking(new ActivatedJob() {
				@Override
				public long getKey() {
					return 0;
				}

				@Override
				public String getType() {
					return null;
				}

				@Override
				public long getProcessInstanceKey() {
					return 0;
				}

				@Override
				public String getBpmnProcessId() {
					return null;
				}

				@Override
				public int getProcessDefinitionVersion() {
					return 0;
				}

				@Override
				public long getProcessDefinitionKey() {
					return 0;
				}

				@Override
				public String getElementId() {
					return null;
				}

				@Override
				public long getElementInstanceKey() {
					return 0;
				}

				@Override
				public Map<String, String> getCustomHeaders() {
					return null;
				}

				@Override
				public String getWorker() {
					return null;
				}

				@Override
				public int getRetries() {
					return 0;
				}

				@Override
				public long getDeadline() {
					return 0;
				}

				@Override
				public String getVariables() {
					return null;
				}

				@Override
				public Map<String, Object> getVariablesAsMap() {
					return null;
				}

				@Override
				public <T> T getVariablesAsType(Class<T> variableType) {
					return null;
				}

				@Override
				public String toJson() {
					return null;
				}
			}, bk1);



//			roomMasterRepository.deleteAll();
//			RoomMasterDto rm1 = new RoomMasterDto("test room so 1");
//			roomMasterRepository.save(rm1);
//
//			RoomMasterDto rm3 = new RoomMasterDto("test room so 1");
//			roomMasterRepository.save(rm3);
//
//			RoomMasterDto rm2 = new RoomMasterDto("test room so 2");
//			roomMasterRepository.save(rm2);
//
//			//booking
//			bookingRepository.deleteAll();
//			BookingDto bk1 = new BookingDto("test booking1","1","1","1");
//			BookingDto bk2 = new BookingDto("test booking1","1","1","1");
//			bookingRepository.save(bk1);
//			bookingRepository.save(bk2);
//
//			//set rela
//			List<BookingDto> bks1s = new ArrayList();
//			bks1s.add(bk1);
//			rm1.setBookings(bks1s);
//
//			roomMasterRepository.save(rm1);
//
//			//person
//			personRepository.deleteAll();

//			Person greg = new Person("Greg");
//			Person roy = new Person("Roy");
//			Person craig = new Person("Craig");
//
//			List<Person> team = Arrays.asList(greg, roy, craig);
//
//			log.info("Before linking up with Neo4j...");
//
//			team.stream().forEach(person -> log.info("\t" + person.toString()));
//
//			personRepository.save(greg);
//			personRepository.save(roy);
//			personRepository.save(craig);
//
//			greg = personRepository.findByName(greg.getName());
//			greg.worksWith(roy);
//			greg.worksWith(craig);
//			personRepository.save(greg);
//
//			roy = personRepository.findByName(roy.getName());
//			roy.worksWith(craig);
//			// We already know that roy works with greg
//			personRepository.save(roy);
//
//			// We already know craig works with roy and greg
//
//			log.info("Lookup each person by name...");
//			team.stream().forEach(person -> log.info(
//					"\t" + personRepository.findByName(person.getName()).toString()));
//
//			List<Person> teammates = personRepository.findByTeammatesName(greg.getName());
//			log.info("The following have Greg as a teammate...");
//			teammates.stream().forEach(person -> log.info("\t" + person.getName()));
		};
	}

}