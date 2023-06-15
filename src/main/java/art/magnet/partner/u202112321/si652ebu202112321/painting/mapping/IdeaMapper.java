package art.magnet.partner.u202112321.si652ebu202112321.painting.mapping;

import art.magnet.partner.u202112321.si652ebu202112321.painting.domain.model.Idea;
import art.magnet.partner.u202112321.si652ebu202112321.painting.resource.CreateIdeaResource;
import art.magnet.partner.u202112321.si652ebu202112321.painting.resource.IdeaResource;
import art.magnet.partner.u202112321.si652ebu202112321.painting.resource.UpdateIdeaResource;
import art.magnet.partner.u202112321.si652ebu202112321.shared.mapping.EnhanceModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class IdeaMapper implements Serializable {
    @Autowired
    private EnhanceModelMapper mapper;
    public IdeaResource toResource(Idea model){
        return mapper.map(model, IdeaResource.class);
    }
    public Idea toModel(CreateIdeaResource resource){
        return mapper.map(resource, Idea.class);
    }

    public Idea toModel(UpdateIdeaResource resource){return mapper.map(resource, Idea.class);}

    public Page<IdeaResource> modelListPage(List<Idea> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, IdeaResource.class),pageable, modelList.size());
    }
}
