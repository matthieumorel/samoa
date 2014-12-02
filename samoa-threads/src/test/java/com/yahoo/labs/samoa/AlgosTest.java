package com.yahoo.labs.samoa;

/*
 * #%L
 * SAMOA
 * %%
 * Copyright (C) 2013 - 2014 Yahoo! Inc.
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

import org.junit.Test;

public class AlgosTest {

    @Test(timeout = 60000)
    public void testVHTWithThreads() throws Exception {

        TestParams vhtConfig = new TestParams.Builder()
                .inputInstances(200_000)
                .samplingSize(20_000)
                .evaluationInstances(200_000)
                .classifiedInstances(200_000)
                .classificationsCorrect(55f)
                .kappaStat(-0.1f)
                .kappaTempStat(-0.1f)
                .cliStringTemplate(TestParams.Templates.PREQEVAL_VHT_RANDOMTREE + " -t 2")
                .resultFilePollTimeout(10)
                .prePollWait(10)
                .taskClassName(LocalThreadsDoTask.class.getName())
                .build();
        TestUtils.test(vhtConfig);

    }

    @Test(timeout = 180000)
    public void testBaggingWithThreads() throws Exception {
        TestParams baggingConfig = new TestParams.Builder()
                .inputInstances(100_000)
                .samplingSize(10_000)
                .inputDelayMicroSec(100) // prevents saturating the system due
                                         // to unbounded queues
                .evaluationInstances(90_000)
                .classifiedInstances(105_000)
                .classificationsCorrect(55f)
                .kappaStat(0f)
                .kappaTempStat(0f)
                .cliStringTemplate(TestParams.Templates.PREQEVAL_BAGGING_RANDOMTREE + " -t 2")
                .prePollWait(10)
                .resultFilePollTimeout(30)
                .taskClassName(LocalThreadsDoTask.class.getName())
                .build();
        TestUtils.test(baggingConfig);

    }

}
