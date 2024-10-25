package com.fkereki.mvpproject.client;

abstract public class Presenter<D> {
  private String params;
  private D display;
  private Environment environment;

  private KeyValueMap kvm;

  public Presenter() {
  }

  public Presenter(
      String someParams, D aDisplay, Environment anEnvironment) {
    super();
    params = someParams;
    display = aDisplay;
    environment = anEnvironment;
    kvm = new KeyValueMap(params);
  }

  public D getDisplay() {
    return display;
  }

  public Environment getEnvironment() {
    return environment;
  }

  public KeyValueMap getKvm() {
    return kvm;
  }
}
