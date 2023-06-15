package art.magnet.partner.u202112321.si652ebu202112321.painting.service;

import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.model.Idea;
import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.persistence.IdeaRepository;
import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.service.IdeaService;
import art.magnet.partner.u202112321.si652ebu202112321.shared.exception.ResourceNotFoundException;
import art.magnet.partner.u202112321.si652ebu202112321.shared.exception.ResourceValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IdeaServiceImpl implements IdeaService {

    private static final String ENTITY = "Idea";
    private final IdeaRepository ideaRepository;
    private final Validator validator;

    public IdeaServiceImpl(IdeaRepository ideaRepository, Validator validator) {
        this.ideaRepository = ideaRepository;
        this.validator = validator;
    }

    @Override
    public List<Idea> getAll() {
        return ideaRepository.findAll();
    }

    @Override
    public Page<Idea> getAll(Pageable pageable) {
        return ideaRepository.findAll(pageable);
    }

    @Override
    public Idea getById(Long ideaId) {
        return ideaRepository.findById(ideaId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ideaId));
    }

    @Override
    public Idea create(Idea idea) {
        Set<ConstraintViolation<Idea>> violations = validator.validate(idea);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        Idea ideaWithTextQuery = ideaRepository.findByTextQuery(idea.getTextQuery());
        if(ideaWithTextQuery !=null)
            throw new ResourceValidationException(ENTITY, "An idea with the same textQuery already exist");


        Idea ideaWithAuthorId = ideaRepository.findByAuthorId(idea.getAuthorId());
        if(ideaWithAuthorId !=null)
            throw new ResourceValidationException(ENTITY, "An idea with the same Author Id already exist");


        return ideaRepository.save(idea);
    }

    @Override
    public Idea update(Long ideaId, Idea idea) {
        Set<ConstraintViolation<Idea>> violations = validator.validate(idea);

        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);


        Idea ideaWithTextQuery = ideaRepository.findByTextQuery(idea.getTextQuery());

        if(ideaWithTextQuery != null && !ideaWithTextQuery.getId().equals(idea.getId()))
            throw new ResourceValidationException(ENTITY,
                    "An idea with the same text query already exists.");



        return ideaRepository.findById(ideaId).map(ideaToUpdate ->
                        ideaRepository.save(
                                ideaToUpdate.withTextQuery(idea.getTextQuery())
                                        .withInitialSamples(idea.getInitialSamples())
                                        .withAuthorId(idea.getAuthorId())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ideaId));

    }

    @Override
    public ResponseEntity<?> delete(Long ideaId) {
        return ideaRepository.findById(ideaId).map(idea -> {
                    ideaRepository.delete(idea);
                    return ResponseEntity.ok().build();})
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ideaId));
    }
}
