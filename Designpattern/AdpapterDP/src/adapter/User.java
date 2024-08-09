package adapter;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
 private UUID userId;
 private String name;
 private int pin;
 
}
