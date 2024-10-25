package com.fkereki.mvpproject.client.dtos;

import com.google.gwt.user.client.rpc.IsSerializable;

public abstract class GenericServiceReturnDto
    implements IsSerializable {

  /*
   * Each extended subclass will add some data. The "hash" field must be
   * calculated using the (non-included) nonce, the other data, and the
   * (non-included) sessionkey.
   */
  public String hash;

  public GenericServiceReturnDto() {

  }
}
