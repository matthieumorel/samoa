package com.yahoo.labs.samoa.instances;

/*
 * #%L
 * SAMOA
 * %%
 * Copyright (C) 2013 - 2015 Yahoo! Inc.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;

public class SparseInstance extends AbstractInstance {

    private static final long serialVersionUID = 2978800297651832155L;

    private final Map<Integer, Double> attributes;
    private final int numAttributes;

    /**
     * @param attributes map of attributes: index - value
     * @param numAttributes total number of attributes (usually more than the size of {@link #attributes} for a sparse instance)
     */
    public SparseInstance(Map<Integer, Double> attributes, int numAttributes) {
        this.attributes = attributes;
        this.numAttributes = numAttributes;
    }

    @Override
    public int getNumAttributes() {
        return numAttributes;
    }

    @Override
    public double getAttribute(int index) {
        Double value = attributes.get(index);
        if (value == null) {
            return 0;
        } else {
            return value;
        }
    }

    @Override
    public double[] getAttributes() {
        double[] result = new double[getNumAttributes()];
        for (int i=0; i<result.length; i++) {
            Double value = attributes.get(i);
            if (value == null) {
                result[i] = 0;
            } else {
                result[i] = value;
            }
        }
        return result;
    }
}
