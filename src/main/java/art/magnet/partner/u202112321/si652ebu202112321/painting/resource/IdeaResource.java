package art.magnet.partner.u202112321.si652ebu202112321.painting.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class IdeaResource {
    private Long id;
    private String textQuery;
    private int initialSamples;
    private Long authorId;
}
