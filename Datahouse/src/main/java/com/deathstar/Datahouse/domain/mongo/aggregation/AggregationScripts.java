package com.deathstar.Datahouse.domain.mongo.aggregation;

import avro.shaded.com.google.common.collect.Lists;
import org.bson.Document;

import java.util.List;

public class AggregationScripts {

    public static final List<Document> GET_CLASS_WINS_SINGLE =    Lists.newArrayList(
            Document.parse(("{ $project: { \"winningSquad\":1 } },")),
            Document.parse(("{ $unwind: \"$winningSquad\" },")),
            Document.parse(("{ $group: { _id: \"$winningSquad\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
    );

    public static final List<Document> GET_CLASS_PARTICIPATIONS_SINGLE =    Lists.newArrayList(
            Document.parse(("{ $project: { winningSquad: { $concatArrays: [ \"$winningSquad\", \"$losingSquad\" ] } } },")),
            Document.parse(("{ $unwind: \"$winningSquad\" },")),
            Document.parse(("{ $group: { _id: \"$winningSquad\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
    );

    public static final List<Document> GET_CLASS_WIN_POINTS_MULTI =    Lists.newArrayList(
            Document.parse(("{ $project: { winningSquad: 1 }},")),
            Document.parse(("{ $unwind: \"$winningSquad\" },")),
            Document.parse(("{ $group: { _id: \"$winningSquad\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
    );

    public static final List<Document> GET_CLASS_LOSE_POINTS_MULTI =    Lists.newArrayList(
            Document.parse(("{ $project: { \"losingSquad\":1 } },")),
            Document.parse(("{ $unwind: \"$losingSquad\" },")),
            Document.parse(("{ $group: { _id: \"$losingSquad\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
    );

    public static final List<Document> GET_CLASS_PARTICIPATIONS_MULTI =    Lists.newArrayList(
            Document.parse(("{ $project: { units: { $setUnion: [ \"$winningSquad\", \"$losingSquad\" ] } } },")),
            Document.parse(("{ $unwind: \"$units\" },")),
            Document.parse(("{ $group: { _id: \"$units\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
    );

}
