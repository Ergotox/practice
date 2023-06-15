package art.magnet.partner.u202112321.si652ebu202112321.painting.domain.persistence;

import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.model.Idea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IdeaRepository extends JpaRepository<Idea, Long> {
    List<Idea> findAllByInitialSamples(int initialSamples);
    Idea findByTextQuery(String textQuery);
    Idea findByAuthorId(Long authorId);
}
