/**
 * (C) Copyright IBM Corp. 2019
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.ibm.watsonhealth.fhir.model.path;

import java.util.Collection;
import java.util.Objects;

import com.ibm.watsonhealth.fhir.model.resource.Resource;

public class FHIRPathResourceNode extends AbstractFHIRPathNode {
    private final Resource resource;
    
    private FHIRPathResourceNode(Builder builder) {
        super(builder);
        this.resource = builder.resource;
    }
    
    @Override
    public boolean isResourceNode() {
        return true;
    }
    
    public Resource resource() {
        return resource;
    }

    public static FHIRPathResourceNode resourceNode(Resource resource) {
        return FHIRPathResourceNode.builder(resource).build();
    }
    
    public static FHIRPathResourceNode resourceNode(String name, Resource resource) {
        return FHIRPathResourceNode.builder(resource).name(name).build();
    }
    
    @Override
    public Builder toBuilder() {
        Builder builder = new Builder(type, resource);
        builder.name = name;
        builder.value = value;
        builder.children = children;
        return builder;
    }

    public static Builder builder(Resource resource) {
        return new Builder(FHIRPathType.from(resource.getClass()), resource);
    }
    
    public static class Builder extends AbstractFHIRPathNode.Builder {
        private final Resource resource;

        protected Builder(FHIRPathType type, Resource resource) {
            super(type);
            this.resource = resource;
        }
        
        public Builder name(String name) {
            return (Builder) super.name(name);
        }
        
        public Builder children(FHIRPathNode... children) {
            return (Builder) super.children(children);
        }
        
        public Builder children(Collection<FHIRPathNode> children) {
            return (Builder) super.children(children);
        }
        
        public Builder children(FHIRPathNode.Builder builder) {
            return (Builder) super.children(builder);
        }

        @Override
        public FHIRPathResourceNode build() {
            return new FHIRPathResourceNode(this);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FHIRPathResourceNode other = (FHIRPathResourceNode) obj;
        return Objects.equals(resource, other.resource());
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(resource);
    }
}
