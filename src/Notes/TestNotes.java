package Notes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestNotes {

	public static void main(String[] args) {
		
		List<Notes> notesList = new ArrayList();
		
		notesList.add(new Notes(1,"aa",11));
		notesList.add(new Notes(2,"bb",33));
		notesList.add(new Notes(3,"cc",22));
		notesList.add(new Notes(4,"dd",44));
		notesList.add(new Notes(5,"ee",55));
		
		Map<String,Long> notesRecord = notesList.stream().sorted(Comparator.comparingLong(Notes::getTagId).reversed())
			.collect(Collectors.toMap(Notes::getName, Notes::getTagId,
					(oldValue,newValue)->oldValue,LinkedHashMap::new));
		System.out.println("Notes : " + notesRecord);

	}

}
