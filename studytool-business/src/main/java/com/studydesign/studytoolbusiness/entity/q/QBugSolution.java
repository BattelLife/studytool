package com.studydesign.studytoolbusiness.entity.q;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.studydesign.studytoolbusiness.entity.entitis.BugSolution;


import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBugSolution is a Querydsl query type for BugSolution
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QBugSolution extends com.querydsl.sql.RelationalPathBase<BugSolution> {

    private static final long serialVersionUID = -72580218;

    public static final QBugSolution bugSolution = new QBugSolution("bug_solution");

    public final StringPath bugSolutionInfo = createString("bugSolutionInfo");

    public final StringPath id = createString("id");

    public final com.querydsl.sql.PrimaryKey<BugSolution> primary = createPrimaryKey(id);

    public QBugSolution(String variable) {
        super(BugSolution.class, forVariable(variable), "null", "bug_solution");
        addMetadata();
    }

    public QBugSolution(String variable, String schema, String table) {
        super(BugSolution.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBugSolution(String variable, String schema) {
        super(BugSolution.class, forVariable(variable), schema, "bug_solution");
        addMetadata();
    }

    public QBugSolution(Path<? extends BugSolution> path) {
        super(path.getType(), path.getMetadata(), "null", "bug_solution");
        addMetadata();
    }

    public QBugSolution(PathMetadata metadata) {
        super(BugSolution.class, metadata, "null", "bug_solution");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(bugSolutionInfo, ColumnMetadata.named("bug_solution_info").withIndex(2).ofType(Types.LONGVARCHAR).withSize(65535));
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

