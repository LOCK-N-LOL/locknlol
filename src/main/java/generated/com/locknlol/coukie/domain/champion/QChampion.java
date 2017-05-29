package com.locknlol.coukie.domain.champion;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChampion is a Querydsl query type for ChampionDto
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChampion extends EntityPathBase<Champion> {

    private static final long serialVersionUID = -1307884359L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChampion champion = new QChampion("champion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QChampionImage image;

    public final QChampionInfo info;

    public final StringPath key = createString("key");

    public final StringPath name = createString("name");

    public final StringPath partype = createString("partype");

    public final QChampionPassive passive;

    public final ListPath<ChampionSpell, QChampionSpell> spells = this.<ChampionSpell, QChampionSpell>createList("spells", ChampionSpell.class, QChampionSpell.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QChampion(String variable) {
        this(Champion.class, forVariable(variable), INITS);
    }

    public QChampion(Path<? extends Champion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChampion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChampion(PathMetadata metadata, PathInits inits) {
        this(Champion.class, metadata, inits);
    }

    public QChampion(Class<? extends Champion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.image = inits.isInitialized("image") ? new QChampionImage(forProperty("image")) : null;
        this.info = inits.isInitialized("info") ? new QChampionInfo(forProperty("info")) : null;
        this.passive = inits.isInitialized("passive") ? new QChampionPassive(forProperty("passive"), inits.get("passive")) : null;
    }

}

