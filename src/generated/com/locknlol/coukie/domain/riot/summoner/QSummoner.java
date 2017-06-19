package com.locknlol.coukie.domain.riot.summoner;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSummoner is a Querydsl query type for Summoner
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSummoner extends EntityPathBase<Summoner> {

    private static final long serialVersionUID = -1178400367L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSummoner summoner = new QSummoner("summoner");

    public final com.locknlol.coukie.domain.common.QCommonModel _super = new com.locknlol.coukie.domain.common.QCommonModel(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    //inherited
    public final DatePath<java.util.Date> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DatePath<java.util.Date> modifiedAt = _super.modifiedAt;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

    public final NumberPath<Long> summonerId = createNumber("summonerId", Long.class);

    public final StringPath summonerName = createString("summonerName");

    public final com.locknlol.coukie.domain.user.QUser user;

    public QSummoner(String variable) {
        this(Summoner.class, forVariable(variable), INITS);
    }

    public QSummoner(Path<? extends Summoner> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSummoner(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSummoner(PathMetadata metadata, PathInits inits) {
        this(Summoner.class, metadata, inits);
    }

    public QSummoner(Class<? extends Summoner> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.locknlol.coukie.domain.user.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

