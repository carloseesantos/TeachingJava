package com.tbt.api.essentials.mapper;

import com.tbt.api.essentials.domain.User;
import com.tbt.api.essentials.requests.UserPostRequestBody;
import com.tbt.api.essentials.requests.UserPutRequestBody;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-09T00:32:21-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Private Build)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User toUser(UserPostRequestBody userPostRequestBody) {
        if ( userPostRequestBody == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( userPostRequestBody.getName() );

        return user.build();
    }

    @Override
    public User toUser(UserPutRequestBody userPutRequestBody) {
        if ( userPutRequestBody == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userPutRequestBody.getId() );
        user.name( userPutRequestBody.getName() );

        return user.build();
    }
}
