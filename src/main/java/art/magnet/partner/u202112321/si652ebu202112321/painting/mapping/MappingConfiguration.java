package art.magnet.partner.u202112321.si652ebu202112321.painting.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("paintingMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public IdeaMapper ideaMapper(){
        return new IdeaMapper();
    }
}
