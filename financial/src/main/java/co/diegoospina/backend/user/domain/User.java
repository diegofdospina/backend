package co.diegoospina.backend.user.domain;

import lombok.Builder;
import lombok.NonNull;

@Builder
public record User(
    @NonNull String userName,
    @NonNull String name
) {

}
