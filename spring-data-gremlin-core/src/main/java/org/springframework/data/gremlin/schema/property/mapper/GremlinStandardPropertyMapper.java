package org.springframework.data.gremlin.schema.property.mapper;

import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.springframework.data.gremlin.repository.GremlinGraphAdapter;
import org.springframework.data.gremlin.schema.GremlinSchema;
import org.springframework.data.gremlin.schema.property.GremlinProperty;

import java.util.Set;

/**
 * A concrete {@link GremlinPropertyMapper} for mapping stadard Java types to Vertex properties.
 *
 * @author Gman
 */
public class GremlinStandardPropertyMapper implements GremlinPropertyMapper<GremlinProperty> {

    @Override
    public void copyToVertex(GremlinProperty property, GremlinGraphAdapter graphAdapter, Vertex vertex, Object val, Set<GremlinSchema> cascadingSchemas) {
        vertex.property(property.getName(), val);
    }

    @Override
    public Object loadFromVertex(GremlinProperty property, Vertex vertex, Set<GremlinSchema> cascadingSchemas) {
        return vertex.property(property.getName());
    }
}
