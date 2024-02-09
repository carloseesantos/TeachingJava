package com.tbt.api.essentials.mapper;

import com.tbt.api.essentials.domain.User;
import com.tbt.api.essentials.requests.UserPostRequestBody;
import com.tbt.api.essentials.requests.UserPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public abstract User toUser(UserPostRequestBody userPostRequestBody);
    public abstract User toUser(UserPutRequestBody userPutRequestBody);
}
