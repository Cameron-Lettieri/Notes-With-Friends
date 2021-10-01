package roundTrip.backendTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import roundTrip.backendTest.Users.*;
import roundTrip.backendTest.Notes.*;

@SpringBootApplication
public class BackendTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTestApplication.class, args);
	}
	@Bean
	CommandLineRunner initUser(UserRepository userRepository, NoteRepository noteRepository) {
        return args -> {
            User user1 = new User("John", "john@somemail.com", "pass");
            User user2 = new User("Jane", "jane@somemail.com","pass");
            User user3 = new User("Justin", "justin@somemail.com","pass");
            Note note1= new Note(NoteType.DEFALUT);
            Note note2= new Note(NoteType.CHECK);
            Note note3= new Note(NoteType.TABLE);
            noteRepository.save(note1);
            noteRepository.save(note2);
            noteRepository.save(note3);
            user1.addNote(note1);
            user2.addNote(note2);
            user3.addNote(note3);
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

        };
    }
}
