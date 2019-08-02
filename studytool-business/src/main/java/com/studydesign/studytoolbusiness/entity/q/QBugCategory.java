package com.studydesign.studytoolbusiness.entity.q;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.studydesign.studytoolbusiness.entity.entitis.BugCategory;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBugCategory is a Querydsl query type for BugCategory
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBugCategory extends com.querydsl.sql.RelationalPathBase<BugCategory> {

    private static final long serialVersionUID = -1514015989;

    public static final QBugCategory bugCategory = new QBugCategory("bug_category");

    public final StringPath bugCategoryComment = createString("bugCategoryComment");

    public final StringPath bugCategoryInfo = createString("bugCategoryInfo");

    public final StringPath id = createString("id");

    public final com.querydsl.sql.PrimaryKey<BugCategory> primary = createPrimaryKey(id);

    public QBugCategory(String variable) {
        super(BugCategory.class, forVariable(variable), "null", "bug_category");
        addMetadata();
    }

    public QBugCategory(String variable, String schema, String table) {
        super(BugCategory.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBugCategory(String variable, String schema) {
        super(BugCategory.class, forVariable(variable), schema, "bug_category");
        addMetadata();
    }

    public QBugCategory(Path<? extends BugCategory> path) {
        super(path.getType(), path.getMetadata(), "null", "bug_category");
        addMetadata();
    }

    public QBugCategory(PathMetadata metadata) {
        super(BugCategory.class, metadata, "null", "bug_category");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(bugCategoryComment, ColumnMetadata.named("bug_category_comment").withIndex(3).ofType(Types.LONGVARCHAR).withSize(65535));
        addMetadata(bugCategoryInfo, ColumnMetadata.named("bug_category_info").withIndex(2).ofType(Types.VARCHAR).withSize(255));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

