/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 */

package com.palantir.gradle.cryptocheck;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;

public class CryptoCheckTask extends DefaultTask {

    @TaskAction
    public void checkCrypto() throws NoSuchAlgorithmException {
        // TODO(dfox): print full warning:
        /*
Your machine does not have unlimited strength crypto installed, so some unit tests won't run.

To resolve this immediately:

Set the environment variable "OVERRIDE_KEY_SAFETY_PROTECTIONS" to true.
e.g. $ export OVERRIDE_KEY_SAFETY_PROTECTIONS=true
     $ ./gradlew build

Or, to resolve this permanently:

1. Go to http://www.oracle.com/technetwork/java/javase/downloads/jce8-download-2133166.html
2. Accept and download jce_policy-8.zip
3. Unzip
4. Copy `local_policy.jar` and `US_export_policy.jar` into your `$JAVA_HOME/jre/lib/security` (replacing the existing files).

Before running tests, uou may need to run `./gradlew --stop` to kill any daemons.
         */
    }
}
