package art.magnet.partner.u202112321.si652ebu202112321.painting.resource;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateIdeaResource {
    private Long id;

    @NotNull
    private String textQuery;

    @NotNull
    private int initialSamples;

    @NotNull
    private Long authorId;
}
