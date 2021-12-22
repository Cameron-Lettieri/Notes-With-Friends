package com.example.structureTest.NoteStructureTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;



public interface NoteRepositoryTest extends JpaRepository<NoteTest, Long>
{
	 NoteTest findById(int id);

	   @Transactional
	    void deleteById(int id);
}
