package com.studydesign.studytoolbusiness.entity.q;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.studydesign.studytoolbusiness.entity.entitis.UserInfo;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QUserInfo extends com.querydsl.sql.RelationalPathBase<UserInfo> {

    private static final long serialVersionUID = -592004544;

    public static final QUserInfo userInfo = new QUserInfo("user_info");

    public final StringPath id = createString("id");

    public final StringPath userLevel = createString("userLevel");

    public final StringPath userName = createString("userName");

    public final StringPath userNickname = createString("userNickname");

    public final StringPath userPassword = createString("userPassword");

    public final StringPath userWorkspace = createString("userWorkspace");

    public final com.querydsl.sql.PrimaryKey<UserInfo> primary = createPrimaryKey(id);

    public QUserInfo(String variable) {
        super(UserInfo.class, forVariable(variable), "null", "user_info");
        addMetadata();
    }

    public QUserInfo(String variable, String schema, String table) {
        super(UserInfo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QUserInfo(String variable, String schema) {
        super(UserInfo.class, forVariable(variable), schema, "user_info");
        addMetadata();
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        super(path.getType(), path.getMetadata(), "null", "user_info");
        addMetadata();
    }

    public QUserInfo(PathMetadata metadata) {
        super(UserInfo.class, metadata, "null", "user_info");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
        addMetadata(userLevel, ColumnMetadata.named("user_level").withIndex(6).ofType(Types.VARCHAR).withSize(255));
        addMetadata(userName, ColumnMetadata.named("user_name").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(userNickname, ColumnMetadata.named("user_nickname").withIndex(4).ofType(Types.VARCHAR).withSize(255));
        addMetadata(userPassword, ColumnMetadata.named("user_password").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(userWorkspace, ColumnMetadata.named("user_workspace").withIndex(5).ofType(Types.VARCHAR).withSize(255));
    }

}

