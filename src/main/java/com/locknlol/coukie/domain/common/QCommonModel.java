package com.locknlol.coukie.domain.common;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCommonModel is a Querydsl query type for CommonModel
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QCommonModel extends EntityPathBase<CommonModel> {

    private static final long serialVersionUID = 1823235440L;

    public static final QCommonModel commonModel = new QCommonModel("commonModel");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.util.Date> modifiedAt = createDateTime("modifiedAt", java.util.Date.class);

    public final StringPath modifiedBy = createString("modifiedBy");

    public QCommonModel(String variable) {
        super(CommonModel.class, forVariable(variable));
    }

    public QCommonModel(Path<? extends CommonModel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCommonModel(PathMetadata metadata) {
        super(CommonModel.class, metadata);
    }

}

