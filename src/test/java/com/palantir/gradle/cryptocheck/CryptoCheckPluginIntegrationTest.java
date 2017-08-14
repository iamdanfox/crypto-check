/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 */

package com.palantir.gradle.cryptocheck;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.gradle.testkit.runner.TaskOutcome;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class CryptoCheckPluginIntegrationTest {

    @Rule public final TemporaryFolder gradleDir = new TemporaryFolder();

    @Before
    public void before() throws IOException {
        buildFile("");
    }

    @Test
    public void example_test_running() {
        BuildResult result = gradlew().withArguments("cryptocheck", "i")
                .forwardOutput()
                .build();
        assertThat(result.task(":cryptocheck").getOutcome()).isEqualTo(TaskOutcome.SUCCESS);
    }


    private GradleRunner gradlew() {
        return GradleRunner.create().withProjectDir(gradleDir.getRoot()).withPluginClasspath();
    }

    private void buildFile(String string) throws IOException {
        Files.write("plugins { id 'com.palantir.cryptocheck' }\n" + string,
                new File(gradleDir.getRoot(), "build.gradle"),
                StandardCharsets.UTF_8);
    }

}
