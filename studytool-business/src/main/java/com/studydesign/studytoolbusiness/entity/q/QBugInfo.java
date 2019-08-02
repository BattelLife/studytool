package com.studydesign.studytoolbusiness.entity.q;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.studydesign.studytoolbusiness.entity.entitis.BugInfo;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBugInfo is a Querydsl query type for BugInfo
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBugInfo extends com.querydsl.sql.RelationalPathBase<BugInfo> {

    private static final long serialVersionUID = -336615109;

    public static final QBugInfo bugInfo = new QBugInfo("bug_info");

    public final StringPath bugCategoryId = createString("bugCategoryId");

    public final StringPath bugComment = createString("bugComment");

    public final DateTimePath<java.sql.Timestamp> bugCreateTime = createDateTime("bugCreateTime", java.sql.Timestamp.class);

    public final StringPath bugCreator = createString("bugCreator");

    public final StringPath bugDetailinfo = createString("bugDetailinfo");

    public final BooleanPath bugIsoff = createBoolean("bugIsoff");

    public final StringPath bugSolutionId = createString("bugSolutionId");

    public final StringPath id = createString("id");

    public final com.querydsl.sql.PrimaryKey<BugInfo> primary = createPrimaryKey(id);

    public QBugInfo(String variable) {
        super(BugInfo.class, forVariable(variable), "null", "bug_info");
        addMetadata();
    }

    public QBugInfo(String variable, String schema, String table) {
        super(BugInfo.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBugInfo(String variable, String schema) {
        super(BugInfo.class, forVariable(variable), schema, "bug_info");
        addMetadata();
    }

    public QBugInfo(Path<? extends BugInfo> path) {
        super(path.getType(), path.getMetadata(), "null", "bug_info");
        addMetadata();
    }

    public QBugInfo(PathMetadata metadata) {
        super(BugInfo.class, metadata, "null", "bug_info");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(bugCategoryId, ColumnMetadata.named("bug_category_id").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(bugComment, ColumnMetadata.named("bug_comment").withIndex(3).ofType(Types.VARCHAR).withSize(255));
        addMetadata(bugCreateTime, ColumnMetadata.named("bug_create_time").withIndex(6).ofType(Types.TIMESTAMP).withSize(19));
        addMetadata(bugCreator, ColumnMetadata.named("bug_creator").withIndex(5).ofType(Types.VARCHAR).withSize(255));
        addMetadata(bugDetailinfo, ColumnMetadata.named("bug_detailinfo").withIndex(4).ofType(Types.LONGVARCHAR).withSize(65535));
        addMetadata(bugIsoff, ColumnMetadata.named("bug_isoff").withIndex(8).ofType(Types.BIT).withSize(1));
        addMetadata(bugSolutionId, ColumnMetadata.named("bug_solution_id").withIndex(7).ofType(Types.VARCHAR).withSize(255));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

