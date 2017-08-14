/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 */

package com.palantir.gradle.cryptocheck;

import java.util.Collections;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.testing.Test;

public class CryptoCheckPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        CryptoCheckTask cryptocheck = project.getTasks().create("cryptocheck", CryptoCheckTask.class);
        cryptocheck.setGroup("cryptocheck");
        cryptocheck.setDescription("check if unlimited strength crypto works");

        project.getTasks().withType(Test.class, test -> test.setDependsOn(Collections.singleton(cryptocheck)));


        // TODO(dfox): add a description and group to ensure task appears in ./gradlew tasks
        // TODO(dfox): make task appear as a dependency of ./gradlew test

        // TODO(dfox): auto skip is an environment variable is set: 'OVERRIDE_KEY_SAFETY_PROTECTIONS'


        // TODO(dfox): automatically set up as a dependency of all test tasks (e.g. integTest)
        // TODO(dfox): extra task to automatically download & insert the jars ?!?!
    }
}
