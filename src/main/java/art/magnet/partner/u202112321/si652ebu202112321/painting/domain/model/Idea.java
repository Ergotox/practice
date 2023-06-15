package art.magnet.partner.u202112321.si652ebu202112321.painting.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ideas")
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String textQuery;

    @NotNull
    private int initialSamples;

    @NotNull
    private Long authorId;

}
