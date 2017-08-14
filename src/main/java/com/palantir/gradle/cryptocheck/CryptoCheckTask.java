/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 */

package com.palantir.gradle.cryptocheck;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.TaskExecutionException;

public class CryptoCheckTask extends DefaultTask {

    @TaskAction
    public void checkCrypto() throws NoSuchAlgorithmException {
        if (System.getenv("OVERRIDE_KEY_SAFETY_PROTECTIONS") != null) {
            System.err.println("OVERRIDE_KEY_SAFETY_PROTECTIONS set, skipping crypto check");
            return;
        }

        if (Cipher.getMaxAllowedKeyLength("AES") == Integer.MAX_VALUE) {
            return;
        }

        try (InputStream is = this.getClass().getResource("crypto_warning.txt").openStream()) {
            java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
            String warningMessage = s.next();
            System.err.print(warningMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}