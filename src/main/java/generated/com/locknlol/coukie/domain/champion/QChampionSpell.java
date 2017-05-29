package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChampionSpell is a Querydsl query type for ChampionSpell
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampionSpell extends EntityPathBase<ChampionSpell> {

    private static final long serialVersionUID = 651548655L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChampionSpell championSpell = new QChampionSpell("championSpell");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QChampionSpellImage image;

    public final StringPath key = createString("key");

    public final StringPath name = createString("name");

    public QChampionSpell(String variable) {
        this(ChampionSpell.class, forVariable(variable), INITS);
    }

    public QChampionSpell(Path<? extends ChampionSpell> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChampionSpell(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChampionSpell(PathMetadata metadata, PathInits inits) {
        this(ChampionSpell.class, metadata, inits);
    }

    public QChampionSpell(Class<? extends ChampionSpell> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.image = inits.isInitialized("image") ? new QChampionSpellImage(forProperty("image")) : null;
    }

}

