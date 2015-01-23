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

public class DenseInstance extends AbstractInstance {

    private static final long serialVersionUID = 6129026438277113411L;

    private final double[] attributeValues;

    public DenseInstance(double[] attributeValues) {
        this.attributeValues = attributeValues;
    }

    @Override
    public int getNumAttributes() {
        return attributeValues.length;
    }

    @Override
    public double getAttribute(int index) {
        return attributeValues[index];
    }

    public double[] getAttributes() {
        return attributeValues;
    }

}
