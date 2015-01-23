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

import java.io.Serializable;
import java.util.Map;


public interface Instance extends Serializable {

    Instance setLabel(double label);

    double getLabel();

    /**
     *
     * @return total number of attributes (regardless of whether they are present in the instance)
     */
    int getNumAttributes();

    /**
     * @return the values of attributes. For a sparse implementation, absent values are set to zero.
     */
    double[] getAttributes();

    Instance setWeight(double weight);

    double getWeight();

    double getAttribute(int index);

    Instance setMetadata(Map<Object, Object> metadata);

    /**
     * TODO use java 8's optional?
     * @return null if absent, otherwise arbitrary metadata
     */
    Map<Object, Object> getMetadata();

}
