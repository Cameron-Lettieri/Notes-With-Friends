package experiments.databaseprototype.Notes;

import org.springframework.data.jpa.repository.JpaRepository;

import experiments.databaseprototype.Notes.Note;

/**
 * 
 * @author Nick Pehl, Cam Lettieri
 * 
 */ 
	public interface NoteRepository extends JpaRepository<Note, Long> 
	{
	    
	    Note findById(int id);

	   // @Transactional
	    void deleteById(int id);
	}
