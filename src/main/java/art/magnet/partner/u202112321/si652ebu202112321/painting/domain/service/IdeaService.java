package art.magnet.partner.u202112321.si652ebu202112321.painting.domain.service;

import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.model.Idea;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IdeaService {
    List<Idea> getAll();
    Page<Idea> getAll(Pageable pageable);
    Idea getById(Long ideaId);
    Idea create(Idea idea);

    Idea update(Long ideaId, Idea idea);
    ResponseEntity<?> delete(Long ideaId);

}
