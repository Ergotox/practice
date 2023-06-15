package art.magnet.partner.u202112321.si652ebu202112321.painting.api.rest;

import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.service.IdeaService;
import art.magnet.partner.u202112321.si652ebu202112321.painting.mapping.IdeaMapper;
import art.magnet.partner.u202112321.si652ebu202112321.painting.resource.CreateIdeaResource;
import art.magnet.partner.u202112321.si652ebu202112321.painting.resource.IdeaResource;
import art.magnet.partner.u202112321.si652ebu202112321.painting.resource.UpdateIdeaResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ideas")
public class IdeaController {
    private final IdeaService ideaService;
    private final IdeaMapper mapper;

    public IdeaController(IdeaService ideaService, IdeaMapper mapper) {
        this.ideaService = ideaService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<IdeaResource> getAllIdeas(Pageable pageable){
        return mapper.modelListPage(ideaService.getAll(), pageable);
    }

    @GetMapping("{ideaId}")
    public IdeaResource getIdeaById(@PathVariable Long ideaId){
        return mapper.toResource(ideaService.getById(ideaId));
    }
    @PostMapping
    public ResponseEntity<IdeaResource> createIdea(@RequestBody CreateIdeaResource resource){
        return new ResponseEntity<>(mapper.toResource(ideaService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{ideaId}")
    public IdeaResource updateIdea(@PathVariable Long ideaId,
                                   @RequestBody UpdateIdeaResource resource){
        return mapper.toResource(ideaService.update(ideaId,mapper.toModel(resource)));
    }

    @DeleteMapping("{ideaId}")
    public ResponseEntity<?> deleteIdea(@PathVariable Long ideaId){
        return ideaService.delete(ideaId);
    }
}
