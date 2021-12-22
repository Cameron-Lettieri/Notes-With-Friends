package com.example.structureTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.structureTest.NoteStructureTest.*;

@SpringBootApplication
public class StructureTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StructureTestApplication.class, args);
	}
	 @Bean
	  CommandLineRunner initUser(NoteRepositoryTest noteRep)
	  {
		 return args ->{
			NoteTest note1 = new NoteTest("A");
			NoteTest note2 = new NoteTest("B");
			NoteTest note3 = new NoteTest("C");
			
			DefalutNoteTest dNote1 = new DefalutNoteTest(note1);
			DefalutNoteTest dNote2 = new DefalutNoteTest(note2);
			DefalutNoteTest dNote3 = new DefalutNoteTest(note3);
			
			noteRep.save(note1);
			noteRep.save(note2);
			noteRep.save(note3);
		 };
	  }

}
