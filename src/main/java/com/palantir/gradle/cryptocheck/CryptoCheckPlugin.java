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

        // TODO(dfox): add a description and group to ensure task appears in ./gradlew tasks
        // TODO(dfox): make task appear as a dependency of ./gradlew test
        // TODO(dfox): auto skip is an environment variable is set: 'OVERRIDE_KEY_SAFETY_PROTECTIONS'


        // TODO(dfox): automatically set up as a dependency of all test tasks (e.g. integTest)
        // TODO(dfox): extra task to automatically download & insert the jars ?!?!
    }
}
