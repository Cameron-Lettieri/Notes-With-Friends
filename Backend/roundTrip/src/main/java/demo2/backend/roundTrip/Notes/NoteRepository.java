package demo2.backend.roundTrip.Notes;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;


	public interface NoteRepository extends JpaRepository<Note, Long> 
	{
	    
	    Note findById(int id);

	   @Transactional
	    void deleteById(int id);
	}