/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 */

package com.palantir.gradle.cryptocheck;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CryptoCheckPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create("cryptocheckTask", CryptoCheckTask.class);
    }
}
