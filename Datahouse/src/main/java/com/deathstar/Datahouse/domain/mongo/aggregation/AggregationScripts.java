package com.deathstar.Datahouse.domain.mongo.aggregation;

import avro.shaded.com.google.common.collect.Lists;
import org.bson.Document;

import java.util.List;

public class AggregationScripts {

    public static final List<Document> GET_CLASS_WINS =    Lists.newArrayList(
            Document.parse(("{ $project: { \"battleSquad\":1 } },")),
            Document.parse(("{ $unwind: \"$battleSquad\" },")),
            Document.parse(("{ $group: { _id: \"$battleSquad\", count:{$sum:1} }},")),
            Document.parse(("{ $sort : { count : -1 }}"))
    );

}
