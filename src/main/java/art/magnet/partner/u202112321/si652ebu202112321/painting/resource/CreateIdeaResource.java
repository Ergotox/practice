package art.magnet.partner.u202112321.si652ebu202112321.painting.resource;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateIdeaResource {

    @NotNull
    private String textQuery;

    @NotNull
    private int initialSamples;

    @NotNull
    private Long authorId;
}
