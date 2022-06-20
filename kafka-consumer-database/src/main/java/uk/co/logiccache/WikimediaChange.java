package uk.co.logiccache;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wikimedia_change")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WikimediaChange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String wikiEventData;
}
