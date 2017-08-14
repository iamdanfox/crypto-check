/*
 * Copyright 2017 Palantir Technologies, Inc. All rights reserved.
 */

package com.palantir.gradle.cryptocheck;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class CryptoCheckTask extends DefaultTask {

    @TaskAction
    public void checkCrypto() throws NoSuchAlgorithmException, IOException {
        if (javax.crypto.Cipher.getMaxAllowedKeyLength("AES") == Integer.MAX_VALUE) {
            File file = new File("src/main/resources/unlimited-strength-crypto-error-message.txt");
            System.out.println(new String(Files.readAllBytes(file.toPath())));
        }
    }
}
