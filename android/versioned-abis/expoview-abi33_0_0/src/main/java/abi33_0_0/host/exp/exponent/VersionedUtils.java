// Copyright 2015-present 650 Industries. All rights reserved.

package abi33_0_0.host.exp.exponent;

import abi33_0_0.com.facebook.react.ReactInstanceManager;
import abi33_0_0.com.facebook.react.ReactInstanceManagerBuilder;
import abi33_0_0.com.facebook.react.common.LifecycleState;
import abi33_0_0.com.facebook.react.shell.MainReactPackage;

import host.exp.expoview.Exponent;

public class VersionedUtils {

  public static ReactInstanceManagerBuilder getReactInstanceManagerBuilder(Exponent.InstanceManagerBuilderProperties instanceManagerBuilderProperties) {
    ReactInstanceManagerBuilder builder = ReactInstanceManager.builder()
        .setApplication(instanceManagerBuilderProperties.application)
        .addPackage(new MainReactPackage())
        .addPackage(new ExponentPackage(
                instanceManagerBuilderProperties.experienceProperties,
                instanceManagerBuilderProperties.manifest,
                // When distributing change the following two arguments to nulls
                null,
                null,
                instanceManagerBuilderProperties.singletonModules))
        .setInitialLifecycleState(LifecycleState.BEFORE_CREATE);

    if (instanceManagerBuilderProperties.jsBundlePath != null && instanceManagerBuilderProperties.jsBundlePath.length() > 0) {
      builder = builder.setJSBundleFile(instanceManagerBuilderProperties.jsBundlePath);
    }

    return builder;
  }

}
